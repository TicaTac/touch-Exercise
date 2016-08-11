package clm.touch_exercise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView kittenIV;
    TextView textInfoTV;
    TextView swipeTV;

    float prevX;
    float prevY;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        kittenIV = (ImageView) findViewById(R.id.kittenIV);
        kittenIV.setOnTouchListener(this);

        textInfoTV= (TextView)findViewById(R.id.infoTV);
        swipeTV= (TextView) findViewById(R.id.swipeTV);
*/





    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() ) {

            case MotionEvent.ACTION_DOWN:
                // relative to current layout
                textInfoTV.setText("Down! x= "+event.getX()+ ", y=" +event.getY());
                prevX=event.getX();
                prevY=event.getY();

                break;
            case MotionEvent.ACTION_UP:
                textInfoTV.setText("Up! x= "+event.getX()+ ", y=" +event.getY());

                if (prevX-event.getX()>500) {
                    kittenIV.setImageResource(R.drawable.kitten);
                    swipeTV.setText("Right");

                }
                else if (prevX-event.getX()<500) {
                    kittenIV.setImageResource(R.drawable.tiger);
                    swipeTV.setText("Left");

                }
                else {
                    kittenIV.setX( kittenIV.getX()+ (prevX-event.getX()));
                    float delta=prevX-event.getX();
                    swipeTV.setText(""+delta);

                }

            case MotionEvent.ACTION_MOVE:
                textInfoTV.setText("Move! x= "+event.getX()+ ", y=" +event.getY());


        }

        return true;
    }

}
