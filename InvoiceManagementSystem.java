import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class InvoiceManagementSystem {
    private List<Product> products;

    public InvoiceManagementSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(int id, String name, double price) {
        Product product = new Product(id, name, price);
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void viewProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(int id, String newName, double newPrice) {
        Product product = findProductById(id);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        Product product = findProductById(id);
        if (product != null) {
            products.remove(product);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void main(String[] args) {
        InvoiceManagementSystem ims = new InvoiceManagementSystem();

        // Adding products
        ims.addProduct(1, "Nike Tshirt", 399.0);
        ims.addProduct(2, "Addidas pants", 599.0);
        ims.addProduct(3, "mRN perfume", 350.0);

        // Viewing products
        ims.viewProducts();

        // Updating product
        ims.updateProduct(1, "CASXC shirt", 460.0);
        ims.viewProducts();

        // Deleting product
        ims.deleteProduct(2);
        ims.viewProducts();
    }
}
