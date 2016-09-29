package kr.hs.emirim.dbwlsdud0407.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    DrawShape ds;
    static final int LINE=1,RECT=2,CIRCLE=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DrawShape(getApplicationContext());
       // setContentView(new DrawShape(getApplicationContext()));
        LinearLayout linear=(LinearLayout)findViewById(R.id.linear_view);
        linear.addView(ds);
    }

    public void drawshape(View v){  //hander==view
        switch(v.getId()){

            case R.id.but_line :
                break;
            case R.id.but_rect :
                break;
            case R.id.but_circle :
                break;

        }



    }
    class DrawShape extends View{
        DrawShape(Context context){
            super(context);
        }
        public void onDraw(Canvas canvas){
            super.onDraw(canvas);
            float cx=getWidth()/2.0f;
            float cy=getHeight()/2.0f;
            Paint paint=new Paint();
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(cx,cy,300,paint);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(100,100,500,250,paint);
        }

    }
}
