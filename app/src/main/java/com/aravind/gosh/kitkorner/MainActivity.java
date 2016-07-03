package com.aravind.gosh.kitkorner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button encodeButton = (Button) findViewById(R.id.encodeButton);
        final Button decodeButton = (Button) findViewById(R.id.decodeButton);
        final EditText inputText = (EditText) findViewById(R.id.inputText);
        final TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        final Switch switcher = (Switch) findViewById(R.id.switcher);
        encodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(switcher.isChecked()) {
                        resultTextView.setText(asciiToHex(encode(hexToASCII(inputText.getText().toString()))));
                    } else {
                        resultTextView.setText(asciiToHex(encode(inputText.getText().toString())));
                    }
                } catch (Exception e) {
                    Toast.makeText(switcher.getContext(), "Oops something went wrong\nHere's why: "+e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
        decodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(switcher.isChecked()) {
                        resultTextView.setText(asciiToHex(decode(hexToASCII(inputText.getText().toString()))));
                    } else {
                        resultTextView.setText(asciiToHex(decode(inputText.getText().toString())));
                    }
                } catch (Exception e) {
                    Toast.makeText(switcher.getContext(), "Oops something went wrong\nHere's why: "+e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private String encode(String inputToEncode) {
        return Base64.encodeToString(inputToEncode.getBytes(), Base64.CRLF);
    }

    private String decode(String inputToDecode) {
        return new String(Base64.decode(inputToDecode.getBytes(), Base64.CRLF));
    }

    private static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]) + " ");
        }
        return hex.toString();
    }

    private static String hexToASCII(String hexValue) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < hexValue.length(); i += 2)
        {
            String str = hexValue.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16) + " ");
        }
        return output.toString();
    }
}
