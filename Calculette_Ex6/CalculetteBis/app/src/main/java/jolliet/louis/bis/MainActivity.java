package jolliet.louis.bis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonC;
    Button buttonEgal;
    Button buttonPoint;
    EditText ecran;

    double nb1=0;
    boolean clear = false;
    op operation=null;
    boolean virgule=false;

    private enum op {PLUS,MOINS,FOIS,DIVISE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMoins = findViewById(R.id.buttonMoins);
        buttonDiv = findViewById(R.id.buttonDivision);
        buttonMul = findViewById(R.id.buttonMultiplier);
        buttonC = findViewById(R.id.buttonC);
        buttonEgal = findViewById(R.id.buttonEgal);

        ecran = findViewById(R.id.EditText01);




        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

    }

    private void mulClick() {
        nb1=Double.valueOf(ecran.getText().toString());
        operation=op.FOIS;
        clear=true;
    }

    private void divClick() {
        nb1=Double.valueOf(ecran.getText().toString());
        operation=op.DIVISE;
        clear=true;
        
    }

    private void moinsClick() {
        nb1=Double.valueOf(ecran.getText().toString());
        operation=op.MOINS;
        clear=true;

    }

    private void resetClick() {
        ecran.setText("");
        clear=false;
        nb1=0.;
        operation=null;


    }

    private void egalClick()
            ecran.setText(calcul());
    }

    private String calcul() {
        double result;
        switch (operation){
            case PLUS:
                result = nb1+Double.valueOf(ecran.getText().toString());
                break;
            case FOIS:
                result = nb1*Double.valueOf(ecran.getText().toString());
                break;
            case MOINS:
                result = nb1-Double.valueOf(ecran.getText().toString());
                break;
            case DIVISE:
                result = nb1/Double.valueOf(ecran.getText().toString());
                break;

            default :
                result = -1;
        }
        operation=null;
        clear=true;
        return String.valueOf(result);
    }

    private void chiffreClick(String s) {

        if(!clear && !virgule)
            s += ecran.getText();
        if(s==".")
            virgule=true;
        ecran.setText(s);
        clear=false;



    }

    private void plusClick() {
        nb1=Double.valueOf(ecran.getText().toString());
        operation=op.PLUS;
        clear=true;
    }
}
