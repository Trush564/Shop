import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть своє ім'я:");
        String workerName = scanner.nextLine();
        System.out.println("Доброго дня, " + workerName + "!");
        System.out.println("Виберіть:");
        System.out.println("1. Я клієнт ");
        System.out.println("2. Я працівник");
        System.out.println("3. Я власник");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Customers customers = new Customers(scanner);
            customers.customers();
        } else if (choice == 2) {
            Workers workers = new Workers(scanner);
            workers.workers();
        } else if (choice == 3) {
            Owner owner = new Owner();
            owner.owner();
        } else {
            System.out.println("Не правильний вибір");
        }
    }
}
