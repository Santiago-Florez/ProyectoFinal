package co.edu.unbosque.webSocketsChat;


import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import co.edu.unbosque.webSocketsChat.model.Message;
import com.google.gson.Gson;


public class MessageEncoder implements Encoder.Text<Message> {

    private static Gson gson = new Gson();

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public String encode(Message message) {
        String json = gson.toJson(message);
        return json;
    }



    @Override
    public void destroy() {
        // Close resources
    }
}