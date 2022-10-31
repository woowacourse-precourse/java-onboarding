package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //user 길이 1이상 30이하 문자열 확인
        if(user.length()<1 || user.length()>30)
            return null;
        //friends 길이 1이상 10,000 이하인  리스트/배열 확인
        if (friends.size()<1 || friends.size()>10000)
            return null;
        //visitors 길이 0이상 10,000 이하인 리스트/배열 확인
        if (visitors.size()<0 || visitors.size()>10000)
            return null;
        //사용자 아이디 알파벳 소문자로만 이뤄졌는지 확인
        //만약 대문자가 존재한다면 전부 소문자로 변환한 것과 달라 거짓이 나오게 된다.
        if (!user.toLowerCase().equals(user))
            return null;

        ArrayList<String> oldFriends= (ArrayList<String>) getOldFriends(user, friends);


        return answer;
    }

    public static List<String> getOldFriends(String user, List<List<String>> friends){
        ArrayList<String> oldFriends = new ArrayList<String>();

        for (int i=0; i<friends.size(); i++){
            if (friends.get(i).contains(user)){
                if (friends.get(i).get(0).equals(user))
                    oldFriends.add(friends.get(i).get(1));
                else
                    oldFriends.add(friends.get(i).get(0));
            }
        }
        return oldFriends;
    }
}

