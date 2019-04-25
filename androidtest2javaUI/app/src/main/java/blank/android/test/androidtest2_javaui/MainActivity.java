package blank.android.test.androidtest2_javaui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundColor(Color.BLUE);

        Button btn = new Button(this);
        btn.setId(1);
        btn.setBackgroundColor(Color.BLACK);
        btn.setText("Submit");
        btn.setTextColor(Color.WHITE);

        EditText et1 = new EditText(this);
        et1.setId(2);
        et1.setMinWidth(200);
        RelativeLayout.LayoutParams wrapper1 =
            new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, //for width
                    RelativeLayout.LayoutParams.WRAP_CONTENT //for height
            );

        RelativeLayout.LayoutParams wrapper2 =
            new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            );

        wrapper1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        wrapper1.addRule(RelativeLayout.CENTER_VERTICAL);

        wrapper2.addRule(RelativeLayout.ABOVE, btn.getId());
        wrapper2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        rl.addView(btn, wrapper1);
        rl.addView(et1, wrapper2);
        setContentView(rl);
    }
}
