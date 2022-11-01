package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        HashMap<String,Integer> result = new HashMap<>();

        //key값과 value값을 각자 맵핑이 되는 map만들기
        for (List<String> friend : friends) {
            //key값 기준으로 value값 리스트 맵핑
            List<String> values = new ArrayList<>();
            String key = friend.get(0);

            if(map.containsKey(key)){
                values = map.get(key);
                values.add(friend.get(1));
            }else{
                values.add(friend.get(1));
            }
            map.put(key, values);

            //value값 기준으로 key값 리스트 맵핑
            List<String> values2 = new ArrayList<>();
            String key2 = friend.get(1);
            if(map.containsKey(key2)){
                values2 = map.get(key2);
                values2.add(friend.get(0));
            }else{
                values2.add(friend.get(0));
            }
            map.put(key2, values2);
        }

        //사용자와 함께 아는 친구의 점수 구하기
        List<String> userFriend = map.get(user);
        //사용자의 친구 반복문
        for (String uf : userFriend) {
            List<String> userFriendFriend = map.get(uf);
            //사용자와 함께 아는친구들의 반복문, result에 점수 더하기
            for (String uff : userFriendFriend) {
                if(result.containsKey(uff)){
                    result.put(uff, result.get(uff)+10);
                }else{
                    result.put(uff,10);
                }
            }
        }

        //방문자 점수 더하기
        for (String visitor : visitors) {
            //사용자와 친구인 경우는 제외
            if(userFriend.contains(visitor)){
                continue;
            }
            if(result.containsKey(visitor)){
                result.put(visitor, result.get(visitor)+1);
            }else{
                result.put(visitor,1);
            }
        }

        //사용자 자기자신 제외
        result.remove(user);

        //value값 기준으로 내림차순으로 정렬
        List<String> keySetList = new ArrayList<>(result.keySet());
        Collections.sort(keySetList, (o1, o2) -> (result.get(o2).compareTo(result.get(o1))));

        //최종 List 만드는 함수
        answer.add(keySetList.get(0));
        for(int i=1; i< keySetList.size(); i++){
            answer.add(keySetList.get(i));

            //점수가 같을 경우 이름의 사전순으로 정렬
            if(result.get(keySetList.get(i-1)) == result.get(keySetList.get(i)) && keySetList.get(i-1).compareTo(keySetList.get(i)) > 0){
                Collections.swap(answer,i-1,i);
            }
        }
        return answer;
    }
}
