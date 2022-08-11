package com.matching.kb40.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class Topic {
    private String topic;
	private String delim;
	private String a;
	private String b;

	public Topic(String topic, String delim) throws Exception {

		this.topic = topic;
		if (delim == null) {
			this.delim = "|";
		} else {
			this.delim = delim;
		}
		List<String> strToken = new ArrayList<String>();
		try {
			StringTokenizer tokenizer = new StringTokenizer(topic, delim);
			while (tokenizer.hasMoreTokens()) {
				strToken.add(tokenizer.nextToken());
			}
		} catch (Exception e) {
			log.warn("Too Many Topic keyword : {}", topic);			
		}

		/*
		 * 
		 * 예를 들면 아래와 같이 객체화 시킬 수 있다.
		 * 
		 * this.clientName 	= strToken.get(0);
		 * this.callType 	= strToken.get(1);
		 * this.carNumber 	= strToken.get(2);
		 * 	
		 */
	}
}