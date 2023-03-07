package com.forexchange.currencyconverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

	@Autowired
	CurrencyDao dao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ArrayList<CurrencyRates> getCurrencyExRate(String fromcurrency, String tocurrency)
     {
		return dao.getCurrencyExRate(fromcurrency, tocurrency);
		
		}

	public Map getConvertedValue(@PathVariable String fromcurrency, String tocurrency ,BigDecimal conversionMultiple) {
		
		List<CurrencyRates> list=dao.getConvertedValue(fromcurrency, tocurrency);
		List rates=list.stream().map(e->e.getExchangeRate()).collect(Collectors.toList());
		Collections.sort(rates);
		Integer Max=(Integer)((conversionMultiple.intValue())*(Integer)(rates.get(rates.size()-1)));
		Integer Min=(Integer)((conversionMultiple.intValue())*(Integer)(rates.get(0)));
		
		HashMap<String,Integer> map=new HashMap<>();
		map.put("Max_Value",Max);
		map.put("Min_Value",Min);
		return map;
	}
}