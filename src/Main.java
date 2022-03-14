import service.Session;

import java.util.Scanner;

public class Main {
    static Session session = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createNewSession();
                    break;
                case 2:
                    addPartaker();
                    break;
                case 3:
                    addSpending();
                    break;
                case 4:
                    printExpense();
                    break;
                case 0:
                    return;
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите один из вариантов:");
        System.out.println("1 - создать сессию трат.");
        System.out.println("2 - добавить в сессию участников.");
        System.out.println("3 - занести новую трату.");
        System.out.println("4 - посмотреть список должников.");
        System.out.println("0 - выход.");
    }

    public static void createNewSession() {
        session = new Session();
    }

    public static void addPartaker() {
        session.addPartaker();
    }

    public static void addSpending() {
        session.saveExpence();
    }

    public static void printExpense() {
        session.printList();
    }
}

