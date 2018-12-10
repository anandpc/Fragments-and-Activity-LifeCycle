package io.github.anandpc.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    FragmentManager manager;


    private boolean mswitch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"MainActivity : onCreate()");

            manager = getSupportFragmentManager();
    }


    public void onPush(View view) {

        if(mswitch){
            Fragment1 fragment1 = new Fragment1();
            Toast.makeText(this,"Fragment 1 Pushed..",Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.frag_container,fragment1);
            transaction.addToBackStack("frag1");
            transaction.commit();
            mswitch = true;
        }else {
            Fragment2 fragment2 = new Fragment2();
            Toast.makeText(this,"Fragment 2 Pushed..",Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.frag_container,fragment2);
            transaction.addToBackStack("frag2");
            transaction.commit();
            mswitch = false;
        }
    }

    public void onPop(View view) {
        manager.popBackStack();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"MainActivity : onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"MainActivity : onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"MainActivity : onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"MainActivity : onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"MainActivity : onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MainActivity : onDestroy()");
    }
}
