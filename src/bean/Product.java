package bean;

/**
 * @author chen
 * @create 2019/3/21 0021
 */
public class Product {

    private String productId;

    private String productName;

    private int price;

    private String address;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "productId: "+getProductId()+"\n"+"productName: "+getProductName()+"\n" +
        "price: "+getPrice()+"\n" +"address: "+getAddress()+"\n";
    }
}
