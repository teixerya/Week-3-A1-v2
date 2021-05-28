package sheridan.teixerya.domain;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Envelope implements Serializable {

    @Min(0)
    @Max(2)
    private int message = 1;
    // no need to validate the boolean
    private boolean registered = false;

    public Envelope() {
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "message=" + message +
                ", registered=" + registered +
                '}';
    }
}