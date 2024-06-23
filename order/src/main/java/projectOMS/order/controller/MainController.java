package projectOMS.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("mainpage")
    public String mainpage(Model model){
        model.addAttribute("data", "hello");
        return "mainpage";
    }

    @GetMapping("page1")
    public String page1(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "page1";
    }


}
