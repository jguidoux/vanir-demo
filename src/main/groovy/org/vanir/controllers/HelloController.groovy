package org.vanir.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.vanir.service.api.IHelloService

/**
 * Created by jguidoux on 19/11/2015.
 */
@Controller
class HelloController {

    @Autowired
     IHelloService service

    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("message", service.sayHello())
       return  "hello"
    }

}
