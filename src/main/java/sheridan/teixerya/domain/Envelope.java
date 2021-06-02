package sheridan.teixerya.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Envelope implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Envelope.class);

    @Min(0)
    @Max(3)
    private int userChoice = 1;


    @NotBlank
    private String firstName = "";

    public Envelope() {
    }

    public Envelope(int userChoice) {

        logger.trace("Envelope constructor is called");
        this.userChoice = userChoice;

    }


    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "message= " + userChoice + '}';
    }
}