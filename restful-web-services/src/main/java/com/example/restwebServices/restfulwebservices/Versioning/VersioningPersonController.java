package com.example.restwebServices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person" ,params = "version=1")
    public PersonV1 personV1WithParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 personV2WithParam() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person" ,headers = "X-API-VERSION=1")
    public PersonV1 personV1WithHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person",headers = "X-API-VERSION=2")
    public PersonV2 personV2WithHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person",produces = "application/vnd.company.app-v1+json")
    public PersonV1 personV1WithProduces() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person",produces = "application/vnd.company.app-v2+json")
    public PersonV2 personV2WithProduces() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}
