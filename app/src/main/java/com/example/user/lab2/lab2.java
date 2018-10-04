package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class lab2 extends AppCompatActivity {
    EditText gamer;
    TextView status;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button play;
    TextView name;
    TextView winner;
    TextView mymora;
    TextView computermora;

    int mora_gamer=-1;
    String[] morastring={"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        gamer=(EditText)findViewById(R.id.gamer);
        status=(TextView) findViewById(R.id.status);
        radioButton=(RadioButton)findViewById(R.id.radioButton6) ;
        radioButton2=(RadioButton)findViewById(R.id.radioButton5);
        radioButton3=(RadioButton)findViewById(R.id.radioButton7);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup2);
        play=(Button)findViewById(R.id.play);
        name=(TextView)findViewById(R.id.name);
        winner=(TextView)findViewById(R.id.winner);
        mymora=(TextView)findViewById(R.id.mymora);
        computermora=(TextView)findViewById(R.id.computermora);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton6:
                        mora_gamer=0;
                        break;
                    case R.id.radioButton5:
                        mora_gamer=1;
                        break;
                    case R.id.radioButton7:
                        mora_gamer=2;
                        break;
                }
            }


        });
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(gamer.getText().toString().equals(""))
                    status.setText("請選擇玩家名稱");
                else if (mora_gamer == -1)
                    status.setText("請選擇出拳種類");
                else{
                    name.setText(gamer.getText());
                    mymora.setText(morastring[mora_gamer]);
                    int mora__computer = (int) (Math.random() * 3);
                    computermora.setText(morastring[mora__computer]);
                    if((mora_gamer==0 && mora__computer ==1)||(mora_gamer==1 && mora__computer==2)||(mora_gamer==2 && mora__computer==0)){
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    }
                    else if(mora__computer==mora_gamer){
                        winner.setText("平局");
                        status.setText("平局，再式一場看看");
                    }
                    else{
                        winner.setText(gamer.getText());
                        status.setText("恭喜你獲勝了");
                    }

                }
            }
        });
    }


}
