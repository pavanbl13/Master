package com.SpringRest.controller;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.model.Counter;
import com.SpringRest.model.Message;
import com.SpringRest.service.SpringRestService;


@RestController
public class CounterRestController {

	@Autowired
	SpringRestService springRestService;

	@PostMapping(value="/search",produces = MediaType.APPLICATION_JSON)
	public ArrayList<Message> getCount(@RequestBody Counter searchCriteria) {
		if(searchCriteria.getSearchText() != null) {
			
			ArrayList<Message> s =null;
			try {
				s = springRestService.getCount(searchCriteria);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		} else {
			return null;
		}
		
	}
	@PostMapping(value="/search/{top}",produces = MediaType.APPLICATION_JSON)
	public ArrayList<Message> getCount(@PathVariable("top") int top) {
		ArrayList<Message> listItems = springRestService.getTopCounts(top);
		/*Message msg = null;
		 = new ArrayList<Message> ();
		for(String value : finalValues) {
			msg = new Message(value);
			listItems.add(msg);
		}*/
		return listItems;
	}
}
