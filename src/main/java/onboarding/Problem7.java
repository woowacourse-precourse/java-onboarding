package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friendList = new ArrayList<>();
        List<String> friendProposeList = new ArrayList<>();
        List<Integer> friendProposeScore = new ArrayList<Integer>();

        // 나와 이미 친구인 사람 목록 생성
        for (int i = 0; i < friends.size(); i++) {
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if (user.equals(name1)) {
                friendList.add(name2);
            }
            if (user.equals(name2)) {
                friendList.add(name1);
            }
        }

        // 친구 추가가 가능한 친구 목록 생성
        // 친구 관계에서 이미 친구인 사람을 제외하고 친구 신청 가능 목록에 추가
        for (int i = 0; i < friends.size(); i++) {
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            // 나와 이미 친구가 아닌 경우 친구 신청 가능 목록에 추가
            if (!friendList.contains(name1) && !friendProposeList.contains(name1) && !user.equals(name1)) {
                friendProposeList.add(name1);
            }
            if (!friendList.contains(name2) && !friendProposeList.contains(name2) && !user.equals(name2)) {
                friendProposeList.add(name2);
            }

        }
        // 방문자들 중 친구가 아니면서 친구 신청 가능 목록에 없는 사람들을 친구 신청 가능 목록에 추가
        for (int i = 0; i < visitors.size(); i++) {
            String visitorName = visitors.get(i);
            if (!friendList.contains(visitorName) && !friendProposeList.contains(visitorName)) {
                friendProposeList.add(visitorName);
            }
        }

        // 친구 신청 가능 목록들 점수 계산
        for (int i = 0; i < friendProposeList.size(); i++) {
            String proposeFriend = friendProposeList.get(i);
            int sum = 0;

            // 사용자와 함께 아는 친구의 수 +10점
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(proposeFriend)) {
                    if (friendList.contains(friends.get(j).get(0)) || friendList.contains(friends.get(j).get(1))) {
                        sum += 10;
                    }
                }
            }
            friendProposeScore.add(sum);
        }

        // 방문 횟수 점수 계산
        for (int i = 0; i < friendProposeList.size(); i++) {
            String proposeFriend = friendProposeList.get(i);
            if (visitors.contains(proposeFriend)) {
                int sum = Collections.frequency(visitors, proposeFriend);
                friendProposeScore.set(i, friendProposeScore.get(i) + sum);
            }
        }

        // 추천 점수가 0점일 경우 제거
        for (int i = 0; i < friendProposeList.size(); i++) {
            if (friendProposeScore.get(i) == 0) {
                friendProposeList.remove(i);
                friendProposeScore.remove(i);
            }
        }

        // 점수 순으로 정렬
        int tmpScore;
        String tmpString;

        for (int i = 0; i < friendProposeList.size() - 1; i++) {
            for (int j = i; j < friendProposeList.size(); j++) {
                if (friendProposeScore.get(i) < friendProposeScore.get(j)) {
                    tmpScore = friendProposeScore.get(j);
                    friendProposeScore.set(j, friendProposeScore.get(i));
                    friendProposeScore.set(i, tmpScore);

                    tmpString = friendList.get(j);
                    friendList.set(j, friendList.get(i));
                    friendList.set(i, tmpString);
                }
                // 추천 점수가 같은 경우 이름순으로 정렬
                else if (friendProposeScore.get(i) == friendProposeScore.get(j)) {
                    int compare = friendList.get(i).compareTo(friendList.get(j));
                    if (compare < 0) {
                        tmpScore = friendProposeScore.get(j);
                        friendProposeScore.set(j, friendProposeScore.get(i));
                        friendProposeScore.set(i, tmpScore);

                        tmpString = friendList.get(j);
                        friendList.set(j, friendList.get(i));
                        friendList.set(i, tmpString);
                    }
                }
            }
        }

        // 최대 5명까지 출력
//        for (int i = 0, cnt = 0; i < friendProposeList.size() && cnt < 5; i++, cnt++) {
//            answer.add(friendList.get(i));
//        }
        if(5<friendProposeList.size()){
            for(int i=5;i<friendProposeList.size();i++){
                friendProposeList.remove(i);
            }
        }
        System.out.println(friendList);
        System.out.println(friendProposeList);
        System.out.println(friendProposeScore);

        return friendProposeList;
    }
}
