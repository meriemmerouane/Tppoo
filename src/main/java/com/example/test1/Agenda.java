package com.example.test1;

import com.example.test1.RendezVous;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Agenda {
    private List<RendezVous> rendezVousList;

    public Agenda() {
        this.rendezVousList = new ArrayList<>();
    }

    public void programmerRendezVous(RendezVous rdv) {
        rendezVousList.add(rdv);
    }

    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }
    public boolean verifierDisponibilite(Date date, String heure) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                return true; // Le créneau est déjà réservé
            }
        }
        return false; // Le créneau est disponible
    }

}
