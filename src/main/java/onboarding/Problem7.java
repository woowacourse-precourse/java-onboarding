package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //친구 관계를 저장할 HashMap선언.
        //key값으로 아이디, value는 해당 아이디와 친구인 아이디 리스트(arrayList)
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

        for(List<String> list : friends){
            //리스트(id1, id2) 친구관계를 hashMap에 추가한다.
            //첫번째 id의 친구 리스트에 두번째 id를 넣는다.
            ArrayList<String> temp;
            if(hashMap.containsKey(list.get(0)))
                temp = hashMap.get(list.get(0));
            else
                temp = new ArrayList<>();
            temp.add(list.get(1));
            hashMap.put(list.get(0), temp);

            //두번째 id의 친구 리스트에 첫번째 id를 넣는다.
            if(hashMap.containsKey(list.get(1)))
                temp = hashMap.get(list.get(1));
            else
                temp = new ArrayList<>();
            temp.add(list.get(0));
            hashMap.put(list.get(1), temp);
        }

        //각 id별로 점수를 저장할 hashMap
        Map<String, Integer> scoreMap = new HashMap<>();

        //user의 친구 목록에서 id를 하나씩 꺼내서
        for(String f : hashMap.get(user)){
            //해당 id의 친구 목록해서 user의 친구를 포함하고 있다면 +10점
            for(String person : hashMap.keySet()){
                if(hashMap.get(person).contains(f)){
                    scoreMap.put(person, scoreMap.getOrDefault(person, 0)+10);
                }
            }
        }

        //해당 user 타임라인을 방문한 사람들에게 +1점씩 부여
        for(String f : visitors){
            scoreMap.put(f, scoreMap.getOrDefault(f, 0) + 1);
        }

        //scoreMap에서 이미 user와 친구인 사람은 추천친구에서 제외
        for(String f : hashMap.get(user)){
            if(scoreMap.containsKey(f)){
                scoreMap.remove(f);
            }
        }

        //scoreMap에 자기자신(user)은 추천친구에서 제외
        if(scoreMap.containsKey(user))
            scoreMap.remove(user);


        //각 id별로 점수를 저장한 scoreMap(HashMap)을 value를 기준으로 내림차순으로 정렬하는 코드
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(scoreMap.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //정답을 저장하는 arrayList
        List<String> answer = new ArrayList<>();
        int size_count = 0;

        for(Map.Entry<String,Integer> entry : list_entries){
            answer.add(entry.getKey());
            size_count++;
            //최대 5명까지만 출력하는 문제라서, 5명을 arrayList에 추가했다면 break
            if(size_count == 5)
                break;
        }

        return answer;
    }
}
