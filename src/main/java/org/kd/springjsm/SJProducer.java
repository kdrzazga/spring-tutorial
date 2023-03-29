package org.kd.springjsm;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;

@Getter
@Setter
public class SJProducer {
    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void sendMessage(final String msg) {
        System.out.println("Producer sends " + msg);
        jmsTemplate.send(destination, createMessageCreator(msg));
    }

    private MessageCreator createMessageCreator(final String msg) {
        return session -> session.createTextMessage(msg);
    }
}
