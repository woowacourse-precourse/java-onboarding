package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;

    private static final int FRIEND_RECOMMENDATION_SCORE = 10;

    private static final int VISITOR_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!verifyException(user, friends, visitors)) {
            return List.of("Error");
        }

        List<String> userFriend = findUserFriend(user, friends);
        Map<String, Integer> recommendedFriend = makeRecommend(user, userFriend, friends, visitors);
        addVisitorScore(recommendedFriend, userFriend,visitors);

        return makeAnswer(recommendedFriend);
    }

    private static boolean verifyException(String user, List<List<String>> friends, List<String> visitors) {
        return (checkUser(user) || checkFriend(friends) || checkVisitor(visitors));
    }

    private static boolean checkUser(String user) {
        return (checkUserLength(user) || isLowerLetter(user));
    }

    private static boolean checkUserLength(String user) {
        return (user != null && user.length() >= 1 && user.length() <= 30);
    }

    private static boolean isLowerLetter(String user) {
        for (char letter : user.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFriend(List<List<String>> friends) {
        return (checkFriendSize(friends.size()) || checkFriendId(friends) || checkDuplicate(friends));
    }

    private static boolean checkFriendSize(int size) {
        return (size >= 1 && size <= 10000);
    }

    private static boolean checkFriendId(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (checkUser(friend.get(FIRST_ID)) || checkUser(friend.get(SECOND_ID))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDuplicate(List<List<String>> friends) {
        Set<List<String>> friendsSet = new HashSet<>();

        for (List<String> friend : friends) {
            if (friendsSet.contains(friends)) {
                return false;
            }
            friendsSet.add(friend);
        }
        return true;
    }

    private static boolean checkVisitor(List<String> visitors) {
        return (checkVisitorSize(visitors.size()) || checkVisitorId(visitors));
    }

    private static boolean checkVisitorSize(int size) {
        return (size >= 0 && size <= 10000);
    }

    private static boolean checkVisitorId(List<String> visitors) {
        for (String visitor : visitors) {
            if (!checkUser(visitor)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriend.add(getFriend(user, friend));
            }
        }
        return userFriend;
    }

    private static String getFriend(String user, List<String> friend) {
        if (user.equals(friend.get(FIRST_ID))) {
            return friend.get(SECOND_ID);
        }
        return friend.get(FIRST_ID);
    }

    private static Map<String, Integer> makeRecommend(String user, List<String> userFriends ,List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendedFriend = new HashMap<>();
        String recommendedId = "";

        for (List<String> friend : friends) {
            for (String userFriend : userFriends) {
                if (friend.contains(userFriend) && !friend.contains(user)) {
                    recommendedId = getFriend(userFriend, friend);
                    recommendedFriend.put(recommendedId, getScore(recommendedId, recommendedFriend) + FRIEND_RECOMMENDATION_SCORE);
                }
            }
        }
        return recommendedFriend;
    }

    private static int getScore(String Id, Map<String, Integer> recommededFriend) {
        if (recommededFriend.containsKey(Id)) {
            return (recommededFriend.get(Id));
        }
        return (0);
    }

    private static void addVisitorScore(Map<String, Integer> recommendedFriend, List<String> userFriend ,List<String> visitors) {
        for (String visitor : visitors) {
            if (userFriend.contains(visitor)) {
                continue;
            }
            if (recommendedFriend.containsKey(visitor)) {
                recommendedFriend.put(visitor, getScore(visitor, recommendedFriend) + VISITOR_SCORE);
            } else {
                recommendedFriend.put(visitor, VISITOR_SCORE);
            }

        }
    }

    private static List<String> makeAnswer(Map<String, Integer> recommendedFriend) {
        List<Map.Entry<String, Integer>> sortedRocommandedFriend = new LinkedList<>(recommendedFriend.entrySet());
        Collections.sort(sortedRocommandedFriend, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        return addMaxFive(sortedRocommandedFriend);
    }

    private static List<String> addMaxFive(List<Map.Entry<String, Integer>> sortedRocommandedFriend) {
        List<String> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedRocommandedFriend) {
            if (answer.size() == 5) {
                break;
            }
            answer.add(entry.getKey());
        }
        return answer;
    }
}