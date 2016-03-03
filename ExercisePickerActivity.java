package apc.softdev.befit;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExercisePickerActivity extends Activity {


    String[] categoryValues = new String[] { "Endurance", "Strength", "Balance", "Flexibility"};
    String[] endurance = new String[] { "Walking", "Jogging", "Swimming", "Hiking", "Cycling"};
    String[] strength = new String[] { "Squat", "One-Arm Row", "Modified Push-up", "Shoulder Press", "Plank"};
    String[] balance = new String[] { "One-Legged Balance", "Leg Swings", "One-Legged Clock with Arms", "One-Legged Squat", "Single-Leg Dead Lift"};
    String[] flexibility = new String[] { "Neck Rotation", "Neck Stretch", "Sideways Bend", "Calf Stretch", "Shoulder and Upper Arm Stretch"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_picker);

        Spinner category = (Spinner)findViewById(R.id.categoryS);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < categoryValues.length; ++i) {
            list.add(categoryValues[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
        category.setAdapter(adapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final ArrayList<String> list = new ArrayList<String>();

                Spinner exercise = (Spinner)findViewById(R.id.exerciseS);
                if(position == 0){
                    for (int i = 0; i < endurance.length; ++i) {
                        list.add(endurance[i]);
                    }

                    EnduranceFragment f = new EnduranceFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.exerciseFL, f)
                            .commit();

                    ArrayAdapter<String> adapterFT = new ArrayAdapter(ExercisePickerActivity.this, android.R.layout.simple_spinner_dropdown_item, list);
                    exercise.setAdapter(adapterFT);
                    exercise.setOnItemSelectedListener(f);
                    adapterFT.notifyDataSetChanged();
//                    exercise.setOnItemSelectedListener(this);

                }
                else if(position == 1){
                    for (int i = 0; i < strength.length; ++i) {
                        list.add(strength[i]);
                    }
                    ArrayAdapter<String> adapterDST = new ArrayAdapter(ExercisePickerActivity.this, android.R.layout.simple_spinner_dropdown_item, list);
                    exercise.setAdapter(adapterDST);
                    adapterDST.notifyDataSetChanged();
                }
                else if(position == 2){
                    for (int i = 0; i < balance.length; ++i) {
                        list.add(balance[i]);
                    }
                    ArrayAdapter<String> adapterDST = new ArrayAdapter(ExercisePickerActivity.this, android.R.layout.simple_spinner_dropdown_item, list);
                    exercise.setAdapter(adapterDST);
                    adapterDST.notifyDataSetChanged();
                }
                else if(position == 3){
                    for (int i = 0; i < flexibility.length; ++i) {
                        list.add(flexibility[i]);
                    }
                    ArrayAdapter<String> adapterDST = new ArrayAdapter(ExercisePickerActivity.this, android.R.layout.simple_spinner_dropdown_item, list);
                    exercise.setAdapter(adapterDST);
                    adapterDST.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }

    public void cancelOnClick(View v){
        finish();
    }

    public static class EnduranceFragment extends Fragment implements AdapterView.OnItemSelectedListener {
        LinearLayout walking;
        LinearLayout jogging;

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            walking = (LinearLayout)view.findViewById(R.id.endurance_walking);
            jogging = (LinearLayout)view.findViewById(R.id.endurance_jogging);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.endurance_fragment, container, false);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            walking.setVisibility( (position == 0) ? View.VISIBLE : View.GONE );
            jogging.setVisibility( (position == 1) ? View.VISIBLE : View.GONE );

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    }
}



