package in.aayush.poc.dcos.controller;

import in.aayush.poc.dcos.model.HelloWorld;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by ajai20 on 18/05/17.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET , path = "/{requester}")
    public ResponseEntity<HelloWorld> sayHello(@PathVariable("requester") String requester){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName(requester);
        helloWorld.setMessage("Hello Requester");
        return new ResponseEntity<HelloWorld>(helloWorld , HttpStatus.OK);
    }
}
    