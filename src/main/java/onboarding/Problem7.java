package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 친구의 친구 -> 10점
// 타임 라인 방문 -> 1점
// friends 는 [ID_1, ID_2]이며 서로 친구라는 의미
// 아이디는 모두 알파벳 소문자
// 추천할 친구는 무조건 존재

// 친구 추천 점수의 상위 5명만 1.점수순 -> 2.이름순 으로 정렬하여 결과로 제출

//1.친구관계를 map으로 매핑 -> id-[친구들..]
//2.현재 주목하는 사람인 user의 친구목록을 순회하며 친구의 친구들을 찾아 점수를 추가해줌
//2-1.친구관계 map에는 user를 비롯해 이미 친구인 사람들도 겹칠 수 있다.


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
        
        HashMap<String, List<String>> friends_info = new HashMap<String, List<String>>();
        HashMap<String, Integer> points = new HashMap<String, Integer>(); // 친구 추천 점수 기록용
        
        for (List<String> data: friends) { // 모든 친구관계를 매핑 -> 유저id - [친구들]
        	String id_1 = data.get(0); // ID_1
        	String id_2 = data.get(1);// ID_2
        	
        	if (!friends_info.containsKey(id_1)) { // id_1 이라는 키값이 없으면 빈리스트와 매핑해서 생성해줌
        		friends_info.put(id_1, new ArrayList<String>());
        	}
        	friends_info.get(id_1).add(id_2); // id_1의 친구로 id_2 추가
        	
        	//id_2에도 id_1이 친구라는걸 매핑
        	if (!friends_info.containsKey(id_2)) {
        		friends_info.put(id_2, new ArrayList<String>());
        	}
        	friends_info.get(id_2).add(id_1);
        	
        }
        if (friends_info.containsKey(user)) { // user가 친구가 하나도 없는 경우를 방지
        	for (String f: friends_info.get(user)) { // 유저의 친구들을 순회
        		
        		for (String f_f :friends_info.get(f)) {// 친구의 친구 = f_f를 확인하며 첨수를 더해줌
        			if (!points.containsKey(f_f)) {
        				points.put(f_f, 0);
                	}
        			points.put(f_f, points.get(f_f) + 10);
        			
        		}
        	}
        }
        
//        return answer;
    }
}
