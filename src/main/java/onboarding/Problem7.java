package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> friendsList = new ArrayList<>();
        HashMap<String,Integer> scoreMap = new HashMap<>();
        int score = 0;
        setFriendsList(user, friends, friendsList);
        setFriendOfFriendsList(user, friends, friendsList, scoreMap, score);
        giveOnePoint(visitors, friendsList, scoreMap, score);
        List<String> keyList = new ArrayList<>(scoreMap.keySet());
        List<Integer> valueList = new ArrayList<>(scoreMap.values());
        List<Item> items = new ArrayList<>();
        setListSort(answer, keyList, valueList, items);
        return answer;
    }
}
