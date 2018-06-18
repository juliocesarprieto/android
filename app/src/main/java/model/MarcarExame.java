package model;

import java.io.Serializable;
import java.util.Date;

public class MarcarExame implements Serializable{
    private Integer mexa_id;
    private String mexa_nome;
    private Integer mexa_hosp;
    private Integer mexa_cli;
    private Integer mexa_med;
    private String mexa_obs;
    private Date mexa_data;
    private String mexa_hora;
    private String bnt_mexa;

    //metodo construtor vazio obrigatorio em toda classe que for de implementacao
    public MarcarExame(){

    }

    //metodo construtor ja com parametros
    public MarcarExame (Integer mexa_id,String mexa_nome,Integer mexa_hosp,Integer mexa_cli,Integer mexa_med,String mexa_obs,Date mexa_data,String mexa_hora,String bnt_mexa){
        this.mexa_id = mexa_id;
        this.mexa_nome = mexa_nome;
        this.mexa_hosp = mexa_hosp;
        this.mexa_cli = mexa_cli;
        this.mexa_med = mexa_med;
        this.mexa_obs = mexa_obs;
        this.mexa_data = mexa_data;
        this.mexa_hora = mexa_hora;
        this.bnt_mexa = bnt_mexa;
    }


    public Integer getMexa_id() {
        return mexa_id;
    }

    public String getMexa_nome() {
        return mexa_nome;
    }

    public Integer getMexa_hosp() {
        return mexa_hosp;
    }

    public Integer getMexa_cli() {
        return mexa_cli;
    }

    public Integer getMexa_med() {
        return mexa_med;
    }

    public String getMexa_obs() {
        return mexa_obs;
    }

    public Date getMexa_data() {
        return mexa_data;
    }

    public String getMexa_hora() {
        return mexa_hora;
    }

    public String getBnt_mexa() {
        return bnt_mexa;
    }
}
