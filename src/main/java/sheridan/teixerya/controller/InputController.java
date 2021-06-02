package sheridan.teixerya.controller;

import sheridan.teixerya.domain.ComputerGenerator;
import sheridan.teixerya.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import sheridan.teixerya.domain.FindWinner;

@Controller
public class InputController {

    private final Logger logger = LoggerFactory.getLogger(InputController.class);


    @GetMapping(value={"/", "/Input"})
    public ModelAndView input(){
        logger.trace("input() is called");

        ModelAndView  modelAndView=
         new ModelAndView("Input", "player", new Player());
        modelAndView.addObject("findWinner", new FindWinner());
        modelAndView.addObject("computerGenerator", new ComputerGenerator());

        return modelAndView;
    }


    @GetMapping("/Process")
    public ModelAndView process(
            @Validated @ModelAttribute Player player,
            BindingResult bindingResult, FindWinner findWinner, ComputerGenerator computerGenerator){
        logger.trace("process() is called");
        logger.debug("player = " + player);


        ModelAndView modelAndView2 =
                new ModelAndView("Output", "player", player);
        modelAndView2.addObject("findWinner", findWinner);
        modelAndView2.addObject("computerGenerator", computerGenerator);

        return modelAndView2;

    }

}
