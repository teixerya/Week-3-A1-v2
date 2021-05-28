package sheridan.teixerya.domain;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Envelope implements Serializable {

    @Min(0)
    @Max(1)
    private int message;


    public Envelope() {
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "Envelope{" +
                "message=" + message +
                '}';
    }
}