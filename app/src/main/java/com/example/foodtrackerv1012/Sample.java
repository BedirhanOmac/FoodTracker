package com.example.foodtrackerv1012;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Sample {
  public static void main(String[] args) throws ParseException {
    
    UserRepository userRepository = new UserRepository();
    ProductRepository productRepository = new ProductRepository();
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
      connection.setAutoCommit(false); // Start transaction

      try (Statement statement = connection.createStatement()) {
        statement.setQueryTimeout(30); // set timeout to 30 sec.
        Class.forName("org.sqlite.JDBC");

        // Creating the database and table
        userRepository.createDatabase();
        // Inserting or updating data
        productRepository.createProductTable();
        User user = new User("Engin", "ÖZ", 25, 70, 180, "male", "very active", null,
            "nicotine");
        userRepository.insertOrUpdateUserData(user);
        ArrayList<String> str = new ArrayList<>();
        str.add("any");
        str.add("many");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date expirationDate = dateFormat.parse("01-01-2023");
        java.util.Date purchaseDate = dateFormat.parse("01-12-2022");

        // // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlExpirationDate = new java.sql.Date(expirationDate.getTime());
        java.sql.Date sqlPurchaseDate = new java.sql.Date(purchaseDate.getTime());

        Product prd = new Product("snack", sqlExpirationDate, "your_photo_string", sqlPurchaseDate, str);
        // Product prd1 = new Product("snack", sqlExpirationDate, "your_photo_string", sqlPurchaseDate, str);

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Expiration Date: " + outputDateFormat.format(prd.getExpirationDate()));
        System.out.println("Purchase Date: " + outputDateFormat.format(prd.getPurchaseDate()));
        productRepository.insertOrUpdateProductData(prd);
        // ProductRepository.insertOrUpdateProductData(prd1);
        // ProductRepository.removeProduct(1);
        // Committing the transaction
        connection.commit();
        // ProductRepository.getProductsByName("snack");
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        // Rollback the transaction in case of an exception
        connection.rollback();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}

// SELECT products.Product_ID, products.User_ID, products.Name AS ProductName,
// products.Expiration_Date, products.Ingredients, products.Purchase_Date,
// products.Photo, users.Name AS UserName, users.Surname, users.Age,
// users.Weight, users.Height, users.Gender, users.Daily_Activity_Level,
// users.Allergens, users.Unwanted_Ingredients, users.Profile_Photo
// FROM products
// LEFT JOIN users ON products.User_ID = users.User_ID;

// SELECT products.Product_ID, products.User_ID, products.Name AS ProductName,
// products.Expiration_Date, products.Ingredients, products.Purchase_Date,
// products.Photo, users.Name AS UserName, users.Surname, users.Age,
// users.Weight, users.Height, users.Gender, users.Daily_Activity_Level,
// users.Allergens, users.Unwanted_Ingredients, users.Profile_Photo
// FROM products
// LEFT JOIN users ON products.User_ID = users.User_ID
// WHERE strftime('%Y-%m-%d', products.Expiration_Date) < strftime('%Y-%m-%d',
// 'now');

// OR the following
// while (rs.next()) {
// System.out.println(rs.getString(1) + "\n");
// System.out.println(rs.getString(2) + "\n");
// System.out.println(rs.getString(3) + "\n");
// System.out.println(rs.getString(4) + "\n");
// }

// pstmt.setQueryTimeout(30); // set timeout to 30 sec.

// Statement statement = connection.createStatement();:

// String query = "select * from Student Where (ID < ? OR ID > ?) AND Name LIKE
// 'Veli";
// // Can also say "select ID, Name..." to specify shich attributes to select

// while (rs.next()) {
// // read the result set
// System.out.println("id = " + rs.getInt("ID"));
// System.out.println("name = " + rs.getString("Name"));
// System.out.println("surname = " + rs.getString("Surname"));
// System.out.println("scholarship = " + rs.getInt("Scholarship"));
// }