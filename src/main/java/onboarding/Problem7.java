package onboarding;

import java.util.*;

public class Problem7 {
    // 전체 기능 호출
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> idToNumber = new HashMap<>();
        HashMap<Integer, String> numberToId = new HashMap<>();
        HashSet<String> allUserList = getAllUserList(user, friends, visitors);
        HashSet<String> myFriendList = new HashSet<>();
        List<Integer>[] friendGraph;

        // 사용자와 함께 아는 친구의 수만큼 점수 주기위해 인접배열리스트 초기화
        friendGraph = new List[allUserList.size()];
        for (int i = 0; i < allUserList.size(); i++) {
            friendGraph[i] = new ArrayList<>();
        }

        // 계정별 추천점수 배열 생성
        int[] score = new int[allUserList.size()];

        // 계정당 할당번호 부여
        int userNumber = 0;
        for (String userName : allUserList) {
            idToNumber.put(userName, userNumber);
            numberToId.put(userNumber, userName);
            userNumber += 1;
        }

        // 인접배열리스트(친구그래프) 생성
        for (int i = 0; i < friends.size(); i++) {
            int fromNumber = idToNumber.get(friends.get(i).get(0));
            int toNumber = idToNumber.get(friends.get(i).get(1));
            friendGraph[fromNumber].add(toNumber);
            friendGraph[toNumber].add(fromNumber);
        }

        // 사용자와 함께 아는 친구의 수 만큼 10점 주기
        // - 사용자의 친구의 친구가 해당. 루트가 사용자인 그래프를 깊이 2로 DFS 탐색
        for (int i = 0; i < friendGraph[idToNumber.get(user)].size(); i++) {
            int myFriendNumber = friendGraph[idToNumber.get(user)].get(i);
            // 내 친구목록 생성 - 결과값에 제외할 목록들
            myFriendList.add(numberToId.get(myFriendNumber));

            for (int j = 0; j < friendGraph[myFriendNumber].size(); j++) {
                int myFriendOfFriend = friendGraph[myFriendNumber].get(j);
                score[myFriendOfFriend] += 10;
            }
        }

        // 내 친구목록 생성에 본인도 추가 - 결과값에 제외할 목록들
        myFriendList.add(user);

        // 방문 수 만큼 점수 1점 주기
        for (int i = 0; i < visitors.size(); i++) {
            int visitorNumber = idToNumber.get(visitors.get(i));
            score[visitorNumber] += 1;
        }

        return answer;
    }

    // 나오는 모든계정을 중복제거 후 리스트에 담아 리턴
    private static HashSet<String> getAllUserList(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> allUserList = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            allUserList.add(user);
            allUserList.addAll(friends.get(i));
        }
        allUserList.addAll(visitors);
        return allUserList;
    }

    // 우선순위 큐에 사용할 유저 클래스
    static class User implements Comparable<Problem7.User> {
        String userName;
        int score;

        public User(String userName, int score) {
            this.userName = userName;
            this.score = score;
        }

        // 유저 객체끼리 비교할 compareTo 메서드
        @Override
        public int compareTo(Problem7.User o) {
            if (this.score > o.score) {
                return -1;
            }
            else if (this.score < o.score) {
                return 1;
            }
            return this.userName.compareTo(o.userName);
        }
    }
}


