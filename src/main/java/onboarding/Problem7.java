package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> user_list = new ArrayList<>();
        for (List<String> friend : friends) {    //friends로 유저리스트 만들기
            user_list.addAll(friend);
        }
        HashMap<String,Integer> user_map = new HashMap<>();

        for (String users : user_list){
            user_map.put(users,0);
        }
        visit_score(visitors, user_map);
        friend_score(user, friends, user_map);

        return sorting(user_map);
    }
    static void visit_score(List<String> visitors,HashMap<String,Integer> user_map){
        for (String visitor : visitors){
            if (user_map.containsKey(visitor)){
                int tmp = user_map.get(visitor);
                user_map.put(visitor, tmp+1);
            }
            else{
                user_map.put(visitor, 1);
            }
        }
    }
    static void friend_score(String user, List<List<String>> friends,HashMap<String,Integer> user_map){
        for (List<String> friend : friends){   //친구일 경우 점수는 -1(친구추천 x)
            String a = friend.get(0);
            String b = friend.get(1);
            if (Objects.equals(a, user)){   //문자열 비교 object.equals
                user_map.put(b,-1);
            }
            else if(Objects.equals(b, user)){
                user_map.put(a,-1);
            }
        }

        for (List<String> friend : friends){  //친구의 친구일 경우 점수 +10
            String a = friend.get(0);
            String b = friend.get(1);
            if (user_map.get(a)==-1 && !Objects.equals(b, user)){
                int tmp = user_map.get(b);
                user_map.put(b,tmp+10);
            }
            else if(user_map.get(b)==-1 && !Objects.equals(a, user)){
                int tmp2 = user_map.get(a);
                user_map.put(a,tmp2+10);
            }
        }
    }

    static List<String> sorting(HashMap<String,Integer> map){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        //Entry와 람다를 이용한 map sort

        ArrayList<String> answer = new ArrayList<>();
        int i=0;
        for(Map.Entry<String, Integer> entry : entryList){
            if (i>=5) break;        //최대 5개 출력
            if (entry.getValue()>0){
                answer.add(entry.getKey());
            }
            i+=1;
        }
        return answer;
    }
}
