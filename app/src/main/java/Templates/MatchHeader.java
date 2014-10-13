package Templates;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.boomertruong.footballnow.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MatchHeader.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MatchHeader#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchHeader extends Fragment {

    private static final String TEAM_ONE = "team_one_left_id";
    private static final String T1_CREST_RES_ID = "t1_crest_id";

    private static final String TEAM_TWO = "team_two_right_id";
    private static final String T2_CREST_RES_ID = "t2_crest_id";



    private OnFragmentInteractionListener mListener;


    /**
     *
      * @param teamOne
     * @param t1CrestID
     * @param teamTwo
     * @param t2CrestID
     * @return
     */
    public static MatchHeader newInstance(String teamOne, int t1CrestID, String teamTwo, int t2CrestID) {
        MatchHeader fragment = new MatchHeader();
        Bundle args = new Bundle();
        args.putString(TEAM_ONE,teamOne);
        args.putString(TEAM_TWO,teamTwo);
        args.putInt(T1_CREST_RES_ID, t1CrestID);
        args.putInt(T2_CREST_RES_ID,t2CrestID);
        fragment.setArguments(args);
        return fragment;
    }

    public MatchHeader() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_match_header, container, false);
        Log.d("MatchHeader", "onCreateView adding team 1 and 2");
        Bundle b = getArguments();
        TeamSheet t1 = TeamSheet.newInstance(b.getString(TEAM_ONE),b.getInt(T1_CREST_RES_ID));
        TeamSheet t2 = TeamSheet.newInstance(b.getString(TEAM_TWO),b.getInt(T2_CREST_RES_ID));


        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.team_left_container, t1, "TEAM_ONE").commit();


        fm.beginTransaction().replace(R.id.team_right_container, t2, "TEAM_TWO").commit();


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
