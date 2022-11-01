package onboarding;


import java.util.LinkedList;


import static onboarding.problem2.Recursion.recursive;
import static onboarding.problem2.RecursionThird.recursiveThird;
import static onboarding.problem2.RecursionTwice.recursiveTwice;
import static onboarding.problem2.Repository.save;
import static onboarding.problem2.Returner.returnToString;


public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";

        LinkedList<String> repository = save(cryptogram);

        LinkedList<String> recursion = recursive(repository);
        LinkedList<String> recursiveTwice = recursiveTwice(recursion);
        LinkedList<String> recursiveThird = recursiveThird(recursiveTwice);


        answer = returnToString(recursiveThird);

        return answer;
    }
}


