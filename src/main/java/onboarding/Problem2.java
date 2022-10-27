package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram.toLowerCase();
        String[] charList = answer.split("");
        List<String> charArrayList = new ArrayList<>(Arrays.asList(charList));
        List<Integer> indexList = new ArrayList<>();
        do {
            indexList.clear();
            System.out.println(indexList);
            for (int i = 0; i < charArrayList.size(); i++) {
                if (i != charArrayList.size()-1) {
                    System.out.println(indexList);
                    if (charArrayList.get(i).equals(charArrayList.get(i + 1))) {
                        indexList.add(i);
                        indexList.add(i + 1);
                        System.out.println(indexList.get(0));
                    }
                }
            }
            for (int i = indexList.size()-1; i >= 0; i--) {
                charArrayList.remove(Integer.parseInt(indexList.get(i).toString()));
                System.out.println(charArrayList);
            }

        } while (!indexList.isEmpty());

        answer = String.join("", charArrayList);

        System.out.println("     cryptogram          result     ");
        System.out.println("\"" + cryptogram + "\"" +  "    " + "\"" + answer + "\"");

        return answer;
    }


}
