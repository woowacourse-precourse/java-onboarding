package onboarding;

import java.util.*;

public class Problem6 {
    public static boolean[] already;
    public static HashMap<String, Integer> hashMap;

    public static void init(int size) {
        already = new boolean[size];
        hashMap = new HashMap<>();
    }

    public static void check(String str, int order) {
        for (int i = 0; i < str.length()-1; i++) {
            if (!hashMap.containsKey(str.substring(i, i + 2))) {
                hashMap.put(str.substring(i, i + 2), order);
            } else {
                already[order] = true;
                already[hashMap.get(str.substring(i, i + 2))] = true;
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        init(forms.size());
        int i = 0;
        for (List<String> form : forms) {
            check(form.get(1), i);
            i++;
        }

        for (int j = 0; j < forms.size(); j++) {
            if(already[j] == true)
                answer.add(forms.get(j).get(0));
        }

        Collections.sort(answer);
        return answer;
    }
}
