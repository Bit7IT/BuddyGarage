package atam.buddygarage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sell_SignInPage extends Activity {

    private EditText name,pw;


    public void SignIn (View view){
        String inputUserName = name.getText().toString(); // get username from field
        String inputPW = pw.getText().toString(); // get pw from field
        if(inputPW.equals("")||inputUserName.equals("")){ //pw and usernbame cannot be blank
            // show toast if blank entry
            Context context = getApplicationContext();
            CharSequence text = "Username/Password cannot be blank!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{ // if username pw not blank
            System.out.println("The username is (Sign In button): "+inputUserName); // for testing
            System.out.println("The password is (Sign In button): "+inputPW); // for testing
/*
            // code to call php to do DB actions
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute("login", inputUserName, inputPW);
*/
            // Go to the Events List page
            Intent intent = new Intent(Sell_SignInPage.this, Sell_ListEventsPage.class); // go to the User Sign up Screen
            startActivity(intent);
        }

    } //Sign in button functions

    public void SignUp (View view){
        Intent intent = new Intent(Sell_SignInPage.this, Sell_SignUpPage.class); // go to the User Sign up Screen
        startActivity(intent);
    } //Sign up button functions

    private void setConnectionsXML(){
        name = (EditText) findViewById(R.id.editText_name);
        pw = (EditText) findViewById(R.id.editText_pw);
    } // set connection to XML interface

    private void onPressHideKeyboard(EditText editText){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /*hide keyboard
            If press any else where on screen, (need clickable="true" & focusableInTouchMode="true" in base layer xml)
            */
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // if focus has changed
                if (!hasFocus) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
    }// Other presses, hide keyboard



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__sign_in_page);

        setConnectionsXML();
        onPressHideKeyboard(name);
        onPressHideKeyboard(pw);

    } // main for Sell SignInPage

}
