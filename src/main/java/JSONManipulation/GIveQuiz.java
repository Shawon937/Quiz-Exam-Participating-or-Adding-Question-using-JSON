package JSONManipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GIveQuiz {
    static void giveQuiz() throws IOException, ParseException {
        try {
            System.out.println("\nYou will be asked 5 questions, each questions has 1 marks");
            System.out.println("If \"Option a\" is the correct answer. Then Enter \"a\" for answering");
            System.out.println("Lets Start the Exam!!!\n");

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("./src/main/resources/QuestionList.json"));
            JSONArray jsonArray = (JSONArray) obj;

            int marks = 0;
            for (int i = 0; i < 5; i++) {
                Scanner sc = new Scanner(System.in);
                int min = 0;
                int max = jsonArray.size();
                double randQDouble = Math.random() * (max - min) + min;
                int randQInt = (int) Math.round(randQDouble);

                JSONObject quizObj = new JSONObject();
                quizObj = (JSONObject) jsonArray.get(randQInt);

                String question = (String) quizObj.get("Question");
                String optionA = (String) quizObj.get("Option a");
                String optionB = (String) quizObj.get("Option b");
                String optionC = (String) quizObj.get("Option c");
                String optionD = (String) quizObj.get("Option d");
                String answer = (String) quizObj.get("Answer");

                System.out.println(i + 1 + "." + question + "\na." + optionA + "\nb." + optionB + "\nc." + optionC + "\nd." + optionD);

                System.out.println("\nEnter your answer here:");

                String ans = sc.next();
                ans.toLowerCase();
                if (answer.equals(ans)) {
                    System.out.println("Correct Answer\n");
                    marks++;
                } else {
                    System.out.println("Wrong Answer!!");
                    System.out.println("Correct answer:"+ answer +"\n");
                }
            }
            System.out.println("You got " + marks + " marks out of 5");

        } catch (Exception e) {
            System.out.println("Exception");

        }
    }
}
