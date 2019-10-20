import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Teacher t = new Teacher();
        Exam exam =  new Exam();

        // student or teacher
        System.out.println("1. Teacher \n" + "2. Student \n" + "3. Exit ");
        System.out.println("Enter Choice : ");
        int user = in.nextInt();
        //teacher
        if (user == 1){
            t.CheackTeacher();
                if (t.testUserANdPassword.equals("Welcome Teacher !")) {
                    while (user != 3) {
                        System.out.println("1. Add Question \n" +
                                "2. Print Question \n" +
                                "3. Exit ");
                        System.out.println("Enter Choice : ");
                        int choice = in.nextInt();

                        switch (choice) {
                            case 1:
                                Qustion.AddQuestion();
                                break;
                            case 2:
                                Qustion q = new Qustion();
                                for (Qustion qustion : q.GetAllQustion()
                                ) {
                                    System.out.println(qustion.QustionText);
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Wrong Choice !!!");
                        }
                    }
            }
        }
        //student
        else if (user == 2) {
            System.out.println("Welcome In First Exam ! ");
            System.out.println("How many Question You Want :");
            int manyQ = in.nextInt();
            exam.MakeExam(manyQ);

             // print normal Q
            for (Qustion q : exam.normalQustion) {
               q.DisplayNormalQuestion();
            }
            //print TF Q
            for (Qustion q : exam.TFQustion) {
                q.DisplayNormalQuestion();

            }
            //print multi Q
            for (Qustion q : exam.multiQustion) {
                new MultiQuestion(q).DisplayQuestion();
            }
            //display Final result..
            System.out.println("Final Result: "+Exam.finalResult+" of "+exam.manyQustion);
        }
    }
}