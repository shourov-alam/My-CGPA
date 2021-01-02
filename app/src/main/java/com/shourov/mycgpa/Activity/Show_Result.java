package com.shourov.mycgpa.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.shourov.mycgpa.ModelClass.Model_class;
import com.shourov.mycgpa.Database.DataBaseHelper;
import com.shourov.mycgpa.Database.DatabaseSource;
import com.shourov.mycgpa.R;
import java.util.ArrayList;

public class Show_Result extends AppCompatActivity {
    ArrayList<Model_class> arrayList;
    DatabaseSource databaseSource;
    LinearLayout dashboard;
    CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    Toolbar toolbar;
    TextView cgpa, total_course, total_credit,
            credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10, credit11, credit12,
            sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8, sg9, sg10, sg11, sg12,
            s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;
    int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12;

    float result_sgpa, result_sgpa2, result_sgpa3, result_sgpa4, result_sgpa5, result_sgpa6, result_sgpa7, result_sgpa8, result_sgpa9, result_sgpa10, result_sgpa11, result_sgpa12;
    float result_cgpa;
    float d = 0;
    float g = 0;
    float h = 0, h2 = 0, h3 = 0, h4 = 0, h5 = 0, h6 = 0, h7 = 0, h8 = 0, h9 = 0, h10 = 0, h11 = 0, h12 = 0;
    float j = 0, j2 = 0, j3 = 0, j4 = 0, j5 = 0, j6 = 0, j7 = 0, j8 = 0, j9 = 0, j10 = 0, j11 = 0, j12 = 0;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__result);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1366242071094783/6971469399");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {


                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        databaseSource=new DatabaseSource(getApplicationContext());

        arrayList=databaseSource.getAllCourse(DataBaseHelper.COL_SEMESTER + " ASC");

        for (int i=0;i<arrayList.size();i++){
            dashboard.setVisibility(View.VISIBLE);
            float a= arrayList.get(i).getGrade();
            float b= arrayList.get(i).getCredit();

            float c=a*b;
            d = d+c;
            g=g+b;
            result_cgpa=d/g;

            cgpa.setText(String.format("%.2f", result_cgpa));
            total_course.setText(String.valueOf(arrayList.size()));
            total_credit.setText(String.valueOf(g));

          //  String ns42 = String.format("%.2f", ns4);

            if(arrayList.get(i).getSemester()==1){
                card1.setVisibility(View.VISIBLE);
                i1++;

                float cr=arrayList.get(i).getCredit();
                float gr=arrayList.get(i).getGrade();

                float k=cr*gr;
                h=h+k;
                j=j+cr;
                result_sgpa=h/j;

                credit1.setText(String.valueOf(j));
                sg1.setText(String.format("%.2f", result_sgpa));
                s1.setText(String.valueOf(i1));


            }  if(arrayList.get(i).getSemester()==2){
                card2.setVisibility(View.VISIBLE);
                i2++;

                float cr2=arrayList.get(i).getCredit();
                float gr2=arrayList.get(i).getGrade();

                float k2=cr2*gr2;
                h2=h2+k2;
                j2=j2+cr2;
                result_sgpa2=h2/j2;

                credit2.setText(String.valueOf(j2));
                sg2.setText(String.format("%.2f", result_sgpa2));
                s2.setText(String.valueOf(i2));
            }

            if(arrayList.get(i).getSemester()==3){
                card3.setVisibility(View.VISIBLE);
                i3++;

                float cr3=arrayList.get(i).getCredit();
                float gr3=arrayList.get(i).getGrade();

                float k3=cr3*gr3;
                h3=h3+k3;
                j3=j3+cr3;
                result_sgpa3=h3/j3;

                credit3.setText(String.valueOf(j3));
                sg3.setText(String.format("%.2f", result_sgpa3));
                s3.setText(String.valueOf(i3));
            }


            if(arrayList.get(i).getSemester()==4){
                card4.setVisibility(View.VISIBLE);
                i4++;

                float cr4=arrayList.get(i).getCredit();
                float gr4=arrayList.get(i).getGrade();

                float k4=cr4*gr4;
                h4=h4+k4;
                j4=j4+cr4;
                result_sgpa4=h4/j4;

                credit4.setText(String.valueOf(j4));
                sg4.setText(String.format("%.2f", result_sgpa4));
                s4.setText(String.valueOf(i4));
            }


            if(arrayList.get(i).getSemester()==5){
                card5.setVisibility(View.VISIBLE);
                i5++;

                float cr5=arrayList.get(i).getCredit();
                float gr5=arrayList.get(i).getGrade();

                float k5=cr5*gr5;
                h5=h5+k5;
                j5=j5+cr5;
                result_sgpa5=h5/j5;

                credit5.setText(String.valueOf(j5));
                sg5.setText(String.format("%.2f", result_sgpa5));
                s5.setText(String.valueOf(i5));
            }


            if(arrayList.get(i).getSemester()==6){
                card6.setVisibility(View.VISIBLE);
                i6++;

                float cr6=arrayList.get(i).getCredit();
                float gr6=arrayList.get(i).getGrade();

                float k6=cr6*gr6;
                h6=h6+k6;
                j6=j6+cr6;
                result_sgpa6=h6/j6;

                credit6.setText(String.valueOf(j6));
                sg6.setText(String.format("%.2f", result_sgpa6));
                s6.setText(String.valueOf(i6));
            }


            if(arrayList.get(i).getSemester()==7){
                card7.setVisibility(View.VISIBLE);
                i7++;

                float cr7=arrayList.get(i).getCredit();
                float gr7=arrayList.get(i).getGrade();

                float k7=cr7*gr7;
                h7=h7+k7;
                j7=j7+cr7;
                result_sgpa7=h7/j7;

                credit7.setText(String.valueOf(7));
                sg7.setText(String.format("%.2f", result_sgpa7));
                s7.setText(String.valueOf(i7));
            }


            if(arrayList.get(i).getSemester()==8){
                card8.setVisibility(View.VISIBLE);
                i8++;

                float cr8=arrayList.get(i).getCredit();
                float gr8=arrayList.get(i).getGrade();

                float k8=cr8*gr8;
                h8=h8+k8;
                j8=j8+cr8;
                result_sgpa8=h8/j8;

                credit8.setText(String.valueOf(j8));
                sg8.setText(String.format("%.2f", result_sgpa8));
                s8.setText(String.valueOf(i8));
            }


            if(arrayList.get(i).getSemester()==9){
                card9.setVisibility(View.VISIBLE);
                i9++;

                float cr9=arrayList.get(i).getCredit();
                float gr9=arrayList.get(i).getGrade();

                float k9=cr9*gr9;
                h9=h9+k9;
                j9=j9+cr9;
                result_sgpa9=h9/j9;

                credit9.setText(String.valueOf(j9));
                sg9.setText(String.format("%.2f", result_sgpa9));
                s9.setText(String.valueOf(i9));
            }


            if(arrayList.get(i).getSemester()==10){
                card10.setVisibility(View.VISIBLE);
                i10++;

                float cr10=arrayList.get(i).getCredit();
                float gr10=arrayList.get(i).getGrade();

                float k10=cr10*gr10;
                h10=h10+k10;
                j10=j10+cr10;
                result_sgpa10=h10/j10;

                credit10.setText(String.valueOf(j10));
                sg10.setText(String.format("%.2f", result_sgpa10));
                s10.setText(String.valueOf(i10));
            }


            if(arrayList.get(i).getSemester()==11){
                card11.setVisibility(View.VISIBLE);
                i11++;

                float cr11=arrayList.get(i).getCredit();
                float gr11=arrayList.get(i).getGrade();

                float k11=cr11*gr11;
                h11=h11+k11;
                j11=j11+cr11;
                result_sgpa11=h11/j11;

                credit11.setText(String.valueOf(j11));
                sg11.setText(String.format("%.2f", result_sgpa11));
                s11.setText(String.valueOf(i11));
            }


            if(arrayList.get(i).getSemester()==12){
                card12.setVisibility(View.VISIBLE);
                i12++;

                float cr12=arrayList.get(i).getCredit();
                float gr12=arrayList.get(i).getGrade();

                float k12=cr12*gr12;
                h12=h12+k12;
                j12=j12+cr12;
                result_sgpa12=h12/j12;

                credit12.setText(String.valueOf(j12));
                sg12.setText(String.format("%.2f", result_sgpa12));
                s12.setText(String.valueOf(i12));
            }


        }


    }

    private void init() {
        cgpa=findViewById(R.id.cg);
        total_course=findViewById(R.id.totalc);
        total_credit=findViewById(R.id.totalcr);

        credit1=findViewById(R.id.credit);
        credit2=findViewById(R.id.credit2);
        credit3=findViewById(R.id.credit3);
        credit4=findViewById(R.id.credit4);
        credit5=findViewById(R.id.credit5);
        credit6=findViewById(R.id.credit6);
        credit7=findViewById(R.id.credit7);
        credit8=findViewById(R.id.credit8);
        credit9=findViewById(R.id.credit9);
        credit10=findViewById(R.id.credit10);
        credit11=findViewById(R.id.credit11);
        credit12=findViewById(R.id.credit12);


        sg1=findViewById(R.id.sg);
        sg2=findViewById(R.id.sg2);
        sg3=findViewById(R.id.sg3);
        sg4=findViewById(R.id.sg4);
        sg5=findViewById(R.id.sg5);
        sg6=findViewById(R.id.sg6);
        sg7=findViewById(R.id.sg7);
        sg8=findViewById(R.id.sg8);
        sg9=findViewById(R.id.sg9);
        sg10=findViewById(R.id.sg10);
        sg11=findViewById(R.id.sg11);
        sg12=findViewById(R.id.sg12);

        s1=findViewById(R.id.semester);
        s2=findViewById(R.id.semester2);
        s3=findViewById(R.id.semester3);
        s4=findViewById(R.id.semester4);
        s5=findViewById(R.id.semester5);
        s6=findViewById(R.id.semester6);
        s7=findViewById(R.id.semester7);
        s8=findViewById(R.id.semester8);
        s9=findViewById(R.id.semester9);
        s10=findViewById(R.id.semester10);
        s11=findViewById(R.id.semester11);
        s12=findViewById(R.id.semester12);


        dashboard=findViewById(R.id.lin1);

        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card5=findViewById(R.id.card5);
        card6=findViewById(R.id.card6);
        card7=findViewById(R.id.card7);
        card8=findViewById(R.id.card8);
        card9=findViewById(R.id.card9);
        card10=findViewById(R.id.card10);
        card11=findViewById(R.id.card11);
        card12=findViewById(R.id.card12);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
           onBackPressed(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

        super.onBackPressed();
    }
}
