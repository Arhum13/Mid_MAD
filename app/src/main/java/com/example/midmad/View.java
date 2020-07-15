package com.example.midmad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link View#newInstance} factory method to
 * create an instance of this fragment.
 */
public class View extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public View() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment View.
     */
    // TODO: Rename and change types and number of parameters
    public static View newInstance(String param1, String param2) {
        View fragment = new View();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_item2, container, false);
        recyclerView =(RecyclerView)v1.findViewById(R.id.R1);
        RecyclerView.LayoutManager l1;
        db=new DataBase(getActivity());
        l1 = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(l1);
        cv=db.readData();
        if(cv.getCount()>0)
        {
            if(cv.moveToFirst())
            {
                do{
                    Title=cv.getString(1);
                    Detail=cv.getString(2);
                    Date=cv.getString(3);
                    GetterSetter g1=new GetterSetter(title,detail,date);
                    a1.add(g1);

                }while(cv.moveToNext());
            }
            ad=new Myadapter(getActivity(),a1);
            recyclerView.setAdapter(ad);
        }

        return v1;
    }
}