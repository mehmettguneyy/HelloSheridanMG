package sheridan.guneym.exercise1v1.domain;

import java.io.Serializable;

@SuppressWarnings("unused")
public class User implements Serializable {

    @Min(0)
    @Max(1)
    private int input2 = 1;
    public int getMessage() {
        return input2;
    }

    public void setMessage(int message) {
        this.input2 = message;
    }

    private String firstName = "";

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


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +"input2=" + input2 +
                '}';
    }
}
