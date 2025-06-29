package edu.vit.vtop.navapp.NetworkUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtil {

    public static OkHttpClient getClientInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //                .addInterceptor(interceptor)
        return new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
                .build();
    }
        public static String baseURL = "http://10.0.2.2:80/";
        public static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(getClientInstance())
                .addConverterFactory(GsonConverterFactory.create()).build();

        public static NetworkAPIs networkAPI = retrofit.create(NetworkAPIs.class);

}
