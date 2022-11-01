package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, String> infoMap = setInfoMap(forms);
        Set<String> emailSet  = new HashSet<>();
        String dupStr;
        for(String s : infoMap.keySet()) {
            dupStr = getDuplicateString(s);
            if(!dupStr.equals("")) {
                emailSet.add(infoMap.get(dupStr));
                emailSet.add(infoMap.get(s));
            }
        }
        answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    private static Map<String, String> setInfoMap(List<List<String>> form) {
        // k : nickname | v : email
        Map<String, String> m = new HashMap<>();
        for(List<String> l : form) {
            m.put(l.get(1),l.get(0));
        }
        return m;
    }

    // k : twoLetters | v : nickname
    private static Map<String, String> dupMap = new HashMap<>();
    private static String getDuplicateString(String nickname) {
        String twoLetters;
        for(int i = 0; i < nickname.length() - 1; i++) {
            twoLetters = nickname.substring(i,i+2);
            if(dupMap.containsKey(twoLetters)) {
                return dupMap.get(twoLetters);
            } else {
                dupMap.put(twoLetters, nickname);
            }
        }
        return "";
    }
}
