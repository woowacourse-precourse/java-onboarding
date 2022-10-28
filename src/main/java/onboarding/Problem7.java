package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. user 의 친구 목록을 만든다
        // 2. user 의 친구의 친구 목록을 만들고 알파벳 순으로 정렬한다
        // 3. 친구의 친구 목록과 같은 길이의 빈 정수형 리스트를 만든다
        // 4. 친구의 친구 리스트 순서에 맞게 점수를 카운트 해 입력한다
        // 5. 가장 높은 점수 인덱스를 제출 할 리스트에 입력한다
        // 6. 이름 순서대로 제출 할 리스트에 입력하고 친구의 친구 리스트와 점수 리스트에서 해당 인덱스를 삭제한다
        // 7. 5-6을 반복하고 가장 높은 점수가 0이거나 더이상 인덱스가 없을 경우 루프를 탈출하고 리턴
        List<String> friendsList = findMyFriends(user, friends);
        List<String> stepFriendsList = findStepFriends(user, friends, friendsList);
        List<String> recomUsers = addVisitors(user, visitors, stepFriendsList);
        List<Integer> scr = cntScore(user, friends, visitors, stepFriendsList);


        return sort(recomUsers, scr);
    }

    private static List<String> findMyFriends(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();

        for(List<String> list : friends) {
            if(list.get(0).equals(user)) {
                friendsList.add(list.get(1));

                continue;
            }

            if(list.get(1).equals(user)) {
                friendsList.add(list.get(0));
            }
        }

        return friendsList;
    }

    private static List<String> findStepFriends(String user, List<List<String>> friends, List<String> friendsList) {
        List<String> stepFriendsList = new ArrayList<>();

        for(int i = 0; i < friendsList.size(); i++) {
            String myFriend = friendsList.get(i);

            for(int j = 0; j < friends.size(); j++) {
                if(stepFriendsList.contains(friends.get(j).get(0))) {
                    continue;
                }

                if(stepFriendsList.contains(friends.get(j).get(1))) {
                    continue;
                }

                if(friends.get(j).contains(user)) {
                    continue;
                }

                if(friends.get(j).get(0).equals(myFriend)) {
                    stepFriendsList.add(friends.get(j).get(1));

                    continue;
                }

                if(friends.get(j).get(1).equals(myFriend)) {
                    stepFriendsList.add(friends.get(j).get(0));
                }
            }
        }

        return stepFriendsList;
    }

    private static List<String> addVisitors(String user, List<String> visitors, List<String> stepFriendsList) {
        for(String str : visitors) {
            if(stepFriendsList.contains(str)) {
                continue;
            }

            stepFriendsList.add(str);
        }

        Collections.sort(stepFriendsList);

        return stepFriendsList;
    }

    private static List<Integer> cntScore(String user, List<List<String>>friends, List<String> visitors, List<String> stepFriendsList) {
        List<Integer> scr = new ArrayList<>();
        return scr;
    }

    private static List<String> sort(List<String> stepFriendsList, List<Integer> scr) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
}