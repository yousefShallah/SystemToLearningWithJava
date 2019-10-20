import java.io.*;

public class TFQuestion extends Qustion {

    public TFQuestion(String typeQustion, String qustionText, String answer) {
        super(typeQustion, qustionText, answer);
    }

    public TFQuestion() {
    }

    public void ShowNewQuestions(){
        System.out.println(this.QustionText + "\n" + this.answer);
    }

    public void SaveNewQuestions(){
        try {
            //read data from file
//            File file = new File(Exam.QusetoinBankTF);
//            FileOutputStream fis = new FileOutputStream(file);
            FileWriter file = new FileWriter(Exam.QusetoinBankTF, true);

            PrintWriter pw = new PrintWriter(file);
            pw.append("\n$" + "\n"+this.QustionText+"\n"+this.answer);
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
