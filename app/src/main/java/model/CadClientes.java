package model;

import java.io.Serializable;
import java.util.Date;

public class CadClientes implements Serializable{

    private Integer cli_id;
    private String cli_nome;
    private Integer cli_cpf;
    private String cli_end;
    private String cli_tel;
    private Date cli_dt_nasc;
    private String bnt_cadcli;

    //metodo construtor vazio obrigatorio em toda classe que for de implementacao
    public CadClientes(){

    }

    //metodo construtor ja com parametros
    public CadClientes (Integer cli_id,String cli_nome,Integer cli_cpf,String cli_end,String cli_tel,Date cli_dt_nasc,String bnt_cadcli){
        this.cli_id = cli_id;
        this.cli_nome = cli_nome;
        this.cli_cpf = cli_cpf;
        this.cli_end = cli_end;
        this.cli_tel = cli_tel;
        this.cli_dt_nasc = cli_dt_nasc;
        this.bnt_cadcli = bnt_cadcli;
    }


    public Integer getCli_id() {
        return cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public Integer getCli_cpf() {
        return cli_cpf;
    }

    public String getCli_end() {
        return cli_end;
    }

    public String getCli_tel() {
        return cli_tel;
    }

    public Date getCli_dt_nasc() {
        return cli_dt_nasc;
    }

    public String getBnt_cadcli() {
        return bnt_cadcli;
    }
}
