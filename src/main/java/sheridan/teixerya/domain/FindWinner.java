package sheridan.teixerya.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;

public class FindWinner implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(FindWinner.class);

    private final Random random = new Random();
    int x = random.nextInt(3) + 1;
    private int computerChoice = 0;
    private int winnerResult = 1;

    static String resultMessage = "No Winner yet";

public FindWinner(){}

    public int getComputerChoice() {


        logger.trace("getNumber2() is called");

        setComputerChoice(x);
        logger.debug("getNumber2 = " + x);
        return x;
    }

    public void setComputerChoice(int computerChoice) {
        this.computerChoice = computerChoice;
    }


    public String getResultMessage() {
        System.out.println("getResult() was called");
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getWinnerResult() {
        System.out.println(winnerResult);
        return winnerResult;

    }

    public void setWinnerResult(int winnerInput) {
        winnerResult = winnerInput;
        System.out.println("setWinner Result was called "+ winnerResult);
    }

    public String getWinner(Envelope envelope) {


        String personPlay = ""; //User's play -- "R", "P", or "S"
        int personInt;

        String computerPlay = ""; //Computer's play -- "R", "P", or "S"
        int computerInt; //Randomly generated number used to determine


        System.out.println("Rock, Paper, Scissors has started.\n" +
                "Available weapons.\n" + "Rock = R, Paper" +
                "= P, and Scissors = S.\n");



        //Generate computer's play (0,1,2)
        computerInt = x;
        personInt = envelope.getUserChoice() + 1;

        //Translate computer's randomly generated play to
        //string using if //statements


        if (personInt == 1)
            personPlay = "R";
        else if (personInt == 2)
            personPlay = "P";
        else if (personInt == 3)
            personPlay = "S";

        //Print computer's weapon
        System.out.println("Person played: " + personPlay);

        if (computerInt == 1)
            computerPlay = "R";
        else if (computerInt == 2)
            computerPlay = "P";
        else if (computerInt == 3)
            computerPlay = "S";

        //Print computer's weapon
        System.out.println("Computer played: " + computerPlay);


        //determine winner

        if (personPlay.equals(computerPlay)) {
            System.out.println("tie match");
            setResultMessage("tie match");
            setWinnerResult(3);


        } else if (personPlay.equals("R")) {
            if (computerPlay.equals("S")) {
                System.out.println("Rock crushed scissors. You win");
                setResultMessage("Rock crushed scissors. You win");
                setWinnerResult(2);

            } else if (computerPlay.equals("P")) {
                System.out.println("Paper out smarted rock. You lose");
                setResultMessage("Paper out smarted rock. You lose");
                setWinnerResult(1);
            }
        } else if (personPlay.equals("P")) {
            if (computerPlay.equals("S")) {
                System.out.println("Scissors cut paper. You lose");
                setResultMessage("Scissors cut paper. You lose");
                setWinnerResult(1);

            } else if (computerPlay.equals("R")) {
                System.out.println("Paper eats rock. You win!!");
                setResultMessage("Paper eats rock. You win!!");
                setWinnerResult(2);
            }
        } else if (personPlay.equals("S")) {
            if (computerPlay.equals("P")) {
                System.out.println("Paper out smarted rock. You win");
                setResultMessage("Paper out smarted rock. You win");
                setWinnerResult(2);

            } else if (computerPlay.equals("R")) {
                System.out.println("Rock broke scissors. You lose");
                setResultMessage("Rock broke scissors. You lose");
                setWinnerResult(1);
            }
        } else {
            System.out.println("Invalid weapon input.");
            setResultMessage("Invalid weapon input.");

        }

        return resultMessage;
    }


}//Object closing brace