/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.istic.sir.util;

import javax.activation.DataSource;
import javax.mail.BodyPart;

/**
 *
 * @author soumabkar
 */
public class Fichier {
    String cheminFichier;
    String nomFichier;
    DataSource dataSource;
    BodyPart bodyPart;

    public Fichier() {
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Fichier(String cheminFichier, String nomFichier, DataSource dataSource, BodyPart bodyPart) {
        this.cheminFichier = cheminFichier;
        this.nomFichier = nomFichier;
        this.dataSource = dataSource;
        this.bodyPart = bodyPart;
    }

   
    
    
}
