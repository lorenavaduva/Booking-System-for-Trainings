package main;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[]args){
        Manager manager = new Manager("Alexandru Anton",
                "alexandru.anton@gmail.com",
                "0761234233");
        Client client1 = new Client("Marian Dorobantu",
                "0761125521",
                "marcu.dorobantu@yahoo.com");
        Client client2 = new Client("Andreea Constantin",
                "0761975521",
                "andreea.constantin@gmail.com");
        Trainer trainer1 = new Trainer("Stefan Popescu",
                "0762613121",
                "stefan.popescu@gmail.com",
                new ArrayList<>(Arrays.asList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Arrays.asList(TrainingType.DataScience)));
        manager.addClient(client1);
        manager.addClient(client2);
        manager.addTrainer(trainer1);
        manager.addTrainer(trainer2);
        Training training1 = new Training("Marian Dorobantu",
                "Stefan Popescu",
                "Introducere in MachineLearning",
                "Bucuresti,Sector 6",
                "20/07/2022",
                TrainingType.MachineLearning);
        Training training2 = new Training("Andreea Constantin",
                "Amalia Neacsu",
                "Introducere in Data Science",
                "Bucuresti,Sector 3",
                "15/07/2022",
                TrainingType.DataScience);
        manager.assignTrainer(training1);
        manager.assignTrainer(training2);

        // Afisarea datelor de contact pentru Manager,Trainer,Client
        System.out.println("Afisare date de contact clienti: \n");
        client1.contactInfo();
        client2.contactInfo();
        System.out.println("\nAfisarea datelor de contact manager: \n");
        manager.contactInfo();
        System.out.println("\nAfisarea date de contact traineri: \n");
        trainer1.contactInfo();
        trainer2.contactInfo();

        // Anulare trainning de catre un client
        client1.cancelTraining(manager,"Introducere in MachineLearning","20/07/2022");
        System.out.println("\nLista traininguri dupa anularea de catre client 1");
        System.out.println("\nTraining-urile clientului 1 sunt:");
        for (Training course: client1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        // Restituire training sters
        manager.assignTrainer(training1);

        // Cerere de training din partea unui client
        client2.requestTraining(manager,
                TrainingType.MachineLearning,
                "18/09/2022",
                "Cluj",
                "Aprofundare cunostinte MachineLearning");
        // Verificare ca trainingul a fost adaugat pentru manager,trainer si client
        System.out.println("Lista ");
        System.out.println("\nTraining-urile clientului 2 sunt: \n");
        for (Training course: client2.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }

        // Schimare detalii eveniment de catre client
        // Verificare ca trainingul a fost modificat pentru manager,trainer si client
        client2.changeTrainingDetails(client2.getTrainings().get(1),manager);
        System.out.println("\nListele de training dupa schimbare sunt:\n");
        System.out.println("\nTraining-urile clientului 2 sunt: \n");
        for (Training course: client2.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }

        // Modificare facuta de manager
        manager.changeTrainingDetails(manager.getTrainingList().get(2),client2,"","Resita","");
        System.out.println("\nListele de training dupa schimbare facuta de manager sunt:\n");
        System.out.println("\nTraining-urile clientului 2 sunt: \n");
        for (Training course: client2.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        // Lista trainingurilor pentru manager,client,trainer dupa ce sunt modificate de trainer
        trainer1.modifyTrainingDetails(manager.getTrainingList().get(2),"","Abrud","" );
        System.out.println("\nListele de training dupa schimbare facuta de manager sunt:\n");
        System.out.println("\nTraining-urile clientului 2 sunt: \n");
        for (Training course: client2.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }

        // Datele la care trainerii au de sustinut cursuri/traininguri
        System.out.println("\nTrainer 1:\n");
        trainer1.checkSchedule();
        System.out.println("\nTrainer 2:\n");
        trainer2.checkSchedule();


        // Verificat daca trainerii sunt disponibili sau nu la anumite date
        System.out.println("\nVerificare date disponibile trainer:\n");
        // Date indisponibile
        System.out.println("Trainer 1: ");
        System.out.println(trainer1.checkAvailability("20/07/2022") ? "Data disponibila 20/07/2022" : "Data indisponibila 20/07/2022");
        System.out.println("Trainer 2: ");
        System.out.println(trainer2.checkAvailability("15/07/2022") ? "Data disponibila 15/07/2022" : "Data indisponibila 15/07/2022");
        // Date disponibile
        System.out.println("Trainer 1: ");
        System.out.println(trainer1.checkAvailability("05/09/2022") ? "Data disponibila 05/09/2022" : "Data indisponibila 05/09/2022");
        System.out.println("Trainer 2: ");
        System.out.println(trainer2.checkAvailability("08/09/2022") ? "Data disponibila 08/09/2022" : "Data indisponibila 08/09/2022");

        // Calificari trainner 1
        System.out.println("\nCalificari trainer 1:");
        System.out.println(trainer1.checkQualification(TrainingType.MachineLearning) ? "MachineLearning - da" : "MachineLearning - nu");
        System.out.println(trainer1.checkQualification(TrainingType.DataScience) ? "DataScience - da" : "DataScience - nu");

        // Adaugare materiale trainner
        trainer1.addMaterials("Introducere in MachineLearning","Capitolul 1");
        System.out.println("\nCapitolele cursului de \"Introducere in MachineLearning\" :\n");
        for (Training course :
                trainer1.getTrainings()) {
            if(course.getEventName().equals("Introducere in MachineLearning")){
                course.getChapters().forEach(System.out::println);
            }
        }

        // Anulare training de catre manager
        manager.cancelTraining(training1);
        System.out.println("\nLista traininguri dupa anularea de catre manager");
        System.out.println("\nTraining-urile clientului 1 sunt: \n");
        for (Training course: client1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile de care stie managerului sunt: \n");
        for (Training course: manager.getTrainingList()) {
            System.out.println(course.trainingDetails());
        }
        System.out.println("\nTraining-urile pe care le sustine trainerul sunt: \n");
        for (Training course: trainer1.getTrainings()) {
            System.out.println(course.trainingDetails());
        }

    }
}
