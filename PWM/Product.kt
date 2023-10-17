import java.util.concurrent.atomic.AtomicInteger

data class Product(val id: Int, var name: String, var category: String, var quantity: Int, var price: Double)

fun Product.updateFromProductDTO(productDTO: ProductDTO) {
    this.name = productDTO.name
    this.category = productDTO.category
    this.quantity = productDTO.quantity
    this.price = productDTO.price
}

private val productIdCounter = AtomicInteger(0)

fun generateProductId(): Int {

    return productIdCounter.getAndIncrement()
}
