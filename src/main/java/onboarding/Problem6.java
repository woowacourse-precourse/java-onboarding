package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> answerSet = new TreeSet<>();
        Map<String, String> overWordDic = new HashMap<>();

        for (List<String> f : forms) {
            String email = f.get(0);
            String name = f.get(1);
            Boolean isPut = false;                                  // 해당 이메일을 set에 넣었는지 안넣었는지 저장하는 변수

            for (int i = 0; i < name.length() - 1; i++) {
                String word = name.substring(i, i + 2);

                if (overWordDic.containsKey(word)) {                // dic에 있는 글자일 경우 중복된 이름을 사용한 것이므로 이메일 넣어야함
                    String wordEmail = overWordDic.get(word);

                    if (!wordEmail.equals(email)) {                 // 같은 이름 내에서 두글자가 반복될 경우(ex 이오이오)를 제외
                        if (!isPut) {
                            answerSet.add(email);                   // set에 이메일을 넣지 않은 경우 이메일을 넣음
                        }
                        answerSet.add(wordEmail);
                        isPut = true;                               // 이메일을 set에 넣었으므로 true로 변경
                    }
                } else {
                    overWordDic.put(word, email);                   // dic에 없는 글자일 경우 추가
                }
            }
        }
        return new ArrayList<>(answerSet);
    }
}

