package model;

import java.io.Serializable;
import java.util.Date;

public class MarcarConsulta implements Serializable{

    private Integer mcons_id;
    private Integer mcons_hosp;
    private Integer mcons_cli;
    private Integer mcons_med;
    private Date mcons_data;
    private String mcons_hora;
    private String bnt_mcons;

    //metodo construtor vazio obrigatorio em toda classe que for de implementacao
    public MarcarConsulta(){

    }

    //metodo construtor ja com parametros
    public MarcarConsulta (Integer mcons_id,Integer mcons_hosp,Integer mcons_cli,Integer mcons_med,Date mcons_data,String mcons_hora,String bnt_mcons){
        this.mcons_id = mcons_id;
        this.mcons_hosp = mcons_hosp;
        this.mcons_cli = mcons_cli;
        this.mcons_med = mcons_med;
        this.mcons_data = mcons_data;
        this.mcons_hora = mcons_hora;
        this.bnt_mcons = bnt_mcons;
    }


    public Integer getMcons_id() {
        return mcons_id;
    }


    public Integer getMcons_hosp() {
        return mcons_hosp;
    }

    public Integer getMcons_cli() {
        return mcons_cli;
    }

    public Integer getMcons_med() {
        return mcons_med;
    }


    public Date getMcons_data() {
        return mcons_data;
    }

    public String getMcons_hora() {
        return mcons_hora;
    }

    public String bnt_mcons() {
        return bnt_mcons;
    }

}
