package jp.techacademy.yumie.minakami.monitoringapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
            // タイトルを日表示する

        setContentView(R.layout.activity_splash);
            // Viewにactivity_splashを指定

        ImageView ivSplash = (ImageView) findViewById(R.id.ivSplash);

        AlphaAnimation alpha = new AlphaAnimation(
                0.0f,   // transparency @ start
                1.0f    // transparency @ end
        );
        alpha.setDuration(2000);
        ivSplash.startAnimation(alpha);

        Handler handler = new Handler();
        handler.postDelayed(new splashHandler(), 3000);
    }

    class splashHandler implements Runnable {
        public void run(){
            Intent intnt = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intnt);
            SplashActivity.this.finish();
        }
    }
}
