package atam.buddygarage;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class Sell_SignUpPage extends Activity {

    private EditText name, phoneNo, password, passwordConfirm;

    private void setConnectionsXML() {
        name = (EditText) findViewById(R.id.editText_SignUp_Name);
        phoneNo = (EditText) findViewById(R.id.editText_SignUp_Phone);
        password = (EditText) findViewById(R.id.editText_Signup_PW);
        passwordConfirm = (EditText) findViewById(R.id.editText_SignUp_PwConfirm);
    } // set connection to XML interface

    private void onPressHideKeyboard(EditText editText) {
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

    public void register(View view) {
        String inputUserName = name.getText().toString(); // get username from field
        String inputPhoneNo = phoneNo.getText().toString(); // get phone number
        String inputPw = password.getText().toString(); // get password
        String inputPwConfirm = passwordConfirm.getText().toString(); // get password confirm

        if (inputUserName.equals("") || inputPhoneNo.equals("") || inputPw.equals("") || inputPwConfirm.equals("")) { //pw and usernbame cannot be blank
            // show toast if blank entry
            Context context = getApplicationContext();
            CharSequence text = "All input fields cannot be blank!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            System.out.println("The username is (Register button): " + inputUserName); // for testing
            System.out.println("The phone is (Register button): " + inputPhoneNo); // for testing
            System.out.println("The password is (Register button): " + inputPw); // for testing
            System.out.println("The confirmPw is (Register button): " + inputPwConfirm); // for testing

            // code to call php to do DB actions
            // need to add check for username, check if phone is valid phone format, check if password and confirmPw is matched, before calling the BackgroundWorker execute
        //    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
          //  backgroundWorker.execute("create_member", inputUserName, inputPw, inputPhoneNo);

        }
    } //function for register button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__sign_up_page);
        setConnectionsXML();
        onPressHideKeyboard(name);
        onPressHideKeyboard(phoneNo);
        onPressHideKeyboard(password);
        onPressHideKeyboard(passwordConfirm);

    }//end Sell_SignUpPage main

}
