import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private ArrayList<Product> products;
    private ArrayList<Sale> sales;

    public InventoryManager() {
        products = FileManager.loadProducts();
        sales = FileManager.loadSales();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Product findProductById(String productId) {

        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }

        return null;
    }

    public boolean addProduct(Product product) {

        if (findProductById(product.getProductId()) != null) {
            return false;
        }

        products.add(product);
        FileManager.saveProducts(products);
        return true;
    }
public boolean updateProduct(Product updatedProduct) {

    for (int i = 0; i < products.size(); i++) {

        if (products.get(i).getProductId()
                .equalsIgnoreCase(updatedProduct.getProductId())) {

            products.set(i, updatedProduct);
            FileManager.saveProducts(products);

            return true;
        }
    }

    return false;
}

public boolean deleteProduct(String productId) {

    Product product = findProductById(productId);

    if (product == null) {
        return false;
    }

    products.remove(product);
    FileManager.saveProducts(products);

    return true;
}

public boolean recordSale(String productId, int quantity) {

    Product product = findProductById(productId);

    if (product == null || quantity <= 0) {
        return false;
    }

    if (product.getQuantity() < quantity) {
        return false;
    }

    Sale sale = new Sale(
            "S" + (sales.size() + 1),
            product.getProductId(),
            product.getProductName(),
            quantity,
            product.getPrice()
    );

    sales.add(sale);

    product.setQuantity(product.getQuantity() - quantity);

    FileManager.saveProducts(products);
    FileManager.saveSales(sales);

    return true;
}

public List<Product> getLowStockProducts() {

    ArrayList<Product> lowStockProducts = new ArrayList<>();

    for (Product product : products) {

        if (product.getQuantity() <= product.getMinimumStock()) {
            lowStockProducts.add(product);
        }
    }

    return lowStockProducts;
    }
}