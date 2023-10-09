import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PlayersManager playersManager = new PlayersManager();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int count = scanner.nextInt();

            if (count == 0) {
                break;
            } else if (count == 1) {
                scanner.nextLine();
                System.out.println("Придумайте логин");
                String newlogin = scanner.nextLine();
                System.out.println("Придумайте пароль");
                String newPassword = scanner.nextLine();
                playersManager.createPlayer(newlogin, newPassword);

            } else if (count == 2) {
                scanner.nextLine();
                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();
                playersManager.autorization(login, password);

            } else if (count == 3) {
                playersManager.printPlayersList();

            } else if (count == 4) {
                if (playersManager.getAutorizatedPlayer() != null) {
                    int balance = playersManager.getAutorizatedPlayer().getBalance();
                    System.out.println("Баланс игрока = " + balance);
                } else {
                    System.out.println("Сначало необходимо авторизоваться!");
                }


            } else if (count == 5) {
                if (playersManager.getAutorizatedPlayer() != null) {
                    System.out.println("Введите сумму пополнения");
                    int sum = scanner.nextInt();
                    playersManager.creditBalanse(sum);
                } else {
                    System.out.println("Сначало необходимо авторизоваться!");
                }
            } else if (count == 6) {
                System.out.println(playersManager.showTransactionsOfPlayer());
            } else if (count == 7) {
                if (playersManager.getAutorizatedPlayer() != null) {
                    System.out.println("Введите сумму снятия");
                    int sum = scanner.nextInt();
                    playersManager.debetBalanse(sum);
                } else {
                    System.out.println("Сначало необходимо авторизоваться!");
                }

            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберете действие:");
        System.out.println("1 - Регистрация игрока");
        System.out.println("2 - Авторизация игрока");
        System.out.println("3 - Вывести список игроков");
        System.out.println("4 - Текущий баланс игрока");
        System.out.println("5 - Кредит на игрока (пополнение баланса)");
        System.out.println("6 - Просмотр истории пополнения/снятия средств игроком");
        System.out.println("7 - Дебет на игрока (снятие средств)");
        System.out.println("0 - Выход");


    }
}