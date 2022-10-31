package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String, String> hash;
    public static Set<String> result = new HashSet<>();


    public static void makeHashMap(List<List<String>> forms) {
        hash = new HashMap<>();
        for(int i = 0; i < forms.size(); i++) {
            List<String> data = forms.get(i);
            hash.put(data.get(1), data.get(0));
        }
    }

    public static void check(String name1, String name2) {
        if (duplication(name1, name2)) {
            result.add(name1);
            result.add(name2);
        }
    }

    public static boolean duplication(String name1, String name2) {
        System.out.println(name1 + " : " + name2);
        // 워니 엠제이
        // i = 2
        // j = 0, 1
        for (int i = 2; i < name1.length() + 1; i++) {
            for (int j = 0; j + i < name1.length() + 1; j++) {
                String str = name1.substring(j, j+i);
                System.out.println(str);

                if (name2.contains(str)) {
                    String emailName1 = hash.get(name1);
                    String emailName2 = hash.get(name2);
                    result.add(emailName1);
                    result.add(emailName2);
                }
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        makeHashMap(forms);

        List<String> firstCrew;
        List<String> secondCrew;
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                firstCrew = forms.get(i);
                secondCrew = forms.get(j);
                check(firstCrew.get(1), secondCrew.get(1));
            }
        }

        Iterator<String> iter = result.iterator();

        while (iter.hasNext()) {   // 꺼낼 것이 있다면 true 리턴.
            String str = iter.next(); // next()메소드는 하나를 꺼낸다. 하나를 꺼내면 자동으로 다음것을 참조한다.
            answer.add(str);
        }

        //오름차순 정렬
        Collections.sort(answer);

        return answer;
    }
}
