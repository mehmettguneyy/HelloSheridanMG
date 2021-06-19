//Mehmet GUNEY / Sheridan College /991598109

package sheridan.guneym.assignment2.service;

import sheridan.guneym.assignment2.repository.PetDataRepository;
import sheridan.guneym.assignment2.repository.PetEntity;
import sheridan.guneym.assignment2.model.PetForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service

public class PetDataServiceImpl implements PetDataService {

    private final PetDataRepository petDataRepository;

   PetDataServiceImpl(PetDataRepository petDataRepository){
        this.petDataRepository = petDataRepository;
    }


    private static void copyFormToEntity(PetForm form, PetEntity pet){
       // pet.setId(form.getId());
        pet.setPetName(form.getPetName());
        pet.setKindName(form.getKindName());
        pet.setPetGender(form.getPetGender());
        pet.setPetVac(form.isPetVac());

    }

    private static void copyEntityToForm(PetEntity pet, PetForm form){
        form.setId(pet.getId());
        form.setPetName(pet.getPetName());
        form.setKindName(pet.getKindName());
        form.setPetGender(pet.getPetGender());
        form.setPetVac(pet.getPetVac());

    }

    public void insertPetForm(PetForm form) {
        PetEntity pet = new PetEntity();
        copyFormToEntity(form, pet);
        pet = petDataRepository.save(pet);
        form.setId(pet.getId());
    }

    public List<PetForm> getAllPetForms() {
        List<PetForm> formList = new ArrayList<>();
        List<PetEntity> petList = petDataRepository.findAll();
        for(PetEntity pet: petList){
            PetForm form = new PetForm();
            copyEntityToForm(pet, form);
            formList.add(form);
        }
        return formList;
    }

   public void deletePetForm(int id) {
        petDataRepository.deleteById(id);
    }

    public PetForm getPetForm(int id) {
        Optional<PetEntity> result = petDataRepository.findById(id);
        if(result.isPresent()){
            PetForm form = new PetForm();
            PetEntity pet = result.get();
            copyEntityToForm(pet, form);
            return form;
        }
        return null;
    }

    public void updatePetForm(PetForm form) {
        Optional<PetEntity> result = petDataRepository.findById(form.getId());
        if(result.isPresent()){
            PetEntity pet = result.get();
            copyFormToEntity(form, pet);
            petDataRepository.save(pet);
            //petRepository.flush();
        }
    }
}

