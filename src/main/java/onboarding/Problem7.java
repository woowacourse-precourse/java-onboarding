package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriendList = new ArrayList<>();
        Map<String, Integer> relatedUser;

        checkUser(user);
        checkFriends(friends);
        checkVisitors(visitors);

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                alreadyFriendList.add(friend.get(0));
                alreadyFriendList.add(friend.get(1));
                alreadyFriendList.remove(user);
            }
        }
        Map<String, Integer> togetherKnowUser = checkTogetherKnow(user, friends, alreadyFriendList);
        Map<String, Integer> visitUser = checkWhoVisit(visitors, alreadyFriendList);
        togetherKnowUser.forEach((key, value) -> visitUser.merge(key, value, Integer::sum));
        relatedUser = visitUser;

        List<Map.Entry<String, Integer>> entries = relatedUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        int top5Counter = 5;
        for (int i = entries.size() - 1; i >= 0; i--) {
            if (top5Counter > 0 && entries.get(i) != null) {
                answer.add(entries.get(i).getKey());
            }
            top5Counter--;
        }

        return answer;
    }

    public static Map<String, Integer> checkTogetherKnow(String user, List<List<String>> friends, List<String> alreadyFriendList) {
        Map<String, Integer> togetherKnowUser = new HashMap<>();
        for (List<String> friend : friends) {
            for (String s : alreadyFriendList) {
                if (friend.contains(s)) {
                    for (int k = 0; k < 2; k++) {
                        if (!Objects.equals(friend.get(k), s) && !Objects.equals(friend.get(k), user)) {
                            if (!togetherKnowUser.containsKey(friend.get(k))) {
                                togetherKnowUser.put(friend.get(k), 10);
                            } else {
                                togetherKnowUser.put(friend.get(k), togetherKnowUser.get(friend.get(k)) + 10);
                            }
                        }
                    }
                }
            }
        }
        return togetherKnowUser;
    }

    public static Map<String, Integer> checkWhoVisit(List<String> visitors, List<String> alreadyFriendList) {
        Map<String, Integer> visitUser = new HashMap<>();
        for (String visitor : visitors) {
            if (!alreadyFriendList.contains(visitor)) {
                if (!visitUser.containsKey(visitor)) {
                    visitUser.put(visitor, 1);
                } else {
                    visitUser.put(visitor, visitUser.get(visitor) + 1);
                }
            }
        }
        return visitUser;
    }

    public static void checkUser(String user) {
        if (user.length() < 1 || user.length() > 30) {
            throw new IllegalStateException("사용자 아이디는 1자 이상, 30자 이하여야 합니다.");
        }
        if (!user.toLowerCase().equals(user)) {
            throw new IllegalStateException("사용자 아이디는 소문자로만 이루어져 있어야 합니다.");
        }
    }

    public static void checkFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10_000) {
            throw new IllegalStateException("친구 관계 정보의 개수는 1 이상, 10,000 이하여야 합니다.");
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                throw new IllegalStateException("친구 관계 정보가 잘못되었습니다.");
            } else {
                for (String user : friend) {
                    if (!user.toLowerCase().equals(user)) {
                        throw new IllegalStateException("사용자 아이디는 소문자로만 이루어져 있어야 합니다.");
                    } else if (user.length() < 1 || user.length() > 30) {
                        throw new IllegalStateException("사용자 아이디는 1자 이상, 30자 이하여야 합니다.");
                    }
                }
            }
        }
    }

    public static void checkVisitors(List<String> visitors) {
        if (visitors.size() > 10_000) {
            //visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다. 이 때, visitors는 리스트이므로 0 미만이 될 수 없다.
            throw new IllegalStateException("방문자 수는 0명 이상, 10,000명 이하여야 합니다.");
        } else {
            for (String visitor : visitors) {
                if (!visitor.toLowerCase().equals(visitor)) {
                    throw new IllegalStateException("사용자 아이디는 소문자로만 이루어져 있어야 합니다.");
                }
            }
        }
    }
}
