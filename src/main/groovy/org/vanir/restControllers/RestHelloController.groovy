package org.vanir.restControllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.vanir.service.api.IHelloService

/**
 * Created by jguidoux on 21/11/2015.
 */
@RestController()
@RequestMapping("/rest")
class RestHelloController {

    @Autowired
    private IHelloService service

    @RequestMapping("/hello")
    public String index(Model model) {
        return service.sayHello()
    }
}
