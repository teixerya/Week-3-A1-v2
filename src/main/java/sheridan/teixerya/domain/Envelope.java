package sheridan.teixerya.domain;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Envelope implements Serializable {

    @Min(0)
    @Max(1)
    private int message;

    @NotBlank
    private String firstName = "";

    @NotBlank
    private String lastName = "";


    public Envelope() {
    }

    public Envelope(int message,String firstName,String lastName) {
        this.message = message;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "message=" + message +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}