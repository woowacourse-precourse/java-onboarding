package onboarding;


import onboarding.problem7.exception.FriendsException;
import onboarding.problem7.SnsId;

import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SnsId userId = new SnsId(user);
        checkMaxVisit(visitors);

        return List.of("1");
    }

    private static List<SnsId> convertVisitorIds(List<String> visitors) {
        return visitors.stream().map(SnsId::new).collect(Collectors.toList());
    }

    private static void checkMaxVisit(List<String> visitors) {
        if (visitors.size() > 10_000) {
            throw new FriendsException("처리할 수 있는 친구 정보보다 더 많습니다.");
        }
    }

    private static List<List<SnsId>> convertFriendsId(List<List<String>> friends) {
        return friends.stream()
                .map(friend -> friend.stream().map(SnsId::new)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

}
