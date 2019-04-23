package blank.android.test.androidtest2_javaui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundColor(Color.BLUE);

        Button btn = new Button(this);
        btn.setBackgroundColor(Color.BLACK);
        btn.setText("Submit");
        btn.setTextColor(Color.WHITE);

        RelativeLayout.LayoutParams btndetail =
        new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, //for width
                RelativeLayout.LayoutParams.WRAP_CONTENT //for height
        );

        btndetail.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btndetail.addRule(RelativeLayout.CENTER_VERTICAL);

        rl.addView(btn, btndetail);
        setContentView(rl);
    }
}
