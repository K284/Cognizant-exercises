import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " | Qty: " + quantity + " | Price: $" + price;
    }
}

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        if (!inventory.containsKey(product.productId)) {
            inventory.put(product.productId, product);
        } else {
            System.out.println("Product already exists.");
        }
    }

    // Update a product
    public void updateProduct(int productId, String name, int qty, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.productName = name;
            p.quantity = qty;
            p.price = price;
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display inventory
    public void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new Product(101, "Keyboard", 10, 500.00));
        manager.addProduct(new Product(102, "Mouse", 25, 300.00));
        manager.updateProduct(102, "Wireless Mouse", 30, 450.00);
        manager.deleteProduct(101);
        manager.displayInventory();
    }
}
