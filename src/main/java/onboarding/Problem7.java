package onboarding;

import java.util.*;
import java.util.Map;

public class Problem7 {

    private static final int ID_MAX = 30;
    private static final int ID_MIN = 1;
    private static final int VISITORS_MAX = 10000;
    private static final int VISITORS_MIN = 0;
    private static final int FRIENDS_MAX = 10000;
    private static final int FRIENDS_MIN = 1;
    private static final String LOWERCASE_REGEX = "^[a-z]+";
    private static final int ANSWER_LIMIT = 5;
    private static List<String> alreadyFriends = new ArrayList<>();
    private static Map<String, Integer> friendsScore = new HashMap<>();

    public static void main(String[] args) {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of( "jun", "mrko", "bedi");
        List<String> answer = solution(user, friends, visitors);
        for(String name : answer) {
            System.out.println(name);
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        checkValidation(user, friends, visitors);
        for(List<String> friendShip : friends) {
            findUserFriends(user, friendShip);
        }

        findFriendsOfFriends(user, friends);
        findVisitors(visitors);

        answer = sortFriendsList();
        if(answer.size() > ANSWER_LIMIT) {
            returnFiveNames(answer);
        }

        return answer;
    }

    private static void checkValidation(String user, List<List<String>> friends, List<String> visitors) {
        checkValidateUserLength(user);
        checkUseOnlyLowerCaseInUser(user);
        checkValidateFriendsLength(friends);
        for(List<String> friendShip : friends) {
            checkValidateFriendsIdLength(friendShip);
            checkUseOnlyLowerCaseInId(friendShip);
        }
        checkValidateVisitorsLength(visitors);
    }

    private static void checkValidateUserLength(String user) {
        int len = user.length();
        if(len > ID_MAX || len < ID_MIN) {
            throw new RuntimeException("user의 길이는 1 이상 30 이하인 문자열이어야 합니다.");
        }
    }

    private static void checkUseOnlyLowerCaseInUser(String user) {
        if(!user.matches(LOWERCASE_REGEX)) {
            throw new RuntimeException("아이디에는 소문자만 사용할 수 있습니다.");
        }
    }

    private static void checkValidateFriendsLength(List<List<String>> friends) {
        int len = friends.size();
        if(len > FRIENDS_MAX || len < FRIENDS_MIN) {
            throw new RuntimeException("friends의 길이는 1 이상 10000 이하인 리스트/배열 이어야 합니다.");
        }
    }

    private static void checkValidateFriendsIdLength(List<String> friendShip) {
        for(String id : friendShip) {
            int len = id.length();
            if(len > ID_MAX || len < ID_MIN) {
                throw new RuntimeException("아이디의 길이는 1 이상 30 이하인 문자열이어야 합니다.");
            }
        }
    }

    private static void checkUseOnlyLowerCaseInId(List<String> friendShip) {
        for(String id : friendShip) {
            int len = id.length();
            if(!id.matches(LOWERCASE_REGEX)) {
                throw new RuntimeException("아이디에는 소문자만 사용할 수 있습니다.");
            }
        }
    }

    private static void checkValidateVisitorsLength(List<String> visitors) {
        int len = visitors.size();
        if(len > VISITORS_MAX || len < VISITORS_MIN) {
            throw new RuntimeException("Visitors의 길이는 0 이상 10000 이하인 리스트/배열 이어야 합니다.");
        }
    }

    private static void findUserFriends(String user, List<String> friendShip) {
        if(friendShip.get(0).equals(user)) {
            alreadyFriends.add(friendShip.get(1));
        }
        if(friendShip.get(1).equals(user)) {
            alreadyFriends.add(friendShip.get(0));
        }
    }

    private static void findFriendsOfFriends(String user, List<List<String>> friends) {
        for(int i = 0; i < alreadyFriends.size(); i++) {
            for(int j = 0; j < friends.size(); j++) {
                if(friends.get(j).get(0).equals(alreadyFriends.get(i)) && !friends.get(j).get(1).equals(user)) {
                    friendsScore.put(friends.get(j).get(1),
                            friendsScore.getOrDefault(friends.get(j).get(1), 0) + 10);
                }
                if(friends.get(j).get(1).equals(alreadyFriends.get(i)) && !friends.get(j).get(0).equals(user)) {
                    friendsScore.put(friends.get(j).get(0),
                            friendsScore.getOrDefault(friends.get(j).get(0), 0) + 10);
                }
            }
        }
    }

    private static void findVisitors(List<String> visitors) {
        Map<String, Integer> aa = new HashMap<>();
        int cnt = 0;
        for(String s : visitors) {
            aa.put(s, aa.getOrDefault(s, 0) + 1);
        }
        for(String s : aa.keySet()) {
            for(int i = 0; i < alreadyFriends.size(); i++) {
                if(s.equals(alreadyFriends.get(i))) {
                    break;
                }
                cnt++;
            }
            if(cnt == alreadyFriends.size()) {
                friendsScore.put(s, aa.get(s));
            }
            cnt = 0;
        }
    }

    private static List<String> sortFriendsList() {
        List<String> answer = new ArrayList<>(friendsScore.keySet());
        Collections.sort(answer, (o1, o2) -> (friendsScore.get(o2).compareTo(friendsScore.get(o1))));

        return answer;
    }

    private static void returnFiveNames(List<String> answer) {
        for(int i = 5; i < answer.size(); i++) {
            answer.remove(i);
        }
    }

}
