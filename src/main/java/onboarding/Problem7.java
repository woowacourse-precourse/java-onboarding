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
        friends.forEach(f -> checkFriend(user, friendList, f));


        //함께아는 친구이면 점수를 추가해준다.
        addNearFriendCount(friends, friendList);

        //방문자의 점수를 추가해준다.
        visitors.forEach(v -> addVisitCount(friendList, v));

        //친구 추천 리스트를 만들어준다.
        List<String> recommend = validateFriandList(friendList);

        //출력제한은 5이다.
        answer = limitLength(recommend);

        return answer;
    }

    //친구 관계를 체크해준다.
    private static void checkFriend(String user, List<List<Object>> friendList, List<String> r) {
        if (r.contains(user)){
            friendList.forEach(userinfo -> {
                if (r.contains(callName(userinfo))) setIsFriend(userinfo, true);
            });
        }
    }


    //방문시 Recommend Count를 증가시킨다.
    private static void addVisitCount(List<List<Object>> friendList, String v) {
        friendList.forEach(userinfo -> {
            if (v.equals(callName(userinfo))) {
                if (callRecommendCount(userinfo) == 0) {
                    setRecommendCount(userinfo, 1);
                }
                if (callRecommendCount(userinfo) == 10) {
                    setRecommendCount(userinfo, 11);
                }
            }
        });
    }

    //친구여부와 0점여부를 필터링하고 정렬하여, 친구 추천 리스트를 만들어준다.
    private static List<String> validateFriandList(List<List<Object>> friendList) {
        return friendList.stream()
                .filter(f -> !((Boolean) callIsFriend(f)))
                .filter(f -> callRecommendCount(f) != 0)
                .sorted((f1, f2) -> callRecommendCount(f1) + callRecommendCount(f2))
                .map(Problem7::callName)
                .collect(Collectors.toList());
    }

    //가까운 친구 카운트를 증가시킨다.
    private static void addNearFriendCount(List<List<String>> friends, List<List<Object>> friendList) {
        friendList.forEach(friendinfo -> {
            if (callIsFriend(friendinfo)) {
                friends.forEach(r -> {
                    if (r.contains(callName(friendinfo))){
                        r.forEach(f -> {
                            if (!f.equals(callName(friendinfo))) {
                                friendList.forEach(userinfo -> {
                                    if (f.equals(callName(userinfo))) {
                                        setRecommendCount(userinfo, 10);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    //추천리스트 출력을 5개로 제한한다
    private static List<String> limitLength(List<String> recommend) {
        List<String> answer;
        if (recommend.size() > 4) {
            answer = recommend.subList(0,5);
        } else {
            answer = recommend;
        }
        return answer;
    }

    private static Object setIsFriend(List<Object> userinfo, Boolean isFriend) {
        return userinfo.set(2, isFriend);
    }
    private static void setRecommendCount(List<Object> userinfo, int element) {
        userinfo.set(0, element);
    }
    private static Boolean callIsFriend(List<Object> friendinfo) {
        return (Boolean) friendinfo.get(2);
    }
    private static String callName(List<Object> userinfo) {
        return (String) userinfo.get(1);
    }
    private static Integer callRecommendCount(List<Object> f) {
        return (Integer) f.get(0);
    }
}
