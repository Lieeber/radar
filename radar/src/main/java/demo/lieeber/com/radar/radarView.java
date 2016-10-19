package demo.lieeber.com.radar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lieeber on 16/10/18.
 */

public class RadarView extends View {

    private Paint mPaint;

    private int radius = 0;

    private float angle60 = (float) (60 * Math.PI / 180);
    private float angle30 = (float) (30 * Math.PI / 180);
    private Paint aaPaint;
    private Paint areaPaint;




    PointF[] areaPoint = new PointF[6];

    public RadarView(Context context) {
        super(context);
        initView();
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#3327d4e1"));
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Style.FILL);

        aaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        aaPaint.setStrokeWidth(1);
        aaPaint.setStyle(Style.STROKE);
        aaPaint.setColor(Color.BLUE);




        areaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        areaPaint.setStyle(Style.FILL);
        areaPaint.setColor(getResources().getColor(R.color.aaa));


        for (int i = 0; i < 6; i++) {
            double maxLong = 400 * Math.random();
            PointF pointF = new PointF((float) (maxLong * Math.sin(angle30 + angle60 * i)), (float) (maxLong * Math.cos(angle30 + angle60 * i)));
            areaPoint[i] = pointF;
        }
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.scale(1, -1);
        Path linePath = new Path();
        for (int j = 1; j < 6; j++) {
            linePath.reset();
            radius += 80;
            for (int i = 0; i <= 6; i++) {
                if (i == 0) {
                    linePath.moveTo((float) (radius * Math.sin(angle30)), (float) (radius * Math.cos(angle30)));
                } else {
                    linePath.lineTo((float) (radius * Math.sin(angle30 + angle60 * i)), (float) (radius * Math.cos(angle30 + angle60 * i)));
                }
            }
            canvas.drawPath(linePath, mPaint);
            canvas.drawPath(linePath, aaPaint);
        }

        for (int i = 0; i < 6; i++) {
            linePath.reset();
            linePath.lineTo((float) (radius * Math.sin(angle30 + angle60 * i)), (float) (radius * Math.cos(angle30 + angle60 * i)));
            canvas.drawPath(linePath, aaPaint);
        }

        Path areaPath = new Path();
        for (int i = 0; i < areaPoint.length; i++) {
            if (i == 0) {
                areaPath.moveTo(areaPoint[i].x, areaPoint[i].y);
            } else {
                areaPath.lineTo(areaPoint[i].x, areaPoint[i].y);
            }
        }
        areaPath.close();
        canvas.drawPath(areaPath, areaPaint);
    }
}
