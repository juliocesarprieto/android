package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class MarcarConsulta implements Serializable{


    private Integer mconsId;
    private String mconsData;
    private String mconsHora;
    private Medicos medico;
    private Clientes cliente;
    private Hospitais hospitais;

    public MarcarConsulta(Integer mconsId, String mconsData, String mconsHora, Medicos medico, Clientes cliente, Hospitais hospitais) {
        this.mconsId = mconsId;
        this.mconsData = mconsData;
        this.mconsHora = mconsHora;
        this.medico = medico;
        this.cliente = cliente;
        this.hospitais = hospitais;
    }


    public Integer getMconsId() {
        return mconsId;
    }

    public void setMconsId(Integer mconsId) {
        this.mconsId = mconsId;
    }

    public String getMconsData() {
        return mconsData;
    }

    public void setMconsData(String mconsData) {
        this.mconsData = mconsData;
    }

    public String getMconsHora() {
        return mconsHora;
    }

    public void setMconsHora(String mconsHora) {
        this.mconsHora = mconsHora;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Hospitais getHospitais() {
        return hospitais;
    }

    public void setHospitais(Hospitais hospitais) {
        this.hospitais = hospitais;
    }
}
