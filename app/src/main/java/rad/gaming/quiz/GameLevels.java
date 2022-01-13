package rad.gaming.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class GameLevels extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //Enable fullscreen mode
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //'Back' button listener
        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {

                }
            }
        });

        //'Level 1' button listener
        TextView textView_1 = (TextView) findViewById(R.id.textView_1);
        textView_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(GameLevels.this, Level_1.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {
                    //empty
                }
            }
        });

        //'Level 2' button listener
        TextView textView_2 = (TextView) findViewById(R.id.textView_2);
        textView_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(GameLevels.this, Level_2.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {
                    //empty
                }
            }
        });

        //'Level 3' button listener
        TextView textView_3 = (TextView) findViewById(R.id.textView_3);
        textView_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(GameLevels.this, Level_3.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {
                    //empty
                }
            }
        });

        //'Level 4' button listener
        TextView textView_4 = (TextView) findViewById(R.id.textView_4);
        textView_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent(GameLevels.this, Level_4.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e)
                {
                    //empty
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        try
        {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e)
        {

        }
    }
}