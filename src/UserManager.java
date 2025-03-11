public class UserManager {
    private static final int MAX_USERS = 15;
    private String[] usernames = new String[MAX_USERS];
    private String[] passwords = new String[MAX_USERS];
    private int userCount = 0;

    public void addUser(String username, String password) throws Exception {
        if (userCount >= MAX_USERS) {
            throw new Exception("Досягнуто максимальну кількість користувачів!");
        }
        if (!isValidUsername(username)) {
            throw new Exception("Неправильне ім'я користувача!");
        }
        if (!isValidPassword(password)) {
            throw new Exception("Неприпустимий пароль!");
        }

        usernames[userCount] = username;
        passwords[userCount] = password;
        userCount++;
    }

    public void removeUser(String username) throws Exception {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                usernames[i] = usernames[userCount - 1];
                passwords[i] = passwords[userCount - 1];
                userCount--;
                return;
            }
        }
        throw new Exception("Користувача не знайдено!");
    }

    public void authenticate(String username, String password) throws Exception {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return;
            }
        }
        throw new Exception("Невірне ім'я користувача або пароль!");
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 5 && !username.contains(" ");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 10 && password.matches(".*[!@#$%^&*()].*") && password.matches(".*\\d.*\\d.*\\d.*");
    }
}

