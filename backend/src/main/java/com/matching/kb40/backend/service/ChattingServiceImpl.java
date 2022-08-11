package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.ChattingDao;
import com.matching.kb40.backend.dto.ChatDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matching.kb40.backend.model.Chat;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChattingServiceImpl implements ChattingService{

    @Autowired
	private ChattingDao chattingDao;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
    @KafkaListener(topics = "${kafka.total.topic}")
	@Transactional
	@Override
	public void  receiveChatting(String message, Acknowledgment ack) {
		Gson gson = new Gson();
		try {
			log.info("from message:{}", message);
			ChatDto chatDto = gson.fromJson(message, AccountTransfer.class);
			log.info("account obj from kafka:{}", acc);
			int rc = commonDao.update("updateTransfer", acc);
			rc = commonDao.insert("insertAccountHistory", acc);
			log.info("update account rc:{}", rc);
			ack.acknowledge();
		} catch(Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
	}
    

    public int transfer(AccountTransfer transfer) {
		Gson gson = new Gson();
		log.info("input account:{}", transfer);
		try {
			String topic = commonDao.selectOne("findByTopic", transfer.getTargetBank());
			log.info("input topic:{}", topic);
			String message = gson.toJson(transfer);
			commonDao.update("transfer", transfer);
			kafkaTemplate.send(topic, message);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
				
		return 0;
	}

}
