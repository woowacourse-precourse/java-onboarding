package onboarding;

import java.util.LinkedList;


import static onboarding.problem2.Repository.stored;
import static onboarding.problem2.Returner.returnLinkedList;


public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";
        LinkedList<String> stringLinkedList = new LinkedList<>();

        LinkedList<String> stored = stored(cryptogram);

        for(int i=0; i<stringLinkedList.size(); i++) {
            if (stringLinkedList.get(i).equals(stringLinkedList.get(i+1))) {
                stringLinkedList.remove(i);
                stringLinkedList.remove(i+1);
            }else{
                String result = returnLinkedList(stringLinkedList);
                answer = result;
            }
        }

        return answer;
    }
}


