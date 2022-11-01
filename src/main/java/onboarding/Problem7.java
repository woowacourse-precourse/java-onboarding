package onboarding;

import java.util.*;

public class Problem7 {

    private static HashSet<String> friendsList;
    private static HashSet<String> notFriendsList;
    private static Map<String, Integer> recommend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsList = new HashSet<>();
        notFriendsList = new HashSet<>();
        recommend = new HashMap<>();

        //모든 사람 리스트
        HashSet<String> allList = new HashSet<>();

        //모든 사람 리스트와 친구리스트 생성
        for(int i = 0 ; i < friends.size(); i++) {
            //주어진 friends의 전체를 모든사람 리스트에 중복없이 추가하는 기능
            allList.add(friends.get(i).get(0));
            allList.add(friends.get(i).get(1));

            //주어진 friends의 전체 중 사용자의 친구들만 중복없이 추가하는 기능
            if (friends.get(i).get(0).contains(user) || friends.get(i).get(1).contains(user)) {
                friendsList.add(friends.get(i).get(0));
                friendsList.add(friends.get(i).get(1));
            }
        }

        //모든 사람 리스트에 방문자 목록 추가
        for (String visitor : visitors) {
            allList.add(visitor);
        }

        /* 모든 사람 리스트를 반복하면서 친구리스트에 넣는 것이 가능하면(친구가 아님)
        친구가 아닌 리스트에 추가, 친구리스트에 넣어진 항목 다시 삭제 */
        for (String all : allList) {
            if(friendsList.add(all)) {
                notFriendsList.add(all);
                friendsList.remove(all);
            }
        }

        //친구리스트에 들어있는 유저 삭제
        friendsList.remove(user);

        //추천리스트 탐색
        findRecommend(friends, visitors);


        //5개이하만 출력하기 위한 정답List
        List<String> answer = new ArrayList<>();

        return answer;
    }

    //추천친구를 생성하는 기능
    public static void findRecommend(List<List<String>> friends, List<String> visitors) {

        //친구가 아닌 리스트 전체탐색
        for (String notfriend : notFriendsList) {
            // notFriendsList에서 방문자 목록에 해당하는 사람이 있으면 count += 1
            int visitCount = 0;
            for (String visitor : visitors) {
                if(visitor.contains(notfriend)) {
                    visitCount += 1;
                }
            }

            // notFriend 항목이 가지고 있는 친구리스트 확인 후 점수 계산
            int sameFriendCount = calScore(findFriends(notfriend, friends));

        }

    }

    //관계성 친구목록에 검사할 이름의 친구리스트 생성
    public static List<String> findFriends(String user, List<List<String>> friends) {
        //유저이름이 반복적으로 저장되는 것을 막기 위한 임시 저장소
        HashSet<String> tempList = new HashSet<>();

        //이름이 해당하면 좌, 우 전부 임시저장소에 저장
        for(int i = 0 ; i < friends.size(); i++) {
            if (friends.get(i).get(0).contains(user) || friends.get(i).get(1).contains(user)) {
                tempList.add(friends.get(i).get(0));
                tempList.add(friends.get(i).get(1));
            }
        }
        //해당 유저이름 제거
        tempList.remove(user);

        //SetList를 List로 변환
        List<String> resultList = new ArrayList<>(tempList);
        return resultList;
    }

    //검사할 리스트가 사용자의 친구리스트에 해당하는 항목마다 10점 추가하는 기능
    public static int calScore(List<String> listOfFriends) {
        int count = 0;

        //검사할 리스트 전체탐색
        for (int i = 0 ; i < listOfFriends.size() ; i++) {
            //사용자의 친구리스트 전체탐색
            for (String haveFriend : friendsList) {
                if (haveFriend.contains(listOfFriends.get(i))){
                    count += 10;
                    break;
                }
            }
        }
        return count;
    }

}
