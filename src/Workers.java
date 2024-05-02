import java.util.Scanner;

public class Workers {
    private CustomersInfo customersInfo = new CustomersInfo();
    private Scanner scanner;


    public Workers(Scanner scanner) {
        this.scanner = scanner;
    }

    public void workers() {
        System.out.println("Оберіть, з якою інформацією ви хочете працювати:");
        System.out.println("1. Інформація про клієнтів");
        System.out.println("2. Інформація про товари");
        int choice = scanner.nextInt();

        workers(choice);
    }

    public void workers(int choice) {
        if (choice == 1) {
            CustomersInfo customersInfo = new CustomersInfo();
            customersInfo.customers();
        } else if (choice == 2) {
            Products products = new Products();
            products.products();
        } else {
            System.out.println("Неправильний вибір.");
        }
    }
    public CustomersInfo getCustomersInfo() {
        return customersInfo;
    }

    public void setCustomersInfo(CustomersInfo customersInfo) {

        this.customersInfo = customersInfo;
    }
}
