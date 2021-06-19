//Mehmet GUNEY / Sheridan College /991598109

package sheridan.guneym.assignment2.service;

import sheridan.guneym.assignment2.model.PetForm;

import java.util.List;

public interface PetDataService {

    void insertPetForm(PetForm form);

    List<PetForm> getAllPetForms();

    void deletePetForm(int id);

    PetForm getPetForm(int id);

    void updatePetForm(PetForm form);

}
