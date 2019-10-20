import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Qustion {

    public String typeQustion;
    public String QustionText;
    public String answer;

    public Qustion(){
    }

    public Qustion(String typeQustion, String qustionText, String answer) {
        this.typeQustion = typeQustion;
        QustionText = qustionText;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Qustion{" +
                "typeQustion='" + typeQustion + '\'' +
                ", QustionText='" + QustionText + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    //toget answer from user and cheack on question answer
    public void CheckAnswer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your Answer : ");
        String s = in.nextLine();
            if (answer.equals(s)) {
                Exam.finalResult++;
                System.out.println("Right Answer ");
            }else {
                System.out.println("Wrong Answer !");
            }
    }

    //to get all Question and set question in new ArrayList
    public ArrayList<Qustion> GetAllQustion(){
        ArrayList<Qustion> allQuestion = new ArrayList<>();
        Exam e = new Exam();
        allQuestion.addAll(e.readQuestionsFromFile(Exam.QusetoinBankNormal));
        allQuestion.addAll(e.readQuestionsFromFile(Exam.QusetoinBankTF));
        allQuestion.addAll(e.readQuestionsFromFile(Exam.QusetoinBankMulti));
        return allQuestion;
    }

    // to display normal question
    public void DisplayNormalQuestion(){
        System.out.println(QustionText.toString());
        CheckAnswer();
    }

    // to read from user . what's is type question
    // and add questions
    public static void AddQuestion(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Question Type \n"
        + "1. Normal Q \n" + "2. TF Q \n" + "3. Multi Q");
        int questionType = in.nextInt();

        if (questionType == 1){
            NormalQuestion q = new NormalQuestion();
            //normal Question
            System.out.println("Enter Question Text N ");
            q.QustionText = in.next();
            System.out.println("Enter Question Answer N ");
            q.answer = in.next();
            q.ShowNewQuestions();
            q.SaveNewQuestions();
        }
        else if (questionType == 2){

            TFQuestion q = new TFQuestion();
            //normal Question
            System.out.println("Enter Question Text TF");
            q.QustionText = in.next();
            System.out.println("Enter Question Answer TF");
            q.answer = in.next();
            q.ShowNewQuestions();
            q.SaveNewQuestions();

        }
        else if (questionType == 3){
            MultiQuestion q = new MultiQuestion();
            System.out.println("Enter Question Text Multi");
            q.QustionText = in.next();
            System.out.println("Enter Question true Answer Multi");
            q.answer = in.next();
            for (int i = 0; i < 4; i++) {
                System.out.println("Enter Question Choice Multi");
                q.AddChooses(in.next());
            }
            q.ShowNewQuestions();
            q.SaveNewQuestions();
        }
    }
}
