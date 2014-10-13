package Templates;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boomertruong.footballnow.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TeamSheet extends Fragment {

    private static final String TEAM_NAME_FC = "team_name_fc";
    private static final String CLUB_CREST_ID   = "club_crest_id";




    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param clubname: name of team
     * @param crestid: resource id of crest for club
     * @return A new instance of fragment TeamSheet.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamSheet newInstance(String clubname, int crestid) {
        TeamSheet fragment = new TeamSheet();
        Bundle args = new Bundle();
        args.putString(TEAM_NAME_FC,clubname);
        args.putInt(CLUB_CREST_ID,crestid);
        fragment.setArguments(args);
        return fragment;
    }

    public TeamSheet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_team_sheet, container, false);
        Activity context = getActivity();
        Bundle b = getArguments();
        TextView mTeamNameView = ButterKnife.findById(v,R.id.team_name_id);
        mTeamNameView.setText(b.getString(TEAM_NAME_FC,context.getString(R.string.default_team_name)));


        ImageView mTeamCrest = ButterKnife.findById(v,R.id.team_crest_id);

        Picasso.with(context)
                .load(b.getInt(CLUB_CREST_ID))
                .fit()
                .into(mTeamCrest);


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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
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
