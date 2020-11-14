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

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.os.Environment;
import java.io.File;

public class WhatsVideo extends Fragment {

    List<String> list;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tab, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        versionCode();
        /**Ready Adaptor with List**/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        /**Set The Adaptor with ListView**/
        listView.setAdapter(adapter);

        /**When Click on List Item shows a Snackbar saying item was Clicked**/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, parent.getItemAtPosition(position).toString() + " was Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        /**When Long Click on List Item shows a Snackbar saying Long Clicked on item**/
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, "Long Clicked on " + parent.getItemAtPosition(position).toString(), Snackbar.LENGTH_SHORT).show();
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
         if (files[i].getName().endsWith(".mp4")) {
                list.add(files[i].getName());
         } else {

         }
        }
    }
}
