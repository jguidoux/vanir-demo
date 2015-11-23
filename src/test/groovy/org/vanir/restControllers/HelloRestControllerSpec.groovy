package org.vanir.restControllers

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.servlet.View
import org.vanir.service.api.IHelloService
import spock.lang.Specification

import java.nio.charset.Charset

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Created by jguidoux on 21/11/2015.
 */
class HelloRestControllerSpec extends Specification {


    public static
    final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    def "/rest/hello call HellooService"() {

        given: "an hello service"
        and: "An hello controller mapping the url /hello"
        def service = Mock(IHelloService)
        service.sayHello() >> "Hello world"
        def controller = new RestHelloController()
        controller.service = service
        View mockView = Mock()
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build()

        when: "I call the /hello url"
        mockMvc.perform(get("/rest/hello"))

        then:
        1 * service.sayHello() >> "Hello world"


    }

    def "/hello return 'Hello world"() {

        given: "an hello service"
        and: "An hello controller mapping the url /hello"
        def service = Mock(IHelloService)
        service.sayHello() >> "Hello world"
        def controller = new RestHelloController()
        controller.service = service
        View mockView = Mock()
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build()

        when:
        def response = mockMvc.perform(get("/rest/hello"))

        then:
        response.andExpect(status().isOk())
                .andExpect(content().string("Hello world"))

    }


}
