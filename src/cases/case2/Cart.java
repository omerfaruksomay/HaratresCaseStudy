package cases.case2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        items.add(cartItem);
        product.decreaseStock(quantity);
    }

    public int getItemCount() {
        return items.size();
    }

    public void applyDiscounts() {
        for (int i = 0; i < items.size() - 1; i++) {
            CartItem currentItem = items.get(i);
            CartItem nextItem = items.get(i + 1);

            if (currentItem.getUnitPrice() > nextItem.getUnitPrice()) {
                double newPrice = currentItem.getUnitPrice() - nextItem.getUnitPrice();

                if (newPrice < 0) {
                    newPrice = 0;
                }
                currentItem.setDiscountedUnitPrice(newPrice);
            }
        }
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    public void printCart() {
        applyDiscounts();

        System.out.println("\nSepetiniz:");

        for (CartItem item : items) {
            item.printInfo();
        }

        System.out.println("Sepet Toplamı: " + calculateTotalPrice());

    }

}
