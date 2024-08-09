pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "IBM Security Verify SDK"
include(":adaptive")
include(":authentication")
include(":core")
include(":dc")
include(":dc_demo")
include(":dpop_demo")
include(":fido2")
include(":fido2_demo")
include(":mfa")
include(":mfa_demo")

project(":dc_demo").projectDir = File("examples/dc_demo")
project(":dpop_demo").projectDir = File("examples/dpop_demo")
project(":fido2_demo").projectDir = File("examples/fido2_demo")
project(":mfa_demo").projectDir = File("examples/mfa_demo")

