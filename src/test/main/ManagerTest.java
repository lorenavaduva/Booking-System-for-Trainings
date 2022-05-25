package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
// Pantilimon Adrian-Gabriel

class ManagerTest {

    @Test
    void validateManagerLoginData() {
        Manager manager = new Manager("Alexandru Anton", "alexandru.anton@gmail.com", "0761234233");
        // Consideram ca datele cu care se realizeaza comparatiile urmatoare sunt introduse de user
        // in campurile corespunzatoare de la tastatura sau in consola.
        assertEquals("Alexandru Anton", manager.getManagerName(), "Nume invalid");
        assertNotEquals("Ionut Andrei", manager.getManagerName(), "Nume valid");
        assertEquals("alexandru.anton@gmail.com", manager.getEmail(), "Email invalid");
        assertNotEquals("alexandru.anton89@gmail.com", manager.getEmail(), "Email valid");
        assertEquals("0761234233", manager.getPhone(), "Numar telefon invalid");
        assertNotEquals("0771535233", manager.getPhone(), "Numar telefon valid");
        // Test pentru verificarea faptului ca toate credentialele sunt valide
        assertTrue(manager.getManagerName().equals("Alexandru Anton") &&
                manager.getEmail().equals("alexandru.anton@gmail.com") &&
                manager.getPhone().equals("0761234233"), "Credentiale invalide");
        // Teste pentru a verifica ca daca un camp din credentiale e invalid nu se trece mai departe
        // adica outputul asteptat este false deci specific cazului cu date gresite.
        assertFalse(manager.getManagerName().equals("Alexandru Barbu") &&
                manager.getEmail().equals("alexandru.anton@gmail.com") &&
                manager.getPhone().equals("0761234233"), "Credentiale valide");
        assertFalse(manager.getManagerName().equals("Alexandru Anton") &&
                manager.getEmail().equals("alexandru.barbu@gmail.com") &&
                manager.getPhone().equals("0761234233"), "Credentiale valide");
        assertFalse(manager.getManagerName().equals("Alexandru Anton") &&
                manager.getEmail().equals("alexandru.anton@gmail.com") &&
                manager.getPhone().equals("0761289233"), "Credentiale valide");
    }

    @Test
    void validateTrainingList() {
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
                new ArrayList<>(Collections.singletonList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Collections.singletonList(TrainingType.DataScience)));
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
        assertEquals("""
                        Training pentru: Marian Dorobantu intitulat Introducere in MachineLearning tinut de catre Stefan Popescu
                        Topic: MachineLearning
                        La data de: 20/07/2022 locatia: Bucuresti,Sector 6""",
                manager.getTrainingList().get(0).trainingDetails(),
                "Detaliile pentru training sunt gresite");
        assertEquals("""
                        Training pentru: Andreea Constantin intitulat Introducere in Data Science tinut de catre Amalia Neacsu
                        Topic: DataScience
                        La data de: 15/07/2022 locatia: Bucuresti,Sector 3""",
                manager.getTrainingList().get(1).trainingDetails(),
                "Detaliile pentru training sunt gresite");
        assertNotEquals("""
                        Training pentru: Marian Dorobantu intitulat Introducere in MachineLearning tinut de catre Stefan Popescu
                        Topic: MachineLearning
                        La data de: 20/07/2022 locatia: Bucuresti,Sector 6""",
                manager.getTrainingList().get(1).trainingDetails(),
                "Detaliile pentru training sunt corecte");
        assertNotEquals("""
                        Training pentru: Andreea Constantin intitulat Introducere in Data Science tinut de catre Amalia Neacsu
                        Topic: DataScience
                        La data de: 15/07/2022 locatia: Bucuresti,Sector 3""",
                manager.getTrainingList().get(0).trainingDetails(),
                "Detaliile pentru training sunt corecte");
    }

    @Test
    void validateTrainingExists() {
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
                new ArrayList<>(Collections.singletonList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Collections.singletonList(TrainingType.DataScience)));
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
        // Cautare daca exista trainingurile respective pentru a fi anulate.
        assertTrue(manager.getTrainingList().contains(training1), "Acest training nu exista in lista");
        assertTrue(manager.getTrainingList().contains(training2), "Acest training nu exista in lista");
        assertFalse(manager.getTrainingList().contains(new Training("Razvan Coman",
                "Iulia Andreescu",
                "Introducere in Web Development",
                "Bucuresti,Sector 1",
                "16/10/2022",
                TrainingType.WebDevelopment)), "Acest training exista in lista");
    }

    @Test
    void validateTrainingDetails() {
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
                new ArrayList<>(Collections.singletonList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Collections.singletonList(TrainingType.DataScience)));
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

        // Dupa ce gaseste un training managerul poate cere date referitoare la respetivul training
        // Sunt realizate teste pentru cazurile in care detaliile pentru un anumit training in acest
        // exemplu pentru training-ul 1 sunt corecte sau daca detaliile rezultate nu sunt cele asteptate
        assertEquals("Marian Dorobantu",
                manager.getTrainingList().get(0).getClientName(),
                "Numele clientului nu este acesta.");
        assertEquals("Stefan Popescu",
                manager.getTrainingList().get(0).getTrainer(),
                "Numele trainerului nu este acesta");
        assertEquals("Introducere in MachineLearning",
                manager.getTrainingList().get(0).getEventName(),
                "Numele evenimentului nu este acesta");
        assertEquals("Bucuresti,Sector 6",
                manager.getTrainingList().get(0).getEventLocation(),
                "Locatia nu este aceasta");
        assertEquals("20/07/2022",
                manager.getTrainingList().get(0).getEventDate(),
                "Data evenimentului nu este aceasta");
        assertEquals(TrainingType.MachineLearning,
                manager.getTrainingList().get(0).getEventType(),
                "Tipul evenimentului nu este cel asteptat");
        // Cazul in care detaliile nu sunt cele la care se astepta managerul pentru a verifica
        // corectitudinea datelor
        assertNotEquals("Marian Avram",
                manager.getTrainingList().get(0).getClientName(),
                "Numele clientului nu este acesta.");
        assertNotEquals("Adelina Popescu",
                manager.getTrainingList().get(0).getTrainer(),
                "Numele trainerului nu este acesta");
        assertNotEquals("Introducere in DataTransfer",
                manager.getTrainingList().get(0).getEventName(),
                "Numele evenimentului nu este acesta");
        assertNotEquals("Bucuresti,Sector 1",
                manager.getTrainingList().get(0).getEventLocation(),
                "Locatia nu este aceasta");
        assertNotEquals("09/02/2022",
                manager.getTrainingList().get(0).getEventDate(),
                "Data evenimentului nu este aceasta");
        assertNotEquals(TrainingType.DataTransfer,
                manager.getTrainingList().get(0).getEventType(),
                "Tipul evenimentului nu este cel asteptat");

        // Verificarea detaliilor trainingului folosint functia trainingDetails()
        // Se verifica daca detaliile care sunt asteptate sunt indentice sau daca
        // detaliile sunt diferite fata de niste detalii asteptate care sunt eronate
        assertEquals("""
                Training pentru: Marian Dorobantu intitulat Introducere in MachineLearning tinut de catre Stefan Popescu
                Topic: MachineLearning
                La data de: 20/07/2022 locatia: Bucuresti,Sector 6""", manager.getTrainingList().get(0).trainingDetails(), "Detaliile nu sunt cele asteptate");
        assertNotEquals("""
                Training pentru: Marian Apostolu intitulat Introducere in DataScience tinut de catre Stefan Dumitrescu
                Topic: DataTransfer
                La data de: 07/11/2021 locatia: Cluj""", manager.getTrainingList().get(0).trainingDetails(), "Detaliile sunt cele asteptate");
        assertEquals("""
                Training pentru: Andreea Constantin intitulat Introducere in Data Science tinut de catre Amalia Neacsu
                Topic: DataScience
                La data de: 15/07/2022 locatia: Bucuresti,Sector 3""", manager.getTrainingList().get(1).trainingDetails(), "Detaliile nu sunt cele asteptate");
        assertNotEquals("""
                Training pentru: Marian Apostolu intitulat Introducere in DataScience tinut de catre Stefan Dumitrescu
                Topic: DataTransfer
                La data de: 07/11/2021 locatia: Cluj""", manager.getTrainingList().get(1).trainingDetails(), "Detaliile sunt cele asteptate");
    }

    @Test
    void validateCancelTraining() {
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
                new ArrayList<>(Collections.singletonList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Collections.singletonList(TrainingType.DataScience)));
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
        // Testare daca trainingul inca exista in lista de traininguri
        assertTrue(manager.getTrainingList().contains(training1), "Training-ul 1 nu exista in lista de traininguri.");
        // Se apleaza metoda de stergere a trainingului
        manager.cancelTraining(training1);
        // Verificarea faptului ca evenimentul a fost sters si pentru client, ceea ce intr-o interfata grafica
        // ar notifica clientul respectiv legat de acest lucru.
        assertFalse(client1.getTrainings().contains(training1), "Clientul nu a fost notificat si considera ca evenimentul se va tine.");
        // Verificare ca trainingul a fost sters cu succes
        assertFalse(manager.getTrainingList().contains(training1), "Training-ul 1 nu a fost sters cu succes din lista de training-uri.");
    }

    @Test
    void validateAbortCancel() {
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
                new ArrayList<>(Collections.singletonList(TrainingType.MachineLearning)));
        Trainer trainer2 = new Trainer("Amalia Neacsu",
                "0781624713",
                "amalia.neacsu@gmail.com",
                new ArrayList<>(Collections.singletonList(TrainingType.DataScience)));
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
        // Ceea ce ar alege userul in interfata grafica utilizand un buton de confirmare sau anulare
        // dintr-o fereastra pop-ul astfel vom testa daca pentru cazul nostru nu a fost anulat nimic
        // de catre managerul ce ar utiliza aceasta aplicatie.
        System.out.println("Decizii ce pot fi selectate pentru testul legat de renuntarea operatiei de anulare:");
        System.out.println("1 - Opreste operatie de anulare");
        System.out.println("2 - Continua anulare eveniment");
        String userInput = "2";
        switch (userInput) {
            case "1" -> {
                // Verificarea faptului ca nu a fost anulat nici un training si ca lista de traininguri pentru
                // manager, client si trainner a ramas aceeasi
                assertTrue(manager.getTrainingList().contains(training1), "Lista nu mai contine trainingul 1.");
                assertTrue(manager.getTrainingList().contains(training2), "Lista nu mai contine trainingul 2.");
                assertTrue(client1.getTrainings().contains(training1),"Trainingul 1 nu se mai afla in lista clientului 1.");
                assertFalse(client1.getTrainings().contains(training2),"Trainingul 2 se afla in lista clientului 1.");
                assertFalse(client2.getTrainings().contains(training1),"Trainingul 1 se mai afla in lista clientului 2.");
                assertTrue(client2.getTrainings().contains(training2),"Trainingul 2 nu se afla in lista clientului 2.");
                assertTrue(trainer1.getTrainings().contains(training1),"Training-ul 1 nu se afla in lista trainer-ului 1.");
                assertFalse(trainer1.getTrainings().contains(training2),"Trainingu-ul 2 se afla in lista trainer-ului 1.");
                assertTrue(trainer2.getTrainings().contains(training2),"Training-ul 2 nu se afla in lista trainer-ului 2.");
                assertFalse(trainer2.getTrainings().contains(training1),"Trainingu-ul 1 se afla in lista trainer-ului 2.");
            }
            case "2" -> {
                // Testare daca trainingul inca exista in lista de traininguri
                assertTrue(manager.getTrainingList().contains(training1), "Training-ul 1 nu exista in lista de traininguri.");
                // Se apleaza metoda de stergere a trainingului
                manager.cancelTraining(training1);
                // Verificarea faptului ca evenimentul a fost sters si pentru client, ceea ce intr-o interfata grafica
                // ar notifica clientul respectiv legat de acest lucru.
                assertFalse(client1.getTrainings().contains(training1), "Clientul nu a fost notificat si considera ca evenimentul se va tine.");
                // Verificare ca trainingul a fost sters cu succes
                assertFalse(manager.getTrainingList().contains(training1), "Training-ul 1 nu a fost sters cu succes din lista de training-uri.");
            }
        }
    }
}