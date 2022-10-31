package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem7 {
    static void isCheck(String user, List<List<String>> friends, List<String> visitors) {
        userCheck(user);
        friendsCheck(friends);
        visitorsCheck(visitors);
    }

    static void userCheck(String user) {
        if (user.length() < 1 || user.length() > 30) {
            System.out.println("user의 길이가 잘못되었습니다.");
        }
        if (!Pattern.matches("[a-z]*$", user)) {
            System.out.println("user는 알파벳 소문자만 입력가능합니다.");
        }
    }

    static void friendsCheck(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            System.out.println("친구관계정보는 1이상 10,000이하까지 입력이 가능합니다.");
        }
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j <= 1; j++) {
                if (friends.get(i).get(j).length() < 1 || friends.get(i).get(j).length() > 30) {
                    System.out.println("친구아이디 길이는 1이상 30이하까지 입력이 가능합니다.");
                }
            }
        }
    }

    static void visitorsCheck(List<String> visitors) {
        if (visitors.size() < 0 || visitors.size() > 10000) {
            System.out.println("방문기록은 0이상 10,000이하까지 입력이 가능합니다.");
        }
    }

    static List<String> createFriendsList(String user, List<List<String>> friends, List<String> alreadyFriends) {
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j <= 1; j++) {
                if (friends.get(i).get(j).contains(user) && j == 0) {
                    alreadyFriends.add(friends.get(i).get(1));
                } else if (friends.get(i).get(j).contains(user) && j == 1) {
                    alreadyFriends.add(friends.get(i).get(0));
                }
            }
        }
        return alreadyFriends;
    }

    static HashMap<String, Integer> friendsScore(String user, List<List<String>> friends, List<String> alreadyFriends, HashMap<String, Integer> friendsRecommendation) {
        createFriendsList(user, friends, alreadyFriends);

        for (int i = 0; i < alreadyFriends.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                for (int k = 0; k <= 1; k++) {
                    if (friends.get(j).get(k).contains(alreadyFriends.get(i)) && k == 0
                            && friends.get(j).get(1) != user) {
                        if (isContains(i, j, friends, friendsRecommendation)) {
                            friendsRecommendation.put(friends.get(j).get(1), friendsRecommendation.get(friends.get(j).get(1)) + 10);
                        } else {
                            friendsRecommendation.put(friends.get(j).get(1), 10); // 없다면
                        }

                    } else if (friends.get(j).get(k).contains(alreadyFriends.get(i)) && k == 1
                            && friends.get(j).get(0) != user) {
                        if (isContains(i, j, friends, friendsRecommendation))
                            friendsRecommendation.put(friends.get(j).get(0), friendsRecommendation.get(friends.get(j).get(1)) + 10);
                        } else {
                            friendsRecommendation.put(friends.get(j).get(0), 10); // (j)(0)를 넣어줘라
                        }
                    }
                }
            }
        return friendsRecommendation;
    }

    static boolean isContains(int i, int j, List<List<String>> friends, HashMap<String, Integer> friendsRecommendation) {
        if (friendsRecommendation.containsKey(friends.get(j).get(1))) {
            return true;
        }
        return false;
    }

    static HashMap<String, Integer> visitorsScore(String user, List<String> visitors, List<String> alreadyFriends, HashMap<String, Integer> friendsRecommendation) {

        for (int i = 0; i < visitors.size(); i++) {
            if (friendsRecommendation.containsKey(visitors.get(i)) && !alreadyFriends.contains(visitors.get(i))) {
                friendsRecommendation.put(visitors.get(i), friendsRecommendation.get(visitors.get(i)) + 1);
            } else if (!alreadyFriends.contains(visitors.get(i))) {
                friendsRecommendation.put(visitors.get(i), 1);
            }
        }
        return friendsRecommendation;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriends = new ArrayList<>();
        HashMap<String, Integer> friendsRecommendation = new HashMap<>();
        isCheck(user, friends, visitors);

        friendsScore(user, friends, alreadyFriends, friendsRecommendation);
        visitorsScore(user, visitors, alreadyFriends, friendsRecommendation);

        return answer;
    }
}
