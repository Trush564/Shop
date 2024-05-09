import java.util.Scanner;
import java.util.Random;

public class CustomersInfo {
    private String[][] customers = {{"Шевченко Павло", generateDiscountCode()},
            {"Мельник Марія", generateDiscountCode()},
            {"Бондаренко Максим", generateDiscountCode()},
            {"Ткаченко Юлія", generateDiscountCode()},
            {"Ковальчук Петро", generateDiscountCode()},
            {"Сидоренко Олена", generateDiscountCode()}};

    private Scanner scanner;
    private Random random;

    public CustomersInfo() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void customers() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Вивести список клієнтів");
            System.out.println("2. Додати нового клієнта");
            System.out.println("3. Перевірити чи клієнт є в списку");
            System.out.println("4. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    allCustomers();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    checkCustomer();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }

    public void allCustomers() {
        System.out.println("Список клієнтів:");
        for (String[] customer : customers) {
            System.out.println(customer[0] + " (код на знижку: " + customer[1] + ")");
        }
    }

    private void addNewCustomer() {
        System.out.println("Введіть ім'я та прізвище нового клієнта:");
        String newCustomer = scanner.nextLine();
        String[] newCustomerArray = {newCustomer, generateDiscountCode()};

        String[][] updatedCustomers = new String[customers.length + 1][2];
        System.arraycopy(customers, 0, updatedCustomers, 0, customers.length);
        updatedCustomers[customers.length] = newCustomerArray;
        customers= updatedCustomers;

        System.out.println("Новий клієнт доданий.");
    }

    private void checkCustomer() {
        System.out.println("Введіть прізвище та  ім'я  клієнта для перевірки:");
        String customerToCheck = scanner.nextLine();
        boolean found = false;
        for (String [] customer : customers) {
            if (customer[0].equalsIgnoreCase(customerToCheck)) {
                found = true;
                System.out.println("Клієнт знайдений. Код на знижку: " + customer[1]);
                break;
            }
        }
        if (!found) {
            System.out.println("Клієнта не знайдено.");
        }
    }
    private String generateDiscountCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
    public String[][] getCustomers() {
        return customers;
    }

    public void setCustomers(String[][]customers) {
        this.customers = customers;
    }

    public static void main(String[] args) {
        CustomersInfo customersInfo = new CustomersInfo();
        customersInfo.customers();
    }
}


