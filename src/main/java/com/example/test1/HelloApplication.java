package com.example.test1;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/

/*public class HelloApplication extends Application {

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // You can leave this method empty for now
    }

    // Define a method to execute your console-based application
    public static void executeConsoleApplication(String[] args) {
        HelloApplication app = new HelloApplication();
        app.creerOrthophoniste();
        app.programmerRendezVous();
    }

    // Add the code from your console-based application here
    // Make sure to adjust package names and imports as needed
    private Orthophoniste orthophoniste;
    private Agenda agenda = new Agenda();

    public void creerOrthophoniste() {
        // Add the method content here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Numéro de téléphone: ");
        String numTelephone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        orthophoniste = new Orthophoniste(nom, prenom, adresse, numTelephone, email, motDePasse);
    }

    public void programmerRendezVous() {
        // Add the method content here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type de rendez-vous (1: Consultation, 2: Suivi, 3: Atelier): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Date (yyyy-MM-dd): ");
        Date date = java.sql.Date.valueOf(scanner.nextLine());
        System.out.print("Heure (HH:mm): ");
        String heure = scanner.nextLine();

        // Vérifier si la date et l'heure saisies correspondent à un rendez-vous existant dans l'agenda
        if (agenda.verifierDisponibilite(date, heure)) {
            System.out.println("Ce créneau horaire est déjà réservé. Veuillez choisir une autre date ou heure.");
            return;
        }

        RendezVous rdv;
        switch (type) {
            case 1:
                System.out.print("Nom du patient: ");
                String nomPatient = scanner.nextLine();
                System.out.print("Prenom du patient: ");
                String prenomPatient = scanner.nextLine();
                System.out.print("Age du patient: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Détecter automatiquement si le patient est adulte ou enfant
                int patientType = (age >= 18) ? 2 : 1;

                if (patientType == 1) {
                    System.out.print("Classe d'études: ");
                    String classeEtudes = scanner.nextLine();
                    System.out.print("Téléphone des parents: ");
                    String telParents = scanner.nextLine();

                    Enfant enfant = new Enfant(nomPatient, prenomPatient, "", "", "", classeEtudes, telParents);
                    rdv = new Consultation(date, heure, 150, nomPatient, prenomPatient, age);
                } else {
                    System.out.print("Diplôme: ");
                    String diplome = scanner.nextLine();
                    System.out.print("Profession: ");
                    String profession = scanner.nextLine();
                    System.out.print("Numéro personnel: ");
                    String numPersonnel = scanner.nextLine();

                    Adulte adulte = new Adulte(nomPatient, prenomPatient, "", "", "", diplome, profession, numPersonnel);
                    rdv = new Consultation(date, heure, 90, nomPatient, prenomPatient, age);
                }

                System.out.println("Consultation créée pour " + nomPatient + " " + prenomPatient);
                break;
            case 2:
                System.out.print("Numéro du dossier du patient: ");
                int numeroDossier = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("En ligne (0: false, 1: true): ");
                boolean enLigne = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline

                rdv = new Suivi(date, heure, 60, numeroDossier, enLigne);

                System.out.println("Suivi créé pour le dossier numéro " + numeroDossier);
                break;
            case 3:
                System.out.print("Thématique de l'atelier: ");
                String thematique = scanner.nextLine();
                System.out.print("Nombre de patients: ");
                int nombrePatients = scanner.nextInt();
                List<Integer> listePatients = new ArrayList<>();
                for (int i = 0; i < nombrePatients; i++) {
                    System.out.print("Numéro du dossier du patient " + (i + 1) + ": ");
                    listePatients.add(scanner.nextInt());
                }
                scanner.nextLine(); // Consume newline

                rdv = new Atelier(date, heure, 60, thematique, listePatients);
                System.out.println("Atelier créé sur le thème: " + thematique);
                break;
            default:
                System.out.println("Type de rendez-vous invalide.");
                return;
        }

        System.out.print("Observation: ");
        rdv.setObservation(scanner.nextLine());

        agenda.programmerRendezVous(rdv);
        System.out.println("Rendez-vous programmé avec succès pour le " + date + " à " + heure);
    }
}*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.OutputStream;
import java.io.PrintStream;

public class HelloApplication extends Application {

    private TextArea consoleTextArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.getChildren().add(consoleTextArea);

        // Create a custom PrintStream to redirect output to the TextArea
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) {
                consoleTextArea.appendText(String.valueOf((char) b));
            }
        };
        PrintStream printStream = new PrintStream(outputStream);

        // Redirect System.out to the custom PrintStream
        System.setOut(printStream);

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setTitle("JavaFX Console");
        primaryStage.show();

        // Execute the console-based application logic
        executeConsoleApplication(new String[]{});
    }

    // Define a method to execute your console-based application
    public static void executeConsoleApplication(String[] args) {
        HelloApplication app = new HelloApplication();
        app.creerOrthophoniste();
        app.programmerRendezVous();
    }

    // Add the code from your console-based application here
    // Make sure to adjust package names and imports as needed
    private Orthophoniste orthophoniste;
    private Agenda agenda = new Agenda();

    public void creerOrthophoniste() {
        // Add the method content here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Numéro de téléphone: ");
        String numTelephone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        orthophoniste = new Orthophoniste(nom, prenom, adresse, numTelephone, email, motDePasse);
    }

    public void programmerRendezVous() {
        // Add the method content here
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type de rendez-vous (1: Consultation, 2: Suivi, 3: Atelier): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Date (yyyy-MM-dd): ");
        Date date = java.sql.Date.valueOf(scanner.nextLine());
        System.out.print("Heure (HH:mm): ");
        String heure = scanner.nextLine();

        // Vérifier si la date et l'heure saisies correspondent à un rendez-vous existant dans l'agenda
        if (agenda.verifierDisponibilite(date, heure)) {
            System.out.println("Ce créneau horaire est déjà réservé. Veuillez choisir une autre date ou heure.");
            return;
        }

        RendezVous rdv;
        switch (type) {
            case 1:
                System.out.print("Nom du patient: ");
                String nomPatient = scanner.nextLine();
                System.out.print("Prenom du patient: ");
                String prenomPatient = scanner.nextLine();
                System.out.print("Age du patient: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Détecter automatiquement si le patient est adulte ou enfant
                int patientType = (age >= 18) ? 2 : 1;

                if (patientType == 1) {
                    System.out.print("Classe d'études: ");
                    String classeEtudes = scanner.nextLine();
                    System.out.print("Téléphone des parents: ");
                    String telParents = scanner.nextLine();

                    Enfant enfant = new Enfant(nomPatient, prenomPatient, "", "", "", classeEtudes, telParents);
                    rdv = new Consultation(date, heure, 150, nomPatient, prenomPatient, age);
                } else {
                    System.out.print("Diplôme: ");
                    String diplome = scanner.nextLine();
                    System.out.print("Profession: ");
                    String profession = scanner.nextLine();
                    System.out.print("Numéro personnel: ");
                    String numPersonnel = scanner.nextLine();

                    Adulte adulte = new Adulte(nomPatient, prenomPatient, "", "", "", diplome, profession, numPersonnel);
                    rdv = new Consultation(date, heure, 90, nomPatient, prenomPatient, age);
                }

                System.out.println("Consultation créée pour " + nomPatient + " " + prenomPatient);
                break;
            case 2:
                System.out.print("Numéro du dossier du patient: ");
                int numeroDossier = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("En ligne (0: false, 1: true): ");
                boolean enLigne = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline
                rdv = new Suivi(date, heure, 60, numeroDossier, enLigne);
                System.out.println("Suivi créé pour le dossier numéro " + numeroDossier);
                break;
            case 3:
                System.out.print("Thématique de l'atelier: ");
                String thematique = scanner.nextLine();
                System.out.print("Nombre de patients: ");
                int nombrePatients = scanner.nextInt();
                List<Integer> listePatients = new ArrayList<>();
                for (int i = 0; i < nombrePatients; i++) {
                    System.out.print("Numéro du dossier du patient " + (i + 1) + ": ");
                    listePatients.add(scanner.nextInt());
                }
                scanner.nextLine(); // Consume newline

                rdv = new Atelier(date, heure, 60, thematique, listePatients);
                System.out.println("Atelier créé sur le thème: " + thematique);
                break;
            default:
                System.out.println("Type de rendez-vous invalide.");
                return;
        }

        System.out.print("Observation: ");
        rdv.setObservation(scanner.nextLine());

        agenda.programmerRendezVous(rdv);
        System.out.println("Rendez-vous programmé avec succès pour le " + date + " à " + heure);
    }
}