package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = userFriends(user, friends);
        List<String> notFriends = notFriends(user, userFriends, friends, visitors);
        HashMap<String, Integer> score = score(notFriends, friends, visitors);
        List<String> answer = sortScore(score);

        return answer;
    }

    //기능1. 사용자의 친구 목록
    public static List<String> userFriends(String user, List<List<String>> friends){
        HashSet<String> userFri = new HashSet<>();

        for (List<String> fri: friends) {

            if(fri.get(0).equals(user)){
                userFri.add(fri.get(1));
            } else if (fri.get(1).equals(user)) {
                userFri.add(fri.get(0));
            }
        }

        List<String> userFriends = new ArrayList<>(userFri);

        return userFriends;
    }

    //기능2. 사용자가 모르는 친구 목록
    public static List<String> notFriends(String user, List<String> userFriends, List<List<String>> friends, List<String> visitors){
        HashSet<String> notFri = new HashSet<>();

        for(List<String> fri: friends){
            notFri.add(fri.get(0));
            notFri.add(fri.get(1));
        }
        for(String fri : visitors){
            notFri.add(fri);
        }
        for(String fri : userFriends){
            notFri.remove(fri);
        }
        notFri.remove(user);

        List<String> notFriends = new ArrayList<>(notFri);
        return notFriends;
    }

    //기능3. 점수 계산
    public static HashMap<String, Integer> score (List<String> notFriends, List<List<String>> friends, List<String> visitors){
        HashMap<String, Integer> score = new HashMap<>();

        for(String fri : notFriends){
            score.put(fri, 0);
        }

        for(String fri : visitors){
            if(score.containsKey(fri)){
                score.put(fri, score.get(fri)+1);
            }
        }
        for(List<String> fri : friends){
            if(score.containsKey(fri.get(0))){
                score.put(fri.get(0), score.get(fri.get(0)) + 10);
            }else if(score.containsKey(fri.get(1))){
                score.put(fri.get(1), score.get(fri.get(1)) + 10);
            }
        }


        Iterator<String> it = score.keySet().iterator();
        ArrayList<String> arr = new ArrayList<>();
        while (it.hasNext()) {
            String key = it.next();
            if(score.get(key) == 0){
                arr.add(key);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            score.remove(arr.get(i));
        }

        return score;
    }

    //기능4. 정렬 후 최대 5명을 반환한다.
    public static List<String> sortScore(HashMap<String, Integer> score){
        List<String> sortScore = new ArrayList<>();

        List<String> keySetList = new ArrayList<>(score.keySet());
        Collections.sort(keySetList, (o1, o2) -> Integer.compare( score.get(o2), score.get(o1) ) );
        int cnt = 0;
        for(String str : keySetList){
            if(cnt==5){
                break;
            }
            sortScore.add(str);
            cnt++;
        }

        return sortScore;
    }
}
