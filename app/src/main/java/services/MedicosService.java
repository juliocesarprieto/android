package services;

import java.util.List;

import model.Medicos;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MedicosService {

    @GET("api/medicos")
    Call<List<Medicos>> listMedicos();
}
