package onboarding;


import java.util.*;

public class Problem7 {
    private static HashMap<String,Integer> friendScore = new HashMap<>();
    private static List<String> friendMember = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        friendList(user, friends);

        calcBothFriend(user,friends);
        calcVisited(visitors);

        // 점수가 가장 높은 순으로 정렬 +  이름순으로 정렬
        List<Map.Entry<String, Integer>> sortlist = new LinkedList<>(friendScore.entrySet());
        sortlist.sort(Map.Entry.comparingByKey());
        sortlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 최대 5개 출력
        int printValue=sortlist.size();
        if(sortlist.size()>5){
            printValue=5;
        }
        for(int i=0; i<printValue; i++){
            answer.add(sortlist.get(i).getKey());
        }

        return answer;
    }
    // user의 친구들 목록 함수
    private static void friendList(String user, List<List<String>> friends){
        for(int i=0; i<friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                friendMember.add(friends.get(i).get(1));
            } else if (user.equals(friends.get(i).get(1))) {
                friendMember.add(friends.get(i).get(0));
            }
        }
    }
    // 함께 아는 친구 점수 계산 함수
    private static void calcFriendScore(String firstName,String secondName,String userFriend){
        if(firstName.equals(userFriend) && friendMember.contains(firstName)){
            int score = 0;
            if(!friendScore.containsKey(secondName))
                friendScore.put(secondName,0);
            score += friendScore.get(secondName) + 10;
            friendScore.put(secondName,score);
        }
    }
    // 함께 아는 친구 계산 함수
    private static void calcBothFriend(String user,  List<List<String>> friends){
        for(int i=0; i<friendMember.size(); i++){
            String userFriend = friendMember.get(i);
            for(int j=0; j<friends.size(); j++){
                String firstName = friends.get(j).get(0);
                String secondName = friends.get(j).get(1);
                if(firstName == user || secondName == user)
                    continue;
                calcFriendScore(firstName,secondName,userFriend);
                calcFriendScore(secondName,firstName,userFriend);
            }
        }
    }

    //방문자 점수 계산 함수
    private static void calcVisited(List<String> visitor){
        int score=0;
        for(int i=0; i<visitor.size(); i++) {
            if (!friendMember.contains(visitor.get(i))) {
                if(!friendScore.containsKey(visitor.get(i)))
                    friendScore.put(visitor.get(i),0);
                score = friendScore.get(visitor.get(i))+1;
                friendScore.put(visitor.get(i),score);
            }
        }
    }
}
