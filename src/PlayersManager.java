import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PlayersManager {
    private HashMap<Integer, Player> players = new HashMap<>();
    private Player autorizatedPlayer = null;
    private int id = 0;

    public Player getAutorizatedPlayer() {
        return autorizatedPlayer;
    }

    Player createPlayer(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Придумайте логин");
        String login = scanner.nextLine();
        System.out.println("Придумайте пароль");
        String password = scanner.nextLine();
        int count = 0;
        Player newPlayer = new Player();
        for (Player player : players.values()) {
            if (login.equals(player.getLogin())) {
                System.out.println("Игрок с таким логином уже существует");
                break;
            } else {
                count++;
            }
        }
        if (players.size() == count) {
            id++;
            newPlayer.setPlayerId(id);
            newPlayer.setLogin(login);
            newPlayer.setPassword(password);
            players.put(id, newPlayer);
        }
        return newPlayer;
    }

    Player autorization(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        int count = 0;
        Player findPlayer = null;
        for (Integer id : players.keySet()) {
            Player player = players.get(id);
            if (login.equals(player.getLogin()) && password.equals(player.getPassword())) {
                findPlayer = player;
                autorizatedPlayer = player;
                System.out.println("Добро пожаловать " + player.getLogin());
            } else {
                count++;
            }
        }
        if (count == players.size()) {
            System.out.println("Такого пользователя нет");
        }
        return findPlayer;
    }

    void getPlayerBalance() {
        int balance;
        if (autorizatedPlayer != null) {
            balance = autorizatedPlayer.getBalance();
            System.out.println("Баланс игрока = " + balance);
        } else {
            System.out.println("Сначало необходимо авторизоваться!");
        }
    }

    void printPlayersList() {
        for (Integer i : players.keySet()) {
            System.out.println(players.get(i));
        }
    }

    Player creditBalanse(Scanner scanner) {
        Player returnedPlayer = null;
        if (autorizatedPlayer == null) {
            System.out.println("Сначало необходимо авторизоваться!");
        } else {
            System.out.println("Введите сумму пополнения");
            int sum = scanner.nextInt();
            Transaction transaction = new Transaction();
            id++;
            transaction.setId(id);
            transaction.setType(TypeOfTransaction.CREDIT);
            transaction.setStatus(StatusOfTransaction.DONE);
            int balance = autorizatedPlayer.getBalance();
            balance += sum;
            autorizatedPlayer.setBalance(balance);
            autorizatedPlayer.getPlayerTransactions().add(transaction);
        }
        return returnedPlayer;
    }

    Player debetBalanse(Scanner scanner) {
        Player returnedPlayer = null;
        if (autorizatedPlayer == null) {
            System.out.println("Сначало необходимо авторизоваться!");
        } else {
            System.out.println("Введите сумму снятия");
            int sum = scanner.nextInt();
            Transaction transaction = new Transaction();
            id++;
            transaction.setId(id);
            transaction.setType(TypeOfTransaction.DEBIT);
            if (autorizatedPlayer.getBalance() >= sum) {
                transaction.setStatus(StatusOfTransaction.DONE);
                int balance = autorizatedPlayer.getBalance();
                balance -= sum;
                autorizatedPlayer.setBalance(balance);
            } else {
                transaction.setStatus(StatusOfTransaction.NOT_DONE);
            }
            autorizatedPlayer.getPlayerTransactions().add(transaction);
        }
        return returnedPlayer;
    }

    List<Transaction> showTransactionsOfPlayer() {
        List<Transaction> list = new ArrayList<>();
        if (autorizatedPlayer == null) {
            System.out.println("Сначало необходимо авторизоваться!");
        } else {
            list.addAll(autorizatedPlayer.getPlayerTransactions());
        }
        return list;
    }
}
