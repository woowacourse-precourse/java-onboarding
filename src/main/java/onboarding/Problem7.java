package onboarding;

import java.util.*;

public class Problem7 {
    /* checkUserFriend: 사용자와 친구인 사람 목록 만드는 함수 */
    public static List<String> checkUserFriend(List<List<String>> friends, String user){
        List<String> userFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            List<String> relation = friends.get(i);
            if(relation.get(0).equals(user)){ //사용자와 친구인 사람이 있다면 친구인 사람 저장
                userFriends.add(relation.get(1));
            } else if (relation.get(1).equals(user)) {
                userFriends.add(relation.get(0));
            }
        }

        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        userFriends = checkUserFriend(friends, user);

        //사용자의 친구와 친구인 경우 10점 추가
        for(int i=0; i<friends.size(); i++){
            String people1 = friends.get(i).get(0);
            String people2 = friends.get(i).get(1);

            if(people1.equals(user) | people2.equals(user)){ //사용자와 친구라면 건너뜀
                continue;
            }

            if(userFriends.contains(people1)){
                recommendScore.put(people2, recommendScore.getOrDefault(people2,0)+10);
            } else if (userFriends.contains(people2)) {
                recommendScore.put(people1, recommendScore.getOrDefault(people1,0)+10);
            }
        }

        //사용자의 친구가 아니고 타임 라인에 방문한 경우 1점 추가
        for(int i=0; i<visitors.size(); i++){
            String people = visitors.get(i);
            if(userFriends.contains(people)){ //사용자의 친구라면 건너뜀
                continue;
            }
            recommendScore.put(people, recommendScore.getOrDefault(people, 0) + 1);
        }

        // value(점수) 내림차순 정렬하고 value가 같으면 key 오름차순 정렬
        List<HashMap.Entry<String, Integer>> list = new LinkedList<>(recommendScore.entrySet());
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue().compareTo(o1.getValue())==0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //최대 5명 return, 단, 점수가 0인 경우는 생각하지 않는다.(0일 때는 map에 들어가 있지 않음)
        if(list.size()>=5){
            int i=0;
            for(Map.Entry<String, Integer> entry: list){
                if(i>=5) break;
                answer.add(entry.getKey());
                i++;
            }
        }else{
            for(Map.Entry<String, Integer> entry: list){
                answer.add(entry.getKey());
            }
        }

        return answer;
    }
}