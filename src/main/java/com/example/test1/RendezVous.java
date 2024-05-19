package com.example.test1;

import java.util.Date;
import java.util.List;

public abstract class RendezVous {
    private Date date;
    private String heure;
    private int duree;
    private String observation;

    public RendezVous(Date date, String heure, int duree) {
        this.date = date;
        this.heure = heure;
        this.duree = duree;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getHeure() { return heure; }
    public void setHeure(String heure) { this.heure = heure; }
    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }
    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }
}
class Consultation extends RendezVous {
    private String nomPatient;
    private String prenomPatient;
    private int age;

    public Consultation(Date date, String heure, int duree, String nomPatient, String prenomPatient, int age) {
        super(date, heure, duree);
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.age = age;
    }

    public String getNomPatient() { return nomPatient; }
    public void setNomPatient(String nomPatient) { this.nomPatient = nomPatient; }
    public String getPrenomPatient() { return prenomPatient; }
    public void setPrenomPatient(String prenomPatient) { this.prenomPatient = prenomPatient; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public void programmerRendezVous(Agenda agenda, Date date, String heure, String nomPatient, String prenomPatient, int age, String classeEtudes, String telParents, int numeroDossier, boolean enLigne, String thematique, List<Integer> listePatients, String typePatient, String diplome, String profession, String numPersonnel) {
        if ("Enfant".equals(typePatient)) {
            Enfant enfant = new Enfant(nomPatient, prenomPatient, "", "", "", classeEtudes, telParents);
            Consultation rdv = new Consultation(date, heure, 150, nomPatient, prenomPatient, age);
            rdv.setObservation("Some observation");

            agenda.programmerRendezVous(rdv);
            System.out.println("Consultation créée pour " + nomPatient + " " + prenomPatient + " (Enfant)");
        } else if ("Adulte".equals(typePatient)) {
            Adulte adulte = new Adulte(nomPatient, prenomPatient, "", "", "", diplome, profession, numPersonnel);
            Consultation rdv = new Consultation(date, heure, 90, nomPatient, prenomPatient, age);
            rdv.setObservation("Some observation");

            agenda.programmerRendezVous(rdv);
            System.out.println("Consultation créée pour " + nomPatient + " " + prenomPatient + " (Adulte)");
        } else {
            System.out.println("Type de patient invalide.");
        }
    }
}
 class Suivi extends RendezVous {
    private int numeroDossier;
    private boolean enLigne;

    public Suivi(Date date, String heure, int duree, int numeroDossier, boolean enLigne) {
        super(date, heure, duree);
        this.numeroDossier = numeroDossier;
        this.enLigne = enLigne;
    }

    public int getNumeroDossier() { return numeroDossier; }
    public void setNumeroDossier(int numeroDossier) { this.numeroDossier = numeroDossier; }
    public boolean isEnLigne() { return enLigne; }
    public void setEnLigne(boolean enLigne) { this.enLigne = enLigne; }
     public void programmerRendezVous(Agenda agenda, Date date, String heure, String nomPatient, String prenomPatient, int age, String classeEtudes, String telParents, int numeroDossier, boolean enLigne, String thematique, List<Integer> listePatients) {
         // Implement the method content here using the provided parameters
         Suivi rdv = new Suivi(date, heure, 60, numeroDossier, enLigne);
         rdv.setObservation("Some observation");

         agenda.programmerRendezVous(rdv);
         System.out.println("Suivi créé pour le dossier numéro " + numeroDossier);
     }
}


 class Atelier extends RendezVous {
    private String thematique;
    private List<Integer> listePatients;

    public Atelier(Date date, String heure, int duree, String thematique, List<Integer> listePatients) {
        super(date, heure, duree);
        this.thematique = thematique;
        this.listePatients = listePatients;
    }

    public String getThematique() { return thematique; }
    public void setThematique(String thematique) { this.thematique = thematique; }
    public List<Integer> getListePatients() { return listePatients; }
    public void setListePatients(List<Integer> listePatients) { this.listePatients = listePatients; }
     public void programmerRendezVous(Agenda agenda, Date date, String heure, String nomPatient, String prenomPatient, int age, String classeEtudes, String telParents, int numeroDossier, boolean enLigne, String thematique, List<Integer> listePatients) {
         // Implement the method content here using the provided parameters
         Atelier rdv = new Atelier(date, heure, 60, thematique, listePatients);
         rdv.setObservation("Some observation");

         agenda.programmerRendezVous(rdv);
         System.out.println("Atelier créé sur le thème: " + thematique);
     }
}
