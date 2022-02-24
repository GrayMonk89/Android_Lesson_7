package ru.gb.android_lesson_7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NoteFragment extends Fragment {
    private Note note;
    public static final String ARG_NOTE_KEY = "note_key";


    public static NoteFragment newInstance(Note note){
        NoteFragment fragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE_KEY, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        note = getArguments().getParcelable(ARG_NOTE_KEY);
        TextView textView = view.findViewById(R.id.view_note);
        textView.setTextSize(30);
        textView.setText(getResources().getStringArray(R.array.the_note)[note.getNoteIndex()]);
    }
}