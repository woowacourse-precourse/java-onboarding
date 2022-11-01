package onboarding;
import java.util.*;

public class Problem6 {
    private static Set<String> wordSet = new HashSet<>();
    public static Boolean inWordSet(String twoWord) {
        if (wordSet.contains(twoWord)) return true;
        return false;
    }
    //public static Boolean inTwoWordList(String )

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<String>();
        List<Map<Integer, String>> twoWordList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String two;
            String nick = forms.get(i).get(1);

            for (int j = 0; j < nick.length() - 1; j++) {
                Map<Integer, String> map = new HashMap<>();
                two = nick.substring(j, j + 2);

                if (inWordSet(two)) {
                    for (int k = 0; k < twoWordList.size(); k++) {
                        Map<Integer, String> twoWordMap = twoWordList.get(k);
                        if (twoWordMap.containsValue(two)) {
                            int Key = -1;
                            for (Integer key : twoWordMap.keySet()) {
                                Key = key;
                            }
                            answer.add(forms.get(Key).get(0));
                            break;
                        }
                    }
                    answer.add(forms.get(i).get(0));
                }
                wordSet.add(two);
                map.put(j, two);
                twoWordList.add(map);
            }
        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            if (!resultList.contains(answer.get(i))) {
                resultList.add(answer.get(i));
            }
        }
        answer = resultList;
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
