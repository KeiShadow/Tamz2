package com.example.netactivity;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// TODO upravit tak, aby se zobrazovalo
//
//  |-----------|----------------------------------|
//  | ImageView |          NAZEV MENY              |  
//  |           |Kod                               | 
//  |  vlajka   |Stat                              |
//  |   statu   |Cena                              | 
//  |           |                                  |
//  |----------------------------------------------|


public class CNBAdapter extends ArrayAdapter<Entry>{

    Context context;
    int layoutResourceId;   
    List<Entry> data = null;
    
   
    public CNBAdapter(Context context, int layoutResourceId, List<Entry> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EntryHolder holder = null;
       
        if(row == null)
        {
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );      	
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new EntryHolder();
            holder.txtKod = (TextView)row.findViewById(R.id.txtKod);
            holder.txtKurz = (TextView)row.findViewById(R.id.txtKurz);
            holder.txtZeme = (TextView)row.findViewById(R.id.txtZeme);
            holder.imageFlags = (ImageView)row.findViewById(R.id.imageFlags);
            
            row.setTag(holder);
        }
        else
        {
            holder = (EntryHolder)row.getTag();
        }




        Entry entry = data.get(position);
        holder.txtKod.setText(entry.kod);
        holder.txtKurz.setText(entry.mena);
        holder.txtZeme.setText(entry.zeme);

        Context context = holder.imageFlags.getContext();
        int id= context.getResources().getIdentifier("flag_"+entry.kod.toLowerCase(),"drawable",context.getPackageName());
        holder.imageFlags.setImageResource(id);
        
        return row;
    }
   
    static class EntryHolder
    {
        TextView txtKod;
        TextView txtKurz;
        TextView txtZeme;
        ImageView imageFlags;
    }
}
