package sheridan.guneym.exercise1v1.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@SuppressWarnings("unused")
public class User implements Serializable {



    public User() {
    }

    public User(String firstName) {
        this.firstName = firstName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Min(0)
    @Max(1)
    private int input2 = 0;
    public int getInput2() {
        return input2;
    }

    public void setInput2(int input2) {
        this.input2 = input2;
    }

    private String firstName = "";

    @Override
    public String toString() {
        return "User{" +
                "firstName=" + firstName + ", input2=" + input2 +
                '}';
    }
}
