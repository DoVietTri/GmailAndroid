package com.example.gmailandroid;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ItemsMail> arrayMail;

    public MailAdapter(Context context, int layout, ArrayList<ItemsMail> arrayMail) {
        this.context = context;
        this.layout = layout;
        this.arrayMail = arrayMail;
    }

    @Override
    public int getCount() {
        return arrayMail.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtViewName, txtViewDesc, txtViewTime, txtViewImage;
        ImageView imgViewStar;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtViewName = (TextView) convertView.findViewById(R.id.txtViewName);
            holder.txtViewDesc = (TextView) convertView.findViewById(R.id.txtViewDesc);
            holder.imgViewStar = (ImageView) convertView.findViewById(R.id.imgViewStar);
            holder.txtViewTime = (TextView) convertView.findViewById(R.id.txtViewTime);
            holder.txtViewImage = (TextView) convertView.findViewById(R.id.txtViewImage);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ItemsMail itemsMail = arrayMail.get(position);

        holder.txtViewName.setText(itemsMail.getName());
        holder.txtViewImage.setText(itemsMail.getName().substring(0,1));
        holder.txtViewDesc.setText(itemsMail.getDesc());
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm");
        String strDate = formatDate.format(date);
        holder.txtViewTime.setText(strDate);

        if (itemsMail.isSelected()) {
            holder.imgViewStar.setImageResource(R.drawable.ic_star_bold);
        } else {
            holder.imgViewStar.setImageResource(R.drawable.ic_star_normal);
        }

        holder.imgViewStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = arrayMail.get(position).isSelected();
                arrayMail.get(position).setSelected(!isSelected);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
