package me.paixao.intro.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import me.paixao.intro.MainActivity;
import me.paixao.intro.R;

/**
 * Created by paixao on 13-11-2016.
 */

public class MainFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Anatomy of Pedro Paixão");

        LinearLayout brain = (LinearLayout) getActivity().findViewById(R.id.bt_brain);
        brain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("to", "brain");
                startActivity(intent);
            }
        });

        LinearLayout ear = (LinearLayout) getActivity().findViewById(R.id.bt_ear);
        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("to", "ear");
                startActivity(intent);
            }
        });

        LinearLayout heart = (LinearLayout) getActivity().findViewById(R.id.bt_heart);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("to", "heart");
                startActivity(intent);
            }
        });

        LinearLayout hand = (LinearLayout) getActivity().findViewById(R.id.bt_hand);
        hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("to", "hand");
                startActivity(intent);
            }
        });

        LinearLayout foot = (LinearLayout) getActivity().findViewById(R.id.bt_foot);
        foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("to", "foot");
                startActivity(intent);
            }
        });
    }
}
