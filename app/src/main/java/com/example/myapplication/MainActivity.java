package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float[] inputs = new float[]{7,8};
        float[] outputs = new float[2];

        String filename = "android_tensorflow.pb";

        TensorFlowInferenceInterface tensorFlowInferenceInterface =
                new TensorFlowInferenceInterface(getAssets(), filename);

        tensorFlowInferenceInterface.feed("input", inputs, 1, 2);
        tensorFlowInferenceInterface.run(new String[]{"output"});

        tensorFlowInferenceInterface.fetch("output", outputs);

        Toast.makeText(this, String.valueOf(outputs[0]) + ":" + String.valueOf(outputs[1]), Toast.LENGTH_LONG).show();
    }
}
