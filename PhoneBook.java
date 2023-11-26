import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавление записей в телефонную книгу
        addContact(phoneBook, "Сергей Гаврилин", "123-456-789");
        addContact(phoneBook, "Маша Разумовская", "987-654-321");
        addContact(phoneBook, "Паша Коломогоров", "456-789-012");
        addContact(phoneBook, "Сергей Гаврилин", "111-222-333");
        addContact(phoneBook, "Маша Разумовская", "555-666-777");
        addContact(phoneBook, "Лика Говорухина", "985-633-765");

        // Вывод телефонной книги с учетом повторяющихся имен
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для вывода телефонной книги с учетом сортировки по убыванию числа
    // телефонов
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создание списка записей из телефонной книги
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка списка по убыванию числа телефонов
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Вывод отсортированной телефонной книги
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
