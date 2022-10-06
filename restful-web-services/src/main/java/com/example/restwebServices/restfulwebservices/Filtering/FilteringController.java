package com.example.restwebServices.restfulwebservices.Filtering;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new SomeBean("value1", "value2", "value3"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        mappingJacksonValue.setFilters(new SimpleFilterProvider().addFilter("SomeBeanFilter", filter));
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filterSomeBean() {
        return List.of(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));
    }

}
