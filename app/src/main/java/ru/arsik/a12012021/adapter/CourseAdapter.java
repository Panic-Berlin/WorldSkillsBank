package ru.arsik.a12012021.adapter;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ru.arsik.a12012021.R;
import ru.arsik.a12012021.course.Valute;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CoursesViewHolder> {

    public List<Valute> valuteList;

    public CourseAdapter(List<Valute> valutes) {

        this.valuteList = valutes;
    }

    @NonNull
    @Override
    public CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);

        return new CoursesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesViewHolder holder, int position) {
        holder.bind(valuteList.get(position));
    }

    @Override
    public int getItemCount() {

        return valuteList.size();
    }

    static class CoursesViewHolder extends RecyclerView.ViewHolder {

        private TextView charCode;
        private TextView name;
        private TextView buy;
        private TextView sell;
        private ImageView flagIcon;


        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);

            charCode = itemView.findViewById(R.id.course_code);
            name = itemView.findViewById(R.id.course_name);
            buy = itemView.findViewById(R.id.course_buy);
            sell = itemView.findViewById(R.id.course_sell);
            flagIcon = itemView.findViewById(R.id.flag_icon);

        }

        public void bind(Valute valute) {
            this.charCode.setText(valute.getCharCode());
            this.name.setText(valute.getName());
            this.buy.setText(String.format("%.1f", valute.getValue()));


            AssetManager assetManager = flagIcon.getContext().getAssets();
            try {
                String[] files = assetManager.list("flags");
                for (String file : files){
                    String name = file.split("\\.")[0];
                    if (valute.getCharCode().toLowerCase().startsWith(name)){
                        InputStream stream = assetManager.open("flags/" + file);
                        flagIcon.setImageDrawable(Drawable.createFromStream(stream, null));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
