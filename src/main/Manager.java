package main;
import java.util.*;

public class Manager {

	private String managerName;
	private String email;
	private String phone;
	private List<Training> trainingList = new ArrayList<>();
	public List<Trainer> trainers = new ArrayList<>();
	public List<Client> clients = new ArrayList<>();

	Manager() {
	}

	public Manager(String managerName, String email, String phone) {
		this.managerName = managerName;
		this.email = email;
		this.phone = phone;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void addTrainer(Trainer trainer) {
		trainers.add(trainer);
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void contactInfo() {
		System.out.println("-------Date de contact manager-------");
		System.out.println("Nume: " + managerName);
		System.out.println("Adresa email: " + email);
		System.out.println("Telefon: " + phone);

	}

	public void assignTrainer(Training training) {
		//when assigning trainer you have to take into consideration the list of trainers already in the object manager
		//and the training the client specified
		boolean alocat = false;
		if (!trainers.isEmpty() && (training.getEventType() == TrainingType.DataScience ||
				training.getEventType() == TrainingType.DataTransfer ||
				training.getEventType() == TrainingType.Leadership ||
				training.getEventType() == TrainingType.MachineLearning ||
				training.getEventType() == TrainingType.PublicSpeaking ||
				training.getEventType() == TrainingType.QualityAssurance ||
				training.getEventType() == TrainingType.Sales ||
				training.getEventType() == TrainingType.WebDevelopment ||
				training.getEventType() == TrainingType.WorkPlaceEthics)) {
			for (Trainer trainer : this.trainers) {
				if (trainer.checkAvailability(training.getEventDate()) && trainer.checkQualification(training.getEventType())) {
					training.setTrainerName(trainer.getTrainerName());
					trainingList.add(training);
					trainer.addTraining(training);
					for (Client client : this.clients) {
						if (client.getClientName().equals(training.getClientName())) {
							client.addTraining(training);
						}
					}
					alocat = true;
					break;
				}
			}
			if (alocat) {
				//System.out.println("Trainer alocat");
			} else System.out.println("Nu avem traineri pentru acest eveniment");
		}
	}


	public void cancelTraining(Training training) {
		//remove training from the assigned trainer's list
		trainers.forEach((trainer) -> {
			if (Objects.equals(trainer.getTrainerName(), training.getTrainer())) {
				trainer.trainings.remove(training);
			}
		});
		//remove training from clients list
		clients.forEach((client) -> {
			client.trainings.remove(training);
		});

		trainingList.remove(training);
	}


	public void changeTrainingDetails(Training training,Client client, String newEventName, String newEventLocation, String newEventDate) {
		//modify training from the assigned trainer's list
		trainers.forEach((trainer) -> {
			if (Objects.equals(trainer.getTrainerName(), training.getTrainer())) {
				trainer.modifyTrainingDetails(training, newEventName, newEventLocation, newEventDate);
			}
		});

		for (Training course: client.getTrainings()) {
			if(course.equals(training)){
				if(!newEventName.isEmpty()) training.setEventName(newEventName);
				if(!newEventLocation.isEmpty()) training.setEventLocation(newEventLocation);
				if(!newEventDate.isEmpty()) training.setEventDate(newEventDate);
			}
		}
	}
}
