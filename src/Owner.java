import java.util.Scanner;

public class Owner {
    private Scanner scanner;
    private int hoursWorked;
    private final int standardHours = 1000;

    public Owner() {
        this.scanner = new Scanner(System.in);
    }

    public void owner() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Вирахувати зарплату ");
            System.out.println("2. Вирахувати відпустку для працівників");
            System.out.println("3. Розрахувати прибуток");
            System.out.println("4. Розрахувати премію для працівника");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    calculateSalary();
                    break;
                case 2:
                    calculateVacation();
                    break;
                case 3:
                    calculateProfit();
                    break;
                case 4:
                    calculatePremium(); // Виправлено назву методу
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }

    private void calculateSalary() {
        System.out.println("Введіть кількість годин, які працівник працював:");
        int hours = scanner.nextInt();

        System.out.println("Введіть зарплату за годину:");
        double hourPrice = scanner.nextDouble();

        double salary = hours * hourPrice;
        System.out.println("Загальна зарплата : " + salary);
    }

    private void calculateVacation() {
        System.out.println("Введіть стаж роботи працівника (у роках):");
        int years = scanner.nextInt();
        System.out.println("Введіть кількість використаних днів відпустки:");
        int usedVacationDays = scanner.nextInt();

        int standardVacationDays = 0;

        if (years < 5) {
            standardVacationDays = 21;
        } else if (years >= 5 && years < 10) {
            standardVacationDays = 25;
        } else {
            standardVacationDays = 30;
        }
        int vacationDays = standardVacationDays - usedVacationDays;

        System.out.println("Днів відпустки: " + vacationDays);
    }

    private void calculateProfit() {
        System.out.println("Введіть дохід магазину :");
        double income = scanner.nextDouble();

        System.out.println("Введіть витрати магазину :");
        double costs = scanner.nextDouble();

        double profit = income - costs;

        System.out.println("Прибуток магазину за цей період: " + profit);
    }

    private void calculatePremium() {
        System.out.print("Введіть кількість годин, які працював працівник: ");
        int workedHours = scanner.nextInt();

        int extraHours = workedHours - standardHours;
        if (extraHours > 0) {
            int bonus = (extraHours / 10) * 20;
            System.out.println("Працівник отримує премію у розмірі:" + bonus);
        } else {
            System.out.println("Працівник не отримує премії.");
        }
    }

    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.owner();
    }
}

