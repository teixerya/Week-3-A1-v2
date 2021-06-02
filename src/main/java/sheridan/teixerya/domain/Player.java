package sheridan.teixerya.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Player implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Player.class);

    @Min(0)
    @Max(3)
    private int userChoice = 1;

    @NotBlank
    private String firstName = "";

    public Player() {
    }

    public Player(int userChoice) {

        logger.trace("Player constructor is called");
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
        return "Player{" + "message= " + userChoice + '}';
    }
}