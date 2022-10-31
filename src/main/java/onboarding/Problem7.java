package onboarding;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem7 {
    /*
    * 해결방법
    * 1.user의 친구를 찾고
    * 2.친구의 친구에게 점수 10점씩추가
    * 3.방문자들에게 1점씩주기
    * 4.합산 순으로 정렬
    * */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //follow 된 친구 저장소
        List<String> followFriend=new ArrayList<>();
        //follow 된 친구 구하기
        for(List<String>friend:friends){
           String fl= friend.get(0);
            String fr= friend.get(1);
           if(fl.equals(user)||fr.equals(user)){
               //반대편이 팔로우한 친구임
               if(fl.equals(user)){
                   followFriend.add(fr);
               }
               //반대편이 팔로우한 친구임
               if(fr.equals(user)){
                   followFriend.add(fl);
               }
           }
        }

        Map<String,Integer> map=new HashMap<>();

        //팔로우한 친구의 친구 구하기(user 뺴고)
       for(String  ff:followFriend){
           for(List<String>friend:friends){
               String fl= friend.get(0);
               String fr= friend.get(1);
               if(fl.equals(ff)||fr.equals(ff)){
                   //반대편이  user 이면 안됨
                   if(fl.equals(ff)&&!fr.equals(user)){
                       map.put(fr,map.containsKey(fr)?map.get(fr)+10:10);
                   }
                   //반대편이  user 이면 안됨
                   if(fr.equals(ff)&&!fl.equals(user)){
                       map.put(fl,map.containsKey(fl)?map.get(fl)+10:10);
                   }
               }
           }
       }

       for(String visitor:visitors){
           //follow한 친구는 추천에 있으면 안됨
       if(!followFriend.contains(visitor)){
           if(map.containsKey(visitor)){
               map.put(visitor,map.get(visitor)+1);
           }else{
               map.put(visitor,1);
           }
       }
       }
       //점수가 같으면 이름순으로 정렬,점수가 다르면 점수순으로 내림정렬
        List<Map.Entry<String,Integer>> entries = map.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue()==o2.getValue()){
                            return o1.getKey().compareTo(o2.getKey());
                        }else{
                            return o2.getValue()-o1.getValue();
                        }
                    }
                })
                .limit(5)
                .collect(Collectors.toList());

       List<String> answer=new ArrayList<>();
        for (Map.Entry<String,Integer> entry : entries) {
          answer.add(entry.getKey());
        }

        return answer;
    }
}
