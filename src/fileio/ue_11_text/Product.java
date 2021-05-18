package fileio.ue_11_text;

public class Product {
    String productName;
    double price;
    String ProductCategory;

    public Product(String productName, double price, String productCategory) {
        this.productName = productName;
        this.price = price;
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", ProductCategory='" + ProductCategory + '\'' +
                '}';
    }
}
