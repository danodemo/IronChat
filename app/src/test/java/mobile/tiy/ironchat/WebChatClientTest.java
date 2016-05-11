package mobile.tiy.ironchat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by danarchy on 5/11/16.
 */
public class WebChatClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        WebChatClient client = new WebChatClient();
        String testMessage = "Here is our test message!";
        assertEquals(testMessage,client.sendMessage(testMessage));

    }
}