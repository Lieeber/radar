package demo.lieeber.com.radar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lieeber on 16/10/15.
 */

public class NewView extends View {

    private Paint mPaint;

    public NewView(Context context) {
        super(context);
        initView();
    }


    public NewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.parseColor("#ff27d4e1"));
    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.save();
        aaa(canvas);
        canvas.save();
        canvas.rotate(60);
        aaa(canvas);
        canvas.save();
        canvas.rotate(120);
        aaa(canvas);
        canvas.save();
        canvas.rotate(180);
        aaa(canvas);
        canvas.save();
        canvas.rotate(240);
        aaa(canvas);
        canvas.save();
        canvas.rotate(300);
        aaa(canvas);
    }

    private void aaa(Canvas canvas) {
        Path path = new Path();
        path.lineTo(0, canvas.getHeight() / 2);
        path.lineTo((float) (getHeight() / 2 * Math.sin(60 * Math.PI / 180)), (float) (getHeight() / 2 * Math.cos(60 * Math.PI / 180)));
        canvas.drawPath(path, mPaint);

        mPaint.setColor(Color.parseColor("#ff00ff"));
        canvas.scale(0.8f, 0.8f);
        path.moveTo(0, 0);
        path.lineTo(0, canvas.getHeight() / 2);
        path.lineTo((float) (getHeight() / 2 * Math.sin(60 * Math.PI / 180)), (float) (getHeight() / 2 * Math.cos(60 * Math.PI / 180)));
        canvas.drawPath(path, mPaint);

        mPaint.setColor(Color.parseColor("#6627d4e1"));
        canvas.scale(0.7f, 0.7f);
        path.moveTo(0, 0);
        path.lineTo(0, canvas.getHeight() / 2);
        path.lineTo((float) (getHeight() / 2 * Math.sin(60 * Math.PI / 180)), (float) (getHeight() / 2 * Math.cos(60 * Math.PI / 180)));
        canvas.drawPath(path, mPaint);


        mPaint.setColor(Color.parseColor("#3327d4e1"));
        canvas.scale(0.6f, 0.6f);
        path.moveTo(0, 0);
        path.lineTo(0, canvas.getHeight() / 2);
        path.lineTo((float) (getHeight() / 2 * Math.sin(60 * Math.PI / 180)), (float) (getHeight() / 2 * Math.cos(60 * Math.PI / 180)));
        canvas.drawPath(path, mPaint);
        canvas.restore();

    }
}
