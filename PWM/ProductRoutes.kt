import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.productRoutes() {
    route("/products") {
        get { call.respond(products) }

        post {
            val product = call.receive<ProductDTO>()
            products.add(product.toProduct())
            call.respond(HttpStatusCode.Created)
        }

        route("/{id}") {
            get {
                val productId = call.parameters["id"]?.toIntOrNull()
                val product = products.find { it.id == productId }
                if (product != null) {
                    call.respond(product.toProductDTO())
                } else {
                    throw NotFoundException()
                }
            }

            put {
                val productId = call.parameters["id"]?.toIntOrNull()
                val productDTO = call.receive<ProductDTO>()
                val existingProduct = products.find { it.id == productId }
                if (existingProduct != null) {
                    existingProduct.updateFromProductDTO(productDTO)
                    call.respond(HttpStatusCode.OK)
                } else {
                    throw NotFoundException()
                }
            }

            delete {
                val productId = call.parameters["id"]?.toIntOrNull()
                val product = products.find { it.id == productId }
                if (product != null) {
                    products.remove(product)
                    call.respond(HttpStatusCode.NoContent)
                } else {
                    throw NotFoundException()
                }
            }
        }
    }
}
