import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String PRODUCTS_FILE = "data/products.txt";
    private static final String SALES_FILE = "data/sales.txt";

    public static void saveProducts(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {

            for (Product product : products) {
                writer.write(
                        product.getProductId() + "|" +
                        product.getProductName() + "|" +
                        product.getCategory() + "|" +
                        product.getPrice() + "|" +
                        product.getQuantity() + "|" +
                        product.getMinimumStock()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    public static ArrayList<Product> loadProducts() {

        ArrayList<Product> products = new ArrayList<>();

        File file = new File(PRODUCTS_FILE);

        if (!file.exists()) {
            return products;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    try {
                        String productId = data[0];
                        String productName = data[1];
                        String category = data[2];
                        double price = Double.parseDouble(data[3]);
                        int quantity = Integer.parseInt(data[4]);
                        int minimumStock = Integer.parseInt(data[5]);

                        Product product = new Product(
                                productId,
                                productName,
                                category,
                                price,
                                quantity,
                                minimumStock
                        );

                        products.add(product);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid product record.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }

        return products;
    }

    public static void saveSales(List<Sale> sales) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SALES_FILE))) {

            for (Sale sale : sales) {

                writer.write(
                        sale.getSaleId() + "|" +
                        sale.getProductId() + "|" +
                        sale.getProductName() + "|" +
                        sale.getQuantity() + "|" +
                        sale.getPricePerUnit() + "|" +
                        sale.getTotalAmount() + "|" +
                        sale.getDateTime()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving sales: " + e.getMessage());
        }
    }

    public static ArrayList<Sale> loadSales() {

        ArrayList<Sale> sales = new ArrayList<>();

        File file = new File(SALES_FILE);

        if (!file.exists()) {
            return sales;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 7) {

                    try {
                        String saleId = data[0];
                        String productId = data[1];
                        String productName = data[2];
                        int quantity = Integer.parseInt(data[3]);
                        double pricePerUnit = Double.parseDouble(data[4]);
                        double totalAmount = Double.parseDouble(data[5]);
                        String dateTime = data[6];

                        Sale sale = new Sale(
                                saleId,
                                productId,
                                productName,
                                quantity,
                                pricePerUnit,
                                totalAmount,
                                dateTime
                        );

                        sales.add(sale);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid sale record.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading sales: " + e.getMessage());
        }

        return sales;
    }
}