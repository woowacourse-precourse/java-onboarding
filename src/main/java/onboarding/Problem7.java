package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> friendsOfUser = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        findFriendsOfUser(friends, friendsOfUser, user); // user의 친구 찾기
        scoreFriendsOfFriendsOfUser(friends, friendsOfUser, scoreMap);//찾은 user의 친구와 친구인 사람에게 10점 부여
        scoreVisitors(visitors, scoreMap); // visitors에게 1점 부여
        scoreFriendsOfUser(user,friendsOfUser,scoreMap);
        answer = sortedList(scoreMap);
        return answer;
    }

    public static void findFriendsOfUser(List<List<String>> friends, ArrayList<String> friendsOfUser, String user) {
        String firstPerson;
        String secondPerson;
        for (int i = 0; i < friends.size(); i++) {
            firstPerson = friends.get(i).get(0);
            secondPerson = friends.get(i).get(1);

            if (firstPerson == user) friendsOfUser.add(secondPerson);
            else if (secondPerson == user) friendsOfUser.add(firstPerson);
        }
    }

    public static void scoreFriendsOfFriendsOfUser(List<List<String>> friends, ArrayList<String> friendsOfUser, HashMap<String, Integer> scoreMap) {
        String firstPerson;
        String secondPerson;
        for (int i = 0; i < friends.size(); i++) {
            firstPerson = friends.get(i).get(0);
            secondPerson = friends.get(i).get(1);
            friendsOrNot(friendsOfUser, firstPerson, secondPerson, scoreMap);
        }
    }
    public static void friendsOrNot(ArrayList<String> friendsOfUser, String firstPerson, String secondPerson, HashMap<String, Integer> scoreMap) {
        if (friendsOfUser.contains(firstPerson)) updateScore(scoreMap, secondPerson, 10); // firstPerson이 유저의 친구일 때
        else if (friendsOfUser.contains(secondPerson)) updateScore(scoreMap, firstPerson, 10);
    }

    public static void updateScore(HashMap<String, Integer> scoreMap, String person, int addedScore) {
        if (scoreMap.containsKey(person)) scoreMap.replace(person, scoreMap.get(person) + addedScore);
        else scoreMap.put(person, addedScore);
    }

    public static void scoreVisitors(List<String> visitors, HashMap<String, Integer> scoreMap) {
        String person;
        for (int i = 0; i < visitors.size(); i++) {
            person = visitors.get(i);
            updateScore(scoreMap, person, 1);
        }
    }
    public static void scoreFriendsOfUser(String user,ArrayList<String> friendsOfUser,HashMap<String, Integer> scoreMap) {
        String person;
        for (int i = 0; i < friendsOfUser.size(); i++) {
            person = friendsOfUser.get(i);
            scoreMap.replace(person, 0); // user의 친구는 추천하지 않는다
        }
        scoreMap.replace(user, 0);
    }

}
