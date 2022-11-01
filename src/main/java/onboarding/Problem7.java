package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem7 {
    /**
     * friends 리스트 --> 0점으로 초기화 하며 친구 목록 리스트 따로 만들기
     * 친구목록 리스트 정렬 후 int 리스트 만들어 인덱스에 숫자 값 올리기!
     * friends 리스트 한번 더 순회하며  친구목록과 친구인 사람에게 +10점!
     * */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> users = new ArrayList<>();
        List<String> direct_friends = new ArrayList<>();
        int len = friends.size(); //친구 관계 리스트 사이즈
        for(int i=0; i<len ; i++){
            String person_1 = friends.get(i).get(0);
            String person_2 = friends.get(i).get(1);
            if(!users.contains(person_1)){
                users.add(person_1);
            }
            if(!users.contains(person_2)){
                users.add(person_2);
            }
            if(person_1 == user){
                direct_friends.add(person_2);
            }
            if(person_2 == user){
                direct_friends.add(person_1);
            }
        } // direct_friends 에 직접 친구 목록 잘 들어가 있음.

        int visit_size = visitors.size();
        for(int i=0; i<visit_size;i++){
            String person = visitors.get(i);
            if(!users.contains(person)){
                users.add(person);
            }
        }
        users.sort(Comparator.naturalOrder()); // 전체 유저 목록 가나다순으로 정렬. 인덱스 리스트 먹이기
        List<Integer> score = new ArrayList<>();
        int users_size = users.size();
        for(int i=0; i<users_size; i++){
            score.add(0);
        }

        // 방문자 점수 추가!

        for(int i=0; i<visit_size;i++){
            String person = visitors.get(i);
            int num = users.indexOf(person);
            int val = score.get(num);
            score.set(num,val+1);
        }
        
        // 친구 관계 점수 먹이기
        for(int i=0; i<len ; i++){
            String person_1 = friends.get(i).get(0);
            String person_2 = friends.get(i).get(1);
            if(direct_friends.contains(person_1)){
                int num = users.indexOf(person_2);
                int val = score.get(num);
                score.set(num,val+10);
            }
            if(direct_friends.contains(person_2)){
                int num = users.indexOf(person_1);
                int val = score.get(num);
                score.set(num,val+10);
            }
        }


        //점수 높은 순으로 출력하기!
        List<Integer> vals = new ArrayList<>(); // 최대값 인덱스 저장하기

        for(int j=0; j<5 ; j++) {
            int max = 0;
            int idx = 0;
            int change = 0;
            for (int i = 0; i < users_size; i++) {
                if (score.get(i) > max) {
                    max = score.get(i);
                    idx = i;// score 의 인덱스 들어가있음
                    change = 1;
                }
            }
            if(change == 1) {
                vals.add(idx);
                score.set(idx,0);
            }
        }
        for(Integer e : vals){
            if(users.get(e) != user & !direct_friends.contains(users.get(e))){
            answer.add(users.get(e));}
        }
        return answer;
    }
    // 다 출력되고 있음..
}  // vals :  1 0 3 4 2
// users : "andole", "bedi", "donut", "jun", "mrko", "shakevan"
// score : [20, 3, 1, 20, 20, 1]