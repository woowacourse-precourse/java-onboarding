package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        int end;
        List<String> answer;
        List<String> key;
        List<String> friendsOfUser = new ArrayList<String>();
        HashMap<String, Integer> recommend = new HashMap<String, Integer>();

        for(List<String> frd : friends){
            int userIdx = frd.indexOf(user);
            if(userIdx != -1){
                friendsOfUser.add(frd.get(1 - userIdx));
            }
        } // user의 친구 탐색

        for(List<String> frd: friends){
            if(frd.contains(user)) continue;

            for(String frdUser: friendsOfUser){
                int frdIdx = frd.indexOf(frdUser);
                if(frdIdx != -1){
                    String nearby = frd.get(1-frdIdx);

                    Integer prev = recommend.get(nearby);

                    if(prev == null){
                        prev = 0;
                    }

                    recommend.put(nearby,prev+10);
                }
            }
        } // user와 함께 아는 친구

        for(String visitor: visitors){
            if(friendsOfUser.contains(visitor) || user.equals(visitor)) continue;

            Integer prev = recommend.get(visitor);
            if(prev == null){
                prev = 0;
            }
            recommend.put(visitor, prev+1);
        } // 타임 라인 방문

        key = new ArrayList<String>(recommend.keySet());

        key.sort(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                int result = recommend.get(o2).compareTo(recommend.get(o1));
                if(result == 0){
                    result = o1.compareTo(o2);
                }
                return result;
            }
        }); // 추천 점수가 높은 순으로 아이디 정렬


        end = Math.min(key.size(), 5); // 추천 친구를 최대 5명으로 설정

        answer = new ArrayList<String>(key.subList(0, end));

        return answer;
    }
}
