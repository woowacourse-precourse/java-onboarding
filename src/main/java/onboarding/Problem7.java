package onboarding;

import java.util.*;
import java.util.stream.Collectors;
/*기능 요구사항
1. 모든 유저들간의 친구관계 설정
2. 입력으로 받은 특정 유저와의 친구관계를 확인하여 점수 증가
3. visitor를 체크하여 점수 증가
4. 이미 친구인 경우는 추천할 필요가 없으므로 제외.
4. value를 기준으로 내림정렬
5. stream을 통해 0제외
6. 결과 반환
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> users = new ArrayList<>();
        Map<String, Integer> score = new HashMap<>();
        Map<String, List<String>> relations = new HashMap<String, List<String>>();

        //친구 관계의 설정
        for(List<String> list : friends){
            String a = list.get(0);
            String b = list.get(1);
            users.add(a);
            users.add(b);
            if(relations.get(a)==null){ //map에 존재하지 않는 key 일 경우 list 추가
                relations.put(a,new ArrayList<String>());
            }
            if(relations.get(b)==null){ //map에 존재하지 않는 key 일 경우 list 추가
                relations.put(b,new ArrayList<String>());
            }
            relations.get(b).add(a);
            relations.get(a).add(b);
        }

        //중복 제거
        users = users.stream().distinct().collect(Collectors.toList());

        for(String s : users){
            if(s.equals(user)) continue;
            List<String> friendsOfUser = relations.get(user);
            List<String> friendsOfWho = relations.get(s);
            int res = isSameFriends(friendsOfUser,friendsOfWho);
            if(score.get(s)==null){
                score.put(s,0);
            }
            int before = score.get(s);
            score.put(s,res+before);
        }

        //방문자를 확인후 점수 증가
        for(String s : visitors){
            if(score.get(s)==null){
                score.put(s,0);
            }
            int before = score.get(s);
            score.put(s,before+1);
        }

        //이미 친구면 추천할 필요가 없음 = 0점(제외)
        for(String s : relations.get(user)){
            score.put(s,0);
        }

        //score hash set을 정렬해줌
        List<String> nameSet = new ArrayList<>(score.keySet());
        nameSet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(score.get(o1)==score.get(o2)) return o1.compareTo(o2);
                return score.get(o2).compareTo(score.get(o1));
            }
        });

        //stream을 통해 최대 5명으로 잘라줌, 0일 경우를 filtter를 통해 제외해줌
        List<String> answer = nameSet.stream()
                .filter(a -> (score.get(a)!=0))
                .limit(5).collect(Collectors.toList());

        return answer;
    }

    //같은 친구를 가졌음에 따른 점수
    private static int isSameFriends(List<String> friendsOfUser, List<String> friendsOfWho) {
        int res = 0;
        for(String s : friendsOfUser){
            if(friendsOfWho.contains(s)) res += 10;
        }
        return res;
    }
}
