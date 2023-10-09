import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Transaction {

    private TypeOfTransaction type;
    private StatusOfTransaction status;
    private int id = 0;

    public TypeOfTransaction getType() {
        return type;
    }

    public StatusOfTransaction getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }

    public void setStatus(StatusOfTransaction status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
