package ru.gb.android_lesson_7;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class NoteListFragment extends Fragment {
    public static final String CURRENT_NOTE = "current_note";
    private Note currentNote;

    public NoteListFragment() {
    }

    public static NoteListFragment newInstance() {
        NoteListFragment fragment = new NoteListFragment();
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_NOTE, currentNote);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        } else {
            currentNote = new Note(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLand();
        }
        initView(view);
    }

    private void showLand() {
        NoteFragment noteFragment = NoteFragment.newInstance(currentNote);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.the_note, noteFragment).commit();
    }

    private void showPort() {
        NoteFragment noteFragment = NoteFragment.newInstance(currentNote);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, noteFragment).addToBackStack("").commit();

    }

    private void initView(View view) {
        String[] listOfNote = getResources().getStringArray(R.array.list_of_note);
        int i = 0;
        for(String nameOfNote : listOfNote){
            TextView textView = new TextView(requireContext());
            textView.setTextSize(30f);
            textView.setText(nameOfNote);
            ((LinearLayout)view).addView(textView);
            int finalI = i++;
            textView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    currentNote = new Note(finalI);
                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        showLand();
                    }else{
                        showPort();
                    }
                }
            });
        }
        Button newNoteButton = new MaterialButton(requireContext());
        newNoteButton.setText("New note");
        newNoteButton.setTextSize(30);
        ((LinearLayout)view).addView(newNoteButton);
        newNoteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    NewNoteFragment newNoteFragment = NewNoteFragment.newInstance();
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.the_note, newNoteFragment).addToBackStack("").commit();
                }else{
                    NewNoteFragment newNoteFragment = NewNoteFragment.newInstance();
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, newNoteFragment).addToBackStack("").commit();
                }
            }
        });
    }
}