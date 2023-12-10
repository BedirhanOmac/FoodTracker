package com.example.foodtrackerv1012;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    public void createProductTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            // Create Product table
            String createProductTableQuery = "CREATE TABLE IF NOT EXISTS Products (" +
                    "Product_ID INTEGER PRIMARY KEY," +
                    "User_ID INTEGER REFERENCES User(User_ID)," +
                    "Name TEXT NOT NULL," +
                    "Expiration_Date TEXT NOT NULL," +
                    "Photo TEXT," +
                    "Purchase_Date TEXT NOT NULL," +
                    "Ingredients TEXT NOT NULL" +
                    ")";
            try (PreparedStatement productTableStatement = connection.prepareStatement(createProductTableQuery)) {
                productTableStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Product insertOrUpdateProductData(Product product) {
        String ingredientsString = "";
        for (int i = 0; i < product.getIngredients().size() - 1; i++) {
            ingredientsString += product.getIngredients().get(i) + ", ";
        }
        ingredientsString += product.getIngredients().get(product.getIngredients().size() - 1);
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            String insertOrUpdateQuery = "INSERT OR REPLACE INTO Products (Product_ID, User_ID, Name, Expiration_Date, Photo, Purchase_Date, Ingredients) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertOrUpdateQuery)) {
                statement.setObject(1, Product.getProductID());
                statement.setObject(2, 1);
                statement.setString(3, product.getName());
                statement.setDate(4, product.getExpirationDate());
                statement.setString(5, product.getPhoto());
                statement.setDate(6, product.getPurchaseDate());
                statement.setString(7, ingredientsString);
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public ArrayList<ResultSet> retrieveExpiredProducts() {
        ArrayList<ResultSet> expiredList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:your_database.db")) {
            String query = "SELECT products.Product_ID, products.User_ID, products.Name AS ProductName, " +
                    "products.Expiration_Date, products.Ingredients, products.Purchase_Date, " +
                    "products.Photo, users.Name AS UserName, users.Surname, users.Age, " +
                    "users.Weight, users.Height, users.Gender, users.Daily_Activity_Level, " +
                    "users.Allergens, users.Unwanted_Ingredients " +
                    "FROM products " +
                    "LEFT JOIN users ON products.User_ID = users.User_ID " +
                    "WHERE products.Expiration_Date < date('now')";

            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    expiredList.add(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expiredList;
    }

    public ArrayList<ResultSet> retrieveShoppingListProducts() {
        ArrayList<ResultSet> shoppigtList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:your_database.db")) {
            String query = "SELECT products.Product_ID, products.User_ID, products.Name AS ProductName, " +
                    "products.Expiration_Date, products.Ingredients, products.Purchase_Date, " +
                    "products.Photo, users.Name AS UserName, users.Surname, users.Age, " +
                    "users.Weight, users.Height, users.Gender, users.Daily_Activity_Level, " +
                    "users.Allergens, users.Unwanted_Ingredients " +
                    "FROM products " +
                    "LEFT JOIN users ON products.User_ID = users.User_ID " +
                    "WHERE (julianday(products.Expiration_Date) - julianday(products.Purchase_Date)) * 100 / 80 < (julianday('now') - julianday(products.Purchase_Date))";

            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    shoppigtList.add(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppigtList;
    }

    public ArrayList<ResultSet> retrieveAllProducts() {
        ArrayList<ResultSet> productList = new ArrayList<>();
    
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:your_database.db")) {
            String query = "SELECT * FROM products";
    
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
    
                while (resultSet.next()) {
                    productList.add(resultSet);
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return productList;
    }

    public void removeProduct(int productId) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            String deleteQuery = "DELETE FROM Products WHERE Product_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
                statement.setInt(1, productId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
