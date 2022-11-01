package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        //전체 명단 만들기;
        List<String> my_list = new ArrayList<>();
        my_list = make_list(friends,visitors);

        //친구 명단 만들기
        List<String> fri_list= new ArrayList<>();
        fri_list = find_users_fri(user, friends);

        List<Integer> score_list= new ArrayList<>();
        score_list = get_score(my_list,fri_list,friends,visitors);


        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<my_list.size();i++){
            map.put(my_list.get(i),score_list.get(i));
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        // Value 값으로
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for (String key : keySet) {
            if(map.get(key)!=0 && key!=user) {
                answer.add(key);
            }

        }


        return answer;
    }

    public static int get_position(List<String> my_list, String fri){
        for(int i=0;i<my_list.size();i++){
            if(my_list.get(i)==fri){
                return i;
            }

        }
        return 0;
    }

    public static List<Integer> get_score(List<String> my_list,List<String> fri_list,List<List<String>>friends,List<String> visitors) {
        List<Integer> score_list= new ArrayList<>();
        for(int i=0;i< my_list.size();i++){
            score_list.add(0);
        }// 방문자 점수 올리기.
        for(int i=0; i< visitors.size();i++){
            for(int j =0;j<my_list.size();j++)
            if(visitors.get(i)==my_list.get(j)){
                score_list.set(j,score_list.get(j)+1);
            }
        }

        for(int i=0; i< friends.size();i++){
            for(int j =0;j<my_list.size();j++)
                for(int k=0; k< fri_list.size();k++) {
                    if ((friends.get(i).get(0) == fri_list.get(k))) {
                        int fnum;
                        fnum = get_position(my_list,friends.get(i).get(1));
                        score_list.set(fnum, score_list.get(fnum) + 10);
                    }else if(friends.get(i).get(1) == fri_list.get(k)){
                        int fnum;
                        fnum = get_position(my_list,friends.get(i).get(0));
                        score_list.set(fnum, score_list.get(fnum) + 10);
                    }


                }
        }
        //이미 친구인사람 점수 0점 만들기
        for(int i =0;i<my_list.size();i++){
                if(fri_list.contains(my_list.get(i))){
                    score_list.set(i,0);
                }
        }

        return score_list;


    }

    public static List<String> find_users_fri(String user, List<List<String>> friends ){
/*
        List<Integer> check_list= new ArrayList<>();
        for(int i=0;i<my_list.size();i++){
            check_list.add(0);
        }
*/
        List<String> fri = new ArrayList<>();

        for(int i=0; i<friends.size();i++){
            if(friends.get(i).get(0)==user){
                //String k =friends.get(i).get(1);
                fri.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1)==user){
                fri.add(friends.get(i).get(0));
            }
        }
        //친구 리스트 완성
        return fri;
    }




    public static List<String> make_list(List<List<String>> friends, List<String> visitors){
        List<String> my_list = new ArrayList<>();
        for(int i=0; i<friends.size();i++){
            if( ! my_list.contains(friends.get(i).get(0))){
                my_list.add(friends.get(i).get(0));
            }
            if( ! my_list.contains(friends.get(i).get(1))){
                my_list.add(friends.get(i).get(1));
            }
        }
        for(int i=0;i<visitors.size();i++){
            if( !my_list.contains(visitors.get(i))){

                my_list.add(visitors.get(i));
            }
        }

        return my_list;
    }
}
