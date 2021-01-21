package ru.arsik.a12012021.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.arsik.a12012021.R;

public class BankomatsAdapter extends RecyclerView.Adapter<BankomatsAdapter.BankomatsViewHolder> {
    @NonNull
    @Override
    public BankomatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bankomats_item, parent, false);
        return new BankomatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankomatsViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class BankomatsViewHolder extends RecyclerView.ViewHolder {
        private TextView address;
        private TextView type;
        private TextView work;
        private TextView time;
        public BankomatsViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.tv_address);
            type = itemView.findViewById(R.id.tv_type);
            work = itemView.findViewById(R.id.work);
            time = itemView.findViewById(R.id.work_time);
        }

        public void bind(){
            address.setText("Москва, ул. Валидова, д. 7");
            type.setText("Банкомат");
            work.setText("Работает");
            time.setText("Часы работы 00:00-00:00");
        }
    }
}
