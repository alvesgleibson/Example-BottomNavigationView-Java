package com.alvesgleibson.bottomprincipal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
        private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv);
        getFragment(new HomeFragment());

    }

    @Override
    protected void onStart() {
        super.onStart();
        onCn();
    }

    public void onCn(){
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.ic_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.ic_cidade:
                        selectedFragment = new CidadesFragment();
                        break;
                    case R.id.ic_dicas:
                        selectedFragment = new DicasFragment();
                        break;
                    case R.id.ic_noticias:
                        selectedFragment = new NoticiasFragment();
                        break;
                    case R.id.ic_informacao:
                        selectedFragment = new InformacaoFragment();
                        break;
                }
                getFragment(selectedFragment);

            }
        });
    }


    public void getFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }

}