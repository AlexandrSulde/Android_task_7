package ru.startandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OnActionListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (fragmentManager.getBackStackEntryCount() > 0){
                fragmentManager.popBackStack();
        return true;}
        return false;
    }

    void connectStack(Fragment instance, String t) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameid, instance);
        fragmentTransaction.addToBackStack(t);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        fragmentManager = getSupportFragmentManager();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            Log.d("invocate", "actionBar!=null");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    onAction("first");
    }

    @Override
    public void onAction(String tag) {
        switch (tag) {
            case "second" :
                connectStack(new FragmentActivationCode(), tag);
                break;
            case "third" :
                connectStack(new FragmentContactList(), tag);
                break;
            default :
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameid, new FragmentAuthorization());
                fragmentTransaction.commit();
                break;
        }
    }
    

}