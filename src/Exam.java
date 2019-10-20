import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exam {

    public  int manyQustion = 0;
    public static int finalResult = 0;
    // all question
    ArrayList<Qustion> _normalQustionAll = new ArrayList<>();
    ArrayList<Qustion> _TFQustionAll = new ArrayList<>();
    ArrayList<Qustion> _multiQustionAll = new ArrayList<>();
    // EXAM QUESTION
    ArrayList<Qustion> normalQustion = new ArrayList<>();
    ArrayList<Qustion> TFQustion = new ArrayList<>();
    ArrayList<Qustion> multiQustion = new ArrayList<>();

    public final static String QusetoinBankNormal = "D:\\all project inteliji\\ExamJavaProject\\src\\Data\\QustionBank";
    public final static String QusetoinBankTF = "D:\\all project inteliji\\ExamJavaProject\\src\\Data\\QustionBankTF";
    public final static String QusetoinBankMulti = "D:\\all project inteliji\\ExamJavaProject\\src\\Data\\QustionBankM";

    public Exam MakeExam(int manyQustion) {
        // to know how many Questions
        this.manyQustion = manyQustion;
        int normalAndTFQCount = manyQustion / 3;
        int multyQCount = manyQustion - normalAndTFQCount * 2;

        // to get normal Question and put it in new arrayList
        this._normalQustionAll = readQuestionsFromFile(QusetoinBankNormal);
        Collections.shuffle(_normalQustionAll);
        for (int i = 0; i < normalAndTFQCount; i++) {
            this.normalQustion.add(this._normalQustionAll.get(i));
        }

        // to get TF Question and put it in new arrayList
        this._TFQustionAll = readQuestionsFromFile(QusetoinBankTF);
        Collections.shuffle(_TFQustionAll);
        for (int i = 0; i < normalAndTFQCount; i++) {
            this.TFQustion.add(this._TFQustionAll.get(i));
        }

        // to get multi Question and put it in new arrayList
        this._multiQustionAll = readQuestionsFromFile(QusetoinBankMulti);
        Collections.shuffle(_multiQustionAll);
        for (int i = 0; i < multyQCount; i++) {
            this.multiQustion.add(this._multiQustionAll.get(i));
        }

        return this;
    }

    // to read data from files and set it in new ArrayList
    public ArrayList<Qustion> readQuestionsFromFile(String path) {
        ArrayList<Qustion> tempQustionArr = new ArrayList<>();
        try {
            //read data from file
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            //convert data from byte to utf-8
            String str = new String(data, "UTF-8");

            String[] tempArr = str.split("\\$");

            for (int j = 0; j < tempArr.length; j++) {
                // convert text to question object and add it to quesbank arr
                tempQustionArr.add(
                        new Qustion("Q",
                                tempArr[j].split("\\r?\\n")[1].toString(),
                                tempArr[j].split("\\r?\\n")[2].toString()));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempQustionArr;
    }

}