package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> already = new ArrayList<>();
    static HashMap<String, Integer> candidate = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        alreadyFriends(user, friends);//friends에서 user와 이미 친구인 사람을 already에 저장

        friendsOfMyF(friends);//user의 친구와 친구일때 candidate에 등록, 점수 조정

        visitorCheck(visitors);//방문자를 candidate에 등록, 점수 조정

        removeBad(user);//제외할 친구 찾기(user 자신, 이미 친구, 0점(후보 등록될일 없음))

        //정렬, 가산점기준(같으면 이름)
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(candidate.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < entryList.size(); i++) {//최대 top 5 반환
            answer.add(entryList.get(i).getKey());
            if (i == 4) break;
        }
        return answer;
    }

    static void alreadyFriends(String user, List<List<String>> friends) {//user와 친구일때 already에 저장
        for (int i = 0; i < friends.size(); i++) {
            String personL = friends.get(i).get(0);
            String personR = friends.get(i).get(1);
            if (personL.equals(user)) {
                already.add(personR);
            }
            if (personR.equals(user)) {
                already.add(personL);
            }
        }
    }

    static void friendsOfMyF(List<List<String>> friends) {//user의 친구와 친구일때 친구 후보로 등록하고 점수 조정
        for (int i = 0; i < already.size(); i++) {
            String al_f = already.get(i);
            for (int j = 0; j < friends.size(); j++) {
                String personL = friends.get(j).get(0);
                String personR = friends.get(j).get(1);
                if (personL.equals(al_f)) {
                    if (candidate.containsKey(personR)) {//후보에 없으면 후보 등록, score = 10;
                        candidate.replace(personR, candidate.get(personR) + 10);
                    } else {                    //이미 있으면, score+=10;
                        candidate.put(personR, 10);
                    }
                }
                if (personR.equals(al_f)) {
                    if (candidate.containsKey(personL)) {//후보에 없으면 후보 등록, score = 10;
                        candidate.replace(personL, candidate.get(personL) + 10);
                    } else {                    //이미 있으면, score+=10;
                        candidate.put(personL, 10);
                    }
                }
            }
        }
    }

    static void visitorCheck(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String person = visitors.get(i);
            if (candidate.containsKey(person)) {
                candidate.replace(person, candidate.get(person) + 1);//이미 있으면, score+=1;
            } else {            //후보에 없으면 후보 등록, score = 1;
                candidate.put(person, 1);
            }
        }
    }

    static void removeBad(String user) {
        if (candidate.containsKey(user)) { //user 자신
            candidate.remove(user);
        }
        for (int i = 0; i < already.size(); i++) {//이미 user의 친구
            String al = already.get(i);
            if (candidate.containsKey(al)) {
                candidate.remove(al);
            }
        }
    }
}

