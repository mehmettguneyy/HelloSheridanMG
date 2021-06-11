package sheridan.guneym.exercise2.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class CustomerForm implements Serializable {

    private int customerId = 0;

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String firstName = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String lastName = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*" )
    private String email = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*" )
    private String street = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*" )
    private String city = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*" )
    private String state = "";

    @NotBlank
    @Size(max = 5)
    @Pattern(regexp = "[0-9]*" )
    private String zipCode = "";


    public CustomerForm() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}


