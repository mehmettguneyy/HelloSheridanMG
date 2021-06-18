package sheridan.guneym.assignment2.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pet")
public class PetEntity implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pet_name")
    private String petName = "";

    @Column(name = "kind_name")
    private String kindName = "";

    @Column(name = "pet_gender")
    private Integer petGender = 0;

    @Column(name = "pet_vac")
    private Boolean petVac = false;

    public PetEntity(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPetGender() {
        return petGender;
    }

    public void setPetGender(Integer petGender) {
        this.petGender = petGender;
    }

    public Boolean getPetVac() {
        return petVac;
    }

    public void setPetVac(Boolean petVac) {
        this.petVac = petVac;
    }
}