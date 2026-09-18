import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InventoryManager inventory = new InventoryManager();

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   SMART INVENTORY & SALES MANAGEMENT");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            showMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    recordSale();
                    break;

                case 7:
                    viewSales();
                    break;

                case 8:
                    lowStockReport();
                    break;

                case 9:
                    running = false;
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {

        System.out.println("\n----------------------------------------");
        System.out.println("              MAIN MENU");
        System.out.println("----------------------------------------");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Record Sale");
        System.out.println("7. View Sales");
        System.out.println("8. Low Stock Report");
        System.out.println("9. Exit");
        System.out.println("----------------------------------------");
    }

    private static void addProduct() {

        System.out.println("\n========== ADD PRODUCT ==========");

        String id = readText("Enter product ID: ");

        if (inventory.findProductById(id) != null) {
            System.out.println("Product ID already exists.");
            return;
        }

        String name = readText("Enter product name: ");
        String category = readText("Enter category: ");
        double price = readDouble("Enter price: ");
        int quantity = readInt("Enter quantity: ");
        int minimumStock = readInt("Enter minimum stock level: ");

        Product product = new Product(
                id,
                name,
                category,
                price,
                quantity,
                minimumStock
        );

        if (inventory.addProduct(product)) {
            System.out.println("\nProduct added successfully.");
        } else {
            System.out.println("\nUnable to add product.");
        }
    }

    private static void viewProducts() {

        System.out.println("\n========== ALL PRODUCTS ==========");

        List<Product> products = inventory.getProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {

            System.out.println("----------------------------------------");
            System.out.println("Product ID     : " + product.getProductId());
            System.out.println("Product Name   : " + product.getProductName());
            System.out.println("Category       : " + product.getCategory());
            System.out.println("Price          : " + product.getPrice());
            System.out.println("Quantity       : " + product.getQuantity());
            System.out.println("Minimum Stock  : " + product.getMinimumStock());
        }

        System.out.println("----------------------------------------");
    }

    private static void searchProduct() {

        System.out.println("\n========== SEARCH PRODUCT ==========");

        String id = readText("Enter product ID: ");

        Product product = inventory.findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("\nProduct found:");
        System.out.println("Product ID     : " + product.getProductId());
        System.out.println("Product Name   : " + product.getProductName());
        System.out.println("Category       : " + product.getCategory());
        System.out.println("Price          : " + product.getPrice());
        System.out.println("Quantity       : " + product.getQuantity());
        System.out.println("Minimum Stock  : " + product.getMinimumStock());
    }

    private static void updateProduct() {

        System.out.println("\n========== UPDATE PRODUCT ==========");

        String id = readText("Enter product ID to update: ");

        Product existing = inventory.findProductById(id);

        if (existing == null) {
            System.out.println("Product not found.");
            return;
        }

        String name = readText("Enter new product name: ");
        String category = readText("Enter new category: ");
        double price = readDouble("Enter new price: ");
        int quantity = readInt("Enter new quantity: ");
        int minimumStock = readInt("Enter new minimum stock level: ");

        Product updatedProduct = new Product(
                id,
                name,
                category,
                price,
                quantity,
                minimumStock
        );

        if (inventory.updateProduct(updatedProduct)) {
            System.out.println("\nProduct updated successfully.");
        } else {
            System.out.println("\nUnable to update product.");
        }
    }

    private static void deleteProduct() {

        System.out.println("\n========== DELETE PRODUCT ==========");

        String id = readText("Enter product ID to delete: ");

        Product product = inventory.findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        String confirmation = readText(
                "Are you sure you want to delete this product? (yes/no): "
        );

        if (confirmation.equalsIgnoreCase("yes")) {

            if (inventory.deleteProduct(id)) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Unable to delete product.");
            }

        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    private static void recordSale() {

        System.out.println("\n========== RECORD SALE ==========");

        String id = readText("Enter product ID: ");

        Product product = inventory.findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Product: " + product.getProductName());
        System.out.println("Available quantity: " + product.getQuantity());

        int quantity = readInt("Enter quantity to sell: ");

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Insufficient stock.");
            return;
        }

        if (inventory.recordSale(id, quantity)) {

            double total = quantity * product.getPrice();

            System.out.println("\nSale recorded successfully.");
            System.out.println("Product  : " + product.getProductName());
            System.out.println("Quantity : " + quantity);
            System.out.println("Total    : " + total);

        } else {
            System.out.println("Unable to record sale.");
        }
    }

    private static void viewSales() {

        System.out.println("\n========== SALES HISTORY ==========");

        List<Sale> sales = inventory.getSales();

        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }

        for (Sale sale : sales) {

            System.out.println("----------------------------------------");
            System.out.println("Sale ID        : " + sale.getSaleId());
            System.out.println("Product ID     : " + sale.getProductId());
            System.out.println("Product Name   : " + sale.getProductName());
            System.out.println("Quantity       : " + sale.getQuantity());
            System.out.println("Price/Unit     : " + sale.getPricePerUnit());
            System.out.println("Total Amount   : " + sale.getTotalAmount());
            System.out.println("Date & Time    : " + sale.getDateTime());
        }

        System.out.println("----------------------------------------");
    }

    private static void lowStockReport() {

        System.out.println("\n========== LOW STOCK REPORT ==========");

        List<Product> lowStockProducts =
                inventory.getLowStockProducts();

        if (lowStockProducts.isEmpty()) {
            System.out.println("No products are currently low in stock.");
            return;
        }

        for (Product product : lowStockProducts) {

            System.out.println("----------------------------------------");
            System.out.println("Product ID     : " + product.getProductId());
            System.out.println("Product Name   : " + product.getProductName());
            System.out.println("Current Stock  : " + product.getQuantity());
            System.out.println("Minimum Stock  : " + product.getMinimumStock());
        }

        System.out.println("----------------------------------------");
    }

    private static String readText(String message) {

        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid amount.");
            }
        }
    }
}