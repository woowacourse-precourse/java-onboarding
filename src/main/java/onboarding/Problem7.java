package onboarding;

import javax.swing.text.html.parser.Entity;
import java.lang.management.LockInfo;
import java.util.*;

public class Problem7 {
    /*
    * 규칙
    * 사용자와 함께 아는 친구의 수 = 10점
    * 사용자의 타임 라인에 방문한 횟수 = 1점
    *
    * --
    * user는 길이가 1 이상 30 이하인 문자열이다. -
    * friends는 길이가 1 이상 10,000 이하인 리스트/배열이다. -
    *
    * friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
    * A와 B는 친구라는 의미이다.
    *
    * 아이디는 길이가 1 이상 30 이하인 문자열이다. -
    * visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다. -
    *
    * 사용자 아이디는 알파벳 소문자로만 이루어져 있다. -
    *
    * 동일한 친구 관계가 중복해서 주어지지 않는다.
    * 추천할 친구가 없는 경우는 주어지지 않는다.
    * */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 사용자 아이디 길이 체크
        if(user.length() > 30){
            throw new RuntimeException("user의 길이는 30이하 입니다.");
        }

        for (int target: user.toCharArray()) {
            if(target < 97 || target > 122){
                throw new RuntimeException("사용자의 아이디는 알파벳 소문자입니다.");
            }
        }

        // 친구 목록 길이 체크
        if(friends.size() < 0 || friends.size() > 10000 ){
            throw new RuntimeException("friends의 길이는 0이상 10000이하의 배열입니다.");
        }

        // friends 친구 문자 길이 체크
        for (List<String> index: friends ) {
            if(index.get(0).length() < 0 || index.get(0).length() > 30){
                throw new RuntimeException("친구 A의 아이디는 1이상 30이하 입니다.");
            }
            if(index.get(1).length() < 0 || index.get(1).length()>30){
                throw new RuntimeException("친구 B의 아이디는 1이상 30이하 입니다.");
            }
        }

        //타임 라인 방문 길이 체크
        if(visitors.size() < 0 || visitors.size() > 10000){
            throw new RuntimeException("타임라인 방문 기록은 0이상 10000이하 입니다.");
        }


        // 방문자 순위 통계
        Map<String, Integer> visitCont = new HashMap<>();
        for (String visit : visitors ) {
            visitCont.put(visit, Collections.frequency(visitors,visit));
        }


        // 함께 아는 친구 순위 통계
        String friendName = "";
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends ) {
            if(user.equals(friend.get(1))){
                friendName = friend.get(0);
                visitCont.remove(friend.get(0));
            }else{
                friendName = "";
            }

            if(!friendName.equals("")){
                for (List<String> test: friends) {
                    if(friendName.equals(test.get(0)) && !user.equals(test.get(1))){
                        friendList.add(test.get(1));
                    }
                }
            }
        }

        Map<String, Integer> value = new HashMap<>();
        for (int i = 0; i < friendList.size(); i++) {
            value.put(friendList.get(i), Collections.frequency(friendList,friendList.get(i))*10);
        }


        value.putAll(visitCont);

        List<String> keySet = new ArrayList<>(value.keySet());

        keySet.sort((key1, key2) -> {
                if(value.get(key1) == value.get(key2)){
                    return key1.compareTo(key2);
                }
                return value.get(key2).compareTo(value.get(key1));
            }
        );


        answer = keySet;

        return answer;
    }
}

