package com.fabiosilvateck69.track;

import android.content.Context; 
import android.support.annotation.NonNull; 
import android.support.annotation.Nullable; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.BaseAdapter; 
import android.widget.TextView; 
import android.widget.ImageView;
import java.util.ArrayList; 

public class AdaptImage extends BaseAdapter { 

Context context; 
LayoutInflater inflater; 
ArrayList<ImageReference> model; 

public AdaptImage(Context context, ArrayList<ImageReference> model) { 
            inflater = LayoutInflater.from(context); 
            this.context = context; 
            this.model = model; 
        } 

        @Override 
        public int getCount() { 
            return model.size(); 
        } 

        @Override 
        public Object getItem(int position) { 
            return model.get(position); 
        } 

        @Override 
        public long getItemId(int position) { 
            return position; 
        } 

        /**Holder Class**/ 
        public class Holder { 
            TextView nome, valor; 
        } 

@NonNull 
@Override 
public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) { 
            Holder holder = new Holder(); 
            if (view == null) { 

                /**Initialize View**/ 
                view = inflater.inflate(R.layout.custom_templates, parent, false); 
                holder.nome = (TextView) view.findViewById(R.id.nome); 
                holder.valor = (TextView) view.findViewById(R.id.textview2);
                
                view.setTag(holder); 
            } else { 
                holder = (Holder) view.getTag(); 
            } 

            holder.nome.setText(model.get(position).getNome()); 
            holder.valor.setText(model.get(position).getValor());
            return view; 
     } 
} 
 
 
 
 

