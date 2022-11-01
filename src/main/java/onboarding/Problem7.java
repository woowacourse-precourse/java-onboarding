package onboarding;

import java.util.ArrayList;
import java.util.List;


/*
    ### 기능 목록
    1. 사용자의 닉네임과, 점수를 저장할 수 있는 배열을 만들고, 사용자의 친구관계를 graph 형태로 만든다.
    2. 사용자의 친구는 -1점을, 사용자의 친구의 친구는 10점을 부여한다.
    3. 방문자들을 순회하며, 방문자에게 1점씩 부여한다. 만약 없다면, 방문자를 닉네임과 점수에 추가후 1점을 부여한다.
    4. 높은 점수부터 순회하여 출력한다. 단, 같은 점수시 알파벳 순으로 정렬해 출력한다.
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer =  new ArrayList<>();

        // 1. 사용자의 닉네임과, 점수를 저장할 수 있는 배열을 만들고, 사용자의 친구관계를 graph 형태로 만든다.
        int user_idx = 0;

        /*
            user_score :
            user          : -2,
            user's friend : -1
            others        : 0
         */
        List<String>  user_nickname = new ArrayList<>();
        List<Integer> user_score    = new ArrayList<>();

        List<List<Integer>> friend_graph = new ArrayList<>();

        boolean check_duplicate_first;
        boolean check_duplicate_second;


        for(List<String> friend : friends){
            // init ture
            check_duplicate_first   = true;
            check_duplicate_second  = true;

            for (String s : user_nickname) {
                if (s.equals(friend.get(0))) check_duplicate_first = false;
                if (s.equals(friend.get(1))) check_duplicate_second = false;
            }
            // if true add user list
            if(check_duplicate_first){
                user_nickname.add(friend.get(0));
                user_score.add(0);
                friend_graph.add(new ArrayList<>());
            }
            if(check_duplicate_second){
                user_nickname.add(friend.get(1));
                user_score.add(0);
                friend_graph.add(new ArrayList<>());
            }

        }
        // set user
        for(int i = 0; i < user_nickname.size(); i++){
            if(user_nickname.get(i).equals(user)){
                user_idx = i;
                user_score.set(i, -2);
            }
        }

        // construct friends relationship
        int idx_first;
        int idx_second;
        for(List<String> friend : friends){
            idx_first = -1; idx_second = -1;
            for(int i = 0; i < user_nickname.size(); i++){
                if(user_nickname.get(i).equals(friend.get(0))) idx_first  = i;
                if(user_nickname.get(i).equals(friend.get(1))) idx_second = i;

                if (idx_first > -1 && idx_second > -1) break;
            }
            friend_graph.get(idx_first ).add(idx_second);
            friend_graph.get(idx_second).add(idx_first );
        }


        // set user's friend score -1, user's friend's friend score 10
        // when score == 0
        for(int i : friend_graph.get(user_idx)){
            if (user_score.get(i) == 0) user_score.set(i, -1);
            for(int j : friend_graph.get(i)){
                if (user_score.get(j) == 0) user_score.set(j, 10);
            }
        }


        // 3. 방문자들을 순회하며, 방문자에게 1점씩 부여한다. 만약 없다면, 방문자를 닉네임과 점수에 추가후 1점을 부여한다.
        int visit_idx;
        boolean in_visit;
        for(String visit : visitors){
            in_visit = true;
            visit_idx = -1;
            for(int i = 0; i < user_nickname.size(); i++){
                if (user_nickname.get(i).equals(visit)){
                    visit_idx = i;
                    in_visit = false;
                }
            }
            if(in_visit){
                user_nickname.add(visit);
                user_score.add(1);
            }else{
                if(user_score.get(visit_idx) >= 0)  user_score.set(visit_idx, user_score.get(visit_idx) + 1);
            }
        }

        // 4. 높은 점수부터 순회하여 출력한다. 단, 같은 점수시 알파벳 순으로 정렬해 출력한다.
        int max_score;
        int nickname_idx;
        while(true){
            max_score = 0;
            nickname_idx = -1;

            for(int i = 0; i < user_score.size(); i++){
                if(user_score.get(i) > max_score){
                    max_score = user_score.get(i);
                    nickname_idx = i;
                }
                else if (user_score.get(i) == max_score && nickname_idx != -1 && user_nickname.get(nickname_idx).compareTo(user_nickname.get(i)) > 0){
                    nickname_idx = i;
                }
            }

            if(max_score == 0) break;
            answer.add(user_nickname.get(nickname_idx));
            user_score.set(nickname_idx, 0);
        }

        // check arrays
//        System.out.println("user nickname list");
//        System.out.println(user_nickname);
//
//        System.out.println("user score list");
//        System.out.println(user_score);
//
//        System.out.println("user friends");
//        System.out.println(friend_graph);
//
//        System.out.println("user idx");
//        System.out.println(user_idx);

        return answer;
    }
}
