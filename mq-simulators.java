import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;

public class MQConnectionTest {

    public static void main(String[] args) {
        // Define the MQ connection parameters
        String queueManagerName = "YOUR_QUEUE_MANAGER";
        String channelName = "YOUR_CHANNEL_NAME";
        String hostName = "YOUR_HOSTNAME";
        int port = 1414;  // Default MQ port, replace if needed
        String user = "YOUR_USERNAME";  // Optional
        String password = "YOUR_PASSWORD";  // Optional

        // Create MQ connection properties
        java.util.Hashtable<String, Object> props = new java.util.Hashtable<String, Object>();
        props.put(CMQC.HOST_NAME_PROPERTY, hostName);
        props.put(CMQC.PORT_PROPERTY, port);
        props.put(CMQC.CHANNEL_PROPERTY, channelName);
        props.put(CMQC.USER_ID_PROPERTY, user);
        props.put(CMQC.PASSWORD_PROPERTY, password);
        props.put(CMQC.USE_MQCSP_AUTH_PROPERTY, true); // Optional, use if MQ requires authentication
        
        try {
            // Create a Queue Manager object using the provided connection parameters
            MQQueueManager queueManager = new MQQueueManager(queueManagerName, props);

            // If we reach here, the connection is successful
            System.out.println("Connected to MQ Queue Manager: " + queueManagerName);

            // Close the queue manager connection
            queueManager.disconnect();
            System.out.println("Disconnected from MQ Queue Manager: " + queueManagerName);
        } catch (MQException e) {
            // Handle the MQException if the connection fails
            System.out.println("Failed to connect to MQ Queue Manager: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
