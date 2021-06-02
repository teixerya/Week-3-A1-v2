package sheridan.teixerya.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;

public class ComputerGenerator implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(ComputerGenerator.class);

    public ComputerGenerator(){}

    private final Random random = new Random();
    int generatedValue = random.nextInt(3) + 1;
    private int computerChoice = 0;

    public int getGeneratedValue() {
        return generatedValue;
    }

    public void setGeneratedValue(int generatedValue) {
        this.generatedValue = generatedValue;
    }

    public int getComputerChoice() {

        logger.trace("getNumber2() is called");
        setComputerChoice(generatedValue);
        logger.debug("getNumber2 = " + generatedValue);
        return generatedValue;
    }

    public void setComputerChoice(int computerChoice) {
        this.computerChoice = computerChoice;
    }


}//Close Class brace
