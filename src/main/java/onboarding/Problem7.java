package onboarding;

import java.util.*;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.toLowerCase;

public class Problem7 {
    // 기능 구현 목록
    // 1. 예외처리
    //  (1) user의 길이가 1이상 30이하인 문자열이 아닌경우
    //  (2) friends의 길이가 1이상 10000이하가 아닌경우
    //  (3) 아이디의 길이가 1 이상 30이하가 아닌 경우
    //  (4) 사용자 아이디는 알파벳 소문자로만 이루어져있지 않은 경우가 있다면 모두 소문자로 변환
    //  (5) visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우.
    // 2. user의 친구찾기
    // 3. 추천 친구들을 저장
    // 4. 방문자들 정보로부터 추천친구 정보 추가
    // 5. 사용자와 함께 아는 친구 점수 구하기
    // 6. 사용자의 타임라인에 방문한 횟수 점수 구하고 점수가 0인 것은 제거하기
    // 7. 결과를 내림차순으로 정렬
    public static List<String> solution(String user, List<List<String>
            > friends, List<String> visitors) {
        // 제한사항에 대한 예외처리
        // 1. user의 길이가 1이상 30이하인 문자열이 아닌경우
        
        if (!(1 <= user.length() && 30 >= user.length())){
            List<String> answer = List.of("user의 길이가 1이상 30이하인 문자열이 아닌경우");
            return answer;
        }
        // 2. friends의 길이가 1이상 10000이하가 아닌경우
        if (!(1 <= friends.size() && 10000 >= friends.size())){
            List<String> answer = List.of("friends의 길이가 1이상 10000이하가 아닌경우");
            return answer;
        }
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                // 3. 아이디의 길이가 1 이상 30이하가 아닌 경우
                if (!(1 <= friends.get(i).get(j).length() && 30 >= friends.get(i).get(j).length())) {
                    List<String> answer = List.of("아이디의 길이가 1 이상 30이하가 아닌 경우");
                    return answer;
                }
                // 4. 사용자 아이디는 알파벳 소문자로만 이루어져있지 않은 경우가 있다면 모두 소문자로 변환
                else {
                    friends.get(i).get(j).toLowerCase();
                }
            }
        }
        // 5. visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우.
        if ((!(0 <= visitors.size() && 10000 >= visitors.size()))) {
            List<String> answer = List.of("visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우");
            return answer;
        }


        //2. user의 친구찾기
        Set<String> user_freinds = new HashSet<String>(); // user의 친구를 저장할 자료구조 (중복되는 친구 관계 방지)
        Map<String, Integer> score_recomends = new HashMap<String, Integer>(); // 추천 친구들을 저장하고 그 추천친구들의 점수를 저장할 HashMap 선언

        for (int i = 0; i < friends.size(); i++){
            int userIndex = friends.get(i).indexOf(user); // friends의 원소들 중 user가 포함 되어 있는 리스트의 인덱스, 없다면 -1 return
            if (userIndex != -1){ // 리스트 안에 포함여부를 확인할지 아니면 for문 하나 더 원소 내부까지 찾아볼지
                if (userIndex == 0) {
                    user_freinds.add(friends.get(i).get(1)); // user가 아닌 user의 친구를 user의 친구를 저장할 자료구조에 저장
                }
                else if (userIndex == 1) {
                    user_freinds.add(friends.get(i).get(0)); // user가 아닌 user의 친구를 user의 친구를 저장할 자료구조에 저장
                }
            }
        }

        //System.out.println(friends.get(5).indexOf(user));
        //System.out.println(user_freinds); 친구 저장 성공

        //사용자와 함께아는 친구 점수 구하기

        // 3. 추천 친구들을 저장
        for (int i = 0; i < friends.size(); i++){
            //for (int j = 0; j < user_freinds.size(); j++){
            int userIndex = friends.get(i).indexOf(user); // friends의 원소들 중 user가 포함 되어 있는 리스트의 인덱스, 없다면 -1 return
            if (userIndex == -1) { // user가 없는 원소라면 (user와 user의 친구를 배제한 사람들을 친구추천 목록에 저장할 것이므로)
                for (int j = 0; j < user_freinds.size(); j++){
                    // 해당 원소의 사람들이 user의 친구가 아니고 친구추천 목록에 존재하지 않는다면
                    if ((!(user_freinds.contains(friends.get(i).get(j)))) && (!score_recomends.containsKey(friends.get(i).get(j)))){
                        score_recomends.put(friends.get(i).get(j), 0); // 해당 사람의 정보를 추가
                    }
                }
            }
        }

        // 4. 방문자들 정보로부터 추천친구 정보 추가
        for (int i = 0; i < visitors.size(); i++){
            // 해당 사람이 user가 아니고 user의 친구가 아니고 이미 친추 추천 목록에 존재하지 않는다면
            if (!(visitors.get(i).equals(user)) && !(user_freinds.contains(visitors.get(i))) && !(score_recomends.containsKey(visitors.get(i)))){
                score_recomends.put(visitors.get(i), 0); // 해당 사람의 정보를 추가
            }
        }

        // 5. 사용자와 함께 아는 친구의 수 점수 구하기
        for (int i = 0; i < friends.size(); i++){
            int userIndex = friends.get(i).indexOf(user); // friends의 원소들 중 user가 포함 되어 있는 리스트의 인덱스, 없다면 -1 return
            if (userIndex == -1) { // user가 없는 원소라면
                if ( (user_freinds.contains(friends.get(i).get(0)) ||  user_freinds.contains(friends.get(i).get(1))) &&
                        score_recomends.containsKey(friends.get(i).get(0)) || score_recomends.containsKey(friends.get(i).get(1)) ){
                    if (user_freinds.contains(friends.get(i).get(0))){
                        int score = score_recomends.get(friends.get(i).get(1));
                        score += 10;
                        score_recomends.put(friends.get(i).get(1),score);
                    }
                    else if (user_freinds.contains(friends.get(i).get(1))){
                        int score = score_recomends.get(friends.get(i).get(0));
                        score += 10;
                        score_recomends.put(friends.get(i).get(0),score);
                    }
                }
            }

        }
        //System.out.println("사용자와 함께 아는 친구의 수에 따른 점수 반영 결과");
        //System.out.println(score_recomends); // 저장됨

        // 6. 사용자의 타임라인에 방문한 횟수 점수 구하기
        for (int i = 0; i < visitors.size(); i++){
            if (score_recomends.containsKey(visitors.get(i)) ){ // 추천친구 목록에 존재한다면
                int score = score_recomends.get(visitors.get(i));
                score += 1;
                score_recomends.put(visitors.get(i),score);
            }
        }

        //System.out.println("사용자의 타임 라인에 방문한 횟수에 대한 점수 반영 결과");
        //System.out.println(score_recomends); // 저장됨
        // 점수가 0인 것은 제거하기
        score_recomends.values().remove(0);

        // 7. 결과를 내림차순으로 정렬

        //~~정렬이 요구사항에 맞게 잘 되는지 테스트 용 데이터
        //score_recomends.put("jun",50);
        //score_recomends.put("andole",50);
        //score_recomends.put("bndole",50);
        //score_recomends.put("zndole",0);
        //score_recomends.put("bedi",25);
        //score_recomends.values().remove(0);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score_recomends.entrySet()); // 정렬을 하기 위해 리스트로 변환

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = o2.getValue() - o1.getValue();
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = entryList.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        //System.out.println("정렬 결과");
        //System.out.println(sortedMap); // 저장됨


        List<String> result_map = new ArrayList<>(sortedMap.keySet());
        //System.out.println("정렬 후 리스트로 변환한 결과");
        //System.out.println(result_map);

        List<String> result = result_map;
        return result;
    }
}