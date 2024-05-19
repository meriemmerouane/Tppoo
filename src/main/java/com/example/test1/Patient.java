package com.example.test1;



public abstract class Patient {
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String adresse;

    public Patient(String nom, String prenom, String dateNaissance, String lieuNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    public String getLieuNaissance() { return lieuNaissance; }
    public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}
class Enfant extends Patient {
    private String classeEtudes;
    private String telParents;

    public Enfant(String nom, String prenom, String dateNaissance, String lieuNaissance, String adresse, String classeEtudes, String telParents) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.classeEtudes = classeEtudes;
        this.telParents = telParents;
    }

    public String getClasseEtudes() { return classeEtudes; }
    public void setClasseEtudes(String classeEtudes) { this.classeEtudes = classeEtudes; }
    public String getTelParents() { return telParents; }

    public void setTelParents(String telParents) { this.telParents = telParents; }
}
 class Adulte extends Patient {
    private String diplome;
    private String profession;
    private String numPersonnel;

    public Adulte(String nom, String prenom, String dateNaissance, String lieuNaissance, String adresse, String diplome, String profession, String numPersonnel) {
        super(nom, prenom, dateNaissance, lieuNaissance, adresse);
        this.diplome = diplome;
        this.profession = profession;
        this.numPersonnel = numPersonnel;
    }

    public String getDiplome() { return diplome; }
    public void setDiplome(String diplome) { this.diplome = diplome; }
    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }
    public String getNumPersonnel() { return numPersonnel; }
    public void setNumPersonnel(String numPersonnel) { this.numPersonnel = numPersonnel; }
}
