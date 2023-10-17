import io.ktor.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080) {
                installContentNegotiation()
                installStatusPages()
                configureRouting()
            }
            .start(wait = true)
}
