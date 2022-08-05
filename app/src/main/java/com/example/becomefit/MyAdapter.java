package com.example.becomefit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
ArrayList<data> mlist;
private Context context;

    int h = 1;
public MyAdapter(Context context,ArrayList<data> mlist){
    this.context=context;
    this.mlist=mlist;
}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item1,parent,false);
               return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    if(mlist.get(position).getType().equals("abs")){
            data uploadcurrent = mlist.get(0);
            holder.textView.setText(uploadcurrent.getName());
        data uploadcurrent1 = mlist.get(0);
        holder.des.setText(uploadcurrent1.getDes());
            Glide.with(context).load(mlist.get(0).getImageurl()).into(holder.imageView);}
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    while (h < mlist.size()) {
                        if (mlist.get(h).getType().equals("abs")) {
                            data uploadcurrent = mlist.get(h);
                            holder.textView.setText(uploadcurrent.getName());
                            data uploadcurrent1 = mlist.get(h);
                            holder.des.setText(uploadcurrent1.getDes());
                            Glide.with(context).load(mlist.get(h).getImageurl()).into(holder.imageView);
                            h++;
                            break;
                        }
                        else{
                            h++;
                        }

                    }
                    if(h==mlist.size()){
                        Intent intent = new Intent(context,MainActivity.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




    @Override
    public int getItemCount() {
     return
             mlist.size();
    }

    public static class MyViewHolder  extends   RecyclerView.ViewHolder{
ImageView imageView;
TextView textView,des;
Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.m_image);
            textView=itemView.findViewById(R.id.m_text);
            button=itemView.findViewById(R.id.next);
            des=itemView.findViewById(R.id.des);
        }
    }
}
