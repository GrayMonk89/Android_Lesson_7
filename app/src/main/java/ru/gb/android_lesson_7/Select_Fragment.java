package ru.gb.android_lesson_7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Select_Fragment extends Fragment {

    public static Select_Fragment newInstance() {
        Select_Fragment fragment = new Select_Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] listOfSelect = getResources().getStringArray(R.array.list_of_select);
        int i = 0;
        for(String nameOfSelect : listOfSelect){
            TextView textView = new TextView(requireContext());
            textView.setTextSize(30);
            textView.setText(nameOfSelect);
            textView.setId(1000 + i);
            ((LinearLayout)view).addView(textView);
            i++;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case (1000):{
                            NoteListFragment noteListFragment = NoteListFragment.newInstance();
                            requireActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.list_of_note, noteListFragment).addToBackStack("").commit();

                            break;
                        }
                    }
                }
            });
        }
    }
}