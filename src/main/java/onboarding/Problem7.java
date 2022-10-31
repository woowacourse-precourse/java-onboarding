package onboarding;

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> Id = new HashMap<>();
        Map<String, Integer> totalScore = new HashMap<>();

        // friedns를 list에 담아서 친구 관계의 양방향 그래프를 딕셔너리를 작성해준다.
        for (List<String> list : friends) {
            String person1 = list.get(0);
            String person2 = list.get(1);

            List<String> S1 = new ArrayList<>();
            if (Id.get(person1) != null) S1 = Id.get(person1);  {

                S1.add(person2);
                Id.put(person1, S1);
            }

            List<String> S2 = new ArrayList<>();
            if (Id.get(person2) !=null) S2 = Id.get(person2); {
                S2.add(person1);
                Id.put(person2, S2);
            }
        }
        // Id에 있는 함께 아는 친구들은 total+10 해준다.
        for (String Name : Id.get(user)) {
            for (String Rec : Id.get(Name)) {
                if (user.equals(Rec)) {
                    continue;
                }
                if (totalScore.containsKey(Rec)) {
                    int total = totalScore.get(Rec);
                    totalScore.put(Rec, total+10);
                }
                else {
                    totalScore.put(Rec, 10);
                }


            }

        }
        // visit들은 total+1 해준다.
        for (String visit : visitors) {

            if (Id.get(user).contains(visit)) {
                continue;
            }
            if (totalScore.containsKey(visit)) {
                int total = totalScore.get(visit);
                totalScore.put(visit, total+1);
            }
            else {
                totalScore.put(visit, 1);
            }

        }

        // totalScore Map을 keyset을 사용해 key전체의 값을 list str에 담아 변환 해준다.
        List<String> str = new ArrayList<>(totalScore.keySet());


        // list str로 변환 해준 값을 람다식을 통해 오름차순으로 정렬해준다.
        str.sort((o1, o2) ->  {
            if(totalScore.get(o1).equals(totalScore.get(o2))) {
                return o1.compareTo(o2);
            }
            else{
                return totalScore.get(o2) - totalScore.get(o1);
            }
        });


        // 최대 5명을 return 해주기 위해 조건문을 이용해 return 해준다.
        if (str.size()>5) str = str.subList(0,5);

        return str;



    }
}