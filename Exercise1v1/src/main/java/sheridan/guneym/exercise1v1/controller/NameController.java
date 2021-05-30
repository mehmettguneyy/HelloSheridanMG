package sheridan.guneym.exercise1v1.controller;

import sheridan.guneym.exercise1v1.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class NameController {

    private final Logger logger = LoggerFactory.getLogger(NameController.class);

    @GetMapping("/Index")
    public ModelAndView input(){
        logger.trace("index() is called");
        return new ModelAndView("Index", "user", new User());
    }

    @GetMapping("/Output")
    public ModelAndView output(
            @Validated @ModelAttribute User user,
                         BindingResult bindingResult, Model model) {
        logger.trace("output() is called");
        logger.debug("user = " + user);
        if(bindingResult.hasErrors()){
            return new ModelAndView("Index");
        }
        model.addAttribute("user", user);
        return new ModelAndView("Output", "user", user);

    }
}

