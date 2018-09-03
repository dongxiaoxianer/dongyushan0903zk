package com.bwie.dongyushan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ，全是妖怪 on 2018/9/3.
 */

public class MyView extends View {
    private Paint paint;
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private int width=50;
    private int height=50;
    private int left=70;
    private int right=70;
    private int top;
    private List<Integer> list=new ArrayList<>();
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint1 = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint1.setColor(Color.BLACK);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(2);
        paint1.setTextSize(30);
        paint2 = new Paint();
        paint2.setTextSize(20);
        paint2.setStrokeWidth(2);
        paint2.setAntiAlias(true);
        paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(2);
        paint3.setColor(Color.GREEN);
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                list.add(5);
            } else {
                list.add(10 * i);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //横轴
        canvas.drawLine(100,400,700,400,paint);
        //纵轴
        canvas.drawLine(100,100,100,400,paint);
        canvas.drawText("管理成本",70,440,paint1);
        canvas.drawText("劳务成本",200,440,paint1);
        canvas.drawText("销售成本",340,440,paint1);
        canvas.drawText("资产盘亏",480,440,paint1);

        canvas.drawText("0.00%",0,370,paint1);
        canvas.drawText("5.00%",0,320,paint1);
        canvas.drawText("10.00%",0,270,paint1);
        canvas.drawText("15.00%",0,220,paint1);
        canvas.drawText("20.00%",0,170,paint1);
        canvas.drawText("25.00%",0,120,paint1);


        //纵轴
        for (int i=0;i<5;i++){
            width+=90;
            canvas.drawLine(width,70,width,400,paint1);
        }

         //矩形
        for (int j=0;j<list.size();j++){
             top=list.get(j);
             canvas.drawRect(left,400-top,right,400,paint3);
             left+=90;
             right+=90;
        }
    }
}
