package kr.hs.emirim.dbwlsdud0407.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    DrawShape ds;
    static final int LINE=1,RECT=2,CIRCLE=3;
    int chooseshape=CIRCLE;
    int startx,starty,stopx,stopy;
    int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DrawShape(getApplicationContext());
       // setContentView(new DrawShape(getApplicationContext()));
        LinearLayout linear=(LinearLayout)findViewById(R.id.linear_view);
        linear.addView(ds);
    }

    public void drawshape(View v){  //handler엔 View v
        switch(v.getId()){

            case R.id.but_line :
                chooseshape=LINE;
                break;
            case R.id.but_rect :
                chooseshape=RECT;
                break;
            case R.id.but_circle :
                chooseshape=CIRCLE;
                break;

        }
        ds.invalidate();




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
            switch (chooseshape){
                case LINE:
                    canvas.drawLine(startx,starty,stopx,stopy,paint);
                    break;

                case RECT:
                    paint.setColor(Color.MAGENTA);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(startx,starty,stopx,stopy,paint);
                    break;

                case CIRCLE:
                    r=(int)Math.sqrt(Math.pow(stopx,startx)-Math.pow(stopy,starty));
                    canvas.drawCircle(startx,starty,r,paint);
                    break;
            }


        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startx=(int)event.getX();
                    starty=(int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:

                    break;
                case MotionEvent.ACTION_UP:
                    stopx=(int)event.getX();
                    stopy=(int)event.getY();
                    break;

            }

            invalidate();
            return true;
        }
    }
}
