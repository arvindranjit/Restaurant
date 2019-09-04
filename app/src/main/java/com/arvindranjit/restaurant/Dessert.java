package com.arvindranjit.restaurant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Dessert.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Dessert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dessert extends Fragment {

    private RecyclerView recyclerView;
    private int[] images = { R.drawable.d1 , R.drawable.d2, R.drawable.d3,R.drawable.d4, R.drawable.d5, R.drawable.d6  };
    private String[] names = {"Cold Coffee", "Chocolate Milkshake","Chocolate Brownie","Vanilla Ice Cream","Chocolate Ice Cream","Choco Lava Cake" };
    private int[] prices = {79,99,129,59,59,159};
    private int[] quantity = {1,1,1,1,1,1};
    private Button buttonplus;
    private Button buttonminus;
    private Button buttonaddtocart;







    private RecyclerAdapterS adapter;
    private RecyclerView.LayoutManager layoutManager;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Dessert() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dessert.
     */
    // TODO: Rename and change types and number of parameters
    public static Dessert newInstance(String param1, String param2) {
        Dessert fragment = new Dessert();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity().getBaseContext());

        adapter = new RecyclerAdapterS(images,names,prices,'d',quantity);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View myView = inflater.inflate(R.layout.fragment_starters, container, false);
        recyclerView = (RecyclerView) myView.findViewById(R.id.recyclerstarter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setAdapter(adapter);

        buttonminus = myView.findViewById(R.id.buttonminus);
        buttonaddtocart = myView.findViewById(R.id.buttonaddtocart);
        buttonplus = myView.findViewById(R.id.buttonplus);


        adapter.setOnItemClickListener(new RecyclerAdapterS.OnItemClickListener() {
            @Override
            public void onAddClick(int position) {

                Global.getInstance().additem(images[position],names[position],quantity[position],prices[position]);
                quantity[position] = 1;
                adapter.notifyItemChanged(position);


            }

            @Override
            public void onMinusClick(int position) {
                if(quantity[position]>=2) {
                    quantity[position] = quantity[position] - 1;
                    adapter.notifyItemChanged(position);
                }

            }

            @Override
            public void onPlusClick(int position) {

                quantity[position] = quantity[position] + 1;
                adapter.notifyItemChanged(position);

            }




        });


        /*

        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        }); */



        // Inflate the layout for this fragment
        return myView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
