package sheridan.teixerya.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Envelope implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Envelope.class);

    @Min(0)
    @Max(3)
    private int message = 1;

    private int number = 0;
    private final Random random = new Random();
    int x = random.nextInt(3) + 1;

    static String resultMessage = "No Winner yet";


    @NotBlank
    private String firstName = "";

    public Envelope() {
    }

    public Envelope(int message, int number) {

        logger.trace("Envelope constructor is called");
        this.message = message;
        this.number = number;

    }

    public int getNumber() {


        logger.trace("getNumber2() is called");

        setNumber(x);
        logger.debug("getNumber2 = " + x);
        return x;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getResultMessage() {
        System.out.println("getResult() was called");
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getWinner() {


        String personPlay = ""; //User's play -- "R", "P", or "S"
        int personInt;

        String computerPlay = ""; //Computer's play -- "R", "P", or "S"
        int computerInt; //Randomly generated number used to determine


        System.out.println("Hey, let's play Rock, Paper, Scissors!\n" +
                "Please enter a move.\n" + "Rock = R, Paper" +
                "= P, and Scissors = S.");

        System.out.println();

        //Generate computer's play (0,1,2)
        computerInt = x;
        personInt = getMessage() + 1;

        //Translate computer's randomly generated play to
        //string using if //statements


        if (personInt == 1)
            personPlay = "R";
        else if (personInt == 2)
            personPlay = "P";
        else if (personInt == 3)
            personPlay = "S";

        //Print computer's play
        System.out.println("Person play is: " + personPlay);

        if (computerInt == 1)
            computerPlay = "R";
        else if (computerInt == 2)
            computerPlay = "P";
        else if (computerInt == 3)
            computerPlay = "S";

        //Print computer's play
        System.out.println("Computer play is: " + computerPlay);

        //See who won. Use nested ifs


        if (personPlay.equals(computerPlay)) {
            System.out.println("It's a tie!");
            setResultMessage("It's a tie!");
        } else if (personPlay.equals("R")) {
            if (computerPlay.equals("S")) {
                System.out.println("Rock crushes scissors. You win!!");
                setResultMessage("Rock crushes scissors. You win!!");
            } else if (computerPlay.equals("P")) {
                System.out.println("Paper eats rock. You lose!!");
                setResultMessage("Paper eats rock. You lose!!");
            }
        } else if (personPlay.equals("P")) {
            if (computerPlay.equals("S")) {
                System.out.println("Scissor cuts paper. You lose!!");
                setResultMessage("Scissor cuts paper. You lose!!");

            } else if (computerPlay.equals("R")) {
                System.out.println("Paper eats rock. You win!!");
                setResultMessage("Paper eats rock. You win!!");
            }
        } else if (personPlay.equals("S")) {
            if (computerPlay.equals("P")) {
                System.out.println("Scissor cuts paper. You win!!");
                setResultMessage("Scissor cuts paper. You win!!");

            } else if (computerPlay.equals("R")) {
                System.out.println("Rock breaks scissors. You lose!!");
                setResultMessage("Rock breaks scissors. You lose!!");
            }
        } else {
            System.out.println("Invalid user input.");
            setResultMessage("Invalid user input.");
        }


        return getResultMessage() + " " + resultMessage;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "message= " + message +
//                " number= " + number+
//                " this.number= " + this.number +
//                " getNumber(fromTosString)= " + this.getNumber() + '\'' +

                '}';
    }
}