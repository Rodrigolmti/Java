package ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jms.Message;
import javax.jms.MessageListener;

import model.User;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;

import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.MessagingError;
import service.MessagingClient;

import util.Alert;

/**
 * @author Amanda Nunes / Rodrigo Lopes
 */
public class ChatFrame extends javax.swing.JFrame {

    private User user;

    public ChatFrame(User user) {

        initComponents();
        this.user = user;
        setup();
    }

    public ChatFrame() {

        initComponents();
    }

    /**
     * Setup messaging configurations
     */
    private void setup() {

        try {

            if (user != null) {

                this.setTitle("Messaging v0.1" + " " + "nickname: " + user.getNickname());
                asyncSender();
                asyncReceiver(user.getNickname());
            }
            setLocationRelativeTo(null);
        } catch (NamingException | JMSException error) {

            Alert.showErrorAlert(new MessagingError(error.getMessage(), error.getLocalizedMessage()));
            System.exit(-1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldMessage = new javax.swing.JTextField();
        buttonSend = new javax.swing.JButton();
        textFieldPrivateMessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaMessage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        jLabel1.setText("Private message:");

        jLabel2.setText("Message:");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textAreaMessage.setEditable(false);
        textAreaMessage.setColumns(20);
        textAreaMessage.setRows(5);
        jScrollPane1.setViewportView(textAreaMessage);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldPrivateMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldPrivateMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed

        String message;
        Date date = new Date();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");

        if (textFieldMessage.getText().isEmpty()) {

            Alert.showAlert("Enter you message before!");
        } else if (textFieldPrivateMessage.getText().isEmpty()) {

            message = simpleFormat.format(date) + " " + user.getNickname()
                    + ": " + textFieldMessage.getText();

            MessagingClient.broadcastMessage(message);
            textFieldMessage.setText("");
        } else {

            message = simpleFormat.format(date) + " " + user.getNickname()
                    + ": " + textFieldMessage.getText();

            MessagingClient.privateMessage(textFieldPrivateMessage.getText(),
                    message);
            textFieldMessage.setText("");
            textFieldPrivateMessage.setText("");
        }
    }//GEN-LAST:event_buttonSendActionPerformed

    /**
     * Message listener, this class stay listening messages send by server
     */
    public final class responseListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            try {
                if (message == null) {
                    Alert.showAlert("Something is wrong! I get a null message! \n"
                            + "check your internet connection!");
                } else if (message instanceof TextMessage) {
                    TextMessage m = (TextMessage) message;
                    textAreaMessage.append(m.getText() + "\n");
                } else {
                    TextMessage m = (TextMessage) message;
                    Alert.showAlert("Unkow message ...\n"
                            + "Can you undestand that? \n" + m.getText());
                }
            } catch (Exception error) {
                Alert.showErrorAlert(new MessagingError(error.getMessage(),
                        error.getLocalizedMessage()));
            }
        }
    }

    /**
    * Async Send register subscriber
    */
    private void asyncSender() throws NamingException, JMSException {

        Context context = new InitialContext();

        TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) context
                .lookup("ConnectionFactory");
        Topic topic = (Topic) context.lookup("TesteTopic");
        TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
        TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
        topicSubscriber.setMessageListener(new responseListener());
        topicConnection.start();
    }

    /**
    * Async receiver register consumer
    */
    private void asyncReceiver(String nickname) throws NamingException, JMSException {

        Context context = new InitialContext();

        QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
        Queue queue = (Queue) context.lookup("TesteQueue");
        QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
        QueueSession queuSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        String seletor = "KEY='" + nickname + "'";

        QueueReceiver queueReceiver = queuSession.createReceiver(queue, seletor);

        queueReceiver.setMessageListener(new responseListener());
        queueConnection.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaMessage;
    private javax.swing.JTextField textFieldMessage;
    private javax.swing.JTextField textFieldPrivateMessage;
    // End of variables declaration//GEN-END:variables
}
