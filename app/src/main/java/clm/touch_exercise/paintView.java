package clm.touch_exercise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CLM on 8/11/2016.
 */
public class paintView extends View {
    Path p;
    Paint paint;

    public paintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public void init() {

        paint = new Paint();
        p = new Path();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(p, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                // relative to current layout
                p.moveTo(event.getX(), event.getY());

                break;
            case MotionEvent.ACTION_UP:
                paint.setColor(paint.getColor()+10);
                invalidate(); // redraw the view!
                break;

            case MotionEvent.ACTION_MOVE:

                p.lineTo(event.getX(), event.getY());
                invalidate(); // redraw the view!
                break;


        }

        return true;
    }


}
