package com.example.hussnain.umair;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context=this;
        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OurAdapter adapter=new OurAdapter();
        recyclerView.setAdapter(adapter);
    }
    public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
             DataModel [] dataModels= new  DataModel[2];
        public OurAdapter() {
            dataModels[0]=new DataModel("umair",R.drawable.kuran);
            dataModels[1]=new DataModel("umair",R.drawable.kuran);

        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
              DataModel item=dataModels[position];
              holder.textView.setText(item.getName());
              holder.imageView.setImageResource(item.image);
        }

        @Override
        public int getItemCount() {
            return dataModels.length;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
             TextView textView;
             ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.name);
                imageView=itemView.findViewById(R.id.image);
            }
        }
    }
    public class DataModel{
        String name;
        int image;

        public DataModel(String name, int image) {
            this.name = name;
            this.image = image;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
