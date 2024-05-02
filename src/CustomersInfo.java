import java.util.Scanner;

public class CustomersInfo {
    private String[] customers = {"Шевченко Павло", "Мельник Марія", "Бондаренко Максим",
            "Ткаченко Юлія", "Ковальчук Петро", "Сидоренко Олена"};

    private Scanner scanner;

    public CustomersInfo() {
        this.scanner = new Scanner(System.in);
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
        for (String customer : customers) {
            System.out.println(customer);
        }
    }

    private void addNewCustomer() {
        System.out.println("Введіть ім'я та прізвище нового клієнта:");
        String newCustomer = scanner.nextLine();

        String[] updatedCustomers = new String[customers.length + 1];
        System.arraycopy(customers, 0, updatedCustomers, 0, customers.length);
        updatedCustomers[customers.length] = newCustomer;
        customers = updatedCustomers;

        System.out.println("Новий клієнт доданий.");
    }

    private void checkCustomer() {
        System.out.println("Введіть ім'я та прізвище клієнта для перевірки:");
        String customerToCheck = scanner.nextLine();
        boolean found = false;
        for (String customer : customers) {
            if (customer.equalsIgnoreCase(customerToCheck)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Клієнт знайдений.");
        } else {
            System.out.println("Клієнта не знайдено.");
        }
    }
    public String[] getCustomers() {
        return customers;
    }

    public void setCustomers(String[] customers) {
        this.customers = customers;
    }

    public static void main(String[] args) {
        CustomersInfo customersInfo = new CustomersInfo();
        customersInfo.customers();
    }
}


