package poltekpos.ac.id.e_kuisoner.api;

import poltekpos.ac.id.e_kuisoner.model.ResponsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {

    @GET("read.php")
    Call<ResponsModel> getPertanyaan();

}
