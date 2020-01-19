package io.github.joshtiffany.ultimatecalculator.Geometry;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import io.github.joshtiffany.ultimatecalculator.Calculators.MainActivity;
import io.github.joshtiffany.ultimatecalculator.Calculators.ScientificActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.AngleActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.EnergyActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.ForceActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.MeasureActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.PowerActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.Pressure;
import io.github.joshtiffany.ultimatecalculator.Conversions.SpeedActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.TempActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.TimeActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.VolumeActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.WeightActivty;
import io.github.joshtiffany.ultimatecalculator.R;
import io.github.joshtiffany.ultimatecalculator.SettingsMisc.SettingsActivity;

public class AreaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView simpleList;
    String[] geometry = {"Triangle", "Square", "Rectangle", "Parallelogram", "Trapezoid", "Rhombus",
            "Pentagon", "Hexagon", "Circle", "Circle arc", "Ellipse", "Cube", "Rectangular Prism",
            "Square Pyramid", "Square Pyramid Frustum", "Cylinder", "Cone", "Conical Frustum",
            "Sphere", "Spherical Cap", "Ellipsoid"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        simpleList = findViewById(R.id.areaListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview, R.id.textView, geometry);
        simpleList.setAdapter(arrayAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), AreaTriangleActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), AreaSquareActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), AreaRectangleActivity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), AreaParallelogramActivity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), Trapezoid.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), RhombusActivity.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), PentagonActivity.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), AreaHexagonActivity.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), AreaCircleActivity.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), AreaCircleArcActivty.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(getApplicationContext(), AreaEllipseActivity.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(getApplicationContext(), CubeAreaActivity.class);
                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(getApplicationContext(), RectangPrismAreaActivity.class);
                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(getApplicationContext(), SquarePyramidAreaActivity.class);
                    startActivity(intent);
                } else if (position == 14) {
                    Intent intent = new Intent(getApplicationContext(), SquarePyrFrustumAreaActivity.class);
                    startActivity(intent);
                } else if (position == 15) {
                    Intent intent = new Intent(getApplicationContext(), CylinderAreaActivity.class);
                    startActivity(intent);
                } else if (position == 16) {
                    Intent intent = new Intent(getApplicationContext(), ConeAreaActivity.class);
                    startActivity(intent);
                } else if (position == 17) {
                    Intent intent = new Intent(getApplicationContext(), ConicalFrustumAreaActivity.class);
                    startActivity(intent);
                } else if (position == 18) {
                    Intent intent = new Intent(getApplicationContext(), SphereAreaActivty.class);
                    startActivity(intent);
                } else if (position == 19) {
                    Intent intent = new Intent(getApplicationContext(), SphericalCapAreaActivity.class);
                    startActivity(intent);
                } else if (position == 20) {
                    Intent intent = new Intent(getApplicationContext(), EllipsoidAreaActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.area, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent homeIntent = new Intent(this, SettingsActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent startintent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_gallery) {
            Intent startintent = new Intent(getApplicationContext(), ScientificActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_share) {
            Intent startintent = new Intent(getApplicationContext(), TempActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_send) {
            Intent startintent = new Intent(getApplicationContext(), MeasureActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_time) {
            Intent startintent = new Intent(getApplicationContext(), TimeActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_speed) {
            Intent startintent = new Intent(getApplicationContext(), SpeedActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_volume) {
            Intent startintent = new Intent(getApplicationContext(), VolumeActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_force) {
            Intent startintent = new Intent(getApplicationContext(), ForceActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_weight) {
            Intent startintent = new Intent(getApplicationContext(), WeightActivty.class);
            startActivity(startintent);
        } else if (id == R.id.nav_power) {
            Intent startintent = new Intent(getApplicationContext(), PowerActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_pressure) {
            Intent startintent = new Intent(getApplicationContext(), Pressure.class);
            startActivity(startintent);
        } else if (id == R.id.nav_energy) {
            Intent startintent = new Intent(getApplicationContext(), EnergyActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_angle) {
            Intent startintent = new Intent(getApplicationContext(), AngleActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_area) {
            Intent startintent = new Intent(getApplicationContext(), AreaActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_geovolume) {
            Intent startintent = new Intent(getApplicationContext(), io.github.joshtiffany.ultimatecalculator.Geometry.VolumeActivity.class);
            startActivity(startintent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
