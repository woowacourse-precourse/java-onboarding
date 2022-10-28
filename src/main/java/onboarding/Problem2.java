package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static List<String> stringToList(String cryptogram) {
        String[] cryptogramArray = cryptogram.split("");
        List<String> result = new ArrayList<>(Arrays.asList(cryptogramArray));

        return result;
    }

    public static String listToString(List<String> stringList) {
        String result = stringList.toString()
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")
            .replace(" ", "");

        return result;
    }

    public static String removeStringDuplication(String cryptogram) {
        List<String> temp = new ArrayList<>();
        List<String> cryptogramList = stringToList(cryptogram);

        for (int i=0; i < cryptogramList.size(); i++) {
            if (i == cryptogramList.size() - 1) temp.add(cryptogramList.get(i));
            else if (cryptogramList.get(i).equals(cryptogramList.get(i + 1))) {
                i++;
            }
            else {
                temp.add(cryptogramList.get(i));
            }
        }

        String result = listToString(temp);

        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
