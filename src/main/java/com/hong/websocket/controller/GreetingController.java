package com.hong.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.hong.websocket.model.Chat;
import com.hong.websocket.model.HelloMessage;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Chat greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000);
		return new Chat(HtmlUtils.htmlEscape(message.getName()) + " : " + HtmlUtils.htmlEscape(message.getMessage()));
	}
}
