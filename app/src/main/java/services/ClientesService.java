package services;

import java.util.List;

import model.Clientes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientesService {
    @GET("api/clientes")
    Call<List<Clientes>> listClientes();

    @POST("api/clientes")
    Call<Clientes> inserirNovoCliente(@Body Clientes cliente);
}
