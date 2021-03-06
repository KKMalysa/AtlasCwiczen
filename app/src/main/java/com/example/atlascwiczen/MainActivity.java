package com.example.atlascwiczen;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.legacy.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.atlascwiczen.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private AtlasCwiczenObject[] cwiczenia;
    private AtlasCwiczenObject[] aktywnosciPozatreningowe;
    private AtlasCwiczenObject[] cwiczeniaZPrzyrzadami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pan da 3 ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cwiczenia, R.id.nav_przyrzady, R.id.nav_aktywnosci_pozatreningowe)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        cwiczenia = AtlasCwiczenObject.loadArrayFromJson(this, "cwiczenia");
        aktywnosciPozatreningowe = AtlasCwiczenObject.loadArrayFromJson(this, "aktywnosciPozatreningowe");

        /**
         * Je??li ??wiczenie wykorzystuje przyrz??d, to dodaje je do listy
         */
        ArrayList<AtlasCwiczenObject> arrayList = new ArrayList<>();

        for (AtlasCwiczenObject cwiczenie : cwiczenia) {
            if(cwiczenie.hasPrzyrzad()) {
                arrayList.add(cwiczenie);
            }
        }

        /**
         * Je??li aktywnosc pozatreningowa wykorzystuje przyrz??d, to dodaje je do listy
         *
         * bo w teorii potrzebny mo??e by?? rower albo pi??ka...
         */

        for (AtlasCwiczenObject aktywnoscPozatreningowa : aktywnosciPozatreningowe) {
            if(aktywnoscPozatreningowa.hasPrzyrzad()) {
                arrayList.add(aktywnoscPozatreningowa);
            }
        }

        cwiczeniaZPrzyrzadami = new AtlasCwiczenObject[arrayList.size()];

        /**
         * toArray - jak elementy sie zmieszcz?? to umiesci je w tablicy, jak nie, to stworzy nowa tablice o odpowiednim rozmiarze
         */
        cwiczeniaZPrzyrzadami = arrayList.toArray(cwiczeniaZPrzyrzadami);


        navigationView.setCheckedItem(R.id.nav_cwiczenia);
        /**
         * odkomentowanie poni??szej lini wykrzacza navigation drawer. czemu? - nie wiem
         */
//        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_cwiczenia));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override  // <- NIE ROZUMIEM - raz to podkre??la na czerowono, a raz nie. nie mam poj??cia od czego to zale??y. niestety gdy podkre??la to aplikacja sie wykrzacza
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_cwiczenia) {

            AtlasCwiczenFragment fragment = AtlasCwiczenFragment.newInstance(cwiczenia);

            replaceFragment(fragment);


        } else if (id == R.id.nav_przyrzady) {

            replaceFragment(PrzyrzadyFragment.newInstance(cwiczeniaZPrzyrzadami));


        } else if (id == R.id.nav_aktywnosci_pozatreningowe) {
            AtlasCwiczenFragment fragment = AtlasCwiczenFragment.newInstance(aktywnosciPozatreningowe);

            replaceFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        //wszelkie operacje na fragmentach wyknuje si?? przy u??yciu transakcji
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerLayout, fragment); //<- add by nakladal jedne na drugi, a tego nie chce
        fragmentTransaction.commit(); // <- zatwierdza transakcje. tak trzeba i ju??
    }
}