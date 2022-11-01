package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //유저-점수 맵
        Map<String,Integer> scoreMap = new HashMap<>();
        //유저-친구 맵
        Map<String, Set<String>> friendsMap = new HashMap<>();

        //모든 유저의 친구를 구함
        String f1,f2;
        for(List<String> f : friends){
            f1 = f.get(0);
            f2 = f.get(1);
            if(!friendsMap.containsKey(f1)){
                friendsMap.put(f1,new HashSet<>());
            }
            if(!friendsMap.containsKey(f2)){
                friendsMap.put(f2,new HashSet<>());
            }
            friendsMap.get(f1).add(f2);
            friendsMap.get(f2).add(f1);
        }

        //친구의 친구는 +10점
        //friendsMap을 순회하면서 key가 user의 친구라면 key의 친구들에게 점수 +10
        Set<String> userFriends = friendsMap.get(user);
        for(String f : friendsMap.keySet()){
            //user의 친구라면
            if(userFriends.contains(f)){
                //친구의 친구는 +10점
                Set<String> friendFriend = friendsMap.get(f);
                for(String ff : friendFriend){
                    //아직 scoreMap에 등록이 안된 경우
                    if(!scoreMap.containsKey(ff)){
                        scoreMap.put(ff,10);
                    }
                    //10점 추가
                    else {
                        scoreMap.replace(ff, scoreMap.get(ff) + 10);
                    }
                }
            }
        }

        //user를 방문한 경우 +1점
        for(String v : visitors){
            //아직 scoreMap에 등록이 안된 경우
            if(!scoreMap.containsKey(v)){
                scoreMap.put(v,1);
            }
            //1점 추가
            else{
                scoreMap.replace(v, scoreMap.get(v) + 10);
            }
        }

        //user와 user의 친구는 추천대상에서 제외
        scoreMap.remove(user);
        for(String f : userFriends){
            scoreMap.remove(f);
        }


        //scoreMap의 점수에 따라 내림차순으로 정렬
        List<Map.Entry<String,Integer>> sortedScore = new ArrayList<>(scoreMap.entrySet());
        Collections.sort(sortedScore, new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int scoreDiff = o1.getValue() - o2.getValue();
                //동점인 경우
                if(scoreDiff == 0){
                    scoreDiff = o1.getKey().compareTo(o2.getKey());
                }
                return scoreDiff;
            }
        });

        //상위 5개의 이름을 answer에 추가, 0인경우에는 제외
        for(int i=0;i<5 && i<sortedScore.size();i++){
            if(sortedScore.get(i).getValue() == 0)
                break;
            answer.add(sortedScore.get(i).getKey());
        }

        return answer;
    }

}
