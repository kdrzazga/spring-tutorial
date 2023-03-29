package org.kd.springjms;

import org.apache.activemq.broker.BrokerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.springjsm.SJConsumer;
import org.kd.springjsm.SJProducer;
import org.kd.springjsm.config.JmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(JmsConfig.class)
@ExtendWith(SpringExtension.class)
public class JmsTest {

    @Autowired
    private SJProducer springJmsProducer;

    @Autowired
    private SJConsumer springJmsConsumer;

    @Autowired
    private BrokerService brokerService;

    @Test
    public void testContext() {
        assertNotNull(springJmsProducer);
        assertNotNull(springJmsConsumer);
        assertNotNull(brokerService);
    }

    @Test
    public void communicationTest() {

        try {
            brokerService.start();
            var message = "Ala ma kota";
            springJmsProducer.sendMessage(message);
            assertEquals(message, springJmsConsumer.receiveMessage());
            brokerService.stop();

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}