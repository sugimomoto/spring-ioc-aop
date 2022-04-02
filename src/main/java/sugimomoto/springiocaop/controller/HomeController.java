package sugimomoto.springiocaop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sugimomoto.springiocaop.repository.*;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class HomeController {
    
    private final ApplicationContext appContext;

    @GetMapping
    public String showList(Model model){
        var repository = appContext.getBean(CoffeeRepository.class);
        model.addAttribute("toString",this.toString());
        model.addAttribute("allCoffee", repository.findAll());

        return "index";
    }
}
