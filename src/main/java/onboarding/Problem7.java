package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> nearFriends = new ArrayList<>();
        Map<String, Integer> recommendScore = new HashMap<>();

        // 1. 내 친구 찾기.
        List<String> myFriends = findMyFriends(user, friends);
        System.out.println(myFriends);
        // 2. 내 친구와 아는(=함께 아는 친구) 찾기.
        for(String friend: myFriends){
            nearFriends.addAll(findMyFriends(user, friends, friend));
        }
                System.out.println(nearFriends);
        // 3. 함께 아는 친구에 대한 점수 부여.


        // 4. 방문자에게 점수 부여하기.
        // 5. 점수별로 정렬하기

        return answer;
    }

    /**
     * 파라미터가 두개라면, 내 친구 찾기.
     * @param user
     * @param friends
     * @return
     */
    public static List<String> findMyFriends(String user, List<List<String>> friends){
        List<String> myFriends = new ArrayList<>();

        for(List<String> friend: friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if(friend1.equals(user))
                myFriends.add(friend2);
            if(friend2.equals(user))
                myFriends.add(friend1);
        }

        return myFriends;
    }

    /**
     * 파라미터가 3개라면 함께 아는 친구 찾기.
     * @param user
     * @param friends
     * @param myFriendName
     * @return
     */
    public static List<String> findMyFriends(String user, List<List<String>> friends, String myFriendName){
        List<String> myFriends = new ArrayList<>();

        for(List<String> friend: friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if(friend1.equals(myFriendName)){
                if(!friend2.equals(user))
                    myFriends.add(friend2);
            }
            if(friend2.equals(myFriendName)){
                if(!friend1.equals(user))
                    myFriends.add(friend1);
            }
        }

        return myFriends;
    }



}
