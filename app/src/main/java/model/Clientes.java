package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Clientes implements Serializable{

    private Integer cliId;
    private String cliNome;
    private Integer cliCpf;
    private String cliEnd;
    private Integer cliTel;
    private String cliDtNasc;


    public Clientes(){
    }

    public Clientes(Integer cliId, String cliNome, Integer cliCpf, String cliEnd, Integer cliTel, String cliDtNasc) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliEnd = cliEnd;
        this.cliTel = cliTel;
        this.cliDtNasc = cliDtNasc;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public Integer getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(Integer cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliEnd() {
        return cliEnd;
    }

    public void setCliEnd(String cliEnd) {
        this.cliEnd = cliEnd;
    }

    public Integer getCliTel() {
        return cliTel;
    }

    public void setCliTel(Integer cliTel) {
        this.cliTel = cliTel;
    }

    public String getCliDtNasc() {
        return cliDtNasc;
    }

    public void setCliDtNasc(String cliDtNasc) {
        this.cliDtNasc = cliDtNasc;
    }

    public String toString(){
        return cliNome;
    }

}
