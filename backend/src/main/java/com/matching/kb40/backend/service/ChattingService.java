package com.matching.kb40.backend.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.transaction.annotation.Transactional;

import com.matching.kb40.backend.model.Chatting;


public interface ChattingService {

	public void  receiveAccount(String message, Acknowledgment ack); {

    public int transfer(AccountTransfer transfer);

}
