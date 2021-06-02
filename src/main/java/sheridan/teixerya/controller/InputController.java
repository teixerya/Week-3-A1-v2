package sheridan.teixerya.controller;

import org.springframework.ui.Model;
import sheridan.teixerya.domain.ComputerGenerator;
import sheridan.teixerya.domain.Envelope;
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
         new ModelAndView("Input", "envelope", new Envelope());
        modelAndView.addObject("findWinner", new FindWinner());
        modelAndView.addObject("computerGenerator", new ComputerGenerator());

        return modelAndView;
    }



    @GetMapping("/Process")
    public ModelAndView process(
            @Validated @ModelAttribute Envelope envelope,
            BindingResult bindingResult, FindWinner findWinner, ComputerGenerator computerGenerator){
        logger.trace("process() is called");
        logger.debug("envelope = " + envelope);


        ModelAndView modelAndView2 =
                new ModelAndView("Output", "envelope", envelope);
        modelAndView2.addObject("findWinner", findWinner);
        modelAndView2.addObject("computerGenerator", computerGenerator);

        return modelAndView2;


    }



}
