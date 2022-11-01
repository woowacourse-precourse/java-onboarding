package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //사용자와 함께 아는 친구의 수 = 10점
        //사용자의 타임 라인에 방문한 횟수 = 1점
        //최대 5명을 return 하도록 solution 메서드를 완성하라.
        //이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬

        //총 유저목록을 만들어준다.
        List<List<Object>> friendList = new ArrayList<>();
        Set<String> userSet = new HashSet<>();
        friends.forEach(r -> {
            if (!user.equals(r.get(0))) userSet.add(r.get(0));
            if (!user.equals(r.get(1))) userSet.add(r.get(1));
        });
        userSet.addAll(visitors);

        userSet.forEach(u -> {
            friendList.add(new ArrayList<>(List.of(0, u, false)));
        });

        //이미 친구인 사람들을 체크해준다.
        friends.forEach(r -> {
            if (r.contains(user)){
                friendList.forEach(userinfo -> {
                    if (r.contains(userinfo.get(1))) userinfo.set(2, true);
                });
            }
        });

        //친구의 친구라면 점수를 추가해준다.
        friendList.forEach(friendinfo -> {
            if ((Boolean) friendinfo.get(2)) {
                friends.forEach(r -> {
                    if (r.contains(friendinfo.get(1))){
                        r.forEach(f -> {
                            if (!f.equals(friendinfo.get(1))) {
                                friendList.forEach(userinfo -> {
                                    if (f.equals(userinfo.get(1))) {
                                        userinfo.set(0, 10);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        //방문자의 점수를 추가해준다.
        visitors.forEach(v -> {
            friendList.forEach(userinfo -> {
                if (v.equals(userinfo.get(1))) {
                    if ((Integer) userinfo.get(0) == 0) {
                        userinfo.set(0, 1);
                    }
                    if ((Integer) userinfo.get(0) == 10) {
                        userinfo.set(0, 11);
                    }
                }
            });
        }
        );

        //친구여부와 0점여부를 필터링하고 정렬해준다.
        List<String> recommend = friendList.stream()
                .filter(f -> !((Boolean) f.get(2)))
                .filter(f -> (Integer) f.get(0) != 0)
                .sorted((f1, f2) -> (Integer)f1.get(0) + (Integer)f2.get(0))
                .map(f -> (String) f.get(1))
                .collect(Collectors.toList());

        //출력제한은 5이다.
        if (recommend.size() > 4) {
            answer = recommend.subList(0,5);
        } else {
            answer = recommend;
        }

        return answer;
    }
}
