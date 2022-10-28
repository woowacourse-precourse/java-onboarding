package onboarding;

import java.util.*;

public class Problem6 {
    static HashSet<String> result;
    static String[] emailArr;
    static String[] nickArr;
    static int totalNum;

    static boolean compareTwoNick(String ref, String target) {
        for (int i = 0; i < ref.length()-2; i++) {
            if (target.contains(ref.substring(i, i+2))) return true;
        }
        return false;
    }

    static void overlapDetector() {
        for (int i = 0; i < totalNum; i++) {
            String curNick = nickArr[i];
            for (int j = i + 1; j < totalNum; j++) {
                String targetNick = nickArr[j];
                if (compareTwoNick(curNick, targetNick)) {
                    result.add(emailArr[i]);
                    result.add(emailArr[j]);
                }
            }
        }
    }

    static void getInfo(List<List<String>> forms) {
        totalNum = forms.size();
        emailArr = new String[totalNum];
        nickArr = new String[totalNum];
        for (int i = 0; i < totalNum; i++) {
            String[] curInfo = forms.get(i).toArray(new String[0]);
            emailArr[i] = curInfo[0];
            nickArr[i] = curInfo[1];
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        result = new HashSet<>();
        getInfo(forms);
        overlapDetector();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
}
