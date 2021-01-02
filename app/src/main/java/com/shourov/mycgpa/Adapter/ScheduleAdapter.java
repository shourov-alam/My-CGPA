package com.shourov.mycgpa.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.shourov.mycgpa.R;
import com.shourov.mycgpa.ModelClass.Schedule_Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ScheduleAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Schedule_Model> arrayList;
    private ArrayList<Schedule_Model> orig;

    public ScheduleAdapter(@NonNull Context context, ArrayList<Schedule_Model> arrayList) {
        //super(context, R.layout.single_row,arrayList);
        this.context = context;
        this.arrayList = arrayList;
        this.orig = new ArrayList<Schedule_Model>();
        this.orig.addAll(arrayList);

    }

    public class ViewHolder {
        TextView title, des, date, remaining, before;
        ImageView imageView;

    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        arrayList.clear();
        if (charText.length() == 0) {
            arrayList.addAll(orig);
        } else {
            for (Schedule_Model model : orig) {
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        final ViewHolder holder;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.schedule_row, parent, false);

            holder = new ScheduleAdapter.ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView1);
            holder.title =  convertView.findViewById(R.id.title);
            holder.des =  convertView.findViewById(R.id.des);
            holder.date = convertView.findViewById(R.id.date);
            holder.remaining = convertView.findViewById(R.id.remaining);
            holder.before = convertView.findViewById(R.id.before);

            convertView.setTag(holder);


        } else {
            holder = (ScheduleAdapter.ViewHolder) convertView.getTag();

        }

        holder.title.setText("Title: " + arrayList.get(position).getTitle());

        if (!arrayList.get(position).getDes().equals("")) {

            holder.des.setVisibility(View.VISIBLE);
            SpannableStringBuilder builder = new SpannableStringBuilder();

            builder.append("Des: ");
            String red1 = String.valueOf(arrayList.get(position).getDes());
            SpannableString redSpannable = new SpannableString(red1);
            redSpannable.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red1.length(), 0);
            builder.append(redSpannable);

            holder.des.setText(builder, TextView.BufferType.SPANNABLE);


        } else {

            holder.des.setVisibility(View.GONE);
        }


        if (!arrayList.get(position).getDate().equals("Select Date and Time")) {

            holder.remaining.setVisibility(View.VISIBLE);
            holder.before.setVisibility(View.VISIBLE);

            SimpleDateFormat sdfg = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
            Calendar calendar = Calendar.getInstance();
            Calendar cal = Calendar.getInstance();
            try {
                calendar.setTime(sdfg.parse(arrayList.get(position).getDate()));

                int dateForAlarm = calendar.get(Calendar.DAY_OF_MONTH);
                int monthForAlarm = calendar.get(Calendar.MONTH);
                int yearForAlarm = calendar.get(Calendar.YEAR);
                int hourForAlarm = calendar.get(Calendar.HOUR_OF_DAY);
                int minuteForAlarm = calendar.get(Calendar.MINUTE);
                int secondForAlarm = 0;

                cal.set(yearForAlarm, monthForAlarm, dateForAlarm, hourForAlarm, minuteForAlarm, secondForAlarm);


            } catch (ParseException e) {
                e.printStackTrace();
            }

            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
            String week = dayFormat.format(calendar.getTime());
            SpannableStringBuilder builder = new SpannableStringBuilder();


            builder.append("Day: ");
            String red1 = week;
            SpannableString redSpannable = new SpannableString(red1);
            redSpannable.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red1.length(), 0);
            builder.append(redSpannable);

            holder.before.setText(builder, TextView.BufferType.SPANNABLE);
            SpannableStringBuilder builder1 = new SpannableStringBuilder();

            builder1.append("Date: ");
            String red2 = arrayList.get(position).getDate();
            SpannableString redSpannable1 = new SpannableString(red2);
            redSpannable1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red2.length(), 0);
            builder1.append(redSpannable1);


            holder.date.setText(builder1, TextView.BufferType.SPANNABLE);


            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "dd MMM yyyy hh:mm aa", Locale.getDefault());

            try {

                Date oldDate = dateFormat.parse(arrayList.get(position).getDate());

                Date currentDate = new Date();

                long different = oldDate.getTime() - currentDate.getTime();
                long secondsInMilli = 1000;
                long minutesInMilli = secondsInMilli * 60;
                long hoursInMilli = minutesInMilli * 60;
                long daysInMilli = hoursInMilli * 24;

                long elapsedDays = different / daysInMilli;
                different = different % daysInMilli;

                long elapsedHours = different / hoursInMilli;
                different = different % hoursInMilli;

                long elapsedMinutes = different / minutesInMilli;
               // different = different % minutesInMilli;

                String rem = elapsedDays + "d " + elapsedHours + "h " + elapsedMinutes + "min";

                if (elapsedMinutes > 0 || elapsedHours > 0 || elapsedDays > 0) {
                    if (elapsedDays > 3) {


                        if (elapsedHours > 0 && elapsedMinutes > 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = rem;
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                        else if (elapsedHours == 0 && elapsedMinutes == 0) {
                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);

                        }

                        else if (elapsedHours == 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d " + elapsedMinutes + "min";
                            ;
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                        else if (elapsedMinutes == 0) {
                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d " + elapsedHours + "h ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);

                        }


                    }

                    if (elapsedDays <= 3) {

                        if (elapsedDays > 0 && elapsedHours > 0 && elapsedMinutes > 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = rem;

                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }


                       else if (elapsedHours == 0 && elapsedDays > 0 && elapsedMinutes > 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d " + elapsedMinutes + "min";

                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                       else if (elapsedMinutes == 0 && elapsedDays > 0 && elapsedHours > 0) {
                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d " + elapsedHours + "h ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);

                        }
                       else if (elapsedDays == 0 && elapsedHours > 0 && elapsedMinutes > 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedHours + "h " + elapsedMinutes + "min ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                       else if (elapsedDays == 0 && elapsedHours == 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedMinutes + "min ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }
                       else if (elapsedDays == 0 && elapsedMinutes == 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedHours + "h ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                        if (elapsedMinutes == 0 && elapsedHours == 0) {

                            SpannableStringBuilder builder2 = new SpannableStringBuilder();

                            builder2.append("Remaining: ");
                            String red3 = elapsedDays + "d ";
                            SpannableString redSpannable2 = new SpannableString(red3);
                            redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red3.length(), 0);
                            builder2.append(redSpannable2);
                            holder.remaining.setText(builder2, TextView.BufferType.SPANNABLE);
                        }

                    }

                }
                if (elapsedMinutes < 0 || elapsedHours < 0 || elapsedDays < 0) {

                    if (elapsedDays == 0 && elapsedHours == 0) {
                        elapsedMinutes = elapsedMinutes * (-1);
                        SpannableStringBuilder builder3 = new SpannableStringBuilder();
                        builder3.append("Expired: ");
                        String red4 = elapsedMinutes + "min ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);
                    }
                   else if (elapsedDays < 0 && elapsedHours == 0 && elapsedMinutes == 0) {
                        elapsedDays = elapsedDays * (-1);

                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedDays + "d ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);
                    }
                   else if (elapsedDays == 0 && elapsedHours < 0 && elapsedMinutes == 0) {


                        elapsedHours = elapsedHours * (-1);

                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedHours + "h ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);
                    }

                  else if (elapsedDays == 0 && elapsedHours < 0 && elapsedMinutes < 0) {


                        elapsedHours = elapsedHours * (-1);
                        elapsedMinutes = elapsedMinutes * (-1);
                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedHours + "h " + elapsedMinutes + "min ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);
                    }
                   else if (elapsedDays < 0 && elapsedHours < 0 && elapsedMinutes < 0) {

                        elapsedDays = elapsedDays * (-1);
                        elapsedHours = elapsedHours * (-1);
                        elapsedMinutes = elapsedMinutes * (-1);
                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedDays + "d " + elapsedHours + "h " + elapsedMinutes + "min"
                                + " ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);
                    }

                   else if (elapsedDays < 0 && elapsedHours < 0 && elapsedMinutes == 0) {

                        elapsedDays = elapsedDays * (-1);
                        elapsedHours = elapsedHours * (-1);

                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedDays + "d " + elapsedHours + "h ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);

                    }
                   else if (elapsedDays < 0 && elapsedHours == 0 && elapsedMinutes < 0) {
                        elapsedDays = elapsedDays * (-1);
                        elapsedMinutes = elapsedMinutes * (-1);

                        SpannableStringBuilder builder3 = new SpannableStringBuilder();

                        builder3.append("Expired: ");
                        String red4 = elapsedDays + "d " + elapsedMinutes + "m ago";
                        SpannableString redSpannable2 = new SpannableString(red4);
                        redSpannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#009688")), 0, red4.length(), 0);
                        builder3.append(redSpannable2);
                        holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);

                    }


                }
               else if (elapsedMinutes == 0 && elapsedHours == 0 && elapsedDays == 0) {


                    SpannableStringBuilder builder3 = new SpannableStringBuilder();
                    String red4 = "The Schedule Time is now";
                    SpannableString redSpannable2 = new SpannableString(red4);
                    redSpannable2.setSpan(new ForegroundColorSpan(Color.RED), 0, red4.length(), 0);
                    builder3.append(redSpannable2);
                    holder.remaining.setText(builder3, TextView.BufferType.SPANNABLE);

                }


            } catch (ParseException e) {

                e.printStackTrace();
            }

        } else {

            holder.remaining.setVisibility(View.GONE);
            holder.date.setText("No Date/Time Selected");
            holder.before.setVisibility(View.GONE);

        }


        if (arrayList.get(position).getImageUri().equals("null")) {


            holder.imageView.setVisibility(View.GONE);

        } else {
            holder.imageView.setVisibility(View.VISIBLE);
          //  Bitmap.CompressFormat compressedImageFile = Compressor.(context, arrayList.get(position).getImageUri());

           // Bitmap bitmap= BitmapFactory.decodeFile(arrayList.get(position).getImageUri());
           // Bitmap bitmapt = Bitmap.createScaledBitmap(bitmap, 3, 3, true);

            Glide
                    .with(context)
                    .load(arrayList.get(position).getImageUri())
                    .fitCenter()
                    .into(holder.imageView);

                 }

            return convertView;
        }

}

