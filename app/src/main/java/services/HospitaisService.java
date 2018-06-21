package services;

import java.util.List;

import model.Hospitais;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface HospitaisService {

    //Inserir novo hospital
    @POST("api/hospitais")
    Call<Hospitais> inserirNovoHospitais(@Body Hospitais hospitais);

    //Listar hospitais
    @GET("api/hospitais")
    Call<List<Hospitais>> listarHospitais();


    @PUT("api/hospitais")
    Call<Hospitais> atualizarHospitais(@Body Hospitais hospitais);
}
