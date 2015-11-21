package org.vanir.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.vanir.DemoApplication
import org.vanir.service.api.IHelloService
import spock.lang.Specification

/**
 * Created by jguidoux on 21/11/2015.
 */
@SpringApplicationConfiguration(DemoApplication.class)
class HelloServiceSpec extends Specification {

    @Autowired
    IHelloService service

    def "service hello worlo"() {
        given: "the hello service"

        when: "I ask the hello servcie"
        def message = service.sayHello()

        then: "it must return 'Hello the world!!!'"
        message == 'Hello the world!!!'
    }
}
