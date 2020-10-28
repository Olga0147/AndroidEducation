package com.example.secondtask;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity{



    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.basic_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint({"ShowToast", "NonConstantResourceId"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_btn_exit:
                Toast.makeText(MainActivity.this, R.string.menu_exit,Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.menu_btn_settings:
                Toast.makeText(MainActivity.this, R.string.menu_settings,Toast.LENGTH_LONG).show();
                fragmentManager.beginTransaction().
                        replace(R.id.fragment_container_id,SettingsFragment.newInstance()).
                        addToBackStack(MainFragment.class.getName()).
                        commit();
                break;
            case R.id.menu_btn_search:
                Toast.makeText(MainActivity.this, R.string.menu_search,Toast.LENGTH_LONG).show();
                fragmentManager.beginTransaction().
                        replace(R.id.fragment_container_id,SearchFragment.newInstance()).
                        addToBackStack(MainFragment.class.getName()).
                        commit();
                break;
            default:
                Toast.makeText(MainActivity.this, R.string.menu_error,Toast.LENGTH_LONG);
        }
        return super.onOptionsItemSelected(item);
    }
}
