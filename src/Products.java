import java.util.Scanner;

public class Products {
    private String[] products = {"Помідори", "Огірки", "Картопля",
            "Банани", "Апельсини", "Вода","Хліб"};

    private Scanner scanner;

    public Products() {
        this.scanner = new Scanner(System.in);
    }

    public void products() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Вивести список товарів");
            System.out.println("2. Додати новий товар");
            System.out.println("3. Перевірити чи товар є в списку");
            System.out.println("4. Видалити товар");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    allProducts();
                    break;
                case 2:
                    addNewProducts();
                    break;
                case 3:
                    checkProducts();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }

    public void allProducts() {
        System.out.println("Список товарів:");
        for (String products : products) {
            System.out.println(products);
        }
    }

    private void addNewProducts() {
        System.out.println("Введіть новий товар:");
        String newCustomer = scanner.nextLine();

        String[] updatedCustomers = new String[products.length + 1];
        System.arraycopy(products, 0, updatedCustomers, 0,products.length);
        updatedCustomers[products.length] = newCustomer;
        products = updatedCustomers;

        System.out.println("Новий товар доданий.");
    }

    private void checkProducts() {
        System.out.println("Введіть товар для перевірки:");
        String customerToCheck = scanner.nextLine();
        boolean found = false;
        for (String product : products) {
            if (product.equalsIgnoreCase(customerToCheck)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Товар знайдений.");
        } else {
            System.out.println("Товар не знайдено.");
        }
    }
    private void removeProduct() {
        System.out.println("Введіть товар який потрібно видалити:");
        String productToDelete = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(productToDelete)) {
                found = true;
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[products.length - 1] = "";
                System.out.println("Товар видалено.");
                break;
            }
        }
        if (!found) {
            System.out.println("Товар не знайдено для видалення.");
        }
    }
    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public static void main(String[] args) {
        Products products = new Products();
        products.products();

        String[] productsArray = products.getProducts();
        products.setProducts(productsArray);
    }
}
