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

@Controller
public class NameController {

    private final Logger logger = LoggerFactory.getLogger(NameController.class);

    @GetMapping("/Input")
    public ModelAndView input(){
        logger.trace("input() is called");
        return new ModelAndView("Input", "user", new User());
    }

    @GetMapping("/Output")
    public ModelAndView output(
            @Validated @ModelAttribute User user,
                         BindingResult bindingResult) {
        logger.trace("output() is called");
        logger.debug("user = " + user);
        if(bindingResult.hasErrors()){
            return new ModelAndView("Input");
        }
        return new ModelAndView("Output", "user", user);
    }
}

