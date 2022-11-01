package onboarding;


import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1. 중복을 제거하는 기능
2. 친구의 친구를 찾는기능
3. 친구의 친구중 내친구를 제거하는기능
4. 나의 방문자를 확인하는기능
5. 나의 방문자중 친구를 제거하는 기능
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {

        } catch (Exception e) {

        }
        List<String> answer = Collections.emptyList();
        List<String> friendList = new ArrayList<>(myFriendsSearch(user, friends));
        System.out.println(friendList);
        List<String> friendCandidate = new ArrayList<>(friendOfFriend(friends, friendList));
        System.out.println(friendCandidate);

        List<String> notFriendOfFriendCandidateBeforeScore = deleteMyAndFriend(friendCandidate, friendList, user);
        List<String> notFriendOfVisitorBeforeScored = deleteMyAndFriendOfVisitors(user, friendList, visitors);
        System.out.println(notFriendOfFriendCandidateBeforeScore);

        List<String> deduplicationNotFriendOfFriendCandidate = deduplication(notFriendOfFriendCandidateBeforeScore);
        List<String> deduplicationNotFriendOfVisitor = deduplication(notFriendOfVisitorBeforeScored);
        System.out.println(deduplicationNotFriendOfFriendCandidate);

        Map<String, Integer> notFriendOfFriendCandidate = scoreSet(notFriendOfFriendCandidateBeforeScore, deduplicationNotFriendOfFriendCandidate, 10);
        Map<String, Integer> notFriendOfVisitor = scoreSet(notFriendOfVisitorBeforeScored, deduplicationNotFriendOfVisitor, 1);
        System.out.println(notFriendOfVisitor);
        System.out.println(notFriendOfFriendCandidate);


        notFriendOfFriendCandidate.forEach((key, value) -> notFriendOfVisitor.merge(key, value, (v1, v2) -> v2));
        Map<String, Integer> answerMap = notFriendOfVisitor;


        answer = new ArrayList<>();
        System.out.println(answerMap);
        Map<String, Integer> topFive =
                answerMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(5)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        Comparator<Map.Entry<String, Integer>> test = Map.Entry.comparingByValue();
//        if(String.equals("key")){
//            test = Map.Entry.comparingByKey();  // * 오름차순(Comparator객체를 옆 메소드의 파라미터로 넣어주세요) : Comparator.reverseOrder()
//        }
        answer.addAll(topFive.keySet());
//        public static List<String> sortSuggestFriendArrayAndMakeList(ArrayList<SuggestFriend> suggestFriends){

        return answer;
    }

    public static List<String> myFriendsSearch(String user, List<List<String>> friends) {
        List<List<String>> copyFriends = new ArrayList<>();
        copyFriends.addAll(friends);
        List<String> myFriends = new ArrayList<>();
        for (int i = 0; i < copyFriends.size(); i++) {
            if (copyFriends.get(i).contains(user)) {
                myFriends.addAll(copyFriends.get(i));
                continue;
            }
        }

//        myFriends.addAll();
        myFriends = new ArrayList<>(myFriends.stream().distinct().collect(Collectors.toList()));

        myFriends.remove(user);
        return myFriends;
    }

    public static List<String> friendOfFriend(List<List<String>> friend, List<String> myFriend) {
        List<String> friendCandidate = new ArrayList<>();
        for (int j = 0; j < myFriend.size(); j++) {
            for (int i = 0; i < friend.size(); i++) {
                if (friend.get(i).contains(myFriend.get(j))) {
                    friendCandidate.addAll(friend.get(i));
                }
            }
        }
        return friendCandidate;
    }

    public static List<String> deleteMyAndFriend(List<String> friendCandidate, List<String> myFriend, String user) {
        System.out.println(myFriend);


        for (int i = 0; i < friendCandidate.size() + 2; i++) {
            friendCandidate.remove(user);
            System.out.println(friendCandidate);
        }
        System.out.println("test");
        for (int i = 0; i < myFriend.size(); i++) {
            for (int j = 0; j < friendCandidate.size() + 2; j++) {
                System.out.println(myFriend.get(i));
                friendCandidate.remove(myFriend.get(i));
                System.out.println(friendCandidate + "" + friendCandidate.size());
            }
        }
        return friendCandidate;
    }

    public static List<String> deleteMyAndFriendOfVisitors(String user, List<String> myFriend, List<String> visitors) {
        List<String> newVisitors = new ArrayList<>();
        newVisitors.addAll(visitors);
        System.out.println(newVisitors + "시작");
        for (int i = 0; i < newVisitors.size(); i++) {
            newVisitors.remove(user);
            System.out.println(newVisitors);
        }
        System.out.println("test2");
        for (int i = 0; i < myFriend.size(); i++) {
            for (int j = 0; j < newVisitors.size(); j++) {
                System.out.println(myFriend.get(i));
                newVisitors.remove(myFriend.get(i));
                System.out.println(newVisitors);
            }
        }
        return newVisitors;
    }

    public static List<String> deduplication(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static Map<String, Integer> scoreSet(List<String> list, List<String> deduplication, int score) {
        int count;
        Map<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < deduplication.size(); i++) {
            count = Collections.frequency(list, deduplication.get(i));
            scores.put(deduplication.get(i), score * count);
        }
        return scores;
    }
}
