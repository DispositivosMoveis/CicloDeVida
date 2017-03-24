package br.edu.simples.ciclodevida;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }

    protected void onStart() {
        super.onStart();
        text.setText("Start view");
        Log.i("Activity","Start view");
    }

    protected void onPause() {
        super.onPause();
        text.setText("Pause view");
        Log.i("Activity","Pause view");
    }

    protected void onStop() {
        super.onStop();
        text.setText("Stop view");
        Log.i("Activity","Stop view");
    }

    protected void onResume() {
        super.onResume();
        text.setText("Resume view");
        Log.i("Activity","Resumming view");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("O botão funciona aqui!!");
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,2);
            }
        });

    }

    protected void onActivityResult(int codigo,int resultado, Intent intent){
        String str = intent.getExtras().getString("mensagem");
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
    }

    protected void onRestart() {
        super.onRestart();
        text.setText("Restarting view");
        Log.i("Activity","Restarting view");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity","Destroing view");
    }



}

