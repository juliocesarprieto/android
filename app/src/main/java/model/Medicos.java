package model;

import java.time.LocalDate;

public class Medicos {

    private Integer medId;
    private String medNome;
    private String medEspec;
    private Integer medCrm;
    private String medEndereco;
    private String medDtNasc;
    private Hospitais hospitais;

    public Medicos(Integer medId, String medNome, String medEspec, Integer medCrm, String medEndereco, String medDtNasc, Hospitais hospitais) {
        this.medId = medId;
        this.medNome = medNome;
        this.medEspec = medEspec;
        this.medCrm = medCrm;
        this.medEndereco = medEndereco;
        this.medDtNasc = medDtNasc;
        this.hospitais = hospitais;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public String getMedNome() {
        return medNome;
    }

    public void setMedNome(String medNome) {
        this.medNome = medNome;
    }

    public String getMedEspec() {
        return medEspec;
    }

    public void setMedEspec(String medEspec) {
        this.medEspec = medEspec;
    }

    public Integer getMedCrm() {
        return medCrm;
    }

    public void setMedCrm(Integer medCrm) {
        this.medCrm = medCrm;
    }

    public String getMedEndereco() {
        return medEndereco;
    }

    public void setMedEndereco(String medEndereco) {
        this.medEndereco = medEndereco;
    }

    public String getMedDtNasc() {
        return medDtNasc;
    }

    public void setMedDtNasc(String medDtNasc) {
        this.medDtNasc = medDtNasc;
    }

    public Hospitais getHospitais() {
        return hospitais;
    }

    public void setHospitais(Hospitais hospitais) {
        this.hospitais = hospitais;
    }

    public String toString(){
        return medNome;
    }
}
