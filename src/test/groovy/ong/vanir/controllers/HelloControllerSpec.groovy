package ong.vanir.controllers

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.servlet.View
import org.vanir.controllers.HelloController
import org.vanir.service.api.IHelloService
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Created by jguidoux on 21/11/2015.
 */
class HelloControllerSpec extends Specification {

    private MockMvc mockMvc;

    def "/hello call HellooService"() {

        given: "an hello service"
        and: "An hello controller mapping the url /hello"
        def service = Mock(IHelloService)
        service.sayHello() >> "Hello world"
        def controller = new HelloController()
        controller.service = service
        View mockView = Mock()
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build()

        when: "I call the /hello url"
        mockMvc.perform(get("/hello"))

        then:
        1 * service.sayHello() >> "Hello world"


    }

    def "/hello return 'Hello world"() {

        given: "an hello service"
        and: "An hello controller mapping the url /hello"
        def service = Mock(IHelloService)
        service.sayHello() >> "Hello world"
        def controller = new HelloController()
        controller.service = service
        View mockView = Mock()
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build()

        when:
        def response = mockMvc.perform(get("/hello"))

        then:
        response.andExpect(status().isOk()).andExpect(model().attribute("message", "Hello world"))


    }

    def "/hello return hello.html page"() {

        given: "an hello service"
        and: "An hello controller mapping the url /hello"
        def service = Mock(IHelloService)
        service.sayHello() >> "Hello world"
        def controller = new HelloController()
        controller.service = service
        View mockView = Mock()
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build()

        when:
        def response = mockMvc.perform(get("/hello"))

        then:
        response.andExpect(status().isOk()).andExpect(view().name("hello"))


    }
}
