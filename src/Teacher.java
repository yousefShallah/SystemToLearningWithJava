import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User {

    private String userName;
    private String id;
    private String password;
    public static String testUserANdPassword;

    public Teacher(String userName,  String password) {
        this.userName = userName;
        this.password = password;
    }
    public Teacher(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ArrayList<Teacher> testWriteFromFile(){
        ArrayList<Teacher> tempTeacherArr = new ArrayList<>();
        File file = new File("D:\\\\all project inteliji\\\\ExamJavaProject\\\\src\\\\Data\\\\CheackTeacher");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            //convert data from byte to utf-8
            String str = new String(data, "UTF-8");

            String[] tempArr = str.split("\\r?\\n");

            for (int j = 0; j < tempArr.length; j++) {
                // convert text to question object and add it to quesbank arr
                tempTeacherArr.add(
                        new Teacher(
                                tempArr[j].split("\\n")[0],
                                tempArr[j].split("\\n")[0]));
            }
            //System.out.println(tempTeacherArr.get(0).userName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempTeacherArr;
    }

    public void CheackTeacher() {
        Scanner i = new Scanner(System.in);
        System.out.println("Enter User Name :");
        String m = i.next();
        System.out.println("Enter Password :");
        String f = i.next();

        if (testWriteFromFile().get(0).getUserName().equals(m) && testWriteFromFile()
                .get(1).getPassword().equals(f)) {
            testUserANdPassword ="Welcome Teacher !";
            //System.out.println(testUserANdPassword);
        } else {
            testUserANdPassword ="Wrong UserName Or Password!!";
            System.out.println(testUserANdPassword);

        }
    }
}
