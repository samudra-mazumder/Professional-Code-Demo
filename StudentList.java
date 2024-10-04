import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        String readLine = fileReader("students.txt");
//		Check arguments
        if(args == null || args.length!=1){
            System.out.println("Wrong Argument");
            return;
        }

        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {


                String students[] = readLine.split(",");
                for (String student : students) {
                    System.out.println(student.trim());
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {

                String students[] = readLine.split(",");
                Random random = new Random();
                int randomInt = random.nextInt(students.length);
                System.out.println(students[randomInt]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                                                new FileWriter("students.txt", true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String finalDate = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(finalDate);
                String fd = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + fd);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {

                String i[] = readLine.split(",");
                boolean done = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < i.length && !done; idx++) {
                    if (i[idx].trim().equals(t)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {

                char a[] = readLine.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : a) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.out.println("Wrong argument");
        }
    }
    public static String fileReader(String fileName) {
        try {
            BufferedReader s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
            return s.readLine();
        } catch (Exception e) {

        }

        return fileName;
    }
}