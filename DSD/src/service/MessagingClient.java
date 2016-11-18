package service;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.MessagingError;
import util.Alert;

/**
 *
 * @author Amanda Nunes / Rodrigo Lopes
 */
public class MessagingClient {

    /**
     * Broadcast message send one message to all connected users
     * @param msg
     */
    public static void broadcastMessage(String msg) {

        try {

            Context jndiContext = new InitialContext();

            TopicConnectionFactory connectionFactory = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            Topic topic = (Topic) jndiContext.lookup("TesteTopic");
            TopicConnection connection = connectionFactory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher publisher = session.createPublisher(topic);
            TextMessage message = session.createTextMessage();

            message.setText(msg);

            publisher.publish(message);

            publisher.close();
            session.close();
            connection.close();

        } catch (NamingException | JMSException error) {
            Alert.showErrorAlert(new MessagingError(error.getMessage(),
                    error.getLocalizedMessage()));
            System.exit(-1);
        }
    }

    /**
     * Private message send one message to specific connected user
     * @param receiver
     * @param msg
     */
    public static void privateMessage(String receiver, String msg) {

        Connection connection = null;

        try {

            Context jndiContext = new InitialContext();
            QueueConnectionFactory connectionFactory = (QueueConnectionFactory) jndiContext.lookup("ConnectionFactory");

            Destination destination = (Destination) jndiContext.lookup("TesteQueue");

            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(destination);

            TextMessage message = session.createTextMessage();

            message.setStringProperty("KEY", receiver);
            message.setText(msg);
            producer.send(message);

        } catch (NamingException | JMSException error) {
            Alert.showErrorAlert(new MessagingError(error.getMessage(),
                    error.getLocalizedMessage()));
            System.exit(-1);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException error) {
                    Alert.showErrorAlert(new MessagingError(error.getMessage(),
                            error.getLocalizedMessage()));
                    System.exit(-1);
                }
            }
        }
    }
}
