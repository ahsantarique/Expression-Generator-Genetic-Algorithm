package com.example.ahsan.geneticalgorithm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String target, op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText targetText = (EditText) findViewById(R.id.targettext);
        final EditText opText = (EditText) findViewById(R.id.optext);

        Button btn = (Button) findViewById(R.id.contBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(targetText.getText().toString().equals("") || opText.getText().toString().equals("")) return;

                target = targetText.getText().toString();
                op = opText.getText().toString();

                for(int i=0; i < target.length(); i++) if(target.charAt(i) > '9' || target.charAt(i) < '0') return;
                for(int i=0; i < op.length(); i++) if(op.charAt(i) > '9' || op.charAt(i) < '0') return;

                Log.d("mylog", "ok");
                Intent intent = new Intent("android.intent.action.RESULTS");
                intent.putExtra("target", target);
                intent.putExtra("op", op);
                startActivity(intent);
            }
        });
    }
}
