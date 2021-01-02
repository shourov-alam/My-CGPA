package com.shourov.mycgpa.Fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.shourov.mycgpa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sgpa_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private LinearLayout s_Row3,s_Row4,s_Row5,s_Row6,s_Row7,s_Row8,s_Row9,s_Row10,s_Row11,s_Row12,s_Row13,s_Row14,s_Row15,calculate_view,reset_view;

    private EditText s_Et1,s_Et2,s_Et3,s_Et4,s_Et5,s_Et6,s_Et7,s_Et8,s_Et9,s_Et10,s_Et11,s_Et12,s_Et13,s_Et14,s_Et15;



    private AutoCompleteTextView auto1,auto2,auto3,auto4,auto5,auto6,auto7,auto8,auto9,
            auto10,auto11,auto12,auto13,auto14,auto15;
    private Spinner addMore;

    private View view1;

    private View view;

   private float gpa1, gpa2, gpa3, gpa4, gpa5, gpa6, gpa7, gpa8, gpa9, gpa10, gpa11, gpa12, gpa13, gpa14, gpa15;

   private float credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10,
            credit11, credit12, credit13, credit14, credit15;

   private float point1, point2, point3, point4, point5, point6, point7, point8, point9, point10,
            point11, point12, point13, point14, point15;

   private boolean isOpened2,isOpened3,isOpened4,isOpened5,isOpened6,isOpened7,isOpened8,isOpened9
            ,isOpened10,isOpened11,isOpened12,isOpened13,isOpened14;


   private boolean isEmpty1,isEmpty2,isEmpty3,isEmpty4,isEmpty5,isEmpty6,isEmpty7,isEmpty8,isEmpty9,isEmpty10
            ,isEmpty11,isEmpty12,isEmpty13,isEmpty14,isEmpty15;

   private boolean pass1,pass2,pass3,pass4,pass5,pass6,pass7,pass8
            ,pass9,pass10,pass11,pass12,pass13,pass14,pass15;


    private int a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;

  /*  private String[] arr = { "4.00", "3.80","3.75","3.70","3.67","3.50","3.40","3.33",
            "3.30", "3.25","3.20","3.10","3.00","2.90","2.80","2.75","2.70",
            "2.67","2.50","2.33","2.30","2.25","2.20","2.00","1.99","1.75",
            "1.70","1.67","1.50","1.33","1.30","1.25","1.00","0.00",};  */
    public Sgpa_Fragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view= inflater.inflate(R.layout.fragment_sgpa_, container, false);

        init();
        auto_Adapter();

        return view;

    }

private void auto_Adapter(){

    addMore.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
       /* ArrayAdapter<String> dataAdapter = new ArrayAdapter.<String>(this.getActivity(), android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.count) );
        dataAdapter.setDropDownViewResource(R.layout.my_spinner_item);
        addMore.setAdapter(dataAdapter);  */
    ArrayAdapter adapter1 =  ArrayAdapter.createFromResource(this.getActivity(),R.array.count,  R.layout.spinner);

    adapter1.setDropDownViewResource(R.layout.my_spinner_item);
    addMore.setAdapter(adapter1);


    ArrayAdapter<String> adapter = new ArrayAdapter<String>
            (this.getActivity(),android.R.layout.select_dialog_item,getResources().getStringArray(R.array.grades));

    auto1.setThreshold(1);
    auto2.setThreshold(1);
    auto3.setThreshold(1);
    auto4.setThreshold(1);
    auto5.setThreshold(1);
    auto6.setThreshold(1);
    auto7.setThreshold(1);
    auto8.setThreshold(1);
    auto9.setThreshold(1);
    auto10.setThreshold(1);
    auto11.setThreshold(1);
    auto12.setThreshold(1);
    auto13.setThreshold(1);
    auto14.setThreshold(1);
    auto15.setThreshold(1);

    auto1.setAdapter(adapter);
    auto2.setAdapter(adapter);
    auto3.setAdapter(adapter);
    auto4.setAdapter(adapter);
    auto5.setAdapter(adapter);
    auto6.setAdapter(adapter);
    auto7.setAdapter(adapter);
    auto8.setAdapter(adapter);
    auto9.setAdapter(adapter);
    auto10.setAdapter(adapter);
    auto11.setAdapter(adapter);
    auto12.setAdapter(adapter);
    auto13.setAdapter(adapter);
    auto14.setAdapter(adapter);
    auto15.setAdapter(adapter);

}

     private void init(){

    s_Row3=view.findViewById(R.id.sRow3);
    s_Row4=view.findViewById(R.id.sRow4);
    s_Row5=view.findViewById(R.id.sRow5);
    s_Row6=view.findViewById(R.id.sRow6);
    s_Row7=view.findViewById(R.id.sRow7);
    s_Row8=view.findViewById(R.id.sRow8);
    s_Row9=view.findViewById(R.id.sRow9);
    s_Row10=view.findViewById(R.id.sRow10);
    s_Row11=view.findViewById(R.id.sRow11);
    s_Row12=view.findViewById(R.id.sRow12);
    s_Row13=view.findViewById(R.id.sRow13);
    s_Row14=view.findViewById(R.id.sRow14);
    s_Row15=view.findViewById(R.id.sRow15);


    s_Et1=view.findViewById(R.id.sEt1);
    s_Et2=view.findViewById(R.id.sEt2);
    s_Et3=view.findViewById(R.id.sEt3);
    s_Et4=view.findViewById(R.id.sEt4);
    s_Et5=view.findViewById(R.id.sEt5);
    s_Et6=view.findViewById(R.id.sEt6);
    s_Et7=view.findViewById(R.id.sEt7);
    s_Et8=view.findViewById(R.id.sEt8);
    s_Et9=view.findViewById(R.id.sEt9);
    s_Et10=view.findViewById(R.id.sEt10);
    s_Et11=view.findViewById(R.id.sEt11);
    s_Et12=view.findViewById(R.id.sEt12);
    s_Et13=view.findViewById(R.id.sEt13);
    s_Et14=view.findViewById(R.id.sEt14);
    s_Et15=view.findViewById(R.id.sEt15);


    auto1=view.findViewById(R.id.auto_1);
    auto2=view.findViewById(R.id.auto_2);
    auto3=view.findViewById(R.id.auto_3);
    auto4=view.findViewById(R.id.auto_4);
    auto5=view.findViewById(R.id.auto_5);
    auto6=view.findViewById(R.id.auto_6);
    auto7=view.findViewById(R.id.auto_7);
    auto8=view.findViewById(R.id.auto_8);
    auto9=view.findViewById(R.id.auto_9);
    auto10=view.findViewById(R.id.auto_10);
    auto11=view.findViewById(R.id.auto_11);
    auto12=view.findViewById(R.id.auto_12);
    auto13=view.findViewById(R.id.auto_13);
    auto14=view.findViewById(R.id.auto_14);
    auto15=view.findViewById(R.id.auto_15);

    addMore=view.findViewById(R.id.add_count);

    calculate_view=view.findViewById(R.id.calculate);
    reset_view=view.findViewById(R.id.reset);


    calculate_view.setOnClickListener(new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {

            keyBoard();
            sgpa_calculation();

        }
    });


    reset_view.setOnClickListener(new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {

        reset_All();

        }
    });


}

   private void get_All_Entries(){


     a3= s_Row3.getVisibility();
     a4= s_Row4.getVisibility();
     a5= s_Row5.getVisibility();
     a6= s_Row6.getVisibility();
     a7= s_Row7.getVisibility();
     a8= s_Row8.getVisibility();
     a9= s_Row9.getVisibility();
     a10= s_Row10.getVisibility();
     a11= s_Row11.getVisibility();
     a12= s_Row12.getVisibility();
     a13= s_Row13.getVisibility();
     a14= s_Row14.getVisibility();
     a15= s_Row15.getVisibility();

    pass1=s_Et1.getText().toString().equals("");
    pass2=s_Et2.getText().toString().equals("");
    pass3=s_Et3.getText().toString().equals("");
    pass4=s_Et4.getText().toString().equals("");
    pass5=s_Et5.getText().toString().equals("");
    pass6=s_Et6.getText().toString().equals("");
    pass7=s_Et7.getText().toString().equals("");
    pass8=s_Et8.getText().toString().equals("");
    pass9=s_Et9.getText().toString().equals("");
    pass10=s_Et10.getText().toString().equals("");
    pass11=s_Et11.getText().toString().equals("");
    pass12=s_Et12.getText().toString().equals("");
    pass13=s_Et13.getText().toString().equals("");
    pass14=s_Et14.getText().toString().equals("");
    pass15=s_Et15.getText().toString().equals("");


       isEmpty1=auto1.getText().toString().equals("");
       isEmpty2=auto2.getText().toString().equals("");
       isEmpty3=auto3.getText().toString().equals("");
       isEmpty4=auto4.getText().toString().equals("");
       isEmpty5=auto5.getText().toString().equals("");
       isEmpty6=auto6.getText().toString().equals("");
       isEmpty7=auto7.getText().toString().equals("");
       isEmpty8=auto8.getText().toString().equals("");
       isEmpty9=auto9.getText().toString().equals("");
       isEmpty10=auto10.getText().toString().equals("");
       isEmpty11=auto11.getText().toString().equals("");
       isEmpty12=auto12.getText().toString().equals("");
       isEmpty13=auto13.getText().toString().equals("");
       isEmpty14=auto14.getText().toString().equals("");
       isEmpty15=auto15.getText().toString().equals("");

try{

    gpa1=Float.parseFloat(auto1.getText().toString());
    gpa2=Float.parseFloat(auto2.getText().toString());
    gpa3=Float.parseFloat(auto3.getText().toString());
    gpa4=Float.parseFloat(auto4.getText().toString());
    gpa5=Float.parseFloat(auto5.getText().toString());
    gpa6=Float.parseFloat(auto6.getText().toString());
    gpa7=Float.parseFloat(auto7.getText().toString());
    gpa8=Float.parseFloat(auto8.getText().toString());
    gpa9=Float.parseFloat(auto9.getText().toString());
    gpa10=Float.parseFloat(auto10.getText().toString());
    gpa11=Float.parseFloat(auto11.getText().toString());
    gpa12=Float.parseFloat(auto12.getText().toString());
    gpa13=Float.parseFloat(auto13.getText().toString());
    gpa14=Float.parseFloat(auto14.getText().toString());
    gpa15=Float.parseFloat(auto15.getText().toString());


}catch (Exception e){

}

    try{
        credit1=Float.parseFloat(s_Et1.getText().toString());
        credit2=Float.parseFloat(s_Et2.getText().toString());
        credit3=Float.parseFloat(s_Et3.getText().toString());
        credit4=Float.parseFloat(s_Et4.getText().toString());
        credit5=Float.parseFloat(s_Et5.getText().toString());
        credit6=Float.parseFloat(s_Et6.getText().toString());
        credit7=Float.parseFloat(s_Et7.getText().toString());
        credit8=Float.parseFloat(s_Et8.getText().toString());
        credit9=Float.parseFloat(s_Et9.getText().toString());
        credit10=Float.parseFloat(s_Et10.getText().toString());
        credit11=Float.parseFloat(s_Et11.getText().toString());
        credit12=Float.parseFloat(s_Et12.getText().toString());
        credit13=Float.parseFloat(s_Et13.getText().toString());
        credit14=Float.parseFloat(s_Et14.getText().toString());
        credit15=Float.parseFloat(s_Et15.getText().toString());

    }catch (Exception e){

    }

}

private void sgpa_calculation(){


        get_All_Entries();

        if(a3==8) {


            if (pass1|| pass2 || isEmpty1 || isEmpty2) {


                    if (pass1) {

                        s_Et1.setError("Credit Required");


                    }

                    if (pass2) {

                        s_Et2.setError("Credit Required");

                    }
                    if (isEmpty1) {

                        auto1.setError("Grade Required");
                    }
                    if (isEmpty2) {

                        auto2.setError("Grade Required");
                    }


                } else {


                    float totalCredit = credit1 + credit2;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;

                    float totalPoint = point1 + point2;
                    float totalSgpa = totalPoint / totalCredit;


                    String lastTotalSGPA = String.format("%.2f", totalSgpa);
                    String lastTotalCredit = String.format("%.2f", totalCredit);


                    showResult("2", lastTotalCredit, lastTotalSGPA);
                }


            }


    else if(a3==0 && a4==8) {









        if (pass1|| pass2 || pass3 || isEmpty1 || isEmpty2|| isEmpty3) {


            if (pass1) {

                s_Et1.setError("Credit Required");

            }

            if (pass2) {

                s_Et2.setError("Credit Required");

            }
            if (pass3) {

                s_Et3.setError("Credit Required");

            }
            if (isEmpty1) {

                auto1.setError("Grade Required");
            }
            if (isEmpty2) {

                auto2.setError("Grade Required");
            }

            if (isEmpty3) {

                auto3.setError("Grade Required");
            }


            // }
        } else {


            float totalCredit = credit1 + credit2 + credit3;

            point1 = gpa1 * credit1;
            point2 = gpa2 * credit2;
            point3 = gpa3 * credit3;

            float totalPoint = point1 + point2 + point3;
            float totalSgpa = totalPoint / totalCredit;


            String lastTotalSGPA = String.format("%.2f", totalSgpa);
            String lastTotalCredit = String.format("%.2f", totalCredit);


            showResult("3", lastTotalCredit, lastTotalSGPA);
        }


    }

        else if(a4==0 && a5==8) {

            if (pass1|| pass2 || pass3 || pass4 || isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }


            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;

                float totalPoint = point1 + point2 + point3 + point4;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("4", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a5==0 && a6==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }

            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;

                float totalPoint = point1 + point2 + point3 + point4 + point5;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("5", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a6==0 && a7==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }

            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;

                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("6", lastTotalCredit, lastTotalSGPA);
            }


        }
        else if(a7==0 && a8==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }

            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6+ credit7;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;

                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7;
                float totalSgpa = totalPoint / totalCredit;

                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("7", lastTotalCredit, lastTotalSGPA);
            }


        }
        else if(a8==0 && a9==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }

            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6+ credit7 + credit8;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;

                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("8", lastTotalCredit, lastTotalSGPA);
            }

        }

        else if(a9==0 && a10==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6+ credit7 + credit8 + credit9;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;


                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("9", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a10==0 && a11==8) {


            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6+ credit7 + credit8 + credit9+credit10;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;


                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("10", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a11==0 && a12==8) {


            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 || pass11 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10 || isEmpty11) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (pass11) {

                    s_Et11.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                if (isEmpty11) {

                    auto11.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6+ credit7 + credit8 + credit9+credit10+credit11;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;
                point11 = gpa11 * credit11;


                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10+point11;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("11", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a12==0 && a13==8) {


            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 || pass11 || pass12 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10 || isEmpty11 || isEmpty12) {


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (pass11) {

                    s_Et11.setError("Credit Required");

                }
                if (pass12) {

                    s_Et12.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                if (isEmpty11) {

                    auto11.setError("Grade Required");
                }
                if (isEmpty12) {

                    auto12.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 +
                        credit6+ credit7 + credit8 + credit9+credit10+credit11+credit12;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;
                point11 = gpa11 * credit11;
                point12 = gpa12 * credit12;


                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10+point11+point12;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("12", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a13==0 && a14==8) {


            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 || pass11 || pass12 ||pass13 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10 || isEmpty11 || isEmpty12 || isEmpty13){


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (pass11) {

                    s_Et11.setError("Credit Required");

                }
                if (pass12) {

                    s_Et12.setError("Credit Required");

                }
                if (pass13) {

                    s_Et13.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                if (isEmpty11) {

                    auto11.setError("Grade Required");
                }
                if (isEmpty12) {

                    auto12.setError("Grade Required");
                }
                if (isEmpty13) {

                    auto13.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 +
                        credit6+ credit7 + credit8 + credit9+credit10+credit11+credit12+credit13;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;
                point11 = gpa11 * credit11;
                point12 = gpa12 * credit12;
                point13 = gpa13 * credit13;


                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10+point11+point12+point13;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("13", lastTotalCredit, lastTotalSGPA);
            }


        }

        else if(a14==0 && a15==8) {

            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 || pass11 || pass12 ||pass13 ||pass14 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10 || isEmpty11 || isEmpty12 || isEmpty13 || isEmpty14){


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (pass11) {

                    s_Et11.setError("Credit Required");

                }
                if (pass12) {

                    s_Et12.setError("Credit Required");

                }
                if (pass13) {

                    s_Et13.setError("Credit Required");

                }
                if (pass14) {

                    s_Et14.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                if (isEmpty11) {

                    auto11.setError("Grade Required");
                }
                if (isEmpty12) {

                    auto12.setError("Grade Required");
                }
                if (isEmpty13) {

                    auto13.setError("Grade Required");
                }
                if (isEmpty14) {

                    auto14.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 +
                        credit6+ credit7 + credit8 + credit9+credit10+credit11+credit12+credit13+credit14;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;
                point11 = gpa11 * credit11;
                point12 = gpa12 * credit12;
                point13 = gpa13 * credit13;
                point14 = gpa14 * credit14;

                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10+point11+point12+point13+point14;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("14", lastTotalCredit, lastTotalSGPA);
            }


        }

        else {


            if (pass1|| pass2 || pass3 || pass4 || pass5 || pass6 || pass7 || pass8 || pass9 || pass10 || pass11 || pass12 ||pass13 ||pass14 || pass15 ||
                    isEmpty1 || isEmpty2|| isEmpty3 || isEmpty4 || isEmpty5 || isEmpty6 || isEmpty7 || isEmpty8 || isEmpty9 || isEmpty10 || isEmpty11 || isEmpty12 || isEmpty13 || isEmpty14 || isEmpty15){


                if (pass1) {

                    s_Et1.setError("Credit Required");

                }

                if (pass2) {

                    s_Et2.setError("Credit Required");

                }
                if (pass3) {

                    s_Et3.setError("Credit Required");

                }
                if (pass4) {

                    s_Et4.setError("Credit Required");

                }
                if (pass5) {

                    s_Et5.setError("Credit Required");

                }
                if (pass6) {

                    s_Et6.setError("Credit Required");

                }
                if (pass7) {

                    s_Et7.setError("Credit Required");

                }
                if (pass8) {

                    s_Et8.setError("Credit Required");

                }
                if (pass9) {

                    s_Et9.setError("Credit Required");

                }
                if (pass10) {

                    s_Et10.setError("Credit Required");

                }
                if (pass11) {

                    s_Et11.setError("Credit Required");

                }
                if (pass12) {

                    s_Et12.setError("Credit Required");

                }
                if (pass13) {

                    s_Et13.setError("Credit Required");

                }
                if (pass14) {

                    s_Et14.setError("Credit Required");

                }
                if (pass15) {

                    s_Et15.setError("Credit Required");

                }
                if (isEmpty1) {

                    auto1.setError("Grade Required");
                }
                if (isEmpty2) {

                    auto2.setError("Grade Required");
                }

                if (isEmpty3) {

                    auto3.setError("Grade Required");
                }

                if (isEmpty4) {

                    auto4.setError("Grade Required");
                }
                if (isEmpty5) {

                    auto5.setError("Grade Required");
                }
                if (isEmpty6) {

                    auto6.setError("Grade Required");
                }
                if (isEmpty7) {

                    auto7.setError("Grade Required");
                }
                if (isEmpty8) {

                    auto8.setError("Grade Required");
                }
                if (isEmpty9) {

                    auto9.setError("Grade Required");
                }
                if (isEmpty10) {

                    auto10.setError("Grade Required");
                }
                if (isEmpty11) {

                    auto11.setError("Grade Required");
                }
                if (isEmpty12) {

                    auto12.setError("Grade Required");
                }
                if (isEmpty13) {

                    auto13.setError("Grade Required");
                }
                if (isEmpty14) {

                    auto14.setError("Grade Required");
                }
                if (isEmpty15) {

                    auto15.setError("Grade Required");
                }
                // }
            } else {


                float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 +
                        credit6+ credit7 + credit8 + credit9+credit10+credit11+credit12+credit13+credit14+credit15;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;
                point4 = gpa4 * credit4;
                point5 = gpa5 * credit5;
                point6 = gpa6 * credit6;
                point7 = gpa7 * credit7;
                point8 = gpa8 * credit8;
                point9 = gpa9 * credit9;
                point10 = gpa10 * credit10;
                point11 = gpa11 * credit11;
                point12 = gpa12 * credit12;
                point13 = gpa13 * credit13;
                point14 = gpa14 * credit14;
                point15 = gpa15 * credit15;

                float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 +point7+point8+point9+point10+point11+point12+point13+point14+point15;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("15", lastTotalCredit, lastTotalSGPA);
            }


        }

  /*      else if(s_Row3.getVisibility()==View.VISIBLE && s_Row4.getVisibility()==View.GONE ){
            boolean a=s_Et1.getText().toString().equals("");

            if(s_Et1.getText().toString().equals("") || s_Et2.getText().toString().equals("") ||

                    isEmpty1 || isEmpty2 || s_Et3.getText().toString().equals("") || isEmpty3){

                if (s_Et3.getText().toString().equals("")) {

                    s_Et3.setError("Credit Required");

                }
                if (isEmpty3) {

                    Toast.makeText(getContext(), "Select Grade for Course 3", Toast.LENGTH_SHORT).show();
                }




            }else {

                credit1=Float.parseFloat(s_Et1.getText().toString());
                credit2=Float.parseFloat(s_Et2.getText().toString());
                credit3=Float.parseFloat(s_Et3.getText().toString());


                float totalCredit = credit1 + credit2 + credit3;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;
                point3 = gpa3 * credit3;

                float totalPoint = point1 + point2 + point3;
                float totalSgpa = totalPoint / totalCredit;


                String lastTotalSGPA = String.format("%.2f", totalSgpa);
                String lastTotalCredit = String.format("%.2f", totalCredit);


                showResult("2", lastTotalCredit, lastTotalSGPA);



            }














        }*/





/*
        if(s_Et1.getText().toString().equals("")){

            s_Et1.setError("Credit Required");

        }
        else
            {

                credit1=Float.parseFloat(s_Et1.getText().toString());

            }


    if(s_Et2.getText().toString().equals("")){

        s_Et2.setError("Credit Required");

    }
    else
    {

        credit2=Float.parseFloat(s_Et2.getText().toString());

    }


    if(s_Row3.getVisibility()==View.VISIBLE){

        if(s_Et3.getText().toString().equals("")){

            s_Et3.setError("Required");

        }

        else {

            credit3 = Float.parseFloat(s_Et3.getText().toString());

        }



    }
    else {




    }













    if(s_Et1.getText().toString().equals("") || s_Et2.getText().toString().equals("") ||

            isEmpty1 || isEmpty2){

        if(s_Et1.getText().toString().equals("")||s_Et2.getText().toString().equals("")||isEmpty1||isEmpty2) {

           pass2=false;pass3=false;
            if (s_Et1.getText().toString().equals("")) {

                s_Et1.setError("Credit Required");

            }

            if (s_Et2.getText().toString().equals("")) {

                s_Et2.setError("Credit Required");

            }
            if (isEmpty1) {

                Toast.makeText(getContext(), "Select Grade for Course 1", Toast.LENGTH_SHORT).show();
            }
            if (isEmpty2) {

                Toast.makeText(getContext(), "Select Grade for Course 2", Toast.LENGTH_SHORT).show();
            }


            // }
        }

    else
    {


 pass2=true;




        /*   float totalCredit = credit1 + credit2;

            point1 = gpa1 * credit1;
            point2 = gpa2 * credit2;

            float totalPoint = point1 + point2;
            float totalSgpa = totalPoint / totalCredit;


            String lastTotalSGPA = String.format("%.2f", totalSgpa);
            String lastTotalCredit = String.format("%.2f", totalCredit);


            showResult("2", lastTotalCredit, lastTotalSGPA);
                    }






    if(s_Row3.getVisibility()==View.VISIBLE){



if(s_Et3.getText().toString().equals("") || isEmpty3 ) {


    pass3=false;
    if (s_Et3.getText().toString().equals("")) {

        s_Et3.setError("Credit Required");
    }
    if (isEmpty3) {

        Toast.makeText(getContext(), "Select Grade for Course 3", Toast.LENGTH_SHORT).show();
    }

}
        else {
           // credit3 = Float.parseFloat(s_Et3.getText().toString());
if(pass2){
    pass3=true;
}



        }




    }else {

        if (pass2) {

            credit1 = Float.parseFloat(s_Et1.getText().toString());
            credit2 = Float.parseFloat(s_Et2.getText().toString());

            float totalCredit = credit1 + credit2;

            point1 = gpa1 * credit1;
            point2 = gpa2 * credit2;

            float totalPoint = point1 + point2;
            float totalSgpa = totalPoint / totalCredit;


            String lastTotalSGPA = String.format("%.2f", totalSgpa);
            String lastTotalCredit = String.format("%.2f", totalCredit);


            showResult("2", lastTotalCredit, lastTotalSGPA);

        }

    }




    if(s_Row4.getVisibility()==View.VISIBLE){


        if(s_Et4.getText().toString().equals("") || isEmpty4 ) {

            pass4=false;

            if (s_Et4.getText().toString().equals("")) {

                s_Et4.setError("Credit Required");
            }
            if (isEmpty4) {

                Toast.makeText(getContext(), "Select Grade for Course 4", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            // credit3 = Float.parseFloat(s_Et3.getText().toString());

            pass4=true;


        }




    }else {

        if (pass3) {

            credit1 = Float.parseFloat(s_Et1.getText().toString());
            credit2 = Float.parseFloat(s_Et2.getText().toString());
            credit3 = Float.parseFloat(s_Et3.getText().toString());

            float totalCredit = credit1 + credit2 + credit3;

            point1 = gpa1 * credit1;
            point2 = gpa2 * credit2;
            point3 = gpa3 * credit3;

            float totalPoint = point1 + point2 + point3;
            float totalSgpa = totalPoint / totalCredit;


            String lastTotalSGPA = String.format("%.2f", totalSgpa);
            String lastTotalCredit = String.format("%.2f", totalCredit);


            showResult("3", lastTotalCredit, lastTotalSGPA);

        }

    }


*/













}



    private void reset_All(){


        s_Row3.setVisibility(View.GONE);s_Row4.setVisibility(View.GONE);s_Row5.setVisibility(View.GONE);s_Row6.setVisibility(View.GONE);
        s_Row7.setVisibility(View.GONE);s_Row8.setVisibility(View.GONE);s_Row9.setVisibility(View.GONE);s_Row10.setVisibility(View.GONE);
        s_Row11.setVisibility(View.GONE);s_Row12.setVisibility(View.GONE);s_Row13.setVisibility(View.GONE);s_Row14.setVisibility(View.GONE);
        s_Row15.setVisibility(View.GONE);

        s_Et1.setText("");s_Et2.setText("");s_Et3.setText("");s_Et4.setText("");s_Et5.setText("");s_Et6.setText("");
        s_Et7.setText("");s_Et8.setText("");s_Et9.setText("");s_Et10.setText("");s_Et11.setText("");s_Et12.setText("");
        s_Et13.setText("");s_Et14.setText("");s_Et15.setText("");

       auto1.setText("");auto2.setText("");auto3.setText("");auto4.setText("");auto5.setText("");
        auto6.setText("");auto7.setText("");auto8.setText("");auto9.setText("");auto10.setText("");
        auto11.setText("");auto12.setText("");auto13.setText("");auto14.setText("");auto15.setText("");


        isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
        isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        s_Et1.setError(null);s_Et2.setError(null);s_Et3.setError(null);s_Et4.setError(null);s_Et5.setError(null);
        s_Et6.setError(null);s_Et7.setError(null);s_Et8.setError(null);s_Et9.setError(null);s_Et10.setError(null);
        s_Et11.setError(null);s_Et12.setError(null);s_Et13.setError(null);s_Et14.setError(null);s_Et15.setError(null);

        auto1.setError(null); auto2.setError(null); auto3.setError(null); auto4.setError(null); auto5.setError(null);
        auto6.setError(null); auto7.setError(null); auto8.setError(null); auto9.setError(null); auto10.setError(null);
        auto11.setError(null); auto12.setError(null); auto13.setError(null); auto14.setError(null); auto15.setError(null);


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

          spinner_visibility(position);

       // count  = parent.getItemAtPosition(position).toString() ;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void spinner_visibility(int position){


        if(position == 1){

          if(s_Row3.getVisibility() == View.VISIBLE){



              s_Row3.setVisibility(View.GONE);
              s_Row4.setVisibility(View.GONE);
              s_Row5.setVisibility(View.GONE);
              s_Row6.setVisibility(View.GONE);
              s_Row7.setVisibility(View.GONE);
              s_Row8.setVisibility(View.GONE);
              s_Row9.setVisibility(View.GONE);
              s_Row10.setVisibility(View.GONE);
              s_Row11.setVisibility(View.GONE);
              s_Row12.setVisibility(View.GONE);
              s_Row13.setVisibility(View.GONE);
              s_Row14.setVisibility(View.GONE);
              s_Row15.setVisibility(View.GONE);

              addMore.setSelection(0);


          }

          else {

              Toast.makeText(this.getActivity(),"Course 2 already exists!",Toast.LENGTH_SHORT).show();
              addMore.setSelection(0);
          }


            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        }


        if (position == 2) {


         if(!isOpened2) {


             s_Row3.setVisibility(View.VISIBLE);
             s_Row4.setVisibility(View.GONE);
             s_Row5.setVisibility(View.GONE);
             s_Row6.setVisibility(View.GONE);
             s_Row7.setVisibility(View.GONE);
             s_Row8.setVisibility(View.GONE);
             s_Row9.setVisibility(View.GONE);
             s_Row10.setVisibility(View.GONE);
             s_Row11.setVisibility(View.GONE);
             s_Row12.setVisibility(View.GONE);
             s_Row13.setVisibility(View.GONE);
             s_Row14.setVisibility(View.GONE);
             s_Row15.setVisibility(View.GONE);

             addMore.setSelection(0);
         }


          else {

                 Toast.makeText(this.getActivity(),"Course 3 already exists!",Toast.LENGTH_SHORT).show();
                 addMore.setSelection(0);
             }



            isOpened2=true;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;



        } if (position == 3) {

      if(!isOpened3) {

          s_Row3.setVisibility(View.VISIBLE);
          s_Row4.setVisibility(View.VISIBLE);
          s_Row5.setVisibility(View.GONE);
          s_Row6.setVisibility(View.GONE);
          s_Row7.setVisibility(View.GONE);
          s_Row8.setVisibility(View.GONE);
          s_Row9.setVisibility(View.GONE);
          s_Row10.setVisibility(View.GONE);
          s_Row11.setVisibility(View.GONE);
          s_Row12.setVisibility(View.GONE);
          s_Row13.setVisibility(View.GONE);
          s_Row14.setVisibility(View.GONE);
          s_Row15.setVisibility(View.GONE);

          addMore.setSelection(0);

      }  else {

          Toast.makeText(this.getActivity(),"Course 4 already exists!",Toast.LENGTH_SHORT).show();
          addMore.setSelection(0);
      }

            isOpened2=false;isOpened3=true;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        }



        if (position == 4) {


        if(!isOpened4){

                s_Row3.setVisibility(View.VISIBLE);
                s_Row4.setVisibility(View.VISIBLE);
                s_Row5.setVisibility(View.VISIBLE);
                s_Row6.setVisibility(View.GONE);
                s_Row7.setVisibility(View.GONE);
                s_Row8.setVisibility(View.GONE);
                s_Row9.setVisibility(View.GONE);
                s_Row10.setVisibility(View.GONE);
                s_Row11.setVisibility(View.GONE);
                s_Row12.setVisibility(View.GONE);
                s_Row13.setVisibility(View.GONE);
                s_Row14.setVisibility(View.GONE);
                s_Row15.setVisibility(View.GONE);

                addMore.setSelection(0);

}  else {

    Toast.makeText(this.getActivity(),"Course 5 already exists!",Toast.LENGTH_SHORT).show();
    addMore.setSelection(0);
}

            isOpened2=false;isOpened3=false;isOpened4=true;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;
        }

        if (position == 5) {

if(!isOpened5){

                s_Row3.setVisibility(View.VISIBLE);
                s_Row4.setVisibility(View.VISIBLE);
                s_Row5.setVisibility(View.VISIBLE);
                s_Row6.setVisibility(View.VISIBLE);
                s_Row7.setVisibility(View.GONE);
                s_Row8.setVisibility(View.GONE);
                s_Row9.setVisibility(View.GONE);
                s_Row10.setVisibility(View.GONE);
                s_Row11.setVisibility(View.GONE);
                s_Row12.setVisibility(View.GONE);
                s_Row13.setVisibility(View.GONE);
                s_Row14.setVisibility(View.GONE);
                s_Row15.setVisibility(View.GONE);

                addMore.setSelection(0);
}  else {

    Toast.makeText(this.getActivity(),"Course 6 already exists!",Toast.LENGTH_SHORT).show();
    addMore.setSelection(0);
}

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=true;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;
        }

        if (position == 6) {

if(!isOpened6){
            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.GONE);
            s_Row9.setVisibility(View.GONE);
            s_Row10.setVisibility(View.GONE);
            s_Row11.setVisibility(View.GONE);
            s_Row12.setVisibility(View.GONE);
            s_Row13.setVisibility(View.GONE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);
}  else {

    Toast.makeText(this.getActivity(),"Course 7 already exists!",Toast.LENGTH_SHORT).show();
    addMore.setSelection(0);
}
            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=true;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        }

        if (position == 7) {
            if(!isOpened7) {

                s_Row3.setVisibility(View.VISIBLE);
                s_Row4.setVisibility(View.VISIBLE);
                s_Row5.setVisibility(View.VISIBLE);
                s_Row6.setVisibility(View.VISIBLE);
                s_Row7.setVisibility(View.VISIBLE);
                s_Row8.setVisibility(View.VISIBLE);
                s_Row9.setVisibility(View.GONE);
                s_Row10.setVisibility(View.GONE);
                s_Row11.setVisibility(View.GONE);
                s_Row12.setVisibility(View.GONE);
                s_Row13.setVisibility(View.GONE);
                s_Row14.setVisibility(View.GONE);
                s_Row15.setVisibility(View.GONE);

                addMore.setSelection(0);
            }  else {

                Toast.makeText(this.getActivity(),"Course 8 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=true;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;


        }

        if (position == 8) {

            if(!isOpened8){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.GONE);
            s_Row11.setVisibility(View.GONE);
            s_Row12.setVisibility(View.GONE);
            s_Row13.setVisibility(View.GONE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);


            addMore.setSelection(0);
            }  else {

                Toast.makeText(this.getActivity(),"Course 9 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=true;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;
        }


        if (position == 9) {
            if(!isOpened9){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.GONE);
            s_Row12.setVisibility(View.GONE);
            s_Row13.setVisibility(View.GONE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);
            }  else {

                Toast.makeText(this.getActivity(),"Course 10 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=true;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        }


        if (position == 10) {
            if(!isOpened10){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.VISIBLE);
            s_Row12.setVisibility(View.GONE);
            s_Row13.setVisibility(View.GONE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);
            }  else {

                Toast.makeText(this.getActivity(),"Course 11 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=true;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;


        }

        if (position == 11) {

            if(!isOpened11){


            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.VISIBLE);
            s_Row12.setVisibility(View.VISIBLE);
            s_Row13.setVisibility(View.GONE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);

            }  else {

                Toast.makeText(this.getActivity(),"Course 12 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=true;isOpened12=false;isOpened13=false;isOpened14=false;
        }

        if (position == 12) {

            if(!isOpened12){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.VISIBLE);
            s_Row12.setVisibility(View.VISIBLE);
            s_Row13.setVisibility(View.VISIBLE);
            s_Row14.setVisibility(View.GONE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);

            }  else {

                Toast.makeText(this.getActivity(),"Course 13 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=true;isOpened13=false;isOpened14=false;


        }

        if (position == 13) {

            if(!isOpened13){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.VISIBLE);
            s_Row12.setVisibility(View.VISIBLE);
            s_Row13.setVisibility(View.VISIBLE);
            s_Row14.setVisibility(View.VISIBLE);
            s_Row15.setVisibility(View.GONE);

            addMore.setSelection(0);

            }  else {

                Toast.makeText(this.getActivity(),"Course 14 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }

            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=true;isOpened14=false;

        }

        if (position == 14) {

            if(!isOpened14){

            s_Row3.setVisibility(View.VISIBLE);
            s_Row4.setVisibility(View.VISIBLE);
            s_Row5.setVisibility(View.VISIBLE);
            s_Row6.setVisibility(View.VISIBLE);
            s_Row7.setVisibility(View.VISIBLE);
            s_Row8.setVisibility(View.VISIBLE);
            s_Row9.setVisibility(View.VISIBLE);
            s_Row10.setVisibility(View.VISIBLE);
            s_Row11.setVisibility(View.VISIBLE);
            s_Row12.setVisibility(View.VISIBLE);
            s_Row13.setVisibility(View.VISIBLE);
            s_Row14.setVisibility(View.VISIBLE);
            s_Row15.setVisibility(View.VISIBLE);


            addMore.setSelection(0);

            }  else {

                Toast.makeText(this.getActivity(),"Course 15 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }
            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=true;

        }



    }

    private void showResult(String courseTotal,String creditTotal,String sgpa){

        LayoutInflater layoutInflater =LayoutInflater.from(getContext());

        final View view = layoutInflater.inflate(R.layout.sgpa_row, null);

        final TextView course =  view.findViewById(R.id.course);
        final TextView sGPA = view.findViewById(R.id.sgpa);
        final TextView credit= view.findViewById(R.id.credit);

        course.setText(courseTotal);
        sGPA.setText(sgpa);
        credit.setText(creditTotal);

        new MaterialAlertDialogBuilder(getContext(),R.style.AlertDialogTheme)
               // .setTitle("Title")
                //.setMessage("Your message goes here. Keep it short but clear.")
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                 .setCancelable(true)
                .setView(view)
                .show();


    }


    private void keyBoard() {


        try {
            view1 = getActivity().getCurrentFocus();
        }catch (Exception e){ }

        if(view1 != null){


                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
                }catch (Exception e){ }
        }
    }

}
