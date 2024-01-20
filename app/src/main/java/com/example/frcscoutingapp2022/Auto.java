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
    private TextView AutoUpperConeText;
    private TextView AutoUpperCubeText;

    //initialize Middle node text views
    private TextView AutoMiddleConeText;


    //counter variables
    private int AutoUpperConeCounter = 0;
    private int AutoUpperCubeCounter = 0;

    private int AutoMiddleConeCounter = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto, container, false);



        //Define TextViews
        AutoUpperConeText = (TextView) view.findViewById(R.id.AutoAMPCounter);
        AutoUpperCubeText = (TextView) view.findViewById(R.id.AutoSpeakerCounter);

        AutoMiddleConeText = (TextView) view.findViewById(R.id.NotesAcquiredCounter);



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
                AutoUpperConeCounter++;
                AutoUpperConeText.setText(Integer.toString(AutoUpperConeCounter));
                //MainActivity.editMatchData(0, 0, MainActivity.getButtonData()[0][0] + 1);
                MainActivity.AutoUpperCone++;
                break;
            case R.id.AutoAMPDecrease:
                if(AutoUpperConeCounter > 0) {
                    AutoUpperConeCounter--;
                    AutoUpperConeText.setText(Integer.toString(AutoUpperConeCounter));
                    //MainActivity.editMatchData(0, 0, MainActivity.getButtonData()[0][0] - 1);
                    MainActivity.AutoUpperCone--;
                } break;

            case R.id.AutoUpperCubeIncrease:
                AutoUpperCubeCounter++;
                AutoUpperCubeText.setText(Integer.toString(AutoUpperCubeCounter));
                //MainActivity.editMatchData(0, 1, MainActivity.getButtonData()[0][1] + 1);\
                MainActivity.AutoUpperCube++;

                break;

            case R.id.AutoUpperCubeDecrease:
                if(AutoUpperCubeCounter > 0) {
                    AutoUpperCubeCounter--;
                    AutoUpperCubeText.setText(Integer.toString(AutoUpperCubeCounter));
                    //MainActivity.editMatchData(0, 1, MainActivity.getButtonData()[0][1] - 1);
                    MainActivity.AutoUpperCube--;
                } break;

            case R.id.AutoMiddleConeIncrease:
                AutoMiddleConeCounter++;
                AutoMiddleConeText.setText(Integer.toString(AutoMiddleConeCounter));
                //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] + 1);
                MainActivity.AutoMiddleCone++;

                break;

            case R.id.AutoMiddleConeDecrease:
                if(AutoMiddleConeCounter > 0) {
                    AutoMiddleConeCounter--;
                    AutoMiddleConeText.setText(Integer.toString(AutoMiddleConeCounter));
                    //MainActivity.editMatchData(0, 2, MainActivity.getButtonData()[0][2] - 1);
                    MainActivity.AutoMiddleCone--;
                } break;



        }
    }

    public void onResume() {
        super.onResume();

        AutoUpperConeText.setText(Integer.toString(AutoUpperConeCounter));
        AutoUpperCubeText.setText(Integer.toString(AutoUpperCubeCounter));

        AutoMiddleConeText.setText(Integer.toString(AutoMiddleConeCounter));


    }
}