package services;

import java.util.List;
import model.MarcarConsulta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MarcarConsultasService {

    @GET("api/consultas")
    Call<List<MarcarConsulta>> listarConsultas();

    @POST("api/consultas")
    Call<MarcarConsulta> marcarConsulta(@Body MarcarConsulta marcarConsulta);

    @DELETE("api/consultas/{idConsulta}")
    Call<Void> deleteConsulta(@Path("idConsulta") Integer idConsulta);
}
