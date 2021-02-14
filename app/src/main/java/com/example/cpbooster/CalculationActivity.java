package com.example.cpbooster;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Vector;


public class CalculationActivity extends AppCompatActivity {

    EditText userInput;
    TextView output;
    String str;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        System.out.println(intValue);
        userInput = findViewById(R.id.edit_text);
        output = findViewById(R.id.text_view);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationActivity.this, CalculationActivity.class);
                str = userInput.getText().toString();
                String finalAns = temp(intValue, str);
                output.setText(finalAns); //str
            }
        });


    }

    String temp(int intValue, String inputStr){

        String result = "";
        Integer[] input = ConvertArray((inputStr));
        if(intValue == 1)
        {
            //result = Arrays.toString(input);
            Vector<String> primes = new Vector<String>();
            primes = PrimeInRange(input);
            result = primes.toString();
            //result = Arrays.toString(primes);
        }
        else if(intValue == 2)
        {
            result = Arrays.toString(input);
        }
        result = result.replaceAll("\\p{Punct}","");
        return result;
    }

    public Integer[] ConvertArray(String args) {

        String[] split = args.split("\\s+");
        return processLine((split));
    }

    private Integer[] processLine(String[] strings) {
        Integer[] intArray=new Integer[strings.length];
        int i=0;
        for(String str:strings){
            intArray[i]=Integer.parseInt(str.trim());
            i++;
        }
        return intArray;
    }

    private Vector<String> PrimeInRange(Integer[] input){

        int len = (input.length)/2;

        Vector<String> primes = new Vector<String>();
        primes.add("");
        //int[] primes = new int[1000000];
        int ii = 0;
        while (len > 0){
            int a, b, i, j, flag;
            a = input[ii++];
            b = input[ii++];
            for (i = a; i <= b; i++) {
                if (i == 1 || i == 0)
                    continue;

                flag = 1;

                for (j = 2; j <= i / 2; ++j) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    String str = Integer.toString(i);
                    primes.add(str);
                }
            }
            primes.add("\n");
            len--;
        }
        return primes;
    }
}
