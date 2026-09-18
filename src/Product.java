public class Product {

    private String productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private int minimumStock;

    public Product(String productId, String productName, String category,
                   double price, int quantity, int minimumStock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public boolean isLowStock() {
        return quantity <= minimumStock;
    }

    public boolean isOutOfStock() {
        return quantity == 0;
    }

    public double getInventoryValue() {
        return price * quantity;
    }
}