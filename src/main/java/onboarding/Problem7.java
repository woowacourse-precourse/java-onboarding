package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        // 해쉬맵으로 유저(키), 친구 목록(배열 값)
        Map<String, List<String>> rating = new HashMap<>();
        Map<String, Integer> realRating = new HashMap<>();  // 각 추천점수 저장
        List<String> relate = new ArrayList<String>(); // 친구 관계배제 위한 배열

        for (int i=0;i<friends.size();i++) {
            if(rating.get(friends.get(i).get(0))!=null){
                rating.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            }
            else {
                List<String> a = new ArrayList<String>();
                a.add(friends.get(i).get(1));
                rating.put(friends.get(i).get(0), a);
            }
            if (friends.get(i).get(0).equals(user)) {
                relate.add(friends.get(i).get(1));
            }
            else if (friends.get(i).get(1).equals(user)){
                relate.add(friends.get(i).get(0));
            }
        }

        for (int i=0;i<visitors.size();i++) {
            if (realRating.get(visitors.get(i))==null){
                realRating.put(visitors.get(i),1);
            }
            else {
                int num = realRating.get(visitors.get(i))+1;
                realRating.put(visitors.get(i),num);
            }
        }

        rating.forEach((strKey, strValue)->{
            if (strValue.contains(user)) {
                for(String i : strValue){
                    if (realRating.get(i)==null) {
                        realRating.put(i,10);
                    }
                    else {
                        int num = realRating.get(i) + 10;
                        realRating.put(i,num);
                    }
                }
            }
        });
        realRating.remove(user);
        realRating.forEach((strKey, strValue)->{
            if(strValue==0) {
                realRating.remove(strKey);
            }
        });
        for (String i : relate) {
            realRating.remove(i);
        }
        int count=0;
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(realRating.entrySet());
        entryList.sort(((o1, o2) -> realRating.get(o2.getKey()) - realRating.get(o1.getKey())));
        for(Map.Entry<String, Integer> entry : entryList){
            if (count>=5) {
                break;
            }
            answer.add(entry.getKey());
            count++;
        }

        return answer;
    }
}
