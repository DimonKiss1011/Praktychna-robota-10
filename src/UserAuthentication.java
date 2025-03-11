import java.util.Scanner;

public class UserAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Додати користувача");
            System.out.println("2 - Видалити користувача");
            System.out.println("3 - Аутентифікація");
            System.out.println("4 - Вийти");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я користувача: ");
                    String username = scanner.nextLine();
                    System.out.print("Введіть пароль: ");
                    String password = scanner.nextLine();
                    try {
                        userManager.addUser(username, password);
                        System.out.println("Користувач успішно зареєстрований.");
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Введіть ім'я користувача для видалення: ");
                    String deleteUsername = scanner.nextLine();
                    try {
                        userManager.removeUser(deleteUsername);
                        System.out.println("Користувача видалено.");
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Введіть ім'я користувача: ");
                    String authUsername = scanner.nextLine();
                    System.out.print("Введіть пароль: ");
                    String authPassword = scanner.nextLine();
                    try {
                        userManager.authenticate(authUsername, authPassword);
                        System.out.println("Аутентифікація успішна!");
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Програма завершена.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
        }
    }
}

