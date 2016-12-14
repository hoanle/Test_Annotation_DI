package hoan.checkservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @CustomDI
    public ClassToInject1 classToInject1;
    @CustomDI
    public ClassToInject2 classToInject2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DIParser diParser = new DIParser();
            diParser.inject(this);

            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(classToInject1.getStr() + "\n" + classToInject2.getStr());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
