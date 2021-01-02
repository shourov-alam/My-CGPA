package com.shourov.mycgpa.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.shourov.mycgpa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Plan_Fragment extends Fragment {

    private View view,view1;
    private Button btn;
    private Spinner spinner,spinner1;
    private EditText maintainET,currentET;
    private int sCount,remain,check,within_count;
    private String cgpa_current,cgpa_maintain;
    private boolean flag,flag1;

    public Plan_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_plan_, container, false);
       init();

        return view;
    }

    private void init(){

        spinner = view.findViewById(R.id.add_count3);
        spinner1 = view.findViewById(R.id.add_count4);
        btn=view.findViewById(R.id.btn);
        currentET=view.findViewById(R.id.current);
        maintainET=view.findViewById(R.id.maintain);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                keyBoard();
                spinner_selection();
                check=sCount+within_count;
                remain=12-sCount;
                cgpa_current=currentET.getText().toString();
                cgpa_maintain=maintainET.getText().toString();


                if(TextUtils.isEmpty(cgpa_current) || TextUtils.isEmpty(cgpa_maintain) || Float.parseFloat(cgpa_current)>4 || Float.parseFloat(cgpa_maintain)>4  ){


                    try {
                        if(Float.parseFloat(cgpa_current)>4){

                            currentET.setError("Grade can't greater than 4");
                        }

                        if(Float.parseFloat(cgpa_maintain)>4){

                            maintainET.setError("Grade can't greater than 4");
                        }
                    }catch (Exception e){

                    }

                    if(TextUtils.isEmpty(cgpa_current)){

                        Toast.makeText(getContext(),"Enter your current Grade",Toast.LENGTH_LONG).show();
                    }

                    if(TextUtils.isEmpty(cgpa_maintain)){


                        Toast.makeText(getContext(),"Enter Grade you want to maintain",Toast.LENGTH_LONG).show();
                    }

                }
               else {

                    if(check>12){
                        // remain=12-sCount;
                        showResult(within_count,remain);

                    }
                    else {

                        calculation();

                    }

                }

            }
        });

    }

    void spinner_selection(){

        int p,p1;
        p=spinner.getSelectedItemPosition();
        p1=spinner1.getSelectedItemPosition();

        if(p==0){

            sCount=1;

        }

       else if(p==1){

            sCount=2;

        }
        else if(p==2){

            sCount=3;

        }
        else if(p==3){

            sCount=4;

        }
        else if(p==4){

            sCount=5;

        }

        else if(p==5){

            sCount=6;

        }
        else if(p==6){

            sCount=7;

        }
        else if(p==7){

            sCount=8;

        }
        else if(p==8){

            sCount=9;

        }

        else if(p==9){

            sCount=10;

        }
        else if(p==10){

            sCount=11;

        }

        if(p1==0){

            within_count=1;

        }

        else if(p1==1){

            within_count=2;

        }
        else if(p1==2){

            within_count=3;

        }
        else if(p1==3){

            within_count=4;

        }
        else if(p1==4){

            within_count=5;

        }

        else if(p1==5){

            within_count=6;

        }
        else if(p1==6){

            within_count=7;

        }
        else if(p1==7){

            within_count=8;

        }
        else if(p1==8){

            within_count=9;

        }

        else if(p1==9){

            within_count=10;

        }
        if(p1==10){

            within_count=11;

        }

    }

    private void showResult(int s_within,int s_remain){

        LayoutInflater layoutInflater =LayoutInflater.from(getContext());

        final View view = layoutInflater.inflate(R.layout.plan_row, null);
        final TextView course =  view.findViewById(R.id.planTV);

        SpannableStringBuilder builder = new SpannableStringBuilder();

        builder.append("You want to maintain new Grade within ");
        String red1 = String.valueOf(s_within);
        SpannableString redSpannable= new SpannableString(red1);
        redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red1.length(), 0);
        builder.append(redSpannable);
        builder.append(" semester, but you have only ");


        String red2 = String.valueOf(s_remain);
        SpannableString whiteSpannable= new SpannableString(red2);
        whiteSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red2.length(), 0);
        builder.append(whiteSpannable);

        builder.append(" semester left. You can select ");
        String red3 = String.valueOf(s_remain);
        SpannableString blueSpannable = new SpannableString(red3);
        blueSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
        builder.append(blueSpannable);

        builder.append(" semester at most.");

        course.setText(builder, TextView.BufferType.SPANNABLE);


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

    void calculation(){

        float finalMaintain=Float.parseFloat(cgpa_maintain);
        float finalCurrent=Float.parseFloat(cgpa_current);

        float temp = finalMaintain-finalCurrent;
        if(finalMaintain >= finalCurrent){


            float result=temp/within_count;
            float z=result*sCount;
            float new_maintain=finalMaintain+z;

            if(new_maintain<=4){

                String new_maintain2= String.format("%.2f", new_maintain);
                String finalMaintain2 = String.format("%.2f", finalMaintain);
                String finalCurrent2 = String.format("%.2f", finalCurrent);

                showResult1(new_maintain2,finalMaintain2,finalCurrent2,within_count,sCount);

            }
            else {

                for(int i=within_count+1;i<13-sCount;i++) {

                    float s1 = temp / i;
                    float s2 = s1 * sCount;
                    float s3 = finalMaintain+s2;

                    if(s3<=4){

                        String s32= String.format("%.2f", s3);
                        String finalMaintain2 = String.format("%.2f", finalMaintain);
                        String finalCurrent2 = String.format("%.2f", finalCurrent);

                        showResult1(s32,finalMaintain2,finalCurrent2,i,sCount);
                        flag=true;
                        break;

                    }


                }

                if(!flag){

                    int n=sCount+within_count;

                    float n1=Float.parseFloat(cgpa_current)*sCount;
                    float n2=4*within_count;

                    float n3=n1+n2;

                    float n4=n3/n;

                    String n42 = String.format("%.2f", n4);


                    showResult2(n42,within_count,finalMaintain,4);


                }

                flag=false;

            }


        }else {

            float t=finalCurrent-finalMaintain;

            float result=t/within_count;

            float z=result*sCount;

            float new_maintain=finalMaintain-z;

            if(new_maintain>=2) {

                String new_maintain2= String.format("%.2f", new_maintain);
                String finalMaintain2 = String.format("%.2f", finalMaintain);
                String finalCurrent2 = String.format("%.2f", finalCurrent);
                showResult1(new_maintain2, finalMaintain2, finalCurrent2, within_count,sCount);
            }else {


                for(int i=within_count+1;i<=13-sCount;i++) {

                    float s1 = t / i;
                    float s2 = s1 * sCount;
                    float s3 = finalMaintain-s2;

                    if(s3>=2){

                        String s32= String.format("%.2f", s3);
                        String finalMaintain2 = String.format("%.2f", finalMaintain);
                        String finalCurrent2 = String.format("%.2f", finalCurrent);
                        showResult1(s32,finalMaintain2,finalCurrent2,i,sCount);
                        flag1=true;
                        break;

                    }

                }

                if(!flag1){

                    int ns=sCount+within_count;

                    float ns1=Float.parseFloat(cgpa_current)*sCount;
                    float ns2=2*within_count;

                    float ns3=ns1+ns2;

                    float ns4=ns3/ns;

                    String ns42 = String.format("%.2f", ns4);

                    showResult2(ns42,within_count,finalMaintain,2);


                }

                flag1=false;

            }

        }

    }

    private void showResult1(String maintain,String want,String current,int within,int scount){

        LayoutInflater layoutInflater =LayoutInflater.from(getContext());

        final View view = layoutInflater.inflate(R.layout.plan_row1, null);

        final TextView completed1 =  view.findViewById(R.id.completed1);
        final TextView current1 =  view.findViewById(R.id.current1);
        final TextView maintain1 =  view.findViewById(R.id.maintain1);
        final TextView required1 =  view.findViewById(R.id.required1);

        final TextView required2 =  view.findViewById(R.id.required2);

        completed1.setText(String.valueOf(scount));
        current1.setText(String.valueOf(current));
        maintain1.setText(String.valueOf(want));
        required1.setText(String.valueOf(maintain));
        required2.setText(String.valueOf(within));


        new MaterialAlertDialogBuilder(getContext(),R.style.AlertDialogTheme)

                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })

                .setView(view)
                .setCancelable(true)
                .show();

    }

    private void showResult2(String m1,int m2,float m3,float m4){

        LayoutInflater layoutInflater =LayoutInflater.from(getContext());

        final View view = layoutInflater.inflate(R.layout.plan_row, null);
        final TextView course1 =  view.findViewById(R.id.planTV);

        SpannableStringBuilder builder = new SpannableStringBuilder();

        builder.append("You can't maintain ");
        String red1 = String.valueOf(m3);
        SpannableString redSpannable= new SpannableString(red1);
        redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red1.length(), 0);
        builder.append(redSpannable);
        builder.append(" if you get ");

        String red2 = String.valueOf(m4);
        SpannableString whiteSpannable= new SpannableString(red2);
        whiteSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red2.length(), 0);
        builder.append(whiteSpannable);

        builder.append(" in next ");

        if(m2>1) {
            String red3 = String.valueOf(m2);
            SpannableString blueSpannable = new SpannableString(red3);
            blueSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
            builder.append(blueSpannable);
        }

        builder.append(" semester your grade will be ");

       // String red4 = m1;
        SpannableString blueSpannable1 = new SpannableString(m1);
        blueSpannable1.setSpan(new ForegroundColorSpan(Color.RED), 0, m1.length(), 0);
        builder.append(blueSpannable1);

        course1.setText(builder, TextView.BufferType.SPANNABLE);


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
