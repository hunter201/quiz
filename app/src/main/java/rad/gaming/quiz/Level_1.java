package rad.gaming.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level_1 extends AppCompatActivity
{

    Dialog dialog;
    Dialog dialogEnd;

    //variable for left image
    public int numLeft;
    //variable for right image
    public int numRight;
    //initialization array
    Array array = new Array();
    //generate random numbers
    Random random = new Random();
    public int count = 0;//counter correct answers

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //create variable text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);


        //Clip corners ImageView
        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        //Enable fullscreen mode
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Call dialog window in start game
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//hidden window title
        dialog.setContentView(R.layout.preview_dialog);//path in layout
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //set background window is transparent
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);//Scale window
        dialog.setCancelable(false);//no close back button


        //button Close dialog
        TextView btn_close = (TextView) dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //listener press button
                try
                {
                    //return to select levels
                    Intent intent = new Intent(Level_1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }
                dialog.dismiss();
            }
        });

        //button Continue dialog
        Button btn_continue = (Button) dialog.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    dialog.dismiss();
                } catch (Exception e)
                {

                }
            }
        });

        dialog.show();

        //_______________________________________________________________

        //Call dialog window in end game
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//hidden window title
        dialogEnd.setContentView(R.layout.dialog_end);//path in layout
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //set background window is transparent
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//no close back button

        //button Close dialog
        TextView btn_close2 = (TextView) dialogEnd.findViewById(R.id.btn_close);
        btn_close2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //listener press button
                try
                {
                    //return to select levels
                    Intent intent = new Intent(Level_1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }
                dialogEnd.dismiss();
            }
        });

        //button Continue dialog
        Button btn_continue2 = (Button) dialogEnd.findViewById(R.id.btn_continue);
        btn_continue2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(Level_1.this, Level_2.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }
                dialogEnd.dismiss();
            }
        });


        //_______________________________________________________________

        //button Back
        Button btn_back = (Button) findViewById(R.id.button_back_2);
        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //listener button Back
                try
                {
                    Intent intent = new Intent(Level_1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }
            }
        });

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7,
                R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14,
                R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,

        };

        //set animation -- start
        final Animation animation = AnimationUtils.loadAnimation(Level_1.this, R.anim.alpha);
        //set animation -- end

        //block for left image
        numLeft = random.nextInt(10);
        img_left.setImageResource(array.images1[numLeft]);
        text_left.setText(array.texts1[numLeft]);

        //block for right image
        numRight = random.nextInt(10);
        while (numLeft == numRight)
        {
            numRight = random.nextInt(10);
        }
        img_right.setImageResource(array.images1[numRight]);
        text_right.setText(array.texts1[numRight]);

        //listener press left image -- start
        img_left.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    img_right.setEnabled(false);
                    if (numLeft > numRight)
                    {
                        img_left.setImageResource(R.drawable.onelevel_correct);

                    } else
                    {
                        img_left.setImageResource(R.drawable.onelevel_incorrect);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (numLeft > numRight)
                    {

                        if (count < progress.length)
                        {
                            count++;
                        }

                        for (int i = 0; i < progress.length; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else
                    {
                        if (count > 0)
                        {
                            if (count == 1)
                            {
                                count = 0;
                            } else
                            {
                                count = count - 2;
                            }
                        }
                        for (int i = 0; i < progress.length - 1; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count == 20)
                    {
                        dialogEnd.show();
                    } else
                    {
                        //block for left image
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(animation);
                        text_left.setText(array.texts1[numLeft]);

                        //block for right image
                        numRight = random.nextInt(10);
                        while (numLeft == numRight)
                        {
                            numRight = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(animation);
                        text_right.setText(array.texts1[numRight]);
                        img_right.setEnabled(true);
                    }
                }

                return true;
            }
        });
        //listener press left image -- end

        //listener press right image -- start
        img_right.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    img_left.setEnabled(false);
                    if (numLeft < numRight)
                    {
                        img_right.setImageResource(R.drawable.onelevel_correct);

                    } else
                    {
                        img_right.setImageResource(R.drawable.onelevel_incorrect);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (numLeft < numRight)
                    {

                        if (count < progress.length)
                        {
                            count++;
                        }

                        for (int i = 0; i < progress.length; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else
                    {
                        if (count > 0)
                        {
                            if (count == 1)
                            {
                                count = 0;
                            } else
                            {
                                count = count - 2;
                            }
                        }
                        for (int i = 0; i < progress.length - 1; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++)
                        {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count == 20)
                    {
                        dialogEnd.show();
                    } else
                    {
                        //block for left image
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(animation);
                        text_left.setText(array.texts1[numLeft]);

                        //block for right image
                        numRight = random.nextInt(10);
                        while (numLeft == numRight)
                        {
                            numRight = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(animation);
                        text_right.setText(array.texts1[numRight]);
                        img_left.setEnabled(true);//turn on left image
                    }
                }

                return true;
            }
        });
        //listener press right image -- end
    }


    //system button Back

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        try
        {
            Intent intent = new Intent(Level_1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e)
        {

        }
    }
}