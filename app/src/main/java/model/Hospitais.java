package model;

import java.io.Serializable;
import java.math.BigInteger;

public class Hospitais implements Serializable {

    private Integer hospId;
    private String hospNome;
    private BigInteger hospCnpj;
    private String hospEndereco;
    private Integer hospTel;

    public Hospitais(Integer hospId, String hospNome, BigInteger hospCnpj, String hospEndereco, Integer hospTel) {
        this.hospId = hospId;
        this.hospNome = hospNome;
        this.hospCnpj = hospCnpj;
        this.hospEndereco = hospEndereco;
        this.hospTel = hospTel;
    }

    public Integer getHospId() {
        return hospId;
    }

    public void setHospId(Integer hospId) {
        this.hospId = hospId;
    }

    public String getHospNome() {
        return hospNome;
    }

    public void setHospNome(String hospNome) {
        this.hospNome = hospNome;
    }

    public BigInteger getHospCnpj() {
        return hospCnpj;
    }

    public void setHospCnpj(BigInteger hospCnpj) {
        this.hospCnpj = hospCnpj;
    }

    public String getHospEndereco() {
        return hospEndereco;
    }

    public void setHospEndereco(String hospEndereco) {
        this.hospEndereco = hospEndereco;
    }

    public Integer getHospTel() {
        return hospTel;
    }

    public void setHospTel(Integer hospTel) {
        this.hospTel = hospTel;
    }

    public  String toString(){
        return hospNome;
    }
}
