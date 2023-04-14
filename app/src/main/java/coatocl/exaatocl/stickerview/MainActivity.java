package coatocl.exaatocl.stickerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.xiaopo.flying.sticker.StickerView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    float dX,dY;
    StickerView sticker;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        sticker = findViewById(R.id.sticker);

        sticker.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        dX=v.getX()-event.getRawX();
                        dY=v.getY()-event.getRawY();
                        break;

                    case  MotionEvent.ACTION_MOVE:
                        v.animate().x(event.getRawX()+dX).y(event.getRawY()+dY).setDuration(0).start();
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.ic_android_black_24dp);
            }
        });
    }
}