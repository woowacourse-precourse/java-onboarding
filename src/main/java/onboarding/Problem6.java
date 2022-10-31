package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < forms.get(1).size(); i++) {
            final String name = forms.get(1).get(i).toString();

            if (name.length() < 2) {
                break;
            }


            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j + 2);
                if (hashMap.containsKey(key)) {
                    final String email = hashMap.get(key);
                    if (!email.equals(forms.get(0).get(i))) {
                        emails.add(email);
                        emails.add(forms.get(0).get(i));
                    }
                }
                hashMap.put(key, forms.get(0).get(i));
            }
        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
    // 중복 글자 찾는 함수

    public static void main(String[] args) {
        List<List<String>> str = new ArrayList<>();

        ArrayList<String> data1 = new ArrayList<>();
        data1.add("jm@email.com");
        data1.add("jason@email.com");
        data1.add("woniee@email.com");
        data1.add("mj@email.com");
        data1.add("nowm@email.com");

        ArrayList<String> data2 = new ArrayList<>();
        data2.add("제이엠");
        data2.add("제이슨");
        data2.add("워니");
        data2.add("엠제이");
        data2.add("이제엠");

        str.add(data1);
        str.add(data2);

        System.out.println(solution(str));
    }
}