package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = solution(forms);
        //List.of("jason@email.com", "jm@email.com", "mj@email.com");
        System.out.println(result);
    }


    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        List<String> names = new ArrayList<>();
        //대상자들을 저장하는 이메일
        List<String> emails = new ArrayList<>();

        //이름들만 저장
        for (List<String> s : forms) names.add(s.get(1));

        //스택에서 이름을 제거해 가며 나머지 이름들을 비교


        for (int i = 0; i < names.size(); i++) {
            String key = names.get(i);//제이엠
            for (int j = i + 1; j < names.size(); j++) {
                String target = names.get(j);
                boolean flag = duplication(key, target);
                if (flag) {
                    answer.add(target);
                    answer.add(key);
                }
            }
        }
        Iterator<String> it = answer.iterator();
        while (it.hasNext()) {
            String name = it.next();
            for (List<String> e : forms) {
                if (e.get(1).equals(name)) {
                    emails.add(e.get(0));
                }
            }
        }

        Collections.sort(emails);

        return emails;
    }

    private static boolean duplication(String key, String target) {
        List<String> list = makePossibility(key);

        for (String s : list) {
            if (target.contains(s)) return true;

        }
        return false;
    }

    private static List<String> makePossibility(String key) {
        List<String> list = new ArrayList<>();
        String[] arr1 = key.split("");
        for (int i = 1; i < arr1.length; i++) {
            list.add(arr1[i - 1] + arr1[i]);
        }
        return list;
    }


}