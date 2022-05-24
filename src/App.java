public class App {
    public static void main(String[]args){
        Training t = new Training();
        t.trainingDetails();
        //t.modifyTrainingDetails("maine", "la mama");
        System.out.println();
        t.trainingDetails();
        Trainer tr = new Trainer();
        System.out.println(tr.checkAvailability("15.02"));
    }
}
