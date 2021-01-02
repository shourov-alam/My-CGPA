package com.shourov.mycgpa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.shourov.mycgpa.ModelClass.Model_class;
import com.shourov.mycgpa.R;
import java.util.ArrayList;
import java.util.Locale;

public class CourseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Model_class> arrayList;
    private ArrayList<Model_class> orig;

    public CourseAdapter(@NonNull Context context, ArrayList<Model_class> arrayList) {

        this.context=context;
        this.arrayList=arrayList;
        this.orig = new ArrayList<Model_class>();
        this.orig.addAll(arrayList);
    }

    public class ViewHolder
    {
        TextView course_name,course_grade,course_credit,course_semester,course_remarks;

    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        arrayList.clear();
        if (charText.length()==0){
            arrayList.addAll(orig);
        }
        else {
            for (Model_class model : orig){
                if (model.getCourse_name().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    arrayList.add(model);
                }

            }
        }
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if(convertView==null) {

            convertView=layoutInflater.inflate(R.layout.course_details_row, parent, false);


            holder=new ViewHolder();
            holder.course_name=(TextView) convertView.findViewById(R.id.course_name);
            holder.course_credit=(TextView) convertView.findViewById(R.id.course_credit);
            holder.course_grade=(TextView) convertView.findViewById(R.id.course_grade);
            holder.course_semester=(TextView) convertView.findViewById(R.id.course_semester);
            holder.course_remarks=(TextView) convertView.findViewById(R.id.course_remarks);

            convertView.setTag(holder);
        }
        else

        {
            holder=(ViewHolder) convertView.getTag();

        }

        holder.course_name.setText(arrayList.get(position).getCourse_name());
        holder.course_credit.setText(String.valueOf(arrayList.get(position).getCredit()));
        holder.course_grade.setText(String.valueOf((arrayList.get(position).getGrade())));
        holder.course_semester.setText((String.valueOf(arrayList.get(position).getSemester())));


        if(!arrayList.get(position).getCourse_remarks().equals("")){
            holder.course_remarks.setVisibility(View.VISIBLE);
            holder.course_remarks.setText("Remarks: "+(arrayList.get(position).getCourse_remarks()));
        }else {

            holder.course_remarks.setVisibility(View.GONE);
        }

        return convertView;

    }

}