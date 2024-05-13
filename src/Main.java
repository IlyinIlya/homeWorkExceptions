import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            validation("Ferrari", "ABCdef123_", "ABCdef123_");
        } catch (WrongLoginException el) {
            System.out.println("Недопустимый логин: " + el.getMessage());
        } catch (WrongPasswordException ep) {
            System.out.println("Недопустимый пароль: " + ep.getMessage());
        } finally {
            System.out.println("Подождите...");
        }
    }

    private static boolean validation(String login, String password, String confirmPassword) {
        if (!login.matches("(\\w+)")) {
            throw new WrongLoginException("В логине " + login + " использованы недопустимые символы");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Логин " + login + " содержит более 20 символов");
        }
        if (!password.matches("(\\w+)")) {
            throw new WrongPasswordException("В пароле " + password + " использованы недопустимые символы");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введенный пароль " + password + " не верен");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Пароль " + password + " содержит более 20 символов");
        }
        return false;
    }
}

