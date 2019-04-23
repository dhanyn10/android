package blank.android.test.androidtest2_javaui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout rl = new RelativeLayout(this);
        Button btn = new Button(this);

        rl.addView(btn);
        setContentView(rl);
    }
}
