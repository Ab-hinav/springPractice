package com.microservices.currencyexchangeservice;

//import com.netflix.discovery.DiscoveryClient;
//import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(85));
//        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

//    @RequestMapping("/service-instances/{applicationName}")
//    public Application serviceInstancesByApplicationName(
//            @PathVariable String applicationName) {
//        return this.discoveryClient.getApplication(applicationName);
//    }

}
