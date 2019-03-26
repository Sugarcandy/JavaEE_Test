package bean;

import Dao.ProductDao;
import Impl.ProductImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @create 2019/3/26 0026
 */
public class Cart {
    private List<CartItem> list;//购物车列表
    public Cart(){
        list=new ArrayList<>();
    }

    public List<CartItem> getList() {
        return list;
    }

    public synchronized void addToCart(String productId){
        CartItem cartItem;
        ProductDao productDao=new ProductImpl();
        Product product=productDao.loadbyNo(productId);
        for(int i=0;i<list.size();i++){
            cartItem=(CartItem)list.get(i);
            if(productId.equals(cartItem.getProduct().getProductId())) {
                cartItem.addcount();
                return;
            }
        }
        cartItem=new CartItem(product);
        list.add(cartItem);
    }

    public Long getTotal(){
        Long sum=0L;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i).getTotal();//统计每个货物的总价
        }
        return sum;
    }
}
