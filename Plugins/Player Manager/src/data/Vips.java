/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author macbookpro
 */
public class Vips {
    
    private String groupVip;
    private String sapphireTime;
    private String esmeraldaTime;
    private String nome;
    private String diamanteTime;

    public Vips(String groupVip, String sapphireTime, String esmeraldaTime, String diamanteTime, String nome) {
        this.groupVip = groupVip;
        this.sapphireTime = sapphireTime;
        this.esmeraldaTime = esmeraldaTime;
        this.diamanteTime = diamanteTime;
        this.nome = nome;
    }

    public String getGroupVip() {
        return groupVip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGroupVip(String groupVip) {
        this.groupVip = groupVip;
    }

    public String getSapphireTime() {
        return sapphireTime;
    }

    public void setSapphireTime(String sapphireTime) {
        this.sapphireTime = sapphireTime;
    }

    public String getEsmeraldaTime() {
        return esmeraldaTime;
    }

    public void setEsmeraldaTime(String esmeraldaTime) {
        this.esmeraldaTime = esmeraldaTime;
    }

    public String getDiamanteTime() {
        return diamanteTime;
    }

    public void setDiamanteTime(String diamanteTime) {
        this.diamanteTime = diamanteTime;
    }
    
}
