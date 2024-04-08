package com.test.api.internal.jsonapi.server.controllers;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import com.test.api.internal.jsonapi.server.model.WhoIsModel;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name, @RequestHeader("X-API-KEY") String api_key) {
        return "Hello " + name + "! (key: " + api_key + ")";
    }

    @RequestMapping(value = "/list/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String list(@PathVariable String name) {
        return "Record are " + name + "!";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String create(@RequestBody WhoIsModel data) {
        return "Put " + (data==null?null:data.getDomainName()) + " into DB!";
    }
}
