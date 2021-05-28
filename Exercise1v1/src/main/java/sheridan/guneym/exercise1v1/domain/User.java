package sheridan.guneym.exercise1v1.domain;

import java.io.Serializable;

@SuppressWarnings("unused")
public class User implements Serializable {

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
                "firstName='" + firstName + '\'' +
                '}';
    }
}
