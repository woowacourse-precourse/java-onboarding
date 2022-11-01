package onboarding;

import java.util.*;

public class Problem7 {
    /*
    * 1. 친구 관계를 Map 형태로 변경 key : 이름, value : set of friends name
    * 2. 해당 관게를 통해 각각의 사람의 추천 점수를 구함, 단 직접 user와 친구관계를 맺었을 경우 제외
    * 3. visitors 배열을 이용해 추천점수를 갱신함.
    * 4. 추천 점수를 class TempData에 넣고, comparator 선언을 통해 배열정렬
    * */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 1. 친구관계를 HashMap 으로 표현
        HashMap<String, Set<String>> friendShips = new HashMap<>();

        for(List<String> friend : friends){
            if(!friendShips.containsKey(friend.get(0))){
                friendShips.put(friend.get(0), new HashSet<>());
            }
            if(!friendShips.containsKey(friend.get(1))){
                friendShips.put(friend.get(1), new HashSet<>());
            }
            friendShips.get(friend.get(0)).add(friend.get(1));
            friendShips.get(friend.get(1)).add(friend.get(0));
        }

        //2. 추천 점수를 계산시작
        HashMap<String, Integer> scores = new HashMap<>();
        //2.1 겹치는 친구들을 이용한 점수 계산
        for(String name : friendShips.keySet()){
            if(name.equals(user) || friendShips.get(user).contains(name))
                continue;
            if(!scores.containsKey(name)){
                scores.put(name, 0);
            }
            int temp = scores.get(name);
            for(String friendName : friendShips.get(name))
                if(friendShips.get(user).contains(friendName)){
                    temp += 10;
                }
            scores.put(name, temp);
        }

        //2.2 방문자들에 대한 점수 계산
        for(String name : visitors){
            if(friendShips.get(user).contains(name))
                continue;
            if(!scores.containsKey(name)){
                scores.put(name, 0);
            }
            int temp = scores.get(name);
            scores.put(name, temp + 1);
        }

        //3. 정렬을 위한 class 선언 및 비교연산자 선언
        class TempData{
            public String name;
            public int score;
            public TempData(String name, int score){
                this.name = name;
                this.score = score;
            }

            public int compareTo(TempData other){
                if(this.score == other.score)
                    return this.name.compareTo(other.name);
                return other.score - this.score;
            }
        }

        //3.1 List에 class형태의 데이터 삽입
        List<TempData> datas = new ArrayList<>();
        for(String name : scores.keySet()){
            datas.add(new TempData(name, scores.get(name)));
        }

        //3.2 정렬
        datas.sort(TempData::compareTo);
        List<String> result = new ArrayList<>();

        //3.3 정렬된 데이터들을 뽑아내면서 5개이하 + 점수가 0점 이상 조건으로 필터링
        for(var data : datas){
            if(data.score <= 0 || result.size() == 5)
                break;
            result.add(data.name);
        }
        return result;
    }
}
