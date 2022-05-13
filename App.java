public class App {
    public static void main(String[]args){
        Training t = new Training();
        t.trainingDetails();
        t.modifyTrainingDetails("maine", "la mama");
        System.out.println();
        t.trainingDetails();
        Trainer tr = new Trainer();
        System.out.println(tr.checkAvalability("15.02"));
        tr.addMaterials(t.chapters,"Iluminatii");
        for(int i = 0; i < t.chapters.size(); i++){
            System.out.println(t.chapters.get(i));
        }
    }
}
