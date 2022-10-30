package onboarding.problem2;

import java.util.LinkedList;

import static java.lang.String.valueOf;
import static onboarding.problem2.Repository.stored;
import static onboarding.problem2.Returner.returnLinkedList;

public class Controller {

    // 검사 기능
    public static boolean controlCryptogram(LinkedList<String> encode) {

        for(int i=0; i<encode.size(); i++){

            // 삭제 기능
            if (encode.get(i).equals(encode.get(i+1))) {
                encode.remove(i);
                encode.remove(i+1);

                return true;
            }
        }

        return false;
    }
}


