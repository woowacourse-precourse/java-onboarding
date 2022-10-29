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
        List<String> recomUsers = addVisitors(user, visitors, stepFriendsList, friendsList);
        List<Integer> scr = cntScore(user, friendsList, visitors, recomUsers, friends);

        return sort(recomUsers, scr);
        // 테스트케이스 통과
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

    private static List<String> addVisitors(String user, List<String> visitors, List<String> stepFriendsList, List<String> friendsList) {
        for(String str : visitors) {
            if(stepFriendsList.contains(str)) {
                continue;
            }
            if(friendsList.contains(str)) {
                continue;
            }

            stepFriendsList.add(str);
        }

        Collections.sort(stepFriendsList);

        return stepFriendsList;
    }

    private static List<Integer> cntScore(String user, List<String> friendsList, List<String> visitors, List<String> recomUsers, List<List<String>> friends) {
        List<Integer> scr = new ArrayList<>(recomUsers.size());

        for(int i = 0; i < recomUsers.size(); i++) { // 방문 횟수 기반 점수 추가 루프
            int cnt = 0;

            for(String str : visitors) {
                if(recomUsers.get(i).equals(str)) {
                    cnt++;
                }
            }

            scr.add(cnt);
        }

        List<String> tmp = new ArrayList<>();

        for(int i = 0; i < recomUsers.size(); i++) { // 함께아는 친구 기반 점수 추가 루프
            int cnt = scr.get(0);
            scr.remove(0);

            for(String str : friendsList) {
                tmp.add(recomUsers.get(i));
                tmp.add(str);

                if(friends.contains(tmp)) {
                    cnt += 10;
                    continue;
                }

                tmp.clear();

                tmp.add(str);
                tmp.add(recomUsers.get(i));

                if(friends.contains(tmp)) {
                    cnt += 10;
                }
            }

            scr.add(cnt);

        }

        return scr;
    }

    private static List<String> sort(List<String> recomUsers, List<Integer> scr) {
        List<String> answer = new ArrayList<>();

        while(scr.size() != 0 && answer.size() < 5) {
            int maxScr = Collections.max(scr);
            int idx = scr.indexOf(maxScr);

            answer.add(recomUsers.get(idx));

            recomUsers.remove(idx);
            scr.remove(idx);
        }

        return answer;
    }
}