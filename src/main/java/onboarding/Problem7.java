package onboarding;

import java.util.*;

public class Problem7 {


    static HashSet<String> myFriends = new HashSet<>();
    static HashSet<String> notMyFriends = new HashSet<>();
    static HashMap<String,List<String>> graph = new HashMap<>();
    static HashMap<String,Integer> recommendList = new HashMap<>();

    //유저의 친구셋 만들기
    static void setMyFriends(String user,List<List<String>> friends){

        HashSet<String> tempMyFriends = new HashSet<>();

        for (List<String> friend : friends){
            String a = friend.get(0);
            String b = friend.get(1);

            notMyFriends.add(a);
            notMyFriends.add(b);

            if (Objects.equals(a,user))
                tempMyFriends.add(b);
            else if(Objects.equals(b,user))
                tempMyFriends.add(a);
        }
        myFriends = tempMyFriends;
    }

    //유저의 친구가 아닌사람 리스트를 맵으로 저장


    //친구 관계 그래프 만들기


    //함께 아는 친구의 수를 찾아 점수로 환산하기


    //타임라인 방문기록을 점수화 하기


    //점수를 기준으로 내림차순하고, 이름을 기준으로 오름차순으로 정렬하기


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //함수 호출해서 완성하기
        return answer;
    }
}
