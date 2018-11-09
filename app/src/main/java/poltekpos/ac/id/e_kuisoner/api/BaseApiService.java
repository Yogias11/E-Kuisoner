package poltekpos.ac.id.e_kuisoner.api;

import poltekpos.ac.id.e_kuisoner.model.ResponsModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> sendKuesioner(@Field("npm") String npm,
                                   @Field("dosen") String dosen,
                                   @Field("kuesioner") String kuesioner,
                                   @Field("variable") String variable);

    @GET("read.php")
    Call<ResponsModel> getPertanyaan();

}
