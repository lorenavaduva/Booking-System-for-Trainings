// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

/************************************************************/
/**
 * 
 */
import java.util.*;

public class Client{

	private String clientName;
	private String phone;
	private String email;
	private Training trainingEvent = new Training();
	public List<Training> trainings = new ArrayList<>();

	Client(){}

	Client(String clientName, String phone, String email){
		this.clientName = clientName;
		this.phone = phone;
		this.email = email;
	}

	public String getClientName(){
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Training getTrainingEvent() {
		return trainingEvent;
	}

	public void setTrainingEvent(Training trainingEvent) {
		this.trainingEvent = trainingEvent;
	}

	public void contactInfo() {
		System.out.println("Name: " + this.clientName);
		System.out.println("Phone: " + this.phone);
		System.out.println("Email: " + this.email);
	}


	public void cancelTraining(Manager manager, String eventName, String date) {
		for (Training training : this.trainings) {
			//if the training exists, request the manager to execute the cancellation
			if (training.getEventName().equals(eventName) && training.getEventDate().equals(date)) {
				//Am pus un obiect de tip manager pentru a putea elimina si din lista managerului
				manager.cancelTraining(training);
				this.trainings.remove(training);
			} else {
				System.out.println("Could not cancel the training, as it doesn't exist. Please check the introduced training data.\n");
			}
		}
	}


	public void requestTraining(Manager manager,TrainingType trainingType, String trainingDate, String eventLocation, String eventName) {
		Training requestedTraining = new Training(this.clientName, "", eventName, eventLocation, trainingDate, trainingType);
		manager.assignTrainer(requestedTraining);
	}

	public void addTraining(Training training){
		this.trainings.add(training);
	}

	public void changeTrainingDetails(Training trainingName, String newDate, String newLocation) {
		
	}
}
