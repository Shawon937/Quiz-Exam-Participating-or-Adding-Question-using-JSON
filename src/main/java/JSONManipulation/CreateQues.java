package JSONManipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateQues {
    static void createQues() throws IOException, ParseException {
        try {
            char choiceInput = 'y';
            do {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(new FileReader("./src/main/resources/QuestionList.json"));
                JSONArray jsonArray = (JSONArray) obj;

                Scanner scanner = new Scanner(System.in);

                //Creating JSON type objects
                JSONObject quizAdd = new JSONObject();

                System.out.println("Please add a ques here:");
                System.out.println("Question:");
                quizAdd.put("Question", scanner.nextLine());
                System.out.println("Input options:");
                System.out.println("Option a:");
                quizAdd.put("Option a", scanner.nextLine());
                System.out.println("Option b:");
                quizAdd.put("Option b", scanner.nextLine());
                System.out.println("Option c:");
                quizAdd.put("Option c", scanner.nextLine());
                System.out.println("Option d:");
                quizAdd.put("Option d", scanner.nextLine());
                System.out.println("Please input the correct answer:");
                quizAdd.put("Answer", scanner.nextLine());

                //adding JSON type objects to the JSON array which is still in the menory
                jsonArray.add(quizAdd);

                //Adding the JSON array to the .json file
                FileWriter fileWriter = new FileWriter("./src/main/resources/QuestionList.json");
                fileWriter.write(jsonArray.toString());
                fileWriter.flush();
                System.out.println("Quiz saved at the database. Do you want to add more? (y/n)");
                choiceInput = scanner.next().charAt(0);
            }
            while (choiceInput == 'y'); {

            }
        }
        catch (Exception e){
            System.out.println("Exception");
        }
    }
}
