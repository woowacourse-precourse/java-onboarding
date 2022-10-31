package onboarding;

import java.io.FilterOutputStream;
import java.util.*;
import java.util.Map.Entry;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> step1Friend = new ArrayList<>();

        HashMap<String, Integer> nameScore = new HashMap<>();

        // 1.이미 친구인 사람  , user 제거
        for (int i = 0; i < friends.size(); i++) { //0 ~ 5
            //{dn,ad},{dn,j},{dk,mk},{sk,ad},{sk,j},{sk,mk}
            for (int j = 0; j < friends.get(i).size(); j++) { //0 ~ 1
                if (friends.get(i).get(j).equals(user)) {

                    //list에 담기 (dn, sk) 넣기 하고
                    step1Friend.add(friends.get(i).get(0));
                    step1Friend.add(friends.get(i).get(1));
                    step1Friend.remove(user);
                }

            }
        }
//        System.out.println();
//        System.out.println("step1 : " + step1Friend.toString());

//        2.그 친구가 있는 리스트 친구에게 점수 주기
        for (int i = 0; i < friends.size(); i++) { //0 ~ 5
            //{dn,ad},{dn,j},{dk,mk},{sk,ad},{sk,j},{sk,mk}
            for (int j = 0; j < friends.get(i).size(); j++) { //0 ~ 1

                for (int s = 0; s < step1Friend.size(); s++) {
                    if (step1Friend.get(s).equals(friends.get(i).get(j))) {
                        nameScore.put(friends.get(i).get(0), 10);
                        nameScore.put(friends.get(i).get(1), 10);
//                        nameScore.put(step1Friend.get(s),Integer.valueOf(friends.get(i).get(0)));
                        nameScore.remove(step1Friend.get(s), 10);
                        nameScore.remove(user, 10);  //본인 제거
                    }
                }
            }
        }
//        System.out.println("step 1 점수 주기 : " + nameScore);


        //3.visitor 점수 주기
        for (int i = 0; i < visitors.size(); i++) {
            if (nameScore.containsKey(visitors.get(i))) {
                nameScore.put(visitors.get(i), nameScore.get(visitors.get(i)) + 1);
            } else {
                nameScore.put(visitors.get(i), 1);
            }
        }
//        nameScore.put("josolha", 3);
//        System.out.print("vistors 점수 주기 : ");
//        System.out.println(nameScore);
//        System.out.println(step1Friend);


        //4.이미 친구 제거
        for (int i = 0; i < step1Friend.size() ; i++) {
            nameScore.remove(step1Friend.get(i));
        }
//        System.out.println(nameScore);


        List<String> listKeySet = new ArrayList<>(nameScore.keySet());
        // 오름차순 정렬 방법
//        Collections.sort(listKeySet, (value1, value2) -> (nameScore.get(value1).compareTo(nameScore.get(value2))));
//        for(String key : listKeySet) {
//            System.out.println("key : " + key + " , " + "value : " + nameScore.get(key));
//        }
        // 내림차순 정렬 방법
        Collections.sort(listKeySet, (value1, value2) -> {
            if (nameScore.get(value2) == nameScore.get(value1)) {
                return value1.compareTo(value2);
            }
            return (nameScore.get(value2).compareTo(nameScore.get(value1)));
        });
//        for (String key : listKeySet) {
//            System.out.println("key : " + key + " , " + "value : " + nameScore.get(key));
//        }
//        System.out.println(listKeySet);


        //if 문 넣기 (5개 제한)
        if (listKeySet.size() > 5) {
            answer = listKeySet.subList(0, 5);
        }else{
            answer = listKeySet;
        }
//        System.out.println("answer = "+ answer);
        return answer;
    }
}
