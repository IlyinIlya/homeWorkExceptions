import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        validation("Ferrari", "ABCdef123_", "ABCdef123_");
    }

    // Реализуем методы в класссе Main, так как иное не указано в задании

    private static boolean validation(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException el) {
            System.out.println("Недопустимый логин: " + el.getMessage());
        } catch (WrongPasswordException ep) {
            System.out.println("Недопустимый пароль: " + ep.getMessage());
        } finally {
            System.out.println("Подождите...");
        }
        return false;
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (!login.matches("(\\w+)")) {
            throw new WrongLoginException("В логине " + login + " использованы недопустимые символы");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Логин " + login + " содержит более 20 символов");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("(\\w+)")) {
            throw new WrongPasswordException("В пароле " + password + " использованы недопустимые символы");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введенный пароль " + password + " не верен");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Пароль " + password + " содержит более 20 символов");

        }
    }
}
