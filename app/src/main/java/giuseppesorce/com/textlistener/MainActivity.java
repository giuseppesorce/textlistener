package giuseppesorce.com.textlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvTest)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        tvTest.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {

                int wText = tvTest.getWidth();
                int hText = tvTest.getHeight();

                if (wText > 0 && hText > 0) {

                    tvTest.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    Log.e("app", "hText: "+hText);
                }
            }
        });

        tvTest.setText("CIAO");
    }
}
