package atam.buddygarage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainPage extends AppCompatActivity {

    public void runSellFunc(View view){
        Intent intent = new Intent(MainPage.this, Sell_SignInPage.class); // go to the User Sign up Screen
        startActivity(intent);
    }//for Sell Button

    public void runBuyFunc(View view) {
        //Intent intent = new Intent(MainPage.this, Sell_SignInPage.class); // go to the User Sign up Screen
       // startActivity(intent);
    }//for Buy Button



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
}
