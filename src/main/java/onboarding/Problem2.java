package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
        StringBuilder answer = new StringBuilder();
        List<String> answerList = removeDouble(cryptogram);

        for (String st : answerList) {
            answer.append(st);
        }

        return answer.toString();
    }

    public static List<String> removeDouble(String str) {

        List<String> strList = new ArrayList<>(Arrays.asList(str.split("")));

        while (true) {
            HashSet<Integer> duplicateList = new HashSet<>();
            for (int i = 0; i < strList.size() - 1; i++) {
                if (Objects.equals(strList.get(i), strList.get(i + 1))) {
                    duplicateList.add(i);
                    duplicateList.add(i + 1);
                }
            }
            if (duplicateList.size() == 0) {
                break;
            }

            Iterator<String> strIter = strList.iterator();
            int idx = 0;
            while (strIter.hasNext()) {
                strIter.next();
                if (duplicateList.contains(idx)) strIter.remove();
                idx += 1;
            }
        }

        return strList;

    }
}
