package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        String[] charList = cryptogram.split("");
        List<String> charArrayList = new ArrayList<>(Arrays.asList(charList));
        checkStr(cryptogram);
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
                indexList = indexList.stream().distinct().sorted().collect(Collectors.toList());
                //연속되는 중복 문자가 3개일 경우 인덱스 중복으로 인해 생기는 문제 방지용 중복 제거 및 정렬
                for (int i = indexList.size() - 1; i >= 0; i--) {
                    charArrayList.remove(Integer.parseInt(indexList.get(i).toString()));
                }
            } while (!indexList.isEmpty());

            answer = String.join("", charArrayList);

        return answer;
    }

    public static void checkStr(String cryptogram) {
        if (!cryptogram.equals(cryptogram.toLowerCase())) {
            throw new IllegalStateException("문자열은 소문자로만 이루어져 있어야 합니다.");
        } else if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalStateException("문자열의 길이는 1 이상, 1000 이하여야 합니다.");
        }
    }


}
