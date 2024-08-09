/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc

import java.net.URL
import java.time.Instant

class Agent private constructor(
    val id: String,
    val name: String,
    val agentURL: URL,
    val connectionURL: URL,
    val publicKey: String,
    val did: String,
    val creationDate: Instant
) {
    class Builder {
        private var id: String = ""
        private var name: String = ""
        private var agentURL: URL = URL("http://localhost")
        private var connectionURL: URL = URL("http://localhost")
        private var publicKey: String = ""
        private var did: String = ""
        private var creationDate: Instant = Instant.now()

        fun id(id: String) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun agentURL(agentURL: URL) = apply { this.agentURL = agentURL }
        fun connectionURL(connectionURL: URL) = apply { this.connectionURL = connectionURL }
        fun publicKey(publicKey: String) = apply { this.publicKey = publicKey }
        fun did(did: String) = apply { this.did = did }
        fun creationDate(creationDate: Instant) = apply { this.creationDate = creationDate }

        fun build() = Agent(id, name, agentURL, connectionURL, publicKey, did, creationDate)
    }
}
