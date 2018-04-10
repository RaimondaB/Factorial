package raimonda.lt.vtvpmc.ems.factorial;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import java.math.BigInteger;

import eu.zvedux.factorial.R;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        resultText = (TextView) findViewById(R.id.resultText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigInteger number = new BigInteger(editText.getText().toString());
                BigInteger factorial = calculateFactorial(number);
                String result = String.format("Factorial %d is equal %d", number, factorial);
                resultText.setText(result);
            }
        });
    }

    private BigInteger calculateFactorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) == -1){
            return BigInteger.ONE;
        } else {
            return number.multiply(calculateFactorial(number.subtract(BigInteger.ONE)));
        }
    }
}