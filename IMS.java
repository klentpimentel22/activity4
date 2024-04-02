import java.sql.*;

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

public class IMS {
    private Connection connection;

    public IMS() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice_management", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(int id, String name, double price) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products (id, name, price) VALUES (?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            System.out.println("Products:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Price: " + resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, String newName, double newPrice) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ?");
            statement.setString(1, newName);
            statement.setDouble(2, newPrice);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InvoiceManagementSystem ims = new InvoiceManagementSystem();

        // Adding products
        ims.addProduct(1, "Product A", 10.0);
        ims.addProduct(2, "Product B", 20.0);
        ims.addProduct(3, "Product C", 30.0);

        // Viewing products
        ims.viewProducts();

        // Updating product
        ims.updateProduct(1, "Updated Product A", 15.0);
        ims.viewProducts();

        // Deleting product
        ims.deleteProduct(2);
        ims.viewProducts();
    }
}
