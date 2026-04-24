package cases.case2;

public class Product {
    private String name;
    private double price;
    private int stock;
    private double rating;

    public Product(String name, double price, int stock, double rating) {
        this.price = price;
        this.name = name;
        this.stock = stock;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getRating() {
        return rating;
    }

    public boolean hasEnoughStock(int quantity) {
        return stock >= quantity;
    }

    public void decreaseStock(int quantity) {
        stock -= quantity;
    }

    public void printInfo() {
        System.out.println(
                name + " - Fiyat: " + price +
                        ", Stok: " + stock +
                        ", Değerlendirme: " + rating
        );
    }

}
