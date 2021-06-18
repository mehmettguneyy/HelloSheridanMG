package sheridan.guneym.assignment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sheridan.guneym.assignment2.model.PetForm;
import sheridan.guneym.assignment2.service.PetDataService;

import java.util.List;

@Controller
public class PetDataController {
    private final Logger logger = LoggerFactory.getLogger(PetDataController.class);

    private static final String[] kinds = {
            "Cat",
            "Dog",
            "Rabbit"};

    private final PetDataService petDataService;

    public PetDataController(PetDataService petDataService){
        this.petDataService = petDataService;
    }


    @GetMapping(value={"/", "/Index"})
    public ModelAndView index(){
        logger.trace("index() is called");
        List<PetForm> list = petDataService.getAllPetForms();
        return new ModelAndView("Index",
                "pets", list);
    }

    @GetMapping("/AddPet")
    public ModelAndView addPet(){
        logger.trace("addPet() is called");
        ModelAndView modelAndView =
                new ModelAndView("AddPet",
                        "form", new PetForm());
        modelAndView.addObject("kinds", kinds);
        return modelAndView;
    }
    @PostMapping("/InsertPet")
    public String insertPet(
            @Validated @ModelAttribute("form") PetForm form,
            BindingResult bindingResult,
            Model model){
        logger.trace("insertPet() is called");
        // checking for the input validation errors
        if (bindingResult.hasErrors()) {
            logger.trace("input validation errors");
            //model.addAttribute("form", form);
            model.addAttribute("kinds", kinds);
            return "AddPet";
        } else {
            logger.trace("the user inputs are correct");
            petDataService.insertPetForm(form);
            return "redirect:ConfirmInsert/" + form.getId();
        }
    }
    @GetMapping("/ConfirmInsert/{id}")
    public String confirmInsert(@PathVariable(name = "id") String strId, Model model){
        logger.trace("confirmInsert() is called");
        try {
            int id = Integer.parseInt(strId);
            logger.trace("looking for the data in the database");
            PetForm form = petDataService.getPetForm(id);
            if (form == null) {
                logger.trace("no data for this id=" + id);
                return "DataNotFound";
            } else {
                logger.trace("showing the data");
                model.addAttribute("form", form);
                return "ConfirmInsert";
            }
        } catch (NumberFormatException e) {
            logger.trace("the id in not an integer");
            return "DataNotFound";
        }
    }
    @GetMapping("/DeletePet")
    public String deletePet(@RequestParam String id, Model model) {
        logger.trace("deletePet() is called");
        try {
            PetForm form = petDataService.getPetForm(Integer.parseInt(id));
            if (form != null) {
                model.addAttribute("pet", form);
                return "DeletePet"; // ask "Do you really want to remove?"
            } else {
                return "redirect:Index";
            }
        } catch (NumberFormatException e) {
            return "redirect:Index";
        }
    }
    @PostMapping("/RemovePet")
    public String removePet(@RequestParam String id) {
        logger.trace("removePet() is called");
        try {
            petDataService.deletePetForm(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            logger.trace("the id is missing or not an integer");
        }
        return "redirect:Index";
    }
    @GetMapping("/EditPet")
    public String editPet(@RequestParam String id, Model model) {
        logger.trace("editPet() is called");
        try {
            PetForm form = petDataService.getPetForm(Integer.parseInt(id));
            if (form != null) {
                model.addAttribute("form", form);
                model.addAttribute("kinds", kinds);
                return "EditPet";
            } else {
                logger.trace("no data for this id=" + id);
                return "redirect:Index";
            }
        } catch (NumberFormatException e) {
            logger.trace("the id is missing or not an integer");
            return "redirect:Index";
        }
    }
    @PostMapping("/UpdatePet")
    public String updatePet(
            @Validated @ModelAttribute("form") PetForm form,
            BindingResult bindingResult,
            Model model) {
        logger.trace("updatePet() is called");
        // checking for the input validation errors
        if (bindingResult.hasErrors()) {
            logger.trace("input validation errors");
            //model.addAttribute("form", form);
            model.addAttribute("kinds", kinds);
            return "EditPet";
        } else {
            logger.trace("the user inputs are correct");
            petDataService.updatePetForm(form);
            logger.debug("id = " + form.getId());
            return "redirect:Index/" + form.getId();
        }
    }
}
