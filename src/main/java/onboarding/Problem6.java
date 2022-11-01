package onboarding;

import java.util.*;
import java.util.stream.Collectors;


class Crew {
    private final String email;
    private final String nickname;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}

class DuplicateFinder {
    private List<Crew> crews;

    public DuplicateFinder(List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> getDuplicateCrewList() {
        Set<String> duplicateCrewSet = new HashSet<>();
        Map<String, String> splitNickEmailMap = new HashMap<>();

        for (Crew c : crews) {
            String email = c.getEmail();
            String nickname = c.getNickname();

            List<String> splitNickList = getSplitNickList(nickname);

            for (String nickSub : splitNickList) {
                if (!splitNickEmailMap.containsKey(nickSub)) {
                    splitNickEmailMap.put(nickSub, email);
                    continue;
                }

                String ogEmail = splitNickEmailMap.get(nickSub);
                duplicateCrewSet.add(ogEmail);

                duplicateCrewSet.add(email);

                splitNickEmailMap.put(nickSub, email);
            }
        }

        return new ArrayList<>(duplicateCrewSet).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getSplitNickList(String nickname) {
        List<String> splitNickList = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String sub = nickname.substring(i, i + 2);
            splitNickList.add(sub);
        }
        return splitNickList;
    }
}

/*
기능 목록
1. 중복 닉네임 검출
2. 중복 닉네임 오름차순 중복제거 출력
3. 이메일 입력 형식 예외 처리
4. 닉네임 입력 형식 예외 처리
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = new ArrayList<>();
        for (List<String> l : forms) {
            crews.add(new Crew(l.get(0), l.get(1)));
        }

        DuplicateFinder duplicateFinder = new DuplicateFinder(crews);
        return duplicateFinder.getDuplicateCrewList();
    }
}
