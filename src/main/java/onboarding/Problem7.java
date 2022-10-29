package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> member = new ArrayList<>();

        // 친구 관계를 그래프로 저장
        Iterator<List<String>> friendsItr = friends.iterator();
        for(int i=0; i<friends.size(); i++){
            List<String> ABfriend = friendsItr.next();
            String A = ABfriend.get(0);
            String B = ABfriend.get(1);

            if(!member.contains(A)){
                member.add(A);
            }
            if(!member.contains(B)){
                member.add(B);
            }
        }

        List<String>[] friendList = new ArrayList[member.size()];
        for(int i=0; i< member.size(); i++){
            friendList[i] = new ArrayList<>();
        }

        // 친구 되어있는 관계를 리스트에 넣음
        friendsItr = friends.iterator();
        for(int i=0; i<friends.size(); i++){
            List<String> ABfriend = friendsItr.next();
            String A = ABfriend.get(0);
            String B = ABfriend.get(1);

            int aIdx = member.indexOf(A);
            int bIdx = member.indexOf(B);

            friendList[aIdx].add(B);
            friendList[bIdx].add(A);
        }






        // 방문자로 점수 처리

        return answer;
    }



}
