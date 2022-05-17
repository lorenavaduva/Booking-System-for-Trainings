// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------
/************************************************************/
/**
 * 
 */
import java.util.*;

public class Training {
	/**
	 * 
	 */
	private String clientName;
	/**
	 * 
	 */
	private String eventName;
	/**
	 * 
	 */
	private String eventLocation;
	/**
	 * 
	 */
	private String eventDate;
	/**
	 * 
	 */
	private TrainingType eventType;
	/**
	 * 
	 */
	public List<String> chapters = new ArrayList<>();
	/**
	 * 
	 */
	private String trainerName;

	/**
	 * 
	 */

	Training(){

	}
	Training(String clientName, String trainerName, String eventName, String eventLocation, String eventDate, TrainingType eventType){
		this.clientName = clientName;
		this.trainerName = trainerName;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventDate = eventDate;
		this.eventType = eventType;
	}

	public void trainingDetails() {
		System.out.println("Training pentru: " + this.clientName + " intitulat " + this.eventName + " tinut de catre " + this.trainerName);
		System.out.println("Topic: " + this.eventType);
		System.out.println("La data de: " + this.eventDate + " locatia: " + this.eventLocation);
	}

	/**
	 * 
	 * @param date 
	 * @param location 
	 */
	public void modifyTrainingDetails(String date, String location) {
		this.eventDate = date;
		this.eventLocation = location;
	}

	TrainingType getEventType(){
		return eventType;
	}
	String getClientName(){
		return this.clientName;
	}
	String getEventName(){
		return this.eventName;
	}
	String getEventLocation(){
		return this.eventLocation;
	}
	String getEventDate(){
		return this.eventDate;
	}
	List<String> getChapters(){
		return this.chapters;
	}
	void setClientName(String clientName){
		this.clientName = clientName;
	}
	void setEventName(String eventName){
		this.eventName = eventName;
	}
	void setEventLocation(String eventLocation){
		this.eventLocation = eventLocation;
	}
	void setEventDate(String eventDate){
		this.eventDate = eventDate;
	}
	void setEventType(TrainingType eventType){
		this.eventType = eventType;
	}
	void insertChapter(String chapter){
		this.chapters.add(chapter);
	}

}
