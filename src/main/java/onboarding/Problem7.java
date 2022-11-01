package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem7 {

    public static final int FIRST_FRIEND = 0;
    public static final int SECOND_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if (!verificationTotalCheck(user, friends, visitors)) {
            return List.of("Check Restrictions");
        }

        User target = new User(user, friends, visitors);
        answer = target.getAnswer();

        return answer;
    }

    public static boolean verificationTotalCheck(String user, List<List<String>> friends, List<String> visitors) {
        if (!verificationCheckAboutUser(user)) {
            return false;
        }
        if (!verificationCheckAboutFriends(friends)) {
            return false;
        }
        if (!verificationCheckAboutVisitors(visitors)) {
            return false;
        }
        for (List<String> friend : friends) {
            if (!verificationCheckAboutID(friend.get(FIRST_FRIEND)) ||
                    !verificationCheckAboutID(friend.get(SECOND_FRIEND))) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificationCheckAboutUser(String user) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutVisitors(List<String> visitors) {
        if (visitors.size() > 10000) {
            return false;
        }
        return true;
    }

    public static boolean verificationCheckAboutID(String id) {
        String isLowerAlphaRegex = "^[a-z]*$";
        if (!id.matches(isLowerAlphaRegex)) {
            return false;
        }
        if (id.length() < 1 || id.length() > 30) {
            return false;
        }
        return true;
    }

    public static class User {
        String user;
        List<List<String>> friends;
        List<String> visitors;
        List<String> userFriends;
        HashMap<String, Integer> recommendHashMap;
        PriorityQueue<Friend> friendQueue;

        User(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;

            setUserFriends();
            setRecommandHashMapByFriends();
            setRecommendHashMapByVisitors();
            sort();
        }

        private void setUserFriends() {
            userFriends = new ArrayList<>();

            for (List<String> friend : friends) {
                String firstFriend = friend.get(FIRST_FRIEND);
                String secondFriend = friend.get(SECOND_FRIEND);

                if (firstFriend.equals(user)) {
                    userFriends.add(secondFriend);
                    continue;
                }
                if (secondFriend.equals(user)) {
                    userFriends.add(firstFriend);
                }
            }
        }

        private void setRecommandHashMapByFriends() {
            recommendHashMap = new HashMap<>();

            for (List<String> friend : friends) {
                String firstFriend = friend.get(FIRST_FRIEND);
                String secondFriend = friend.get(SECOND_FRIEND);

                if (firstFriend.equals(user) || secondFriend.equals(user)) {
                    continue;
                }

                if (userFriends.contains(firstFriend)) {
                    giveTenPoint(secondFriend);
                }
                if (userFriends.contains(secondFriend)) {
                    giveTenPoint(firstFriend);
                }
            }
        }

        private void giveTenPoint(String target) {
            recommendHashMap.put(target, recommendHashMap.getOrDefault(target, 0) + 10);
        }

        private void setRecommendHashMapByVisitors() {
            for (String visitor : visitors) {
                if (!userFriends.contains(visitor)) {
                    giveOnePoint(visitor);
                }
            }
        }

        private void giveOnePoint(String target) {
            recommendHashMap.put(target, recommendHashMap.getOrDefault(target, 0) + 1);
        }

        private void sort() {
            friendQueue = new PriorityQueue<>(new friendComparator());

            Set<Entry<String, Integer>> entries = recommendHashMap.entrySet();
            for (Entry<String, Integer> entry : entries) {
                friendQueue.add(new Friend(entry.getKey(), entry.getValue()));
            }
        }

        private List<String> getAnswer() {
            List<String> answer = new ArrayList<>();

            if (friendQueue.size() <= 5) {
                for (Friend friend : friendQueue) {
                    answer.add(friend.name);
                }
            }

            if (friendQueue.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    Friend friend = friendQueue.poll();
                    answer.add(friend.name);
                }
            }

            return answer;
        }
    }

    public static class Friend {
        String name;
        int point;

        Friend(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }

    public static class friendComparator implements Comparator<Friend> {
        @Override
        public int compare(Friend o1, Friend o2) {
            if (o1.point < o2.point) {
                return 1;
            }
            if (o1.point == o2.point) {
                if (o1.name.compareTo(o2.name) > 0) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }
}

