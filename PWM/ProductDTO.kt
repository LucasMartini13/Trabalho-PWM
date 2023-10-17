data class ProductDTO(
        val name: String,
        val category: String,
        val quantity: Int,
        val price: Double
) {
    fun toProduct() = Product(generateProductId(), name, category, quantity, price)
}