package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = FriendRecom(user, friends, visitors);
        return answer;
    }
    public static List<String> FriendRecom(String user, List<List<String>> friends, List<String> visitors){

        if(exceptionCheck(user,friends,visitors)) return null;

        //user의 친구추천을 위해 친구가 아닌 사람들을 저장하기 위한  list
        List<List<String>> list = new ArrayList<>();
        //list에서 중복이 발생했을 때 중복을 제거하기 위한 set
        Set<String> list_set = new HashSet<>();

        //user와 친구인 사람들을 저장하기 위한 list
        List<String> f_list = new ArrayList<>();
        //user와 친구인 사람들에서 중복 발생 시 제거하기 위한 set
        Set<String> f_set = new HashSet<>();

        //추천점수가 높은 순서로 저장하기 위한 list
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
                String user_friend = friends.get(i).get(friends.get(i).indexOf(user) ^ 1);
                f_set.add(user_friend);
                list_set.remove(user_friend);
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
        //list에서 점수가 큰 순서로 recom에 저장한다
        for (int i = 0; i < list_len; i++) {
            //max를 0으로 설정하여 추천점수가 0인 경우 recom에 넣지 않는다.
            //max보다 커야 recom에 저장될 수 있다.
            Integer max = 0;
            //max보다 점수가 큰 요소의 index를 저장하기 위한 flag
            int flag = -1;
            for (int j = 0; j < list.size(); j++) {
                Integer a = Integer.parseInt(list.get(j).get(1));
                if (max < a) {
                    max = a;
                    flag = j;
                } else if ((max != 0) && (max.equals(a))) {
                    // 점수 같은 경우 문자열 비교하여 이름순으로 결정한다.
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

        if (recom.size() > 5) //recom의 크기가 5 보다 크다면 recom에서 0~4번까지 return 한다
            return recom.subList(0,5);
        else    //그렇지 않다면(5보다 작다면) 모두 recom을 모두 return 한다
            return recom;
    }
    //문자열로 되어있는 숫자를 1 증가 시킨다.
    public static String strPlusOne(String num){
        return Integer.toString(Integer.parseInt(num)+1);
    }
    //문자열로 되어있는 숫자를 10 증가 시킨다.
    public static String strPlusTen(String num){
        return Integer.toString(Integer.parseInt(num)+10);
    }
    public static boolean exceptionCheck(String user, List<List<String>> friends, List<String> visitors){
        //user는 길이가 1 이상 30 이하인 문자열이다.
        if(user.length() < 1 || user.length() > 30) return true;
        //friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
        int friends_len = friends.size();
        if(friends_len < 1 || friends_len > 10000) return true;
        //friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
        for(int i = 0 ; i < friends_len ;i++){
            if(friends.get(i).size() != 2 ) return true;
            else{
                //아이디는 길이가 1이상 30이하인 문자열이다.
                int A_len = friends.get(i).get(0).length();
                int B_len = friends.get(i).get(1).length();
                if(A_len < 1 || A_len > 30 ) return true;
                if(B_len < 1 || B_len > 30 ) return true;
            }
        }
        //visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        if(visitors.size() < 0 || visitors.size() > 10000) return true;

        //사용자아이디는 알파벳 소문자로만 이루어져있다.
        for(int i = 0 ; i < user.length() ; i++){
            char user_c = user.charAt(i);
            if( user_c < 97 || user_c > 122 ) return true;
        }
        return false;
    }
}
