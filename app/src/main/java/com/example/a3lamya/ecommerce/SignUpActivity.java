package com.example.a3lamya.ecommerce;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {


    public Button SignUp_btn;
    public EditText name_edt,mobile_edt, email_edt,passWord_edt;
    public TextView nameError,mobilErr,emailErr,passErr;
    public String name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("ar"));

         res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_sign_up);
        init();
        click();
    }

   private void init(){


        SignUp_btn=(Button)findViewById(R.id.signUp_signUp_btn);
        name_edt=(EditText)findViewById(R.id.name_signUp_edtTxt);
        mobile_edt=(EditText)findViewById(R.id.mobile_signUp_edtTxt);
        email_edt=(EditText)findViewById(R.id.email_signUp_edtTxt);
        passWord_edt=(EditText)findViewById(R.id.passWord_signUp_edtTxt);
        nameError=(TextView)findViewById(R.id.nameError);
        mobilErr=(TextView)findViewById(R.id.mobileError);
        emailErr=(TextView)findViewById(R.id.emailError);
       passErr=(TextView)findViewById(R.id.passWordError);
    }

    private void click(){


        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validation = true;




                if (name_edt.getText().toString().length()<3){



                    nameError.setVisibility(View.VISIBLE);
                    validation=false;
                    YoYo.with(Techniques.DropOut)
                            .duration(1300)
                            .playOn(nameError);


                }
                  else {
                    nameError.setVisibility(View.GONE);
                    validation=true;
                }




                if (!isValidEmail(email_edt.getText().toString())){


                    validation=false;
                    emailErr.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown)
                            .duration(1300)
                            .playOn(emailErr);


                }
                else{



                    emailErr.setVisibility(View.GONE);
                    validation=true;
                }


                if (mobile_edt.getText().toString().length()<10){



                   mobilErr.setVisibility(View.VISIBLE);
                    validation=false;
                    YoYo.with(Techniques.Bounce)
                            .duration(1300)
                            .playOn(mobilErr);


                }
                else {
                    mobilErr.setVisibility(View.GONE);
                    validation=true;
                }

                if (passWord_edt.getText().toString().length()<7){



                    passErr.setVisibility(View.VISIBLE);
                    validation=false;
                    YoYo.with(Techniques.Tada)
                            .duration(1300)
                            .playOn(passErr);
                }
                else {

                    passErr.setVisibility(View.GONE);
                    validation=true;
                }







                if (validation){


                    Intent i=new Intent(SignUpActivity.this,AboutTeam.class);
                    startActivity(i);

                }


            }
        });





    }

    private boolean isValidEmail(String email) {// validation for email Id
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,255}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
