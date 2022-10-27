package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String[] charList = answer.split("");
        List<String> charArrayList = new ArrayList<>(Arrays.asList(charList));
        if (!cryptogram.equals(cryptogram.toLowerCase())) {
            throw new IllegalStateException("문자열은 소문자로만 이루어져 있어야 합니다.");
        } else if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalStateException("문자열의 길이는 1 이상, 1000 이하여야 합니다.");
        } else {
            List<Integer> indexList = new ArrayList<>();
            do {
                indexList.clear();
                for (int i = 0; i < charArrayList.size(); i++) {
                    if (i != charArrayList.size() - 1) {
                        if (charArrayList.get(i).equals(charArrayList.get(i + 1))) {
                            indexList.add(i);
                            indexList.add(i + 1);
                        }
                    }
                }
                for (int i = indexList.size() - 1; i >= 0; i--) {
                    charArrayList.remove(Integer.parseInt(indexList.get(i).toString()));
                }
            } while (!indexList.isEmpty());

            answer = String.join("", charArrayList);

            System.out.println("     cryptogram          result     ");
            System.out.println("\"" + cryptogram + "\"" + "    " + "\"" + answer + "\"");
        }

        return answer;
    }
}
