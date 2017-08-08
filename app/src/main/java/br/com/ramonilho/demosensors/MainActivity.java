package br.com.ramonilho.demosensors;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAcelerometer(View view) {
        Intent intent = new Intent(this, AcelerometerActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void openTTS(View view) {
        Intent intent = new Intent(this, TTSActivity.class);
        MainActivity.this.startActivity(intent);
    }

}
