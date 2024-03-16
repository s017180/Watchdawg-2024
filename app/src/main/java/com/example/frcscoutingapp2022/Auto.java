package com.example.frcscoutingapp2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Auto extends Fragment implements View.OnClickListener {


    //initialize variables

    //Initialize upper node text views
    private TextView AutoAMPText;
    private TextView AutoSpeakerText;

    //initialize Middle node text views
    private TextView AutoNoteText;


    //counter variables
    private int AutoAMPCounter = 0;
    private int AutoSpeakerCounter = 0;

    private int AutoNoteCounter = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);



        //Define TextViews
        AutoAMPText = (TextView) view.findViewById(R.id.AutoAMPCounter);
        AutoSpeakerText = (TextView) view.findViewById(R.id.AutoSpeakerCounter);

        AutoNoteText = (TextView) view.findViewById(R.id.NotesAcquiredCounter);



        //Upper Row Buttons
        view.findViewById(R.id.AutoAMPIncrease).setOnClickListener(this);
        view.findViewById(R.id.AutoAMPDecrease).setOnClickListener(this);

        view.findViewById(R.id.AutoSpeakerIncrease).setOnClickListener(this);
        view.findViewById(R.id.AutoSpeakerDecrease).setOnClickListener(this);

        //Middle Row Buttons
        view.findViewById(R.id.NotesAcquiredIncrease).setOnClickListener(this);
        view.findViewById(R.id.NotesAcquiredDecrease).setOnClickListener(this);


        return view;
    }
    //stuff that happens when you hit buttons
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            //+1 to upper cone
            case R.id.AutoAMPIncrease:
                AutoAMPCounter++;
                AutoAMPText.setText(Integer.toString(AutoAMPCounter));
                //MainActivity.editMatchData(0, 0, MainActivity.getButtonData()[0][0] + 1);
                MainActivity.AutoAMP++;
                break;
            case R.id.AutoAMPDecrease:
                if(AutoAMPCounter > 0) {
                    AutoAMPCounter--;
                    AutoAMPText.setText(Integer.toString(AutoAMPCounter));
                    //MainActivity.editMatchData(0, 0, MainActivity.getButtonData()[0][0] - 1);
                    MainActivity.AutoAMP--;
                } break;

            case R.id.AutoSpeakerIncrease:
                AutoSpeakerCounter++;
                AutoSpeakerText.setText(Integer.toString(AutoSpeakerCounter));
                //MainActivity.editMatchData(0, 1, MainActivity.getButtonData()[0][1] + 1);\
                MainActivity.AutoSpeaker++;

                break;

            case R.id.AutoSpeakerDecrease:
                if(AutoSpeakerCounter > 0) {
                    AutoSpeakerCounter--;
                    AutoSpeakerText.setText(Integer.toString(AutoSpeakerCounter));
                    //MainActivity.editMatchData(0, 1, MainActivity.getButtonData()[0][1] - 1);
                    MainActivity.AutoSpeaker--;
                } break;

            case R.id.NotesAcquiredIncrease:
                AutoNoteCounter++;
                AutoNoteText.setText(Integer.toString(AutoNoteCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                MainActivity.AutoNote++;

                break;

            case R.id.NotesAcquiredDecrease:
                if(AutoNoteCounter > 0) {
                    AutoNoteCounter--;
                    AutoNoteText.setText(Integer.toString(AutoNoteCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                    MainActivity.AutoNote--;
                } break;



        }
    }

    public void onResume() {
        super.onResume();

        AutoAMPText.setText(Integer.toString(AutoAMPCounter));
        AutoSpeakerText.setText(Integer.toString(AutoSpeakerCounter));

        AutoNoteText.setText(Integer.toString(AutoNoteCounter));


    }
}
//he he ha ha