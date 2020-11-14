package com.fabiosilvateck69.track;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.Snackbar; 
import android.support.v7.app.AppCompatActivity; 
import java.util.ArrayList; 
import java.util.List;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface; 
import android.content.Intent;
public class WhatsImage extends Fragment {

ArrayList<ImageReference> list; 
ListView listView;
private Context context;
private AlertDialog.Builder att_dialog;
private Intent share = new Intent();
    
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tab, container, false);
        
        listView = (ListView) view.findViewById(R.id.list);
        att_dialog = new AlertDialog.Builder(context);
        
        return view;
    }

@Override
public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }
    
@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        versionCode(); 
        final AdaptImage adaptor = new AdaptImage(context, list); 
        /**Set Adaptor**/ 
        listView.setAdapter(adaptor); 

        /**When Click on List Item shows a Snackbar saying item was Clicked**/ 
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
                @Override 
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 
                    ImageReference pojo1 = (ImageReference) adaptor.getItem(position); 

                } 
            }); 

        /**When Long Click on List Item shows a Snackbar saying Long Clicked on item**/ 
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { 
                @Override 
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { 
                    ImageReference pojo1 = (ImageReference) adaptor.getItem(position); 

                    return true; 
                } 
            }); 
    } 

private void versionCode() {
        list = new ArrayList<>();
        /**Add Items in List**/
        String path = Environment.getExternalStorageDirectory().toString()+"/WhatsApp Business/Media/.Statuses/";
        Log.d("Files", "path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].getName().endsWith(".jpg") || files[i].getName().endsWith(".png")) {
                list.add(new ImageReference(files[i].getName(),"whatsapp buzzines detectado",""));
            }
            }
            }
            }
