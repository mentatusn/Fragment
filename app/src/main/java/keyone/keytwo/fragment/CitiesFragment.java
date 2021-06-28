package keyone.keytwo.fragment;

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
            textView.setTextSize(45);
            linearLayout.addView(textView);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


}