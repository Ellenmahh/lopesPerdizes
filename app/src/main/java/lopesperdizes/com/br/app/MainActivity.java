package lopesperdizes.com.br.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static lopesperdizes.com.br.app.base.tipo.VENDA;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Context context;
    Toolbar toolbar;
    Button instabtn;
    AutoCompleteTextView tipo,tipo_moradia;
    Spinner spinner_tipo,spinner_tipo_moradia;
    EditText endereco, referencia;
    DrawerLayout drawer;
    ViewPager banner_img;
    LinearLayout sliderDots;
    ListView lst_main;
    List<base> lstImoveis = new ArrayList<>();
    private int dotscount;
    private ImageView[] dots;
    baseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        toolbar = findViewById(R.id.toolbar);
        tipo =  findViewById(R.id.tipo);
        tipo_moradia =  findViewById(R.id.tipo_moradia);
        spinner_tipo =  findViewById(R.id.spinner_tipo);
        drawer =  findViewById(R.id.drawer_layout);
        endereco =  findViewById(R.id.endereco);
        referencia =  findViewById(R.id.referencia);
        banner_img =  findViewById(R.id.banner_img);
        sliderDots =  findViewById(R.id.sliderDots);
        lst_main =  findViewById(R.id.lst_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //set auto complete
        spinner_tipo_moradia =  findViewById(R.id.spinner_tipo_moradia);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipo));
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.tipo_moradia));
        tipo.setAdapter(adapter);
        tipo_moradia.setAdapter(adapter2);
        //set spinner
        spinner_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo.setText(spinner_tipo.getSelectedItem().toString());
                tipo.dismissDropDown();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipo.setText(spinner_tipo.getSelectedItem().toString());
                tipo.dismissDropDown();
            }
        });
        spinner_tipo_moradia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo_moradia.setText(spinner_tipo_moradia.getSelectedItem().toString());
                tipo_moradia.dismissDropDown();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipo_moradia.setText(spinner_tipo_moradia.getSelectedItem().toString());
                tipo_moradia.dismissDropDown();
            }
        });

        ViewPageAdapter adapter1 = new ViewPageAdapter(context,lstImoveis);
        banner_img.setAdapter(adapter1);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
