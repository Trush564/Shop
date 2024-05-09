import java.util.Scanner;

public class Customers {
    Reviews reviews = new Reviews(100);
    private  Scanner scanner;
    private String[] customerComments;
    private int commentIndex;


    public Customers(Scanner scanner) {

        this.scanner = scanner;
        customerComments = new String[100];
        commentIndex = 0;

    }

    public void customers() {
        boolean ch = true;

        Scanner scanner = new Scanner(System.in);
        while (ch) {
            System.out.println("Виберіть:");
            System.out.println("1. Інформація про магазин");
            System.out.println("2. Написати відгук");
            System.out.println("3. Відгуки");
            System.out.println("4. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Продуктовий магазин Пролісок");
                    System.out.println("Адреса: м.Львів вул.Антоновича 28А");
                    System.out.println("Контакти: +380 (67) 456 3366");
                    System.out.println("E-mail: prolisok@gmail.com");
                    break;
                case 2:
                    System.out.println("Напишіть ваш відгук:");
                    String reviewText = scanner.nextLine();
                    customerComments[commentIndex++] = reviewText;

                    System.out.println("Дякуємо за відгук!");
                    break;
                case 3:
                    System.out.println("Відгуки:");
                    System.out.println("Чудовий магазин!");
                    System.out.println("Супер!");
                    System.out.println("Клас");
                    System.out.println("Хороші продавці");
                    System.out.println("Гарний магазин ");
                    if (reviews != null) {
                        String[] comments = reviews.getComments();
                        if (comments != null) {
                            for (String comment : comments) {
                                if (comment != null) {
                                    System.out.println(comment);
                                }
                            }
                        }
                    }
                    if (customerComments != null) {
                        for (String comment : customerComments) {
                            if (comment != null) {
                                System.out.println(comment);
                            }
                        }
                    }
                    break;
                case 4:
                    ch = false;
                    break;
                default:
                    System.out.println("Неправильний вибір, спробуйте ще раз.");
                    break;
            }
        }
    }
    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }
}
