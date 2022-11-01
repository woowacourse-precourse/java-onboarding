package onboarding;

import jdk.jshell.EvalException;

import java.util.*;


public class Problem6 {
    static String k;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Map<String, Set<String>>> list = new ArrayList<>();

        for (List<String> form : forms) {
            HashMap hashMap = new HashMap();
            hashMap.put(form.get(0), sliceName(form));
            list.add(hashMap);
        }

        a:
        for (int i = 0; i < list.size(); i++) {
            b:
            for (int j = i + 1; j < list.size(); j++) {
                c:
                for (String key : list.get(i).keySet()) {
                    if (list.get(j).containsKey(key)) {
                        answer.add(list.get(i).get(key).toString());
                        break c;
                    }
                }
            }
        }


        return answer;
    }

    public static Set<String> sliceName(List<String> form) {
        Set<String> WordMass = new HashSet<>();
        String nickName = form.get(1);

        for (int i = 0; i < form.get(1).length() - 1; i++) {
            WordMass.add(nickName.substring(i, i + 2));
        }

        return WordMass;
    }

    public static boolean isAlreadyExist(Set<String> WordMass, Set<String> dic) {
        for (String word : WordMass) {
            if (dic.contains(word)) {
                return true;
            }
        }

        return false;
    }
}
