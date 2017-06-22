package coderxu.com.test;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main= (RelativeLayout) findViewById(R.id.activity_main);
    }
    public void sendHongbao(View view){
        showPop();
    }
    private void showPop(){
        LinearLayout view= (LinearLayout) LayoutInflater.from(this).inflate(R.layout.pop_lay,null);
        RelativeLayout mainView= (RelativeLayout) view.findViewById(R.id.mainview);
        ImageView dismiss= (ImageView) view.findViewById(R.id.dismiss);
        final PopupWindow popupWindow=new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,true);
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());这句加了设置setOutsideTouchable无效
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.AnimationSlide);
        popupWindow.showAtLocation(main, Gravity.CENTER,0,0);
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                showOpenPop();
            }
        });
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    private void showOpenPop(){
        LinearLayout view= (LinearLayout) LayoutInflater.from(this).inflate(R.layout.pop_open_lay,null);
        RelativeLayout main= (RelativeLayout) view.findViewById(R.id.main);
        final PopupWindow popupWindow=new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.AnimationSlide);
        popupWindow.showAtLocation(main, Gravity.CENTER,0,0);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
