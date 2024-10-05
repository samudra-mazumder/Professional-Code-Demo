import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if(args == null || args.length!=1)
            System.out.println("Wrong Argument");
       String readLine = LoadData(Constants.FILE_NAME);
//		Check arguments
        if (args[0].equals(Constants.ShowAll)) {
            System.out.println(Constants.LoadingDataText);
            try {

                String strings[] = readLine.split(Constants.StudentEntryDelimiter);
                for (String j : strings) {
                    System.out.println(j.trim());
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.DataLoadedText);
        } else if (args[0].equals("r")) {
            System.out.println(Constants.LoadingDataText);
            try {
                String strings[] = readLine.split(",");
                Random random = new Random();
                int nextInt = random.nextInt(strings.length);
                System.out.println(strings[nextInt]);
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
                String formatted = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + formatted);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {

                String split[] = readLine.split(",");
                boolean done = false;
                String string = args[0].substring(1);
                for (int idx = 0; idx < split.length && !done; idx++) {
                    if (split[idx].trim().equals(string)) {
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
        else
            System.out.println("Wrong Argument");
    }
    public static String LoadData(String fileName){
        try{
            BufferedReader s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
           return fileName;
        }
        catch (Exception e){
            return null;
        }

       // return fileName;
    }


}