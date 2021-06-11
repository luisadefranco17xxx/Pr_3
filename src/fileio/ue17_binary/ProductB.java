package fileio.ue17_binary;

import java.io.Serializable;

public class ProductB   implements Serializable {
    String ProductName;
    Double Price;
    String ProductCategory;

    public ProductB(String productName, Double price, String productCategory) {
        ProductName = productName;
        Price = price;
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    @Override
    public String toString() {
        return "ProductB{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", ProductCategory='" + ProductCategory + '\'' +
                '}';
    }
}
