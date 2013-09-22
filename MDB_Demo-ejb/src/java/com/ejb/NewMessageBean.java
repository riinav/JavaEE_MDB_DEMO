/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Rinav Gangar, <rinav4all@gmail.com>
 */
@MessageDriven(mappedName = "jms/dest", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {
    
    public NewMessageBean() {
        System.out.println("===== NewMessageBean Constructed =====");
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            String text = msg.getText();
            Logger.getLogger(NewMessageBean.class.getName()).log(Level.INFO, text);
        } catch (JMSException ex) {
            Logger.getLogger(NewMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
