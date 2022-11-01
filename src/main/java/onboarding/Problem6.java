package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<String>> map = mapFragmentedNNEmail(forms);

        List<String> answer = findEmail(map);

        return answer;
    }

    private static List<String> fragmentNN(String nickName) {
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < nickName.length() - 1; i++) {
            String subString = nickName.substring(i, i + 2);
            ret.add(subString);
        }

        return ret;
    }

    private static HashMap<String, List<String>> mapFragmentedNNEmail(List<List<String>> forms) {
        HashMap<String, List<String>> ret = new HashMap<>();

        for (List<String> list : forms) {
            List<String> keys = fragmentNN(list.get(1));

            for (String key : keys) {
                ret.putIfAbsent(key, new ArrayList<>());
                ret.get(key).add(list.get(0));
            }
        }

        return ret;
    }

    private static List<String> findEmail(HashMap<String, List<String>> map) {
        HashSet<String> hs = new HashSet<>();

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                hs.addAll(map.get(key));
            }
        }

        List<String> ret = new ArrayList<>(hs);

        ret.sort(Comparator.naturalOrder());

        return ret;
    }
}
