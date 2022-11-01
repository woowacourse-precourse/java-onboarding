package onboarding;

/*
    Goal : 친구추천 알고리즘 구현하기
    Parameters: 사용자 아이디 user, 친구관계정보 friends, 사용자 타임라인 방문기록 visitors

    - 사용자와 함께 아는 친구의 수 : 10점
    - 사용자의 타임라인 방문 횟수 : 1점
    => 점수 높은 순으로 정렬하여 5명 리턴
    - 점수가 0인 경우 추천 X, 점수가 같을 경우 이름순 정렬

    To dos
    [ ] 점수 계산
    [ ] 0점 유저 제거 및 정렬
 */

/*
    Notes

    1) User 친구 목록 확인
    2) 그 친구가 알고있는 친구 +10, 리스트에 추가
    3) 방문자 리스트 확인 +1, 리스트 추가

 */

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        TreeMap<String, Integer> userList = new TreeMap<String, Integer>();
        ArrayList<String> friendList = new ArrayList<String>();

        int users = 0;
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);

                if (name != user) {
                    userList.put(name, 0);
                    if (friends.get(i).contains(user)) {
                        friendList.add(name);
                    }

                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            userList.put(visitors.get(i),0);

        }


        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).contains(friendList.get(j))) {
                    userList.put(friends.get(i).get(j), userList.get(friends.get(i).get(j)) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            for (int j = 0; j < friendList.size(); j++) {
                if (visitors.get(i).contains(friendList.get(j))){
                    userList.put(visitors.get(i), userList.get(visitors.get(i)) + 1);
                }
            }

        }


        userList.put(user, 0);

        for(int i=0; i< friendList.size(); i++){
            userList.put(friendList.get(i), 0);
        }


        List<String> totalscores = new ArrayList<>(friendList);

        return totalscores;
    }


}
