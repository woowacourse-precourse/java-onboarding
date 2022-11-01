package onboarding;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriendList = new ArrayList<>();
        Map<String, Integer> relatedUser = new HashMap<>();
        for (int i = 0; i<friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                alreadyFriendList.add(friends.get(i).get(0));
                alreadyFriendList.add(friends.get(i).get(1));
                alreadyFriendList.remove(user);
            }
        }
        Map<String, Integer> togetherKnowUser = checkTogetherKnow(user, friends, alreadyFriendList);
        Map<String, Integer> visitUser = checkWhoVisit(visitors, alreadyFriendList);
        togetherKnowUser.forEach((key, value) -> visitUser.merge(key, value, Integer::sum));
        relatedUser = visitUser;
        List<Map.Entry<String, Integer>> entries =
                relatedUser.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());
        System.out.println(relatedUser + "가나다");

        entries = relatedUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());


        System.out.println(relatedUser);


        int top5Counter = 5;
        for (int i = entries.size()-1; i >= 0; i--) {
            if (top5Counter > 0 && entries.get(i) != null)
            {
                answer.add(entries.get(i).getKey());
        }
            top5Counter--;
        }
       // answer = new ArrayList<>(relatedUser.keySet());


        System.out.println(answer);
        return answer;
    }

    public static Map<String, Integer> checkTogetherKnow(String user, List<List<String>> friends, List<String> alreadyFriendList) {
        Map<String, Integer> togetherKnowUser = new HashMap<>();
        for (int i = 0; i<friends.size(); i++) {
            for (int j = 0; j<alreadyFriendList.size(); j++) {
                if (friends.get(i).contains(alreadyFriendList.get(j))) {
                    for (int k = 0; k < 2; k++) {
                        if (!Objects.equals(friends.get(i).get(k), alreadyFriendList.get(j)) && !Objects.equals(friends.get(i).get(k), user)) {
                            if (!togetherKnowUser.containsKey(friends.get(i).get(k))) {
                                System.out.println("새로운" + friends.get(i).get(k));
                                togetherKnowUser.put(friends.get(i).get(k), 10);
                            } else if (togetherKnowUser.containsKey(friends.get(i).get(k))) {
                                System.out.println("안새로운" + friends.get(i).get(k));
                                togetherKnowUser.put(friends.get(i).get(k), togetherKnowUser.get(friends.get(i).get(k)) + 10);
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
        for (int i = 0; i<visitors.size(); i++) {
            if (!alreadyFriendList.contains(visitors.get(i))) {
                if (!visitUser.containsKey(visitors.get(i))) {
                    System.out.println("새로운방문자" + visitors.get(i));
                    visitUser.put(visitors.get(i), 1);
                } else if (visitUser.containsKey(visitors.get(i))) {
                    visitUser.put(visitors.get(i), visitUser.get(visitors.get(i)) + 1);
                    System.out.println("안새로운방문자" + visitors.get(i));
                }
                System.out.println(visitUser);
            }
        }
        return visitUser;
    }

    public static void main(String[] args) {
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("donut", "newKing"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("donut", "newKing"),
                List.of("king", "andole"),
                List.of("king", "jun"),
                List.of("king", "mrko"),
                List.of("king", "newKing")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "newKing1", "newKing1", "newKing1");
        solution("mrko", friends, visitors );
    }


}
