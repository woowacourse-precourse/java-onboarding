package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//문제 7번 기능 요구사항
//1. 특정 아이디 주면 그 아이디와 친구인 아이디 반환하는 함수
//2. 사용자와 친구인 사람 찾아서 리스트로 반환하는 함수
//3. 사용자와 친구인 사람과 친구인 사람 점수 10점 주는 함수
//4. 방문자에서 사용자와 친구를 제거하는 함수
//5. 방문한 횟수 세어서 점수 주는 함수
//6. 점수 순으로 정렬하고 점수 같으면 문자 순으로 정렬하는 함수

public class Problem7 {

    //기능 1
    public static String findFriend(String id, List<String> friend) {
        if(friend.get(0).equals(id)) {
            return friend.get(1);
        }
        else if(friend.get(1).equals(id)){
            return friend.get(0);
        }
        else {
            return null;
        }
    }

    //기능 2
    public static List<String> findUserFriend(String user, List<List<String>> friends){
        List<String> userFriend=new ArrayList<String>();

        for(int i=0;i<friends.size();i++) {

            List<String> onePairFriend=friends.get(i);
            String friendName=findFriend(user,onePairFriend);

            if(friendName!=null) {
                userFriend.add(friendName);
            }
        }
        return userFriend;
    }

    //기능 3
    public static HashMap<String, Integer> findSameFriend(String user, List<List<String>> friends, List<String> userFriend){

        HashMap<String, Integer> sameFriendList=new HashMap<String, Integer>();

        for(int i=0;i<friends.size();i++) {

            List<String> onePairFriend=friends.get(i);

            for(int j=0;j<userFriend.size();j++) {
                String sameFriend=userFriend.get(j);
                String friendName=findFriend(sameFriend,onePairFriend);

                if(friendName!=null) {
                    if(friendName!=user)
                        if(!sameFriendList.containsKey(friendName)) {
                            sameFriendList.put(friendName,10);
                        }
                        else {
                            int point=sameFriendList.get(friendName)+10;
                            sameFriendList.put(friendName,point);
                        }
                }
            }
        }
        return sameFriendList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
