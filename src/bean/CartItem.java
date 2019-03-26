package bean;

/**
 * @author chen
 * @create 2019/3/26 0026
 */
public class CartItem {
    Product product;

    int count;

    public CartItem(Product pro){
        product=pro;
        count=1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addcount(){
        this.count+=1;
    }

    public int getTotal(){
        return product.getPrice()*count;
    }
}
