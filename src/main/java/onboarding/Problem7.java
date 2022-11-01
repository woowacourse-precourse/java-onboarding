package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = FriendRecom(user, friends, visitors);
        return answer;
    }
    public static List<String> FriendRecom(String user, List<List<String>> friends, List<String> visitors){
        List<List<String>> list = new ArrayList<>();
        Set<String> list_set = new HashSet<>();

        List<String> f_list = new ArrayList<>();
        Set<String> f_set = new HashSet<>();

        List<String> recom = new ArrayList<>();

        // friends 인물들 list_set에 넣기
        for(int i =0 ; i < friends.size() ;i++){
            list_set.add(friends.get(i).get(0));
            list_set.add(friends.get(i).get(1));
        }
        // visitors 인물들 list_set에 넣기
        for(int i=0 ; i < visitors.size() ;i++){
            list_set.add(visitors.get(i));
        }
        // list_set 에서 user 제거
        list_set.remove(user);

        // user와 친구인 friends 인물들 f_set에 넣기
        // user와 친구인 friends 인물들 list_set에서 제거
        for(int i =0 ; i < friends.size() ;i++) {
            if (friends.get(i).contains(user)) {
                // XOR 연산자 이용 user가 0번에 있으면 1번 요소를 넣고
                // user가 1번에 있으면 0번 요소를 넣는다
                f_set.add(friends.get(i).get(friends.get(i).indexOf(user) ^ 1));
                list_set.remove(friends.get(i).get(friends.get(i).indexOf(user) ^ 1));
            }
        }
        // list_set을 list로 변환
        Iterator e = list_set.iterator();
        while(e.hasNext()){
            list.add(Arrays.asList((String)e.next(),"0"));
        }
        // f_set을 f_list로 변환
        f_list = new ArrayList<>(f_set);

        // list에 있는 사람이 user와 함께 아는 친구가 있다면 값을 10 증가 시킨다
        for(int i =0 ; i < friends.size() ;i++){
            for(int j = 0 ;j < f_list.size();j++){
                if(friends.get(i).contains(f_list.get(j))){
                    int idx = friends.get(i).indexOf(f_list.get(j)) ^ 1;
                    if(!friends.get(i).get(idx).equals(user)){
                        for(int k = 0 ; k < list.size(); k++){
                            if(list.get(k).get(0).equals(friends.get(i).get(idx))){
                                list.get(k).set(1, strPlusTen(list.get(k).get(1)));
                            }
                        }
                    }
                }
            }
        }
        // list에 있는 사람이 user를 방문했다면 값을 1 증가시킨다
        for(int i = 0 ; i < visitors.size(); i++){
            for(int j = 0 ;j < list.size();j++){
                if(list.get(j).get(0).equals(visitors.get(i))){
                    list.get(j).set(1, strPlusOne(list.get(j).get(1)));
                }
            }
        }

        int list_len = list.size();
        for (int i = 0; i < list_len; i++) {
            Integer max = 0;
            int flag = -1;
            for (int j = 0; j < list.size(); j++) {
                Integer a = Integer.parseInt(list.get(j).get(1));
                if (max < a) {
                    max = a;
                    flag = j;
                } else if ((max != 0) && (max == a)) {
                    // 점수 같은 경우 문자열 비교 > 정렬
                    int stringCmp = list.get(j).get(1).compareTo(list.get(flag).get(1));
                    if (stringCmp < 0)
                        flag = j;
                }
            }
            if (flag != -1) {
                recom.add(list.get(flag).get(0));
                list.remove(flag);
            }
        }
        if (recom.size() > 5)
            return recom.subList(0,5);
        else
            return recom.subList(0, recom.size());
    }
    public static String strPlusOne(String num){
        return Integer.toString(Integer.parseInt(num)+1);
    }
    public static String strPlusTen(String num){
        return Integer.toString(Integer.parseInt(num)+10);
    }
}
