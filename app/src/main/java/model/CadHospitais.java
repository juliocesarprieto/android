package model;

import java.io.Serializable;
import java.util.Date;

public class CadHospitais implements Serializable {

    private Integer hosp_id;
    private String hosp_nome;
    private Integer hosp_cnpj;
    private String hosp_end;
    private String hosp_tel;
    private String bnt_cadHosp;

    //metodo construtor vazio obrigatorio em toda classe que for de implementacao
    public CadHospitais(){

    }

    //metodo construtor ja com parametros
    public CadHospitais (Integer hosp_id,String hosp_nome,Integer hosp_cnpj,String hosp_end,String hosp_tel,String bnt_cadHosp){
        this.hosp_id = hosp_id;
        this.hosp_nome = hosp_nome;
        this.hosp_cnpj = hosp_cnpj;
        this.hosp_end = hosp_end;
        this.hosp_tel = hosp_tel;
        this.bnt_cadHosp = bnt_cadHosp;
    }


    public Integer getHosp_id() {
        return hosp_id;
    }

    public String getHosp_nome() {
        return hosp_nome;
    }

    public Integer getHosp_cnpj() {
        return hosp_cnpj;
    }

    public String getHosp_end() {
        return hosp_end;
    }

    public String getHosp_tel() {
        return hosp_tel;
    }

    public String getBnt_cadHosp() {
        return bnt_cadHosp;
    }
}
