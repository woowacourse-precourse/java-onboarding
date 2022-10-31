package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        // 2글자 이상 중복된 문자열 찾기 로직
        for (List<String> userInfos : forms) {
            String nickname = userInfos.get(1);

            // 점화식을 사용해 닉네임을 2자부터 한글자씩 증가하여 자른다.
            for (int i = 1; i < nickname.length(); i++) {
                String data = nickname.substring(0, i + 1);

                // queue 에 존재 한다면 set 에 저장하여 다시 한번 중복 값을 제거한다.
                if (queue.contains(data)) {
                    set.add(data);
                }
                // queue 에 중복된 문자열을 저장한다.
                queue.add(data);
            }
        }


        Set<String> result = new LinkedHashSet<>();

        // forms 에 닉네임을 순회한다.
        for (List<String> form : forms) {
            String nickname = form.get(1);

            // 중복된 닉네임 리스트가 들어있는 set 을 순회한다.
            for (String data : set) {

                // forms 에 들어있는 닉네임에 중복된 닉네임이 존재한다면 해당 이메일을 set에 저장하여 이메일의 중복도 제거한다.
                if (nickname.contains(data)) {
                    result.add(form.get(0));
                }
            }
        }

        // 내림차순 정렬과 반환타입 List 타입으로 변환한다.
        List<String> list = result.stream().sorted().collect(Collectors.toList());

        return list;
    }

    private static List<List<String>> settings() {
        List<List<String>> lists = new ArrayList<>() {{
            add(new ArrayList<>(List.of("jm@email.com", "제이엠")));
            add(new ArrayList<>(List.of("jason@email.com", "제이슨")));
            add(new ArrayList<>(List.of("woniee@email.com", "워니")));
            add(new ArrayList<>(List.of("mj@email.com", "엠제이")));
            add(new ArrayList<>(List.of("nowm@email.com", "이제엠")));
        }};
        return lists;
    }
}
