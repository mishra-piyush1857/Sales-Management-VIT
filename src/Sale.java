import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sale {

    private String saleId;
    private String productId;
    private String productName;
    private int quantity;
    private double pricePerUnit;
    private double totalAmount;
    private String dateTime;

    public Sale(String saleId, String productId, String productName,
                int quantity, double pricePerUnit) {

        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = quantity * pricePerUnit;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public Sale(String saleId, String productId, String productName,
                int quantity, double pricePerUnit,
                double totalAmount, String dateTime) {

        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDateTime() {
        return dateTime;
    }
}