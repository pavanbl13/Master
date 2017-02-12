package com.SpringRest.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.model.Counter;
import com.SpringRest.model.Message;
import com.SpringRest.model.Properties;

@Service
public class SpringRestService {

	@Autowired
	private Properties prop;

	public ArrayList<Message> getCount(Counter searchTexts) throws Exception{
		System.out.println(prop.getFilePath());
		ArrayList<Message> sortedList = new ArrayList<Message> ();
		int finalCounter = 0;
		Stream<String> fileStream = null;
		List<String> inputArray = Arrays.asList(searchTexts.getSearchText());
		try{
			// Read all lines from a file as a Stream. Bytes from the file are decoded into characters using the UTF-8 charset
			List<String> searchArray = inputArray.stream().collect(Collectors.toList());
			for(String value: searchArray){
				fileStream = Files.lines(Paths.get("c:\\" + prop.getFilePath()));
				Iterator<String> it = fileStream.iterator();
				while(it.hasNext()) {
					String line = it.next();
					int counter = StringUtils.countMatches(line, value);
					finalCounter = finalCounter + counter;
				}
				String s1 = value +"|" + finalCounter;
				Message msg = new Message(s1);
				sortedList.add(msg);
				finalCounter = 0;
			}  
		} catch(Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(fileStream != null) {
				fileStream.close();
			}
		}
		/*StringBuffer str = prop.getFileData();
		System.out.println(str.toString());

		for(int i =0 ; i < inputArray.length ; i++) {
			int counter = StringUtils.countMatches(str.toString(), inputArray[i]);
			String s1 = inputArray[i] + "|"+ counter;

			sortedList.add(msg);
		}*/
		return sortedList;
	}
	public ArrayList<Message> getTopCounts(int top) {
		String[] finalValues = new String[top];
		ArrayList<Message> sortedList = new ArrayList<Message> ();
		LinkedHashMap<String, Integer> wordcount =
				new LinkedHashMap<String, Integer>();
		StringBuffer str = prop.getFileData();
		String s = str.toString().toLowerCase();
		String[] words = s.split("\\s+");

		for( String word : words ) {
			if( word.length() == 0 ) {
				continue; 
			}

			Integer occurences = wordcount.get(word);

			if( occurences == null) {
				occurences = 1;
			} else {
				occurences++;
			}

			wordcount.put(word, occurences);
		}

		ArrayList<Integer> values = new ArrayList<Integer>();
		values.addAll(wordcount.values());

		Collections.sort(values, Collections.reverseOrder());
		int last_i = -1;

		for (Integer i : values.subList(0, 9)) { 
			if (last_i == i) // without duplicates
				continue;
			last_i = i;

			for (String s2 : wordcount.keySet()) { 
				if (wordcount.get(s2) == i) {// which have this value  
					System.out.println("Length: "  + sortedList.size());
					if(sortedList.size() < top){
						Message msg = new Message( s2 + "|" + i);
						sortedList.add(msg);
					}
					System.out.println(s2+ " " + i);
				}
			}

		}
		/*finalValues = sortedList.toArray(finalValues);
		System.out.println("finalValues: " + finalValues);*/
		return sortedList;
	}
}
