package sheridan.guneym.assignment1.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import sheridan.guneym.assignment1.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping(value={"/", "/Game"})
    public String card(Model model){
        logger.trace("game() is called");

        Game game = new Game();
        logger.debug("game = " + game);

        model.addAttribute("game", game);
        return "Input";
    }

    @GetMapping("/Process")
    public ModelAndView process(
            @Validated @ModelAttribute Game game,
            BindingResult bindingResult){
        logger.trace("process() is called");
        logger.debug("game = " + game);
        if(bindingResult.hasErrors()){
            return new ModelAndView("Input");
        }
        return new ModelAndView("Output", "game", game);
    }
}