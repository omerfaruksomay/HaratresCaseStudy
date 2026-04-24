package cases.case2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity){
        CartItem cartItem = new CartItem(product,quantity);
        items.add(cartItem);
        product.decreaseStock(quantity);
    }

    public int getItemCount() {
        return items.size();
    }

    public void applyDiscounts(){

    }

}
