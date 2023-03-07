package com.forexchange.currencyconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class CurrencyDao {
	
	SessionFactory factory;
	
	public ArrayList<CurrencyRates> getCurrencyExRate(String fromcurrency, String tocurrency){
	Session session=factory.openSession();
	Criteria criteria=session.createCriteria(CurrencyRates.class);
	criteria.add(Restrictions.eq("fromcurrency", fromcurrency));
	criteria.add(Restrictions.eq("tocurrency", tocurrency));
	ArrayList<CurrencyRates> list=(ArrayList<CurrencyRates>) criteria.list();
	//list.sort(CurrencyRates.getExchangeRate());
	return list;
	}
	
	public List<CurrencyRates> getConvertedValue(@PathVariable String fromcurrency, String tocurrency ) {
		
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(CurrencyRates.class);
		criteria.add(Restrictions.eq("fromcurrency", fromcurrency));
		criteria.add(Restrictions.eq("tocurrency", tocurrency));
		List list= criteria.list();
		return list;
		
	}
	
	

}
