package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> answer2 = new ArrayList<>();
        List<String> userfriends = new ArrayList<>();
        List<String> samefriends = new ArrayList<>();
        List<String> recomfriends = new ArrayList<>();
        List<String> visitfriends = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String, Integer>> entryList;

        for(int i=0;  i<friends.size(); i++){                    //user의 친구 추출
            if(friends.get(i).contains(user)){
                if((friends.get(i).get(0)).equals(user))
                    userfriends.add(friends.get(i).get(1));
                if((friends.get(i).get(1)).equals(user))
                    userfriends.add(friends.get(i).get(0));
            }
        }
        for(String str : userfriends){                      //user의 친구의 친구, 10번씩 추가 (10점)
            for(int i=0; i<friends.size(); i++){
                if(friends.get(i).contains(str)){
                    if((friends.get(i).get(0)).equals(str) && userfriends.contains(friends.get(i).get(1)) == false)
                        for(int j=0; j<10; j++) {
                            samefriends.add(friends.get(i).get(1));
                        }
                    if((friends.get(i).get(1)).equals(str) && userfriends.contains(friends.get(i).get(0)) == false)
                        for(int j=0; j<10; j++) {
                            samefriends.add(friends.get(i).get(0));
                        }
                }
            }
        }

        while(samefriends.contains(user)){     //user 삭제
            samefriends.remove(user);
        }

        visitfriends.addAll(visitors);

        for(int i=0; i<userfriends.size(); i++){              //현재 user의 친구 삭제
            while(visitfriends.contains(userfriends.get(i))){     //user 삭제
                visitfriends.remove(userfriends.get(i));
            }
        }

        recomfriends.addAll(samefriends);    //recomfriends로 추천 친구들 합치기
        recomfriends.addAll(visitfriends);

        Collections.sort(recomfriends);  //이름 순 정렬

        for (String str : recomfriends) {   //맵으로 갯수 세기(점수)
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }

        entryList = new LinkedList<>(map.entrySet());   //맵을 list로

        if(entryList.size()==0)                         //리스트로 만들어 키만 출력하기(이름)
            return answer;
        for(int i = 0; i<entryList.size(); i++){
            answer2.add(entryList.get(i).getKey());
            if(answer2.size()==5) break;
        }

        answer =answer2;
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(Problem7.solution(user,friends,visitors));
    }
}
