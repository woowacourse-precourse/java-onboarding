package onboarding;

import java.util.LinkedList;

import static onboarding.problem2.Repository.save;
import static onboarding.problem2.Returner.returnToString;


public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";

        LinkedList<String> repository = save(cryptogram);
        answer = returnToString(repository);

        return answer;
    }
}


