package onboarding;

import java.util.*;

public class Problem6 {

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> sub1 = new ArrayList<>();
        List<String> sub2 = new ArrayList<>();
        List<String> sub3 = new ArrayList<>();
        List<String> sub4 = new ArrayList<>();
        List<String> sub5 = new ArrayList<>();
        sub1.add("jm@email.com");
        sub1.add("제이엠");
        sub2.add("jason@email.com");
        sub2.add("제이슨");
        sub3.add("woniee@email.com");
        sub3.add("워니");
        sub4.add("mj@email.com");
        sub4.add("엠제이");
        sub5.add("nowm@email.com");
        sub5.add("이제엠");
        input.add(sub1);
        input.add(sub2);
        input.add(sub3);
        input.add(sub4);
        input.add(sub5);
        List<String> solution = solution(input);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        for (List<String> form : forms) {
            Set<String> subSet = subWordSet(form.get(1));
            for (String s : map.keySet()) {
                if (subSet.contains(s)) {
                    answer.add(form.get(0));
                    answer.add(map.get(s));
                    break;
                }
            }

            for (String s : subSet) {
                map.put(s, form.get(0));
            }
        }
        List<String> ansList = new ArrayList<>();
        for (String s : answer) {
            ansList.add(s);
        }
        Collections.sort(ansList);
        return ansList;
    }

    static Set<String> subWordSet(String word) {
        Set<String> set = new HashSet<>();
        for (int len = 2; len <= word.length(); ++len) {
            for (int i = 0; i + len <= word.length(); ++i) {
                set.add(word.substring(i, i+len));
            }
        }
        return set;
    }
}
