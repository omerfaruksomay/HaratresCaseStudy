package cases.case2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Case2 {

    public static void run(Scanner scanner) {
        System.out.println("\n--- Soru 2 ---");

        ArrayList<Product> products = getProducts(scanner);

        sortProducts(scanner, products);

        System.out.println("\nSıralanmış Ürünler:");
        for (Product product : products) {
            product.printInfo();
        }

        Cart cart = new Cart();
        addProductsToCart(scanner, products, cart);

        cart.printCart();
    }

    private static ArrayList<Product> getProducts(Scanner scanner) {
        ArrayList<Product> products = new ArrayList<>();
        int productCount = getProductCount(scanner);

        for (int i = 0; i < productCount; i++) {
            System.out.println("\nÜrün " + (i + 1) + ":");

            String name = getProductName(scanner);
            double price = getProductPrice(scanner);
            int stock = getProductStock(scanner);
            double rating = getProductRating(scanner);

            products.add(new Product(name, price, stock, rating));
        }

        return products;
    }

    private static int getProductCount(Scanner scanner) {
        while (true) {
            System.out.print("Kaç farklı ürün gireceksiniz: ");
            String input = scanner.nextLine();

            try {
                int count = Integer.parseInt(input);

                if (count > 1) {
                    return count;
                }

                System.out.println("Birden fazla farklı ürün girişi yapılmalıdır.");
            } catch (NumberFormatException e) {
                System.out.println("Geçerli bir sayı giriniz.");
            }
        }
    }

    private static String getProductName(Scanner scanner) {
        while (true) {
            System.out.print("Ürün Adı: ");
            String name = scanner.nextLine();

            if (!name.isEmpty() && name.length() <= 20) {
                return name;
            }

            System.out.println("Ürün adı boş olamaz ve en fazla 20 karakter olmalıdır.");
        }
    }

    private static double getProductPrice(Scanner scanner) {
        while (true) {
            System.out.print("Birim Fiyat: ");
            String input = scanner.nextLine();

            try {
                double price = Double.parseDouble(input);

                if (price >= 1 && price <= 100) {
                    return price;
                }

                System.out.println("Fiyat 1 ile 100 arasında olmalıdır.");
            } catch (NumberFormatException e) {
                System.out.println("Geçerli bir fiyat giriniz.");
            }
        }
    }

    private static int getProductStock(Scanner scanner) {
        while (true) {
            System.out.print("Stok Miktarı: ");
            String input = scanner.nextLine();

            try {
                int stock = Integer.parseInt(input);

                if (stock >= 1) {
                    return stock;
                }

                System.out.println("Stok miktarı en az 1 olmalıdır.");
            } catch (NumberFormatException e) {
                System.out.println("Geçerli bir stok miktarı giriniz.");
            }
        }
    }

    private static double getProductRating(Scanner scanner) {
        while (true) {
            System.out.print("Değerlendirme Puanı: ");
            String input = scanner.nextLine();

            try {
                double rating = Double.parseDouble(input);

                if (rating >= 0 && rating <= 5) {
                    return rating;
                }

                System.out.println("Değerlendirme puanı 0 ile 5 arasında olmalıdır.");
            } catch (NumberFormatException e) {
                System.out.println("Geçerli bir değerlendirme puanı giriniz.");
            }
        }
    }

    private static void sortProducts(Scanner scanner, ArrayList<Product> products) {
        String criteria = getSortCriteria(scanner);
        String sortType = getSortType(scanner);

        Comparator<Product> comparator;

        switch (criteria) {
            case "name":
                comparator = Comparator.comparing(Product::getName);
                break;
            case "stock":
                comparator = Comparator.comparingInt(Product::getStock);
                break;
            case "rating":
                comparator = Comparator.comparingDouble(Product::getRating);
                break;
            default:
                comparator = Comparator.comparing(Product::getName);
        }

        if (sortType.equals("azalan")) {
            comparator = comparator.reversed();
        }

        products.sort(comparator);
    }

    private static String getSortCriteria(Scanner scanner) {
        while (true) {
            System.out.print("Ürünleri hangi kritere göre sıralamak istersiniz? (name/stock/rating): ");
            String criteria = scanner.nextLine().trim().toLowerCase();

            switch (criteria) {
                case "name":
                case "stock":
                case "rating":
                    return criteria;
                default:
                    System.out.println("Geçerli bir kriter giriniz.");
            }
        }
    }

    private static String getSortType(Scanner scanner) {
        while (true) {
            System.out.print("Sıralama türü artan mı azalan mı olsun? (artan/azalan): ");
            String sortType = scanner.nextLine().trim().toLowerCase();

            switch (sortType) {
                case "artan":
                case "azalan":
                    return sortType;
                default:
                    System.out.println("Geçerli bir sıralama türü giriniz.");
            }
        }
    }

    private static void addProductsToCart(Scanner scanner, ArrayList<Product> products, Cart cart) {
        while (true) {
            System.out.print("\nSepete ürün eklemek ister misiniz? (Evet/Hayır): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            switch (answer) {
                case "evet":
                    addSingleProductToCart(scanner, products, cart);
                    break;

                case "hayır":
                    if (cart.getItemCount() >= 2) {
                        return;
                    }

                    System.out.println("Sepette en az iki ürün olmalıdır. Lütfen ürün ekleyiniz.");
                    break;

                default:
                    System.out.println("Geçerli bir cevap giriniz.");
            }
        }
    }

    private static void addSingleProductToCart(Scanner scanner, ArrayList<Product> products, Cart cart) {
        Product selectedProduct = findProductByName(scanner, products);
        int quantity = getCartQuantity(scanner, selectedProduct);

        cart.addItem(selectedProduct, quantity);

        System.out.println(selectedProduct.getName() + " sepetinize eklendi.");
    }

    private static Product findProductByName(Scanner scanner, ArrayList<Product> products) {
        while (true) {
            System.out.print("Eklemek istediğiniz ürünün adı: ");
            String productName = scanner.nextLine();

            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    return product;
                }
            }

            System.out.println("Bu isimde bir ürün bulunamadı.");
        }
    }

    private static int getCartQuantity(Scanner scanner, Product product) {
        while (true) {
            System.out.print("Eklemek istediğiniz adet: ");
            String input = scanner.nextLine();

            try {
                int quantity = Integer.parseInt(input);

                if (quantity <= 0) {
                    System.out.println("Adet 0'dan büyük olmalıdır.");
                } else if (!product.hasEnoughStock(quantity)) {
                    System.out.println("Stokta yeterli ürün yok. Mevcut stok: " + product.getStock());
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçerli bir adet giriniz.");
            }
        }
    }
}