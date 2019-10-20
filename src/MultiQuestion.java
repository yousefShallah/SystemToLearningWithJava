import java.io.*;
import java.util.ArrayList;

public class MultiQuestion extends Qustion {

    ArrayList<String> choices = new ArrayList<>();

    public MultiQuestion( ) {
    }
    public MultiQuestion(String typeQustion, String qustionText, String answer) {
        super(typeQustion, qustionText, answer);
    }

    public MultiQuestion(Qustion q) {
      try {
          for (int i = 0; i <4 ; i++) {
              this.choices.add(q.answer.split(",")[i]);
          }
          this.answer = q.answer.split(",")[4];
      }catch (java.lang.ArrayIndexOutOfBoundsException e){
          System.out.println("not Multi");
      }
        this.QustionText = q.QustionText;

    }

    public void AddChooses(String c){
        choices.add(c);
     }
    public void ShowNewQuestions(){
        System.out.println(this.QustionText + "\n" + this.answer + " \n" + this.choices.toString());
    }

    //display new Question
    public void DisplayQuestion(){
        System.out.println(this.QustionText);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i+1)+". "+this.choices.get(i));
        }
        CheckAnswer();
    }

    //add to files
    public void SaveNewQuestions(){
        try {
//            //read data from file
//            File file = new File(Exam.QusetoinBankMulti);
//            FileOutputStream fis = new FileOutputStream(file);
            FileWriter file = new FileWriter(Exam.QusetoinBankMulti, true);

            PrintWriter pw = new PrintWriter(file);
            pw.append("\n$" + "\n"+this.QustionText+"\n"+this.answer+"\n"+this.choices);
            pw.close();
            file.close();
            System.out.println("Question Saved ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
