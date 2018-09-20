package com.example.ahsan.geneticalgorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int target, op, popSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle bundle = getIntent().getExtras();
        int target = Integer.parseInt(bundle.getString("target"));
        int op = Integer.parseInt(bundle.getString("op"));

        Log.d("mylog", ""+target);
        Log.d("mylog", ""+op);

        /////////////////////

        popSize = 5;
        GeneticAlgo geneticAlgo = new GeneticAlgo(target,op,popSize);
        setAll(geneticAlgo);
    }

    void setAll(GeneticAlgo geneticAlgo){
        String expression = geneticAlgo.geneticAlgorithm();
        double bestfitness = geneticAlgo.bestfitness;
        int numgen = geneticAlgo.numgen;

        TextView exprText = (TextView) findViewById(R.id.exprText);
        TextView numgenText = (TextView) findViewById(R.id.genText);
        TextView bestfitText = (TextView) findViewById(R.id.bestFitText);

        exprText.setText(expression);
        numgenText.setText(" "+  numgen);
        bestfitText.setText(" "+ bestfitness);
    }
}
