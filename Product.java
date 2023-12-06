import java.util.ArrayList;
import java.sql.Date;

public class Product {
    private String name;
    private Date expirationDate;
    private String photo;
    private Date purchaseDate;
    private ArrayList<String> ingredients;
    private static int productID = 0;
    private static final int userID = 1;

    public Product(String name, Date expirationDate, String photo, Date purchaseDate,
            ArrayList<String> ingredients) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.ingredients = ingredients;
        this.photo = photo;
        this.purchaseDate = purchaseDate;
        productID++;
    }

  public Date getExpirationDate() {
      return expirationDate;
  }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public static int getProductID() {
        return productID;
    }

  public Date getPurchaseDate() {
      return purchaseDate;
  }

    public static int getUserid() {
        return userID;
    }

   public void setExpirationDate(Date expirationDate) {
       this.expirationDate = expirationDate;
   }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static void setProductID(int productID) {
        Product.productID = productID;
    }

}
