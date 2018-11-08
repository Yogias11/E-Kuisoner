package poltekpos.ac.id.e_kuisoner.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import poltekpos.ac.id.e_kuisoner.R;
import poltekpos.ac.id.e_kuisoner.adapter.QuestionAdapter;
import poltekpos.ac.id.e_kuisoner.api.BaseApiService;
import poltekpos.ac.id.e_kuisoner.api.Server;
import poltekpos.ac.id.e_kuisoner.model.Question;
import poltekpos.ac.id.e_kuisoner.model.ResponsModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.rv_pertanyaan)
    RecyclerView rvPertanyaan;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Question> listPertanyaan = new ArrayList<>();
    ProgressDialog loading;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getActivity()).setTitle(R.string.app_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        loading = new ProgressDialog(getActivity());
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        rvPertanyaan.setLayoutManager(manager);

        refresh();

        return view;

    }

    private void refresh(){
        loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getClient().create(BaseApiService.class);
        Call<ResponsModel> getdata = apiService.getPertanyaan();
        getdata.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                    listPertanyaan = response.body().getResult();

                    adapter = new QuestionAdapter(getActivity(), listPertanyaan);
                    rvPertanyaan.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getActivity(), "Failed to Fetch Data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                loading.dismiss();
                Log.d("RETRO", "FAILED : respon gagal");
                Toast.makeText(getActivity(), "Failed to Connect Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
