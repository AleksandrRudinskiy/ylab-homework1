import java.util.ArrayList;
import java.util.List;

public class Player {
    private String login;
    private String password;
    private int playerId;
    private int balance;


    private List<Transaction> PlayerTransactions = new ArrayList<>();

    public List<Transaction> getPlayerTransactions() {
        return PlayerTransactions;
    }

    public Player() {
        balance = 0;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "login='" + login + '\'' +
                ", password length='" + password.length() + '\'' +
                ", playerId=" + playerId +
                ", balance=" + balance +
                ", transactions=" + PlayerTransactions.size() +
                '}';
    }
}
