package mobile.tiy.ironchat;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView chat;
    EditText message;
    Button send;
    ArrayAdapter<String> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chat = (ListView) findViewById(R.id.listView);
        message = (EditText) findViewById(R.id.messageField);
        send = (Button) findViewById(R.id.sendButton);

        messages = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        chat.setAdapter(messages);
        send.setOnClickListener(this);
        chat.setOnItemLongClickListener(this);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onClick(View v) {
        String item = message.getText().toString();
        messages.add(item);
        message.setText("");

        try {
            new WebChatClient().sendMessage(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = messages.getItem(position);
        messages.remove(item);
        return true;
    }
}
