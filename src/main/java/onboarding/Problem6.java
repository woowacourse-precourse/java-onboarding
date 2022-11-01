package onboarding;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Problem6 {
    /**key: 연속되는 문자 2개
     * value: 연속되는 문자를 가진 크루의 이메일
     * e.g. {
     *     "제이": ["jason@email.com", "jm@email.com", "mj@email.com"]
     * }
     * value 길이가 2 이상이면 목록을 정렬해서 반환
     * */
    private static Map<String, Set<String>> nickNameMap = new HashMap<>();
    
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        for (List<String> form : forms) {
            setNicknameMap(form);
        }

        for (String sameChars : nickNameMap.keySet()) {
            Set<String> emails = nickNameMap.get(sameChars);
            if (emails.size() > 1) {
                answer.addAll(emails);
            }
        }

        return Arrays.asList(Arrays.stream(answer.toArray()).sorted().toArray(String[]::new));
    }

    private static void setNicknameMap(List<String> form) {
        String email = form.get(0);
        String name = form.get(1);
        
        for(int i = 0; i < name.length() - 1; i++) {
            String chars = i == name.length() - 1 ? name.substring(i) : name.substring(i, i + 2);
            Set<String> emailSet = nickNameMap.getOrDefault(chars, new HashSet<>());
            emailSet.add(email);
            nickNameMap.put(chars, emailSet);
        }
    }
}
