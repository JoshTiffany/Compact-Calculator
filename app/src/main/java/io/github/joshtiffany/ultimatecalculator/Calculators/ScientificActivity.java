package io.github.joshtiffany.ultimatecalculator.Calculators;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.common.math.BigIntegerMath;

import java.text.DecimalFormat;

import io.github.joshtiffany.ultimatecalculator.Conversions.ForceActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.MeasureActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.SpeedActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.TempActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.TimeActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.VolumeActivity;
import io.github.joshtiffany.ultimatecalculator.Conversions.WeightActivty;
import io.github.joshtiffany.ultimatecalculator.R;

public class ScientificActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button squared;
    private Button squareRoot;
    private Button Xy;
    private Button cos;
    private Button sin;
    private Button tan;
    private Button tenX;
    private Button log;
    private Button exp;
    private Button mod;
    private Button upArrow;
    private Button clearEntry;
    private Button clear;
    private Button del;
    private Button division;
    private Button multiplication;
    private Button subtraction;
    private Button addition;
    private Button pi;
    private Button fact;
    private Button minus;
    private Button openBrace;
    private Button closeBrace;
    private Button decimal;
    private Button equal;
    private TextView result;
    private TextView info;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '−';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '÷';
    private final char XY = 'y';
    private final char MOD = 'm';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setUpViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + ".");
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + "-");
                    info.setText(null);
                } else {
                    info.setText(null);
                }
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = ADDITION;
                    result.setText(String.valueOf(val1) + "+");
                    info.setText(null);
                } else {
                    info.setText(null);
                }
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + "*");
                    info.setText(null);
                } else {
                    info.setText(null);
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + "/");
                    info.setText(null);
                } else {
                    info.setText(null);
                }
            }
        });

        squared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        val1 = val1 * val1 * val1;
                        result.setText("sqr(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = val1 * val1;
                        result.setText("sqr(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    }

                } else {
                    info.setText(null);
                }
            }
        });

        squareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        val1 = 1 / val1;
                        result.setText("1/" + String.valueOf(val1) + "=" + val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = Math.sqrt(val1);
                        result.setText("√(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    }
                } else {
                    info.setText(null);
                }
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = EQU;
                    result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                    // 5 + 4 = 9
                    info.setText(String.valueOf(val1));
                } else
                    info.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    DecimalFormat fmt = new DecimalFormat("-#");
                    info.setText(fmt.format(val1));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    info.setText(null);
                    result.setText(null);
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence input = info.getText().toString();
                    info.setText(input.subSequence(0, input.length() - 1));
                }
            }
        });

        clearEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    info.setText(null);
                }
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        val1 = Math.acos(Math.toRadians(val1));
                        result.setText("acos(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = Math.cos(Math.toRadians(val1));
                        result.setText("cos(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    }
                }
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        val1 = Math.asin(Math.toRadians(val1));
                        result.setText("asin(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = Math.sin(Math.toRadians(val1));
                        result.setText("sin(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    }
                }

            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        val1 = Math.atan(Math.toRadians(val1));
                        result.setText("atan(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = Math.tan(Math.toRadians(val1));
                        result.setText("tan(" + String.valueOf(val1) + ")" + "=" + val1);
                        info.setText(String.valueOf(val1));
                    }
                }
            }
        });

        tenX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        result.setText("e^(" + String.valueOf(val1) + ")" + "=" + Math.E * val1);
                        val1 = Math.E * val1;
                        info.setText(String.valueOf(val1));
                    } else {
                        val1 = Math.pow(10, val1);
                        result.setText("10^(" + String.valueOf(val1 + ")" + "=" + val1));
                        info.setText(String.valueOf(val1));
                    }

                }
            }
        });

        Xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = XY;
                    result.setText(String.valueOf(val1) + "^");
                    info.setText(null);
                }
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(String.valueOf(Math.PI));
            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    int convert = (int) val1;
                    val1 = BigIntegerMath.factorial(convert).doubleValue();
                    result.setText("Fact(" + String.valueOf(BigIntegerMath.factorial(convert) + ")"));
                    info.setText(String.valueOf(val1));
                }
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    if (upArrow.getTag().equals(1)) {
                        result.setText("In(" + String.valueOf(val1) + ")" + "=" + Math.log(val1));
                        val1 = Math.log(val1);
                        info.setText(String.valueOf(val1));
                    } else {
                        result.setText("log(" + String.valueOf(val1) + ")" + "=" + Math.log10(val1));
                        val1 = Math.log10(val1);
                        info.setText(String.valueOf(val1));
                    }
                }
            }
        });

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    result.setText("exp(" + String.valueOf(val1) + ")" + "=" + Math.exp(val1));
                    val1 = Math.exp(val1);
                    info.setText(String.valueOf(val1));
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    compute();
                    ACTION = MOD;
                    result.setText(String.valueOf(val1) + "%");
                    info.setText(null);
                }
            }
        });
        upArrow.setTag(0);
        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer) v.getTag();
                switch (status) {
                    case 0:
                        v.setTag(1);
                        cos.setText("-COS");
                        tan.setText("-TAN");
                        sin.setText("-SIN");
                        squared.setText("X3");
                        squareRoot.setText("1/X");
                        tenX.setText("Ex");
                        log.setText("IN");
                        break;
                    case 1:
                        cos.setText("COS");
                        tan.setText("TAN");
                        sin.setText("SIN");
                        squared.setText("X2");
                        squareRoot.setText("√");
                        tenX.setText("10X");
                        log.setText("LOG");
                        v.setTag(0);
                        break;
                }
            }
        });

    }

    public void setUpViews() {
        one = findViewById(R.id.sciOneBTN);
        two = findViewById(R.id.sciTwoBTN);
        three = findViewById(R.id.sciThreeBTN);
        four = findViewById(R.id.sciFourBTN);
        five = findViewById(R.id.sciFiveBTN);
        six = findViewById(R.id.sciSixBTN);
        seven = findViewById(R.id.sciSevenBTN);
        eight = findViewById(R.id.sciEightBTN);
        nine = findViewById(R.id.sciNineBTN);
        zero = findViewById(R.id.sciZeroBTN);
        squared = findViewById(R.id.sciSquardedBTN);
        squareRoot = findViewById(R.id.sciSquareRootBTN);
        Xy = findViewById(R.id.xYBTN);
        cos = findViewById(R.id.cosBTN);
        sin = findViewById(R.id.sinBTN);
        tan = findViewById(R.id.tanBTN);
        tenX = findViewById(R.id.tenXBTN);
        log = findViewById(R.id.logBTN);
        exp = findViewById(R.id.expBTN);
        mod = findViewById(R.id.modBTN);
        upArrow = findViewById(R.id.upArrowBTN);
        clearEntry = findViewById(R.id.sciClearEntryBTN);
        clear = findViewById(R.id.sciClearBTN);
        del = findViewById(R.id.sciDeleteBTN);
        division = findViewById(R.id.sciDivisionBTN);
        multiplication = findViewById(R.id.sciMultiplicationBTN);
        subtraction = findViewById(R.id.sciSubtractionBTN);
        addition = findViewById(R.id.sciAdditionBTN);
        pi = findViewById(R.id.piBTN);
        fact = findViewById(R.id.factBTN);
        minus = findViewById(R.id.sciMinusBTN);
        openBrace = findViewById(R.id.braceOpenBTN);
        closeBrace = findViewById(R.id.braceCloseBTN);
        decimal = findViewById(R.id.sciPeriodBTN);
        equal = findViewById(R.id.sciEqualBTN);
        info = findViewById(R.id.sciInfoTV);
        result = findViewById(R.id.sciResultTV);
    }

    public double factorialUsingRecursion() {
        if (val1 <= 2) {
            return val1;
        }
        return val1 * factorialUsingRecursion();
    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case XY:
                    val1 = Math.pow(val1, val2);
                    break;
                case MOD:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }
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
        getMenuInflater().inflate(R.menu.scientific, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_standard) {
            Intent startintent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_scientific) {
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
        } else if (id == R.id.speed) {
            Intent startintent = new Intent(getApplicationContext(), SpeedActivity.class);
            startActivity(startintent);
        } else if (id == R.id.volume) {
            Intent startintent = new Intent(getApplicationContext(), VolumeActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_force) {
            Intent startintent = new Intent(getApplicationContext(), ForceActivity.class);
            startActivity(startintent);
        } else if (id == R.id.nav_weight) {
            Intent startintent = new Intent(getApplicationContext(), WeightActivty.class);
            startActivity(startintent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
