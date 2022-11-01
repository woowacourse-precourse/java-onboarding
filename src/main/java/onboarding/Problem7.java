package onboarding;

//기능1. friends 리스트/배열에 있는 이름(key)과 점수10(value) 을 해시맵에 추가한다. 만약 friends 리스트/배열에 유저와 같은 이름이 있으면 해시맵에 넣지 않는다.
//기능2. 만약 해쉬맵에있는 이름이 있을경우 추가하지 않고 value에 10을 더한다.
//기능3. visitors 에 등장하는 친구들은 value에 +1 을 하고 key에 등록되지 않은 경우 등록하고 +1 한다.
//기능4. 맵에서 유저와 친구인 친구를 삭제한다.
//기능5. value 값이 높은 순으로 리스트에 정렬한다.
//기능6. 만약 점수가 같으면 알파벳 순으로 출력한다.

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();

        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0;i<friends.size();i++) {
            for (int j=0;j<2;j++) {
                if (!(friends.get(i).contains(user))) { //user 의 이름을 포함하지 않으면
                    if (map.containsKey(friends.get(i).get(j))) { //만약 이름이 이미 있으면
                        map.put((friends.get(i).get(j)), map.get((friends.get(i).get(j)))+10); //10을 더한다.
                    } else {
                        map.put((friends.get(i).get(j)), 10); //추가
                    }
                }
            }
        }

        for (int i=0;i<visitors.size();i++) {
            if (map.containsKey(visitors.get(i))) { //맵에 비지터의 이름이 있으면
                map.put((visitors.get(i)), map.get((visitors.get(i)))+1); //1을 더한다.
            } else { // 없으면
                map.put(visitors.get(i), 1);
            }
        }

        List<String> d = new ArrayList<>();
        for (int i=0;i<friends.size();i++) {
            if (friends.get(i).contains(user)) { //리스트의 리스트에 유저가 있다면
                System.out.println(friends.get(i));
                if (Objects.equals(user, friends.get(i).get(0))) { //만약 유저가 첫번재 자리라면
                    d.add(friends.get(i).get(1)); //유저의 친구는 두번째자리
                } else if (Objects.equals(user, friends.get(i).get(1))) { //유저가 두번재자리라면
                    d.add(friends.get(i).get(0)); //유저의 친구는 첫번재 자리
                }
            }
        }

        for (int i=0;i<d.size();i++) {
            map.remove(d.get(i)); //유저의 친구들 삭제
        }

//  맵에 마지막에 end 0 을 추가
//  먼저 값이 높은순으로 맵을 정렬
//  높은순으로 리스트에 넣음.
//  다음에 넣을 값도 현재 넣는 값이랑 동일하면 현재의 값의 키를 모두 다른 리스트로 뺌. -> 리스트를 정렬 -> 정답리스트에 붙여줌
//  end가 나오면 넣지말고 종료.
//  반환
//   끝.


        List<String> answer = new ArrayList<>(map.keySet());


        System.out.println(map);
        System.out.println(d);
        System.out.println(answer);

        return answer;
    }
}
