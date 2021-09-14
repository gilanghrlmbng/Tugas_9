package com.e.cobanavbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendFragment extends Fragment implements TrendAdapter.itemCLickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private ArrayList<TrendModel> Trendlist = new ArrayList<>();
    public TrendFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrendFragment newInstance(String param1, String param2) {
        TrendFragment fragment = new TrendFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_trending, container, false);
        ListData();
        AdapterRecyclerview(v);
        return v;
    }
    private void AdapterRecyclerview(View v){
        RecyclerView recyclerView = v.findViewById(R.id.rcv_trend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        TrendAdapter trendAdapter = new TrendAdapter(Trendlist,this);
        recyclerView.setAdapter(trendAdapter);
    }
    private void ListData(){
        Trendlist.add(new TrendModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/ilustrasi-mayat_20180826_182838.jpg","Operator Karaoke Ditemukan Tewas di Kamar Wisma Semarang","https://www.tribunnews.com/regional/2021/09/14/operator-karaoke-ditemukan-tewas-di-kamar-wisma-semarang"));
        Trendlist.add(new TrendModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/update-kasus-asusila-youtuber-di-aceh-pria-inisial-ma-jadi-tersangka-terancam-dicambuk-45-kali.jpg","Update Kasus Asusila YouTuber di Aceh, Pria Inisial MA Jadi Tersangka, Terancam Dicambuk 45 Kali","https://www.tribunnews.com/regional/2021/09/14/update-kasus-asusila-youtuber-di-aceh-pria-inisial-ma-jadi-tersangka-terancam-dicambuk-45-kali"));
        Trendlist.add(new TrendModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/pelajar-di-jepang-nih2.jpg","Sediakan Tiket Pesawat Gratis Bagi Murid Berprestasi","https://www.tribunnews.com/internasional/2021/09/14/sekolah-bahasa-jepang-pandan-college-sediakan-tiket-pesawat-gratis-bagi-murid-berprestasi"));
    }

    @Override
    public void onItemCLick(TrendModel trendModel) {
        Fragment fragment = WebviewFragment.newInstance(trendModel.getUrlwebview());

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment,"webview fragment");
/*        fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("today_fragment"));
        fragmentTransaction.replace(R.id.fragment_container,fragment);*/
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}