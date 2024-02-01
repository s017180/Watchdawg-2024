//2022 Mark and Micheal(Officer). Excel Oliver(The Excel God)
//2023 Micheal, Andy, and Simon(Oliver II). Excel Oliver(The Excel God)(Officer)
//2024 Simon(Officer)(Oliver II) and Luka. Excel Ivan. UI design Mason

package com.example.frcscoutingapp2022;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static Bitmap bitmap;
    private static boolean qrReady = false;

    //Set up Varibles
    public static String teamNumber;
    public static String matchNumber;
    public static String scoutName;
    public static int alliance = 0;
    public static EditText teamNumText;
    public static EditText matchNumText;
    public static EditText scoutNameText;

    //Varibles we need but I don't know what they do
    public static int[][] buttonData;
    public static int[] checkBoxData;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private save saveFragment;

    //Defense Varibles
    public static int playedDefense = 0;
    public static int defendedOn = 0;
    public static String defendedOnByNumber = "";

    //Endgame Varibles
    public static int Parking = 0;
    public static int Climb = 0;
    public static int penalty = 0;
    public static int deadBot = 0;
    public static String trapScored;
    public static String harmony;
    public static String additionalNotes;

    //Auto Varibles
    public static int AutoAMP = 0;
    public static int AutoSpeaker = 0;
    public static int AutoNote = 0;
    public static int leave = 0;


    //Teleop Varibles
    public static int TeleopAmpScored = 0;
    public static int TeleopAmpMissed = 0;
    public static int TeleopSpeakerScored = 0;
    public static int TeleopSpeakerMissed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        //Makes Pages work I think though I don't know how
        VPadapter vpAdapter = new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        vpAdapter.addFragment(new Auto(), "Auto");
        vpAdapter.addFragment(new Teleop(), "Teleop");
        vpAdapter.addFragment(new endgame(), "Endgame");
        vpAdapter.addFragment(new save(), "Save");
        viewPager.setAdapter(vpAdapter);

        //Some Set up things
        teamNumText = (EditText) findViewById(R.id.teamNum);
        matchNumText = (EditText) findViewById(R.id.matchNum);
        scoutNameText = (EditText) findViewById(R.id.name);

        //defense
        playedDefense = 0;
        defendedOn = 0;

        //Endgame
        Parking = 0;
        Climb = 0;
        penalty = 0;
        deadBot = 0;

        //Auto
        leave = 0;
        AutoAMP = 0;
        AutoSpeaker = 0;
        AutoNote = 0;

        //Teleop
        TeleopAmpScored = 0;
        TeleopAmpMissed = 0;
        TeleopSpeakerScored = 0;
        TeleopSpeakerMissed = 0;





    }

    public static void editMatchData(int ind0, int ind1, int value) {
        buttonData[ind0][ind1] = value;
    }

    public void onCheckBoxClicked(View view) {
        // Is view checked
        boolean checked = ((CheckBox) view).isChecked();

        // Check which one clicked
        switch (view.getId()) {
            case R.id.playedDefenseCheckBox:
                //MainActivity.checkBoxData[2] = checked ? 1 : 0;
                MainActivity.playedDefense = checked ? 1 : 0;

                break;
            case R.id.GotDefendedCheckBox:
                //MainActivity.checkBoxData[3] = checked ? 1 : 0;
                MainActivity.defendedOn = checked ? 1 : 0;

                break;


            case R.id.LeaveCheckBox:
                //MainActivity.checkBoxData[16] = checked ? 1 : 0;
                MainActivity.leave = checked ? 1 : 0;

                break;
            case R.id.penalized:
                //MainActivity.checkBoxData[17] = checked ? 1 : 0;
                MainActivity.penalty = checked ? 1 : 0;

                break;
            case R.id.deadBot:
                //MainActivity.checkBoxData[18] = checked ? 1 : 0;
                MainActivity.deadBot = checked ? 1 : 0;

                break;

        }


    }

    public void onRadioButtonClicked(View view) {
        RadioGroup EndgameRadioGroup = (RadioGroup)findViewById(R.id.EndgameRadioGroup);
        RadioGroup AutoRadioGroup = (RadioGroup)findViewById(R.id.AutoRadioGroup);

        //run all radio buttons
        switch (view.getId()) {
            case R.id.blue:
                MainActivity.alliance = 1;
                System.out.println(MainActivity.alliance);
                break;

            case R.id.red:
                MainActivity.alliance = 0;
                System.out.println(MainActivity.alliance);
                break;


            case R.id.Climb:
                if(MainActivity.Climb ==1){
                    EndgameRadioGroup.clearCheck();
                    MainActivity.Climb =0;
                }
                else{
                MainActivity.Climb =1;
                MainActivity.Parking =0;
                System.out.println(MainActivity.Climb);
                System.out.println(MainActivity.Parking);}
                break;
            case R.id.Parking:
                if(MainActivity.Parking==1){
                    EndgameRadioGroup.clearCheck();
                    MainActivity.Parking=0;
                }
                else{
                MainActivity.Climb =0;
                MainActivity.Parking =1;
                System.out.println(MainActivity.Climb);
                System.out.println(MainActivity.Parking);}
                break;
        }

        boolean checked = ((RadioButton) view).isChecked();

//
//    public void updateTeamAndMatchNum() {
//        teamNumber = Integer.parseInt(((EditText)findViewById(R.id.teamNum)).getText().toString());
//        matchNumber = Integer.parseInt(((EditText)findViewById(R.id.matchNum)).getText().toString());
//    }
    }
}
