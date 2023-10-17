import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.jackson.jackson
import io.ktor.routing.routing

fun Application.installContentNegotiation() {
    install(ContentNegotiation) { jackson {} }
}

fun Application.installStatusPages() {
    install(StatusPages) { exception<NotFoundException> { call.respond(HttpStatusCode.NotFound) } }
}

fun Application.configureRouting() {
    routing { productRoutes() }
}
