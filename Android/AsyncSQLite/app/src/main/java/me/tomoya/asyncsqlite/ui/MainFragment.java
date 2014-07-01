package me.tomoya.asyncsqlite.ui;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;
import me.tomoya.asyncsqlite.app.R;
import me.tomoya.asyncsqlite.utils.AsyncDBManager;

/**
 * Created by usr0200379 on 2014/06/03.
 */
public class MainFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button asyncButton;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MainFragment newInstance(int sectionNumber) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        // パッケージマネージャーの作成
        final PackageManager packageManager = getActivity().getPackageManager();
        // Async Button
        asyncButton = (Button) rootView.findViewById(R.id.async_button);
        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("test", "--- Async Button Click in ---");

                AsyncDBManager.insert(packageManager);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        AsyncDBManager.exit();
    }
}
