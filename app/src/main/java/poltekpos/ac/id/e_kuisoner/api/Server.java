package poltekpos.ac.id.e_kuisoner.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {

    private  static  final String base_url = "http://192.168.100.158/kuesioner/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }

}