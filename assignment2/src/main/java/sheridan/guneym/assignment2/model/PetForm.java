package sheridan.guneym.assignment2.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class PetForm implements Serializable {

    private int id = 0;

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String petName = "";

    @NotBlank
    @Pattern(regexp = "(Cat|Dog|Rabbit|)?")
    private String kindName = "";

    @NotNull
    @Min(1)
    @Max(3)
    private int petGender = 1;

    private boolean petVac = false;

    public PetForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public int getPetGender() {
        return petGender;
    }

    public void setPetGender(int petGender) {
        this.petGender = petGender;
    }

    public boolean isPetVac() {
        return petVac;
    }

    public void setPetVac(boolean petVac) {
        this.petVac = petVac;
    }
}
