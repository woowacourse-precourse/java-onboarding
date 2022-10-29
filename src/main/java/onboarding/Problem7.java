package onboarding;

import java.util.*;


public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        TreeSet<String> users_friend = new TreeSet<>();
        HashMap<String, Integer> other_users=new HashMap<String,Integer>();

        //친구 목록 생성
        for(List<String> friend:friends){
            if(friend.contains(user)){
                String friend_name=friend.get( 1-friend.indexOf(user) );
                users_friend.add(friend_name);
            }
        }
        //친구아닌 유저 목록 생성
        for(List<String> friend:friends) {
            String r_name = friend.get(0);
            String l_name = friend.get(1);
            if(r_name==user || l_name==user)
                continue;
            if (!users_friend.contains(r_name) && !other_users.containsKey(r_name))
                other_users.put(r_name, 0);
            if (!users_friend.contains(l_name )&& !other_users.containsKey(l_name))
                other_users.put(l_name, 0);
        }


        //같은 친구 공유시 +10
        for(List<String> friend:friends){
            if(friend.contains(user))
                continue;
            String r_name=friend.get(0);
            String l_name=friend.get(1);
            //한쪽만 친구일때만 처리
            if(users_friend.contains(r_name)^users_friend.contains(l_name))
                //친구를 r_name으로 몰아넣기
                if(users_friend.contains(l_name)){
                    String temp=l_name;
                    l_name=r_name;
                    r_name=temp;
                }
            other_users.put(l_name,other_users.get(l_name)+10);
        }
        for(String visit_name : visitors){
            if (users_friend.contains(visit_name))
                continue;
            if(!other_users.containsKey(visit_name) )
                other_users.put(visit_name,1);
            else
                other_users.put(visit_name,other_users.get(visit_name)+1);
        }
        List<Map.Entry<String,Integer>> sorting_users=new ArrayList<>(other_users.entrySet());
        Collections.sort(sorting_users, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int value_comp=o1.getValue().compareTo(o2.getValue());
                return value_comp==0? o1.getKey().compareTo(o2.getKey()):-value_comp;
            }
        });



        int cnt=0;
        for(Map.Entry<String,Integer> user_name : sorting_users){
            if(cnt==5)
                break;
            if(user_name.getValue()==0)
                continue;
            answer.add(user_name.getKey());
            cnt++;
        }
        return answer;
    }
}
