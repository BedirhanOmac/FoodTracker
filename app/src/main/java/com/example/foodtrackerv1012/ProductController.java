package com.example.foodtrackerv1012;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {

    ProductRepository productRepository = new ProductRepository();

    public void enterName(Product product, String name) {

        product.setName(name);

        productRepository.insertOrUpdateProductData(product);
    }

    public void enterExpirationDate(Product product, Date date) {

        product.setExpirationDate(date);

        productRepository.insertOrUpdateProductData(product);
    }

    public void addImage(Product product, String photo) {

        product.setPhoto(photo);

        productRepository.insertOrUpdateProductData(product);
    }

    public void addIngredient(Product product, String newIngredient) {

        ArrayList<String> ingredientsList = product.getIngredients();

        ingredientsList.add(newIngredient);

        product.setIngredients(ingredientsList);

        productRepository.insertOrUpdateProductData(product);
    }

    public void addProduct(String name, Date expirationDate, String photo, Date purchaseDate,
            ArrayList<String> ingredients) {

        Product newProduct = new Product(name, expirationDate, photo, purchaseDate, ingredients);

        productRepository.insertOrUpdateProductData(newProduct);
    }
   public ArrayList<String> convertResultSetToStringList() {
        ArrayList<String> stringList = new ArrayList<>();
        String resultString =  "";
        ArrayList<ResultSet> resultSetList = productRepository.retrieveShoppingListProducts();

        for (ResultSet resultSet : resultSetList) {
            try {
                resultString = resultSet.getString("ProductName") +
                        " - " + resultSet.getString("UserName") +
                        " - " + resultSet.getDate("Expiration_Date") +

                stringList.add(resultString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return stringList;
    }
}
