package br.com.ramonilho.demosensors;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class TTSActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private EditText etTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        tts = new TextToSpeech(this, this);
        etTexto = (EditText) findViewById(R.id.etTexto);
    }

    public void talk(View view){
        talk();
    }

    private void talk() {
        String text = etTexto.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            Locale localeBR = new Locale("pt", "br");
            int result = tts.setLanguage(localeBR);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language not supported");
            } else {
                talk();
            }
        } else {
            Log.e("TTS", "Initialization failed!");
        }
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
