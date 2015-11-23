package org.vanir.service.impl

import org.springframework.stereotype.Service
import org.vanir.service.api.IHelloService

/**
 * Created by jguidoux on 21/11/2015.
 */
@Service
class HelloService implements IHelloService {


    @Override
    String sayHello() {
        "Hello the world!!!"
    }
}
