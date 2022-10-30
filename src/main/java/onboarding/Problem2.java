package onboarding;



import java.util.LinkedList;
import static onboarding.problem2.Repository.save;
import static onboarding.problem2.Returner.returnToString;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";

        // 저장 기능
        LinkedList<String> save = save(cryptogram);

        // 반환 기능
        answer = returnToString(save);


        return answer;
    }
}




