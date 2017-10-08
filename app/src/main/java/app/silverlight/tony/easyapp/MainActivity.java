package app.silverlight.tony.easyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.silverlight.tony.easyapp.fragment.ChooseTargetFragment;
import app.silverlight.tony.easyapp.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //History
        setContentView(R.layout.activity_main);

//        Add Fragment to Activity
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment())
                    .commit();
        }

        //Tool bar Controller
        toolBarController();

    } //Main Method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        For Main Menu
        if (item.getItemId() == R.id.itemMain) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentFragmentMain,new MainFragment())
                    .commit();
        }

//        For Choose Image Item
        if (item.getItemId() == R.id.itemChooseImage) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentFragmentMain,new ChooseTargetFragment())
                    .commit();
        }

//        For Exit
        if (item.getItemId() == R.id.itemExit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void toolBarController() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
} //Main Class
