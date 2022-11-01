package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        List<String> user_fr=new ArrayList<>();
        for(int i=0;i< friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                user_fr.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                user_fr.add(friends.get(i).get(0));
            }
        }
        for(int i=0;i< user_fr.size();i++){
            for(int j=0;j< friends.size();j++) {
                if(friends.get(j).get(0).equals(user)||friends.get(j).get(1).equals(user)){
                    continue;
                }
                else {
                    if (friends.get(j).get(0).equals(user_fr.get(i))) {
                        if (have_not(user_fr, friends.get(j).get(1))) {
                            map.put(friends.get(j).get(1), map.getOrDefault(friends.get(j).get(1), 0) + 10);
                        }
                    } else if (friends.get(i).get(1).equals(user_fr.get(i))) {
                        if (have_not(user_fr, friends.get(j).get(0))) {
                            map.put(friends.get(j).get(0), map.getOrDefault(friends.get(j).get(0), 0) + 10);
                        }
                    }
                }
            }
        }

        for(int i=0;i<visitors.size();i++){
            if(have_not(user_fr,visitors.get(i))) {
                map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue().equals(o1.getValue())) //이름이 같을 경우
                    return o1.getKey().charAt(0)-o2.getKey().charAt(0);
                return o2.getValue() - o1.getValue();
            }
        });
        int x=0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
            if(++x>=5)
                break;
        }

        return answer;
    }
    public static boolean have_not(List<String> list1,String str){
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).equals(str)){
                return false;
            }
        }
        return true;
    }
}
