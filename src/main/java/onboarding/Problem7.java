package onboarding;

import java.util.*;

/**
 * 1.친구목록을 통해 사용자와 함께아는친구 찾기
 * 2.함께 아는 친구의 아이디와 점수를 TreeMap에 저장하는 함수
 * 3.타임라인의 방문자들을 TreeMap에 저장하는 함수
 */
public class Problem7 {

    static Map<String, Integer> map = new TreeMap<>();
    
    /**
     * 1.친구목록을 통해 사용자와 함께아는친구 찾기
     */
    public static List<String> friendList(String user, List<List<String>> n) {
        List<String> friendList = new ArrayList<>();
        for(int i = 0; i<n.size();i++){
            if(n.get(i).get(1).equals(user)){
                friendList.add(n.get(i).get(0));
            }

            if(n.get(i).get(0).equals(user)){
                friendList.add(n.get(i).get(1));
            }
        }

        return friendList;
    }

    /**
     * 2.함께 아는 친구의 아이디와 점수를 TreeMap에 저장하는 함수
     * 친구목록에서 사용자와 함께 아는 친구일 경우 +10점
     * 사용자 제외
     */
    public static void friendsScore(List<String> userFriend, List<List<String>> friends, String user) {
        for(int i =0;i<userFriend.size();i++){
            for(int j=0; j<friends.size();j++){
                if(userFriend.get(i).equals(friends.get(j).get(0)) && !friends.get(j).get(1).equals(user) && !userFriend.contains(friends.get(j).get(1))){
                    if(map.containsKey(friends.get(j).get(1))){
                        int value = map.get(friends.get(j).get(1));
                        map.replace(friends.get(j).get(1), value+10);
                    } else{
                        map.put(friends.get(j).get(1),10);
                    }
                }

                if (userFriend.get(i).equals(friends.get(j).get(1)) && !friends.get(j).get(0).equals(user) && !userFriend.contains(friends.get(j).get(0))){
                    if(map.containsKey(friends.get(j).get(0))){
                        int value = map.get(friends.get(j).get(0));
                        map.replace(friends.get(j).get(0), value+10);
                    } else{
                        map.put(friends.get(j).get(0),10);
                    }
                }

            }
        }
    }

    /**
     * 3.타임라인의 방문자들을 TreeMap 에 저장하는 함수
     * 친구목록에서 사용자와 함께 아는 친구일 경우 x
     * 방문 횟수당 +1점
     */
    public static void visitantScore(List<String> userFriend, List<String> visitors) {
        for(int i =0; i<visitors.size();i++){
            if(map.containsKey(visitors.get(i))){
                int value = map.get(visitors.get(i));
                map.replace((visitors.get(i)),value+1);
            }else{
                if(!userFriend.contains(visitors.get(i))){
                    map.put(visitors.get(i),1);
                }

            }
        }
    }
    
    /**
     * 문제 해결을 위한 함수
     * TreeMap 이름순 정렬
     * List 점수 내림차순 정렬
     * 최대 5명을 리턴
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriend = friendList(user,friends);

        friendsScore(userFriend,friends,user);
        visitantScore(userFriend,visitors);
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int count = 0 ;
        for(int i = 0 ; i<keySet.size();i++){

            answer.add(keySet.get(i));
            count++;

            if(count == 5){
                break;
            }
        }
        return answer;
    }
}