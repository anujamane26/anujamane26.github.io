package com.forexchange.currencyconverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("Currencyapi")
public class CurrencyController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyService service;
	
	@GetMapping("/currency-exchange/from/{fromcurrency}/to/{tocurrency}")
	public ArrayList<CurrencyRates> getCurrencyExRate(@PathVariable String fromcurrency, String tocurrency){
		
		ArrayList<CurrencyRates> list= new ArrayList<CurrencyRates>();
		
		 Map<String, String> uriVariables = new HashMap<>();
	        uriVariables.put("from", fromcurrency);
	        uriVariables.put("to", tocurrency);

	        ResponseEntity<CurrencyRates> responseEntity1 = new RestTemplate().getForEntity(
	                " https://www.xe.com/currencyconverter", CurrencyRates.class,
	                uriVariables);

	        CurrencyRates response1 = responseEntity1.getBody();

	        CurrencyRates a1= new CurrencyRates(response1.getId(), fromcurrency, tocurrency, response1.getExchangeRate(), response1.getConversionMultiple(),
	        		response1.getConversionMultiple().multiply(response1.getExchangeRate()), response1.getPort());
		
	        
	        ResponseEntity<CurrencyRates> responseEntity2 = new RestTemplate().getForEntity(
	                " https://www.xe.com/currencyconverter", CurrencyRates.class,
	                uriVariables);

	        CurrencyRates response2 = responseEntity1.getBody();

	        CurrencyRates a2= new CurrencyRates(response2.getId(), fromcurrency, tocurrency, response2.getExchangeRate(), response2.getConversionMultiple(),
	        		response2.getConversionMultiple().multiply(response2.getExchangeRate()), response2.getPort());
	        
	        ResponseEntity<CurrencyRates> responseEntity3 = new RestTemplate().getForEntity(
	                " https://www.xe.com/currencyconverter", CurrencyRates.class,
	                uriVariables);

	        CurrencyRates response3 = responseEntity1.getBody();

	        CurrencyRates a3= new CurrencyRates(response3.getId(), fromcurrency, tocurrency, response3.getExchangeRate(), response3.getConversionMultiple(),
	        		response3.getConversionMultiple().multiply(response3.getExchangeRate()), response3.getPort());
	        
	        list.add(a1);
	        list.add(a2);
	        list.add(a3);
	        
	        return list;
	}
	
	@GetMapping("/convert/from/{fromcurrency}/to/{tocurrency}/amount/{conversionMultiple}")
	public Map getConvertedValue(@PathVariable String fromcurrency, String tocurrency,BigDecimal conversionMultiple ){
		
		return service.getConvertedValue(fromcurrency, tocurrency, conversionMultiple);
	}
	
}
