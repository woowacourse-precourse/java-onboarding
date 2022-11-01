package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<String> cryptogramToArray = stringToArr(cryptogram);
        ArrayList<String> answerArray = new ArrayList<>();
        for(int i = 0; i<500; i++) {
            answerArray = finalDeleter(cryptogramToArray);
        }
        return String.join("", answerArray);
    }

    public static ArrayList<String> stringToArr(String str) {
        return new ArrayList<>(List.of(str.split("")));
    }

    public static void sameCharDeleter(ArrayList<String> substringArray, int index) {
        substringArray.subList(index, index+2).clear();
    }

    public static ArrayList<String> finalDeleter(ArrayList<String> stringToArray) {
        for (int i = 0; i < stringToArray.size() -1 ; i++) {
            if (Objects.equals(stringToArray.get(i), stringToArray.get(i + 1))) {
                sameCharDeleter((stringToArray), i);
            }
        }
        return stringToArray;
    }
}
