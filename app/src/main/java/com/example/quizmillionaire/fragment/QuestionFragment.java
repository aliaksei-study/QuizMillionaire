package com.example.quizmillionaire.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quizmillionaire.MainActivity;
import com.example.quizmillionaire.R;

public class QuestionFragment extends Fragment {
    private int nextFragment;
    private Runnable runnable = () -> {
        MainActivity activity = (MainActivity) getActivity();
        if(activity != null) {
            activity.setViewPager(this.nextFragment);
        }
    };

    public QuestionFragment(int nextFragment) {
        this.nextFragment = nextFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment, container, false);
        return view;
    }

}
