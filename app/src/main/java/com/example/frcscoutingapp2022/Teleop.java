package com.example.frcscoutingapp2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Teleop extends Fragment implements View.OnClickListener{

    //initialize variables



    //Initialize upper node text views
    private TextView TeleopScoredAMPText;
    private TextView TeleopMissedAMPText;

    //initialize middle node text views
    private TextView TeleopMissedSpeakerText;
    private TextView TeleopScoredSpeakerText;

    //counter variables
    private int TeleopScoredAMPCounter = 0;
    private int TeleopMissedAMPCounter = 0;
    private int TeleopScoredSpeakerCounter = 0;
    private int TeleopMissedSpeakerCounter = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_teleop, container, false);


        //Define TextViews
        TeleopScoredAMPText = (TextView) view.findViewById(R.id.TeleopScoredAMPCounter);
        TeleopMissedAMPText = (TextView) view.findViewById(R.id.TeleopMissedAMPCounter);

        TeleopScoredSpeakerText = (TextView) view.findViewById(R.id.TeleopScoredSpeakerCounter);
        TeleopMissedSpeakerText = (TextView) view.findViewById(R.id.TeleopMissedSpeakerCounter);






        //Upper buttons
        view.findViewById(R.id.TeleopScoredAMPIncrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopScoredAMPDecrease).setOnClickListener(this);

        view.findViewById(R.id.TeleopMissedAMPIncrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopMissedAMPDecrease).setOnClickListener(this);

        //Middle buttons
        view.findViewById(R.id.TeleopScoredSpeakerIncrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopScoredSpeakerIncrease).setOnClickListener(this);

        view.findViewById(R.id.TeleopMissedSpeakerIncrease).setOnClickListener(this);
        view.findViewById(R.id.TeleopMissedSpeakerDecrease).setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.TeleopScoredAMPIncrease:
                System.out.println(MainActivity.checkBoxData);
                TeleopScoredAMPCounter++;
                TeleopScoredAMPText.setText(Integer.toString(TeleopScoredAMPCounter));
                //MainActivity.editMatchData(1, 0, MainActivity.getButtonData()[0][0] + 1);
                MainActivity.TeleopAmpScored++;
                break;

            case R.id.TeleopScoredAMPDecrease:
                if(TeleopScoredAMPCounter > 0) {
                    TeleopScoredAMPCounter--;
                    TeleopScoredAMPText.setText(Integer.toString(TeleopScoredAMPCounter));
                    //MainActivity.editMatchData(1, 0, MainActivity.getButtonData()[0][0] - 1);
                    MainActivity.TeleopAmpScored--;
                } break;

            case R.id.TeleopMissedAMPIncrease:
                TeleopMissedAMPCounter++;
                TeleopMissedAMPText.setText(Integer.toString(TeleopMissedAMPCounter));
                //MainActivity.editMatchData(1, 1, MainActivity.getButtonData()[0][1] + 1);
                MainActivity.TeleopAmpMissed++;
                break;

            case R.id.TeleopMissedAMPDecrease:
                if(TeleopMissedAMPCounter > 0) {
                    TeleopMissedAMPCounter--;
                    TeleopMissedAMPText.setText(Integer.toString(TeleopMissedAMPCounter));
                    //MainActivity.editMatchData(1, 1, MainActivity.getButtonData()[0][1] - 1);
                    MainActivity.TeleopAmpMissed--;
                } break;

            case R.id.TeleopScoredSpeakerIncrease:
                TeleopScoredSpeakerCounter++;
                TeleopScoredSpeakerText.setText(Integer.toString(TeleopScoredSpeakerCounter));
                //MainActivity.editMatchData(1, 2, MainActivity.getButtonData()[0][2] + 1);
                MainActivity.TeleopSpeakerScored++;
                System.out.println(MainActivity.TeleopSpeakerScored);
                break;

            case R.id.TeleopScoredSpeakerDecrease:
                if(TeleopScoredSpeakerCounter > 0) {
                    TeleopScoredSpeakerCounter--;
                    TeleopScoredSpeakerText.setText(Integer.toString(TeleopScoredSpeakerCounter));
                    //MainActivity.editMatchData(1, 2, MainActivity.getButtonData()[0][2] - 1);
                    MainActivity.TeleopSpeakerScored--;
                    System.out.println(MainActivity.TeleopSpeakerScored);

                } break;

            case R.id.TeleopMissedSpeakerIncrease:
                TeleopMissedSpeakerCounter++;
                TeleopMissedSpeakerText.setText(Integer.toString(TeleopMissedSpeakerCounter));
                //MainActivity.editMatchData(1, 3, MainActivity.getButtonData()[0][3] + 1);
                MainActivity.TeleopSpeakerMissed++;
                break;

            case R.id.TeleopMissedSpeakerDecrease:
                if(TeleopMissedSpeakerCounter > 0) {
                    TeleopMissedSpeakerCounter--;
                    TeleopMissedSpeakerText.setText(Integer.toString(TeleopMissedSpeakerCounter));
                    //MainActivity.editMatchData(1, 3, MainActivity.getButtonData()[0][3] - 1);
                    MainActivity.TeleopSpeakerMissed--;
                } break;


        }
    }

    public void onResume(){
        super.onResume();

        TeleopScoredAMPText.setText(Integer.toString(TeleopScoredAMPCounter));
        TeleopMissedAMPText.setText(Integer.toString(TeleopMissedAMPCounter));
        TeleopScoredSpeakerText.setText(Integer.toString(TeleopScoredSpeakerCounter));
        TeleopMissedSpeakerText.setText(Integer.toString(TeleopMissedSpeakerCounter));
    }

    public void clear(){
        TeleopScoredAMPText.setText(Integer.toString(0));
        TeleopMissedAMPText.setText(Integer.toString(0));
        TeleopScoredSpeakerText.setText(Integer.toString(0));
        TeleopMissedSpeakerText.setText(Integer.toString(0));

        TeleopScoredAMPCounter = 0;
        TeleopMissedAMPCounter = 0;

        TeleopScoredSpeakerCounter = 0;
        TeleopMissedSpeakerCounter = 0;


    }





}
