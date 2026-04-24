import cases.case1.Case1;
import cases.case2.Case2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("   HARATRES F.I.T CASE STUDY   ");
            System.out.println("1 - Soru 1");
            System.out.println("2 - Soru 2");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    Case1.run(scanner);
                    break;

                case "2":
                    Case2.run(scanner);
                    break;

                case "0":
                    System.out.println("Çıkılıyor..");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçerli bi seçim yapın");
            }

        }

    }

}
