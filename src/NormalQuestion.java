import java.io.*;

public class NormalQuestion extends Qustion {
    public NormalQuestion(String typeQustion, String qustionText, String answer) {
        super(typeQustion, qustionText, answer);
    }

    public NormalQuestion() {
    }

    //show new Question added
    public void ShowNewQuestions(){
        System.out.println(this.QustionText + "\n" + this.answer);
    }

    //add to files ..
    public void SaveNewQuestions(){
        try {
//            File file = new File(Exam.QusetoinBankNormal);
//            FileOutputStream fis = new FileOutputStream(file);

            //read data from file
            FileWriter file = new FileWriter(Exam.QusetoinBankNormal, true);
            PrintWriter pw = new PrintWriter(file);
            pw.append("\n$" + "\n"+this.QustionText+"\n"+this.answer);
            pw.close();
            file.close();
            System.out.println("Question Saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
