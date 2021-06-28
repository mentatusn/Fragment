package keyone.keytwo.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CitiesFragment extends Fragment {


    private boolean isLandscape;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        if(isLandscape){
            showLandCoatOfArms(0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout linearLayout) {
        String[] cities = getResources().getStringArray(R.array.cities);
        for(int i=0;i<cities.length;i++){
            TextView textView = new TextView(getContext());
            textView.setText(cities[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isLandscape){
                        showLandCoatOfArms(finalI);
                    }else{
                        showPortCoatOfArms(finalI);
                    }

                }
            });
            textView.setTextSize(30);
            linearLayout.addView(textView);
        }
    }

    private void showLandCoatOfArms(int index) {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(index);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(
                R.id.coat_of_arms_land_container,coatOfArmsFragment).commit();
    }

    private void showPortCoatOfArms(int finalI) {
        Intent intent = new Intent(getActivity(),CoatOFArmsPortActivity.class);
        intent.putExtra(CoatOfArmsFragment.KEY_INDEX, finalI);
        startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


}