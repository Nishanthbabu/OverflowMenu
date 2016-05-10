package com.example.skilledanswers_d1.overflowmenu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.skilledanswers_d1.overflowmenu.Fragments.MyAccount;
import com.example.skilledanswers_d1.overflowmenu.Fragments.MyOrders;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager=null;
    private FragmentTransaction fragmentTransaction=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int count=fragmentManager.getBackStackEntryCount();
//        if(count==0)
//        {
//            super.onBackPressed();
//        }else
//        {
//            getSupportFragmentManager().popBackStack();
//        }
        Toast.makeText(MainActivity.this, "fragment"+count, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_myaccount) {
            MyAccount myAccount= (MyAccount) getSupportFragmentManager().findFragmentByTag("MYACCOUNT");
            if(myAccount!=null && myAccount.isVisible())
            {
                Toast.makeText(MainActivity.this, "You are in same page", Toast.LENGTH_SHORT).show();
            }
            else {



                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_main, new MyAccount(), "MYACCOUNT").addToBackStack(null).commit();

                return true;
            }

        }
        else if(id == R.id.action_myorder)
        {
            MyOrders myAccount= (MyOrders) getSupportFragmentManager().findFragmentByTag("MYORDER");
            if(myAccount!=null && myAccount.isVisible())
            {
                Toast.makeText(MainActivity.this, "You are in same page", Toast.LENGTH_SHORT).show();
            }
            else {


                MyOrders myAccount1 = new MyOrders();
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_main, myAccount1, "MYORDER").addToBackStack("MYORDER").commit();

                return true;
            }
        }
        else if(id==R.id.action_wishlist)
        {
            return true;
        }
        else if(id==R.id.action_rate_the_app)
        {
            return true;
        }
        else if (id==R.id.action_help_center)
        {
            return true;
        }
        else if (id==R.id.action_leagel)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
