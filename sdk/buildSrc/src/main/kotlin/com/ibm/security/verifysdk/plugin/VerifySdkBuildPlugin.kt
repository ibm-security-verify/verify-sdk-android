/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */

package com.ibm.security.verifysdk.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class VerifySdkBuildPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply("com.hcl.security.appscan")
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlinx-serialization")
        project.plugins.apply("maven-publish")
        project.plugins.apply("org.jetbrains.dokka")
        project.plugins.apply("org.owasp.dependencycheck")
        project.plugins.apply("com.github.ben-manes.versions")

        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(34)
                defaultConfig {
                    targetSdk = 30
                    minSdk = 26
                    versionCode = 101
                    versionName = "3.0.1"
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    manifestPlaceholders["auth_redirect_scheme"] = "https"
                    manifestPlaceholders["auth_redirect_host"] = "chageman.dev.verify.ibmcloudsecurity.com"
                    manifestPlaceholders["auth_redirect_path"] = "/callback"
                }

                packagingOptions {
                    resources.excludes.add("META-INF/LICENSE*.md")
                }

                project.configurations.all {
                    resolutionStrategy.failOnVersionConflict()
                    resolutionStrategy.preferProjectModules()
                    resolutionStrategy.force("com.fasterxml.woodstox:woodstox-core:6.4.0")
                }

                testOptions.unitTests {
                    isReturnDefaultValues = true
                }

                buildTypes {
                    getByName("debug") {
                        isTestCoverageEnabled = true
                    }
                }

                packagingOptions {
                    resources.excludes.add("META-INF/DEPENDENCIES")
                }

                val proguardFile = "proguard-rules.pro"
                when (this) {
                    is LibraryExtension -> defaultConfig {
                        consumerProguardFiles(proguardFile)
                    }
                    is AppExtension -> buildTypes {
                        getByName("release") {
                            isMinifyEnabled = true
                            isShrinkResources = true
                            isDebuggable = false
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                proguardFile
                            )
                        }
                    }
                }

                compileOptions {
                    isCoreLibraryDesugaringEnabled = true
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }
        }

        // Unit tests: JUnit5
        // Instrumentation tests: JUnit4

        project.dependencies {
            add("androidTestImplementation", "androidx.test.ext:junit:1.1.5")
            add("androidTestImplementation", "androidx.test:core:1.5.0")
            add("androidTestImplementation", "androidx.test:rules:1.5.0")
            add("androidTestImplementation", "androidx.test:runner:1.5.0")
            add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.5.1")
            add("androidTestImplementation", "androidx.test.uiautomator:uiautomator:2.2.0")
            add("androidTestImplementation", "junit:junit:4.12")
            add("androidTestImplementation", "org.junit.jupiter:junit-jupiter")    // JUnit5
            add("androidTestImplementation", "org.mockito.kotlin:mockito-kotlin:4.0.0")
            add("androidTestImplementation", "com.squareup.okhttp3:mockwebserver:4.10.0")
            add("androidTestImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
            add("androidTestImplementation", platform("org.junit:junit-bom:5.8.2"))          // JUnit5
            add("androidTestImplementation", "org.slf4j:slf4j-jdk14:2.0.7")

            add("coreLibraryDesugaring", "com.android.tools:desugar_jdk_libs:1.1.5")

            add("implementation", "androidx.core:core-ktx:1.7.0")
            add("implementation", "com.google.code.gson:gson:2.9.0")
            add("implementation", "org.jacoco:org.jacoco.core:0.8.8")
            add("implementation", "com.squareup.retrofit2:retrofit:2.9.0")
            add("implementation", "com.squareup.retrofit2:converter-gson:2.9.0")
            add("implementation", "com.squareup.okhttp3:okhttp:4.10.0")
            add("implementation", "com.squareup.okhttp3:logging-interceptor:4.10.0")
            add("implementation", "org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-rx3:1.6.4")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            add("implementation", "org.slf4j:slf4j-api:2.0.7")
            add("implementation", "androidx.browser:browser:1.6.0")

            add("testImplementation", "junit:junit:4.12") // JUnit4 for Adaptive SDK
//            add("testImplementation", "org.json:json:20220320")             // Using json in unit tests
        }
    }

    private fun BaseExtension.applyProguardSettings() {
        val proguardFile = "proguard-rules.pro"
        when (this) {
            is LibraryExtension -> defaultConfig {
                consumerProguardFiles(proguardFile)
            }
            is AppExtension -> buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        proguardFile
                    )
                }
            }
        }
    }
}
