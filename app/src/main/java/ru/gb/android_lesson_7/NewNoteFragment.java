package ru.gb.android_lesson_7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NewNoteFragment extends Fragment {

    public static NewNoteFragment newInstance() {
        NewNoteFragment fragment = new NewNoteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NewNoteChildFragment newNoteChildFragment = NewNoteChildFragment.newInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.container_child,newNoteChildFragment).commit();
    }
}