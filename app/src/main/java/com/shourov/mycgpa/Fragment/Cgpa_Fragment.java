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
public class Cgpa_Fragment extends Fragment implements AdapterView.OnItemSelectedListener  {

    private Spinner addMore;
    private View view;
    private View view1;
    private LinearLayout c_Row3,c_Row4,c_Row5,c_Row6,c_Row7,c_Row8,c_Row9,c_Row10,c_Row11,c_Row12,c_Row13,c_Row14,c_Row15,calculate_view,reset_view;

    private EditText c_Et1,c_Et2,c_Et3,c_Et4,c_Et5,c_Et6,c_Et7,c_Et8,c_Et9,c_Et10,c_Et11,c_Et12,c_Et13,c_Et14,c_Et15;

    private EditText cc_Et1,cc_Et2,cc_Et3,cc_Et4,cc_Et5,cc_Et6,cc_Et7,cc_Et8,cc_Et9,cc_Et10,cc_Et11,cc_Et12,cc_Et13,cc_Et14,cc_Et15;

    private boolean isOpened2,isOpened3,isOpened4,isOpened5,isOpened6,isOpened7,isOpened8,isOpened9
            ,isOpened10,isOpened11,isOpened12,isOpened13,isOpened14;

    private int a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;


    private boolean pass1,pass2,pass3,pass4,pass5,pass6,pass7,pass8
            ,pass9,pass10,pass11,pass12,pass13,pass14,pass15;

    private boolean cpass1,cpass2,cpass3,cpass4,cpass5,cpass6,cpass7,cpass8
            ,cpass9,cpass10,cpass11,cpass12,cpass13,cpass14,cpass15;

    private float credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10,
            credit11, credit12, credit13, credit14, credit15;


    private float sg1,sg2,sg3,sg4,sg5,sg6,sg7,sg8,sg9,sg10,sg11,sg12,sg13,sg14,sg15;


    public Cgpa_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cgpa_, container, false);
       init();
        addMore.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
       /* ArrayAdapter<String> dataAdapter = new ArrayAdapter.<String>(this.getActivity(), android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.count) );
        dataAdapter.setDropDownViewResource(R.layout.my_spinner_item);
        addMore.setAdapter(dataAdapter);  */


        ArrayAdapter adapter =  ArrayAdapter.createFromResource(this.getActivity(),R.array.count1,  R.layout.spinner);

        adapter.setDropDownViewResource(R.layout.my_spinner_item);
        addMore.setAdapter(adapter);

        return  view;
    }

  private void init(){




        c_Row3=view.findViewById(R.id.sRow3);
        c_Row4=view.findViewById(R.id.sRow4);
        c_Row5=view.findViewById(R.id.sRow5);
        c_Row6=view.findViewById(R.id.sRow6);
        c_Row7=view.findViewById(R.id.sRow7);
        c_Row8=view.findViewById(R.id.sRow8);
        c_Row9=view.findViewById(R.id.sRow9);
        c_Row10=view.findViewById(R.id.sRow10);
        c_Row11=view.findViewById(R.id.sRow11);
        c_Row12=view.findViewById(R.id.sRow12);
        c_Row13=view.findViewById(R.id.sRow13);
        c_Row14=view.findViewById(R.id.sRow14);
        c_Row15=view.findViewById(R.id.sRow15);


        c_Et1=view.findViewById(R.id.sgpa_1);
        c_Et2=view.findViewById(R.id.sgpa_2);
        c_Et3=view.findViewById(R.id.sgpa_3);
        c_Et4=view.findViewById(R.id.sgpa_4);
        c_Et5=view.findViewById(R.id.sgpa_5);
        c_Et6=view.findViewById(R.id.sgpa_6);
        c_Et7=view.findViewById(R.id.sgpa_7);
        c_Et8=view.findViewById(R.id.sgpa_8);
        c_Et9=view.findViewById(R.id.sgpa_9);
        c_Et10=view.findViewById(R.id.sgpa_10);
        c_Et11=view.findViewById(R.id.sgpa_11);
        c_Et12=view.findViewById(R.id.sgpa_12);
        c_Et13=view.findViewById(R.id.sgpa_13);
        c_Et14=view.findViewById(R.id.sgpa_14);
        c_Et15=view.findViewById(R.id.sgpa_15);

        cc_Et1=view.findViewById(R.id.cEt1);
        cc_Et2=view.findViewById(R.id.cEt2);
        cc_Et3=view.findViewById(R.id.cEt3);
        cc_Et4=view.findViewById(R.id.cEt4);
        cc_Et5=view.findViewById(R.id.cEt5);
        cc_Et6=view.findViewById(R.id.cEt6);
        cc_Et7=view.findViewById(R.id.cEt7);
        cc_Et8=view.findViewById(R.id.cEt8);
        cc_Et9=view.findViewById(R.id.cEt9);
        cc_Et10=view.findViewById(R.id.cEt10);
        cc_Et11=view.findViewById(R.id.cEt11);
        cc_Et12=view.findViewById(R.id.cEt12);
        cc_Et13=view.findViewById(R.id.cEt13);
        cc_Et14=view.findViewById(R.id.cEt14);
        cc_Et15=view.findViewById(R.id.cEt15);

      addMore=view.findViewById(R.id.add_count1);
      calculate_view=view.findViewById(R.id.calculate1);
      reset_view=view.findViewById(R.id.reset1);

      calculate_view.setOnClickListener(new View.OnClickListener() {

          @RequiresApi(api = Build.VERSION_CODES.N)
          @Override
          public void onClick(View v) {

              keyBoard();
              cgpa_calculation();

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

    private void reset_All(){


        c_Row3.setVisibility(View.GONE);c_Row4.setVisibility(View.GONE);c_Row5.setVisibility(View.GONE);c_Row6.setVisibility(View.GONE);
        c_Row7.setVisibility(View.GONE);c_Row8.setVisibility(View.GONE);c_Row9.setVisibility(View.GONE);c_Row10.setVisibility(View.GONE);
        c_Row11.setVisibility(View.GONE);c_Row12.setVisibility(View.GONE);c_Row13.setVisibility(View.GONE);c_Row14.setVisibility(View.GONE);
        c_Row15.setVisibility(View.GONE);

        c_Et1.setText("");c_Et2.setText("");c_Et3.setText("");c_Et4.setText("");c_Et5.setText("");c_Et6.setText("");
        c_Et7.setText("");c_Et8.setText("");c_Et9.setText("");c_Et10.setText("");c_Et11.setText("");c_Et12.setText("");
        c_Et13.setText("");c_Et14.setText("");c_Et15.setText("");

        cc_Et1.setText("");cc_Et2.setText("");cc_Et3.setText("");cc_Et4.setText("");cc_Et5.setText("");cc_Et6.setText("");
        cc_Et7.setText("");cc_Et8.setText("");cc_Et9.setText("");cc_Et10.setText("");cc_Et11.setText("");cc_Et12.setText("");
        cc_Et13.setText("");cc_Et14.setText("");cc_Et15.setText("");

        isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
        isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=false;

        c_Et1.setError(null);c_Et2.setError(null);c_Et3.setError(null);c_Et4.setError(null);c_Et5.setError(null);
        c_Et6.setError(null);c_Et7.setError(null);c_Et8.setError(null);c_Et9.setError(null);c_Et10.setError(null);
        c_Et11.setError(null);c_Et12.setError(null);c_Et13.setError(null);c_Et14.setError(null);c_Et15.setError(null);

        cc_Et1.setError(null);cc_Et2.setError(null);cc_Et3.setError(null);cc_Et4.setError(null);cc_Et5.setError(null);
        cc_Et6.setError(null);cc_Et7.setError(null);cc_Et8.setError(null);cc_Et9.setError(null);cc_Et10.setError(null);
        cc_Et11.setError(null);cc_Et12.setError(null);cc_Et13.setError(null);cc_Et14.setError(null);cc_Et15.setError(null);


    }


   private void get_All_Entries(){

       a3= c_Row3.getVisibility();
       a4= c_Row4.getVisibility();
       a5= c_Row5.getVisibility();
       a6= c_Row6.getVisibility();
       a7= c_Row7.getVisibility();
       a8= c_Row8.getVisibility();
       a9= c_Row9.getVisibility();
       a10= c_Row10.getVisibility();
       a11= c_Row11.getVisibility();
       a12= c_Row12.getVisibility();
       a13= c_Row13.getVisibility();
       a14= c_Row14.getVisibility();
       a15= c_Row15.getVisibility();

       pass1=c_Et1.getText().toString().equals("");
       pass2=c_Et2.getText().toString().equals("");
       pass3=c_Et3.getText().toString().equals("");
       pass4=c_Et4.getText().toString().equals("");
       pass5=c_Et5.getText().toString().equals("");
       pass6=c_Et6.getText().toString().equals("");
       pass7=c_Et7.getText().toString().equals("");
       pass8=c_Et8.getText().toString().equals("");
       pass9=c_Et9.getText().toString().equals("");
       pass10=c_Et10.getText().toString().equals("");
       pass11=c_Et11.getText().toString().equals("");
       pass12=c_Et12.getText().toString().equals("");
       pass13=c_Et13.getText().toString().equals("");
       pass14=c_Et14.getText().toString().equals("");
       pass15=c_Et15.getText().toString().equals("");

       cpass1=cc_Et1.getText().toString().equals("");
       cpass2=cc_Et2.getText().toString().equals("");
       cpass3=cc_Et3.getText().toString().equals("");
       cpass4=cc_Et4.getText().toString().equals("");
       cpass5=cc_Et5.getText().toString().equals("");
       cpass6=cc_Et6.getText().toString().equals("");
       cpass7=cc_Et7.getText().toString().equals("");
       cpass8=cc_Et8.getText().toString().equals("");
       cpass9=cc_Et9.getText().toString().equals("");
       cpass10=cc_Et10.getText().toString().equals("");
       cpass11=cc_Et11.getText().toString().equals("");
       cpass12=cc_Et12.getText().toString().equals("");
       cpass13=cc_Et13.getText().toString().equals("");
       cpass14=cc_Et14.getText().toString().equals("");
       cpass15=cc_Et15.getText().toString().equals("");

       try{

           sg1=Float.parseFloat(c_Et1.getText().toString());
           sg2=Float.parseFloat(c_Et2.getText().toString());
           sg3=Float.parseFloat(c_Et3.getText().toString());
           sg4=Float.parseFloat(c_Et4.getText().toString());
           sg5=Float.parseFloat(c_Et5.getText().toString());
           sg6=Float.parseFloat(c_Et6.getText().toString());
           sg7=Float.parseFloat(c_Et7.getText().toString());
           sg8=Float.parseFloat(c_Et8.getText().toString());
           sg9=Float.parseFloat(c_Et9.getText().toString());
           sg10=Float.parseFloat(c_Et10.getText().toString());
           sg11=Float.parseFloat(c_Et11.getText().toString());
           sg12=Float.parseFloat(c_Et12.getText().toString());
           sg13=Float.parseFloat(c_Et13.getText().toString());
           sg14=Float.parseFloat(c_Et14.getText().toString());
           sg15=Float.parseFloat(c_Et15.getText().toString());

       }catch (Exception e){

       }

       try {


           credit1=Float.parseFloat(cc_Et1.getText().toString());
           credit2=Float.parseFloat(cc_Et2.getText().toString());
           credit3=Float.parseFloat(cc_Et3.getText().toString());
           credit4=Float.parseFloat(cc_Et4.getText().toString());
           credit5=Float.parseFloat(cc_Et5.getText().toString());
           credit6=Float.parseFloat(cc_Et6.getText().toString());
           credit7=Float.parseFloat(cc_Et7.getText().toString());
           credit8=Float.parseFloat(cc_Et8.getText().toString());
           credit9=Float.parseFloat(cc_Et9.getText().toString());
           credit10=Float.parseFloat(cc_Et10.getText().toString());
           credit11=Float.parseFloat(cc_Et11.getText().toString());
           credit12=Float.parseFloat(cc_Et12.getText().toString());
           credit13=Float.parseFloat(cc_Et13.getText().toString());
           credit14=Float.parseFloat(cc_Et14.getText().toString());
           credit15=Float.parseFloat(cc_Et15.getText().toString());


       }catch (Exception e){


       }

   }



   private void cgpa_calculation(){


        get_All_Entries();

        if(a3==8){

            if(pass1 || pass2 || cpass1 || cpass2){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }

                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");


                }


            }
            else {


                if (sg1 > 5 || sg2 > 5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;

                    float totalCredit = credit1 + credit2;
                    float totalPoint = Point1 + Point2;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("2",lastTotalCredit,lastTotalCGPA);


                }

            }



}
      else if(a3==0 && a4==8){

           if(pass1 || pass2 || pass3 || cpass1 || cpass2 || cpass3){


               if (cpass1) {

                   cc_Et1.setError("Credit Required");

               }

               if (cpass2) {

                   cc_Et2.setError("Credit Required");

               }
               if (cpass3) {

                   cc_Et3.setError("Credit Required");

               }

               if (pass1) {

                   c_Et1.setError("SGPA Required");

               }

               if (pass2) {

                   c_Et2.setError("SGPA Required");
               }
               if (pass3) {

                   c_Et3.setError("SGPA Required");


               }

           }
           else {


               if (sg1 > 5 || sg2 > 5 || sg3>5) {

                   if (sg1 > 5) {


                       c_Et1.setError("SGPA can't greater than 5");
                   }
                   if (sg2 > 5) {


                       c_Et2.setError("SGPA can't greater than 5");
                   }
                   if (sg3 > 5) {


                       c_Et3.setError("SGPA can't greater than 5");
                   }


               } else {


                   float Point1 = credit1 * sg1;
                   float Point2 = credit2 * sg2;
                   float Point3 = credit3 * sg3;

                   float totalCredit = credit1 + credit2 + credit3;
                   float totalPoint = Point1 + Point2 + Point3;


                   float cgpa = totalPoint / totalCredit;


                   String lastTotalCredit = String.format("%.2f", totalCredit);
                   String lastTotalCGPA = String.format("%.2f", cgpa);


                   showResult("3",lastTotalCredit,lastTotalCGPA);


               }

           }

      }

        else if(a4==0 && a5==8){

            if(pass1 || pass2 || pass3 || pass4 || cpass1 || cpass2 || cpass3 || cpass4){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }

                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;


                    float totalCredit = credit1 + credit2 + credit3 + credit4;
                    float totalPoint = Point1 + Point2 + Point3+ Point4;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("4",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else if(a5==0 && a6==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || cpass1 || cpass2 || cpass3 || cpass4 || cpass5){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }

                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("5",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else if(a6==0 && a7==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6|| cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }

                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("6",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else if(a7==0 && a8==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("7",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else if(a8==0 && a9==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 ||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }


                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("8",lastTotalCredit,lastTotalCGPA);


                }

            }

        }


        else if(a9==0 && a10==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 ||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("9",lastTotalCredit,lastTotalCGPA);


                }

            }

        }


        else if(a10==0 && a11==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("10",lastTotalCredit,lastTotalCGPA);


                }

            }

        }


        else if(a11==0 && a12==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10|| pass11||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10||cpass11){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (cpass11) {

                    cc_Et11.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }
                if (pass11) {

                    c_Et11.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5||sg11>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }
                    if (sg11 > 5) {


                        c_Et11.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;
                    float Point11 = credit11 * sg11;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10+credit11;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10+Point11;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("11",lastTotalCredit,lastTotalCGPA);


                }

            }

        }



        else if(a12==0 && a13==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10|| pass11|| pass12 ||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10||cpass11||cpass12){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (cpass11) {

                    cc_Et11.setError("Credit Required");

                }
                if (cpass12) {

                    cc_Et12.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }
                if (pass11) {

                    c_Et11.setError("SGPA Required");
                }
                if (pass12) {

                    c_Et12.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5||sg11>5||sg12>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }
                    if (sg11 > 5) {


                        c_Et11.setError("SGPA can't greater than 5");
                    }
                    if (sg12 > 5) {


                        c_Et12.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;
                    float Point11 = credit11 * sg11;
                    float Point12 = credit12 * sg12;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10+credit11+credit12;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10+Point11+Point12;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("12",lastTotalCredit,lastTotalCGPA);


                }

            }

        }


        else if(a13==0 && a14==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10|| pass11|| pass12 || pass13||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10||cpass11||cpass12||cpass13){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (cpass11) {

                    cc_Et11.setError("Credit Required");

                }
                if (cpass12) {

                    cc_Et12.setError("Credit Required");

                }
                if (cpass13) {

                    cc_Et13.setError("Credit Required");

                }
                if (pass1) {

                    c_Et1.setError("SGPA Required");

                }


                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }
                if (pass11) {

                    c_Et11.setError("SGPA Required");
                }
                if (pass12) {

                    c_Et12.setError("SGPA Required");
                }
                if (pass13) {

                    c_Et13.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5||sg11>5||sg12>5||sg13>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }
                    if (sg11 > 5) {


                        c_Et11.setError("SGPA can't greater than 5");
                    }
                    if (sg12 > 5) {


                        c_Et12.setError("SGPA can't greater than 5");
                    }
                    if (sg13 > 5) {


                        c_Et13.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;
                    float Point11 = credit11 * sg11;
                    float Point12 = credit12 * sg12;
                    float Point13 = credit13 * sg13;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10+credit11+credit12+credit13;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10+Point11+Point12+Point13;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("13",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else if(a14==0 && a15==8){

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10|| pass11|| pass12 || pass13||pass14||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10||cpass11||cpass12||cpass13||cpass14){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (cpass11) {

                    cc_Et11.setError("Credit Required");

                }
                if (cpass12) {

                    cc_Et12.setError("Credit Required");

                }
                if (cpass13) {

                    cc_Et13.setError("Credit Required");

                }
                if (pass14) {

                    cc_Et14.setError("Credit Required");

                }


                if (pass1) {

                    c_Et1.setError("SGPA Required");
                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }
                if (pass11) {

                    c_Et11.setError("SGPA Required");
                }
                if (pass12) {

                    c_Et12.setError("SGPA Required");
                }
                if (pass13) {

                    c_Et13.setError("SGPA Required");
                }
                if (pass14) {

                    c_Et14.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5||sg11>5||sg12>5||sg13>5||sg14>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }
                    if (sg11 > 5) {


                        c_Et11.setError("SGPA can't greater than 5");
                    }
                    if (sg12 > 5) {


                        c_Et12.setError("SGPA can't greater than 5");
                    }
                    if (sg13 > 5) {


                        c_Et13.setError("SGPA can't greater than 5");
                    }
                    if (sg14 > 5) {


                        c_Et14.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;
                    float Point11 = credit11 * sg11;
                    float Point12 = credit12 * sg12;
                    float Point13 = credit13 * sg13;
                    float Point14 = credit14 * sg14;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10+credit11+credit12+credit13+credit14;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10+Point11+Point12+Point13+Point14;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("14",lastTotalCredit,lastTotalCGPA);


                }

            }

        }

        else{

            if(pass1 || pass2 || pass3 || pass4 || pass5 || pass6||pass7 || pass8 || pass9 || pass10|| pass11|| pass12 || pass13||pass14||pass15||
                    cpass1 || cpass2 || cpass3 || cpass4 || cpass5 || cpass6||cpass7||cpass8||cpass9 || cpass10||cpass11||cpass12||cpass13||cpass14||cpass15){


                if (cpass1) {

                    cc_Et1.setError("Credit Required");

                }

                if (cpass2) {

                    cc_Et2.setError("Credit Required");

                }
                if (cpass3) {

                    cc_Et3.setError("Credit Required");

                }

                if (cpass4) {

                    cc_Et4.setError("Credit Required");

                }
                if (cpass5) {

                    cc_Et5.setError("Credit Required");

                }
                if (cpass6) {

                    cc_Et6.setError("Credit Required");

                }
                if (cpass7) {

                    cc_Et7.setError("Credit Required");

                }

                if (cpass8) {

                    cc_Et8.setError("Credit Required");

                }
                if (cpass9) {

                    cc_Et9.setError("Credit Required");

                }
                if (cpass10) {

                    cc_Et10.setError("Credit Required");

                }
                if (cpass11) {

                    cc_Et11.setError("Credit Required");

                }
                if (cpass12) {

                    cc_Et12.setError("Credit Required");

                }
                if (cpass13) {

                    cc_Et13.setError("Credit Required");

                }
                if (pass14) {

                    cc_Et14.setError("Credit Required");

                }
                if (pass15) {

                    cc_Et15.setError("Credit Required");

                }


                if (pass1) {

                    c_Et1.setError("SGPA Required");
                }

                if (pass2) {

                    c_Et2.setError("SGPA Required");
                }
                if (pass3) {

                    c_Et3.setError("SGPA Required");


                }
                if (pass4) {

                    c_Et4.setError("SGPA Required");
                }
                if (pass5) {

                    c_Et5.setError("SGPA Required");
                }
                if (pass6) {

                    c_Et6.setError("SGPA Required");
                }
                if (pass7) {

                    c_Et7.setError("SGPA Required");
                }

                if (pass8) {

                    c_Et8.setError("SGPA Required");
                }
                if (pass9) {

                    c_Et9.setError("SGPA Required");
                }
                if (pass10) {

                    c_Et10.setError("SGPA Required");
                }
                if (pass11) {

                    c_Et11.setError("SGPA Required");
                }
                if (pass12) {

                    c_Et12.setError("SGPA Required");
                }
                if (pass13) {

                    c_Et13.setError("SGPA Required");
                }
                if (pass14) {

                    c_Et14.setError("SGPA Required");
                }
                if (pass15) {

                    c_Et15.setError("SGPA Required");
                }

            }
            else {


                if (sg1 > 5 || sg2 > 5 || sg3>5 ||sg4>5 || sg5>5 || sg6>5 ||sg7>5||sg8>5 || sg9>5|| sg10>5||sg11>5||sg12>5||sg13>5||sg14>5||sg15>5) {

                    if (sg1 > 5) {


                        c_Et1.setError("SGPA can't greater than 5");
                    }
                    if (sg2 > 5) {


                        c_Et2.setError("SGPA can't greater than 5");
                    }
                    if (sg3 > 5) {


                        c_Et3.setError("SGPA can't greater than 5");
                    }
                    if (sg4 > 5) {


                        c_Et4.setError("SGPA can't greater than 5");
                    }
                    if (sg5 > 5) {


                        c_Et5.setError("SGPA can't greater than 5");
                    }
                    if (sg6 > 5) {


                        c_Et6.setError("SGPA can't greater than 5");
                    }
                    if (sg7 > 5) {


                        c_Et7.setError("SGPA can't greater than 5");
                    }
                    if (sg8 > 5) {


                        c_Et8.setError("SGPA can't greater than 5");
                    }

                    if (sg9 > 5) {


                        c_Et9.setError("SGPA can't greater than 5");
                    }
                    if (sg10 > 5) {


                        c_Et10.setError("SGPA can't greater than 5");
                    }
                    if (sg11 > 5) {


                        c_Et11.setError("SGPA can't greater than 5");
                    }
                    if (sg12 > 5) {


                        c_Et12.setError("SGPA can't greater than 5");
                    }
                    if (sg13 > 5) {


                        c_Et13.setError("SGPA can't greater than 5");
                    }
                    if (sg14 > 5) {


                        c_Et14.setError("SGPA can't greater than 5");
                    }
                    if (sg15 > 5) {


                        c_Et15.setError("SGPA can't greater than 5");
                    }

                } else {


                    float Point1 = credit1 * sg1;
                    float Point2 = credit2 * sg2;
                    float Point3 = credit3 * sg3;
                    float Point4 = credit4 * sg4;
                    float Point5 = credit5 * sg5;
                    float Point6 = credit6 * sg6;
                    float Point7 = credit7 * sg7;
                    float Point8 = credit8 * sg8;
                    float Point9 = credit9 * sg9;
                    float Point10 = credit10 * sg10;
                    float Point11 = credit11 * sg11;
                    float Point12 = credit12 * sg12;
                    float Point13 = credit13 * sg13;
                    float Point14 = credit14 * sg14;
                    float Point15 = credit15 * sg15;


                    float totalCredit = credit1 + credit2 + credit3 + credit4 +credit5+credit6+credit7+credit8+credit9+credit10+credit11+credit12+credit13+credit14+credit15;
                    float totalPoint = Point1 + Point2 + Point3+ Point4+Point5+Point6+Point7+Point8+Point9+Point10+Point11+Point12+Point13+Point14+Point15;


                    float cgpa = totalPoint / totalCredit;


                    String lastTotalCredit = String.format("%.2f", totalCredit);
                    String lastTotalCGPA = String.format("%.2f", cgpa);


                    showResult("15",lastTotalCredit,lastTotalCGPA);


                }

            }

        }


   }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner_visibility(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void spinner_visibility(int position){


        if(position == 1){

            if(c_Row3.getVisibility() == View.VISIBLE){

                c_Row3.setVisibility(View.GONE);
                c_Row4.setVisibility(View.GONE);
                c_Row5.setVisibility(View.GONE);
                c_Row6.setVisibility(View.GONE);
                c_Row7.setVisibility(View.GONE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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


                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.GONE);
                c_Row5.setVisibility(View.GONE);
                c_Row6.setVisibility(View.GONE);
                c_Row7.setVisibility(View.GONE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.GONE);
                c_Row6.setVisibility(View.GONE);
                c_Row7.setVisibility(View.GONE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.GONE);
                c_Row7.setVisibility(View.GONE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);
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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.GONE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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
                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.GONE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.GONE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);


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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.GONE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);


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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.GONE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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
                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.VISIBLE);
                c_Row12.setVisibility(View.GONE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);

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


                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.VISIBLE);
                c_Row12.setVisibility(View.VISIBLE);
                c_Row13.setVisibility(View.GONE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);


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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.VISIBLE);
                c_Row12.setVisibility(View.VISIBLE);
                c_Row13.setVisibility(View.VISIBLE);
                c_Row14.setVisibility(View.GONE);
                c_Row15.setVisibility(View.GONE);
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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.VISIBLE);
                c_Row12.setVisibility(View.VISIBLE);
                c_Row13.setVisibility(View.VISIBLE);
                c_Row14.setVisibility(View.VISIBLE);
                c_Row15.setVisibility(View.GONE);

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

                c_Row3.setVisibility(View.VISIBLE);
                c_Row4.setVisibility(View.VISIBLE);
                c_Row5.setVisibility(View.VISIBLE);
                c_Row6.setVisibility(View.VISIBLE);
                c_Row7.setVisibility(View.VISIBLE);
                c_Row8.setVisibility(View.VISIBLE);
                c_Row9.setVisibility(View.VISIBLE);
                c_Row10.setVisibility(View.VISIBLE);
                c_Row11.setVisibility(View.VISIBLE);
                c_Row12.setVisibility(View.VISIBLE);
                c_Row13.setVisibility(View.VISIBLE);
                c_Row14.setVisibility(View.VISIBLE);
                c_Row15.setVisibility(View.VISIBLE);


                addMore.setSelection(0);

            }  else {

                Toast.makeText(this.getActivity(),"Course 15 already exists!",Toast.LENGTH_SHORT).show();
                addMore.setSelection(0);
            }
            isOpened2=false;isOpened3=false;isOpened4=false;isOpened5=false;isOpened6=false;isOpened7=false;
            isOpened8=false;isOpened9=false;isOpened10=false;isOpened11=false;isOpened12=false;isOpened13=false;isOpened14=true;

        }


    }

    private void showResult(String semTotal,String creditTotal,String cgpa){

        LayoutInflater layoutInflater =LayoutInflater.from(getContext());

        final View view = layoutInflater.inflate(R.layout.cgpa_row, null);

        final TextView semester =  view.findViewById(R.id.semesterTotal);
        final TextView cGPA = view.findViewById(R.id.cgpa);
        final TextView credit= view.findViewById(R.id.credit1);

        semester.setText(semTotal);
        cGPA.setText(cgpa);
        credit.setText(creditTotal);

        new MaterialAlertDialogBuilder(getContext(),R.style.AlertDialogTheme)
                // .setTitle("Title")
                //.setMessage("Your message goes here. Keep it short but clear.")
                .setCancelable(false)
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
