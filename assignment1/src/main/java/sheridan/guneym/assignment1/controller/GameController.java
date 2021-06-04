package sheridan.guneym.assignment1.controller;

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
    public String game(Model model){
        logger.trace("game() is called");

        Game game = new Game();
        logger.debug("game = " + game);

        model.addAttribute("game", game);
        return "Output";
    }

}
