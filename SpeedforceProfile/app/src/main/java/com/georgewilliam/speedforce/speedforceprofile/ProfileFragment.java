package com.georgewilliam.speedforce.speedforceprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] profileSampleArray = {
                "Nombre",
                "Apellido",
                "Sexo",
                "Altura",
                "Peso",
                "Fecha de Nacimiento",
                "Ciudad",
                "Telefono",
                "ID de Usuario",
                "Email"
        };

        List<String> profileArrayList = new ArrayList<String>(
                Arrays.asList(profileSampleArray)
        );

        // Adapter del Item List
        ArrayAdapter<String> profileAdapter =
                new ArrayAdapter<String>(

                        //Context que contiene environment elements de la app (este activity)
                        getActivity(),

                        //ID del Layout (nombre del archivo xml a emplear como layout)
                        R.layout.list_item_profile,

                        //ID del elemento del Layout (identificador del element/tag en dicho layout)
                        R.id.list_item_profile_textview,

                        //Raw Data como el List of Array con los strings
                        profileArrayList
                );


        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Get reference to the ListView to bind this adapter to it
        ListView listView = (ListView) rootView.findViewById(R.id.listview_profile);
        listView.setAdapter(profileAdapter);


        return rootView;
    }
}
