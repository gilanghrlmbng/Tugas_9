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
 * Use the {@link TodayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodayFragment extends Fragment implements TodayAdapter.itemCLickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<DataModel> Datalist = new ArrayList<>();
    private TodayAdapter todayAdapter;
    private RecyclerView recyclerView;

    public TodayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment TodayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodayFragment newInstance(String param1) {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_today, container, false);
        ListData();
        /*recyclerView = v.findViewById(R.id.rcv_dashboard);
        todayAdapter = new TodayAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(todayAdapter);*/
        AdapterRecyclerview(v);
        return v;

    }
    private void AdapterRecyclerview(View v){
        RecyclerView recyclerView = v.findViewById(R.id.rcv_today);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        TodayAdapter todayAdapter = new TodayAdapter(Datalist,this);
        recyclerView.setAdapter(todayAdapter);
    }
    private void ListData(){
        Datalist.add(new DataModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/bentangkan-poster-saat-presiden-jokowi-datang.jpg","10 Mahasiswa UNS yang Bentangkan Poster Sambut Presiden Jokowi Akhirnya Dibebaskan","https://www.tribunnews.com/nasional/2021/09/14/10-mahasiswa-uns-yang-bentangkan-poster-sambut-presiden-jokowi-akhirnya-dibebaskan"));
        Datalist.add(new DataModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/menteri-pertahanan-prabowo-subianto-vg.jpg","POPULER Nasional: Prabowo Didesak Mundur | Varian Baru Corona Masuk Indonesia","https://www.tribunnews.com/nasional/2021/05/04/populer-nasional-prabowo-didesak-mundur-varian-baru-corona-masuk-indonesia"));
        Datalist.add(new DataModel("https://cdn-2.tstatic.net/tribunnews/foto/bank/images/ekspor-kopi-lampung1.jpg","Potensi Pasar Besar, Kemendag Lepas Ekspor 600 Metrik Ton Kopi Lampung ke Mesir","https://www.tribunnews.com/bisnis/2021/09/14/potensi-pasar-besar-kemendag-lepas-ekspor-600-metrik-ton-kopi-lampung-ke-mesir"));
    }

    @Override
    public void onItemCLick(DataModel dataModel) {
        Fragment fragment = WebviewFragment.newInstance(dataModel.getUrlwebview());

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment,"webview_fragment");
/*        fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("today_fragment"));
        fragmentTransaction.replace(R.id.fragment_container,fragment);*/
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}