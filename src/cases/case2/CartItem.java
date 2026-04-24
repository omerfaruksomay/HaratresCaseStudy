package cases.case2;

public class CartItem {
    private Product product;
    private int quantity;
    private double discountedUnitPrice;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.discountedUnitPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountedUnitPrice() {
        return discountedUnitPrice;
    }

    public double getUnitPrice() {
        return product.getPrice();
    }

    public void setDiscountedUnitPrice(double discountedUnitPrice) {
        this.discountedUnitPrice = discountedUnitPrice;
    }

    public double getTotalPrice() {
        return discountedUnitPrice * quantity;
    }

    public void printInfo() {
        System.out.println(
                product.getName() +
                        " - Adet: " + quantity +
                        ", Birim Fiyat: " + discountedUnitPrice +
                        ", Toplam Fiyat: " + getTotalPrice()
        );
    }

}
