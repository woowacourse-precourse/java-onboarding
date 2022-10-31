package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, ArrayList<String>> Connect_Friend(HashMap<String,ArrayList<String>> Friend , String name1, String name2){
        ArrayList<String> friend_list1 = Friend.getOrDefault(name1,new ArrayList<String>());
        friend_list1.add(name2);
        Friend.put(name1, friend_list1);

        ArrayList<String> friend_list2 = Friend.getOrDefault(name2, new ArrayList<String>());
        friend_list2.add(name1);
        Friend.put(name2,friend_list2);
        return Friend;
    }

    static HashMap<String, ArrayList<String>> Find_Friend(List<List<String>> friends){
        HashMap<String,ArrayList<String>> Friend = new HashMap<>();
        List<String> people;
        String name1;
        String name2;

        for(int i = 0 ;i <friends.size() ; i++){
            people = friends.get(i);
            name1 = people.get(0);
            name2 = people.get(1);
            Friend = Connect_Friend(Friend,name1,name2);
        }
        return Friend;
    }

    static HashMap<String,Integer> Score_Friend(String user, HashMap<String,ArrayList<String>> Friend){
        HashMap<String,Integer> friend_score = new HashMap<String,Integer>();
        ArrayList<String> friend_friend;
        ArrayList<String> user_friend = Friend.get(user);
        String user_friend_name = null;
        String friend_friend_name = null;
        int friend_score_temp;
        for(int i = 0; i < user_friend.size() ; i++){
            user_friend_name = user_friend.get(i);
            friend_friend = Friend.get(user_friend_name);
            for(int j = 0 ; j < friend_friend.size() ; j++){
                friend_friend_name = friend_friend.get(j);
                if(user.equals(friend_friend_name)) continue; // User 는 점수고려 X
                friend_score_temp = friend_score.getOrDefault(friend_friend_name, 0) + 10;
                friend_score.put(friend_friend_name,friend_score_temp);
            }
        }
        return friend_score;
    }

    static HashMap<String,Integer> Score_Visit(HashMap<String,Integer> friend_score,List<String> visitors){
        String visitor_name;
        int friend_score_temp;

        for(int i = 0 ; i < visitors.size();i++){
            visitor_name = visitors.get(i);
            friend_score_temp = friend_score.getOrDefault(visitor_name,0) + 1;
            friend_score.put(visitor_name,friend_score_temp);
        }
        return friend_score;
    }

    static HashMap<String,Integer> Delete_Score(HashMap<String,Integer> friend_score,List<String> friend){
        for(int i = 0 ; i < friend.size() ; i++){
            friend_score.put(friend.get(i),0);
        }
        return friend_score;
    }

    static List<String> Recommend_Friend(HashMap<String,Integer> friend_score){
        Set<String> key = friend_score.keySet();
        List<String> Recommend = new ArrayList<String>();
        String name = null;
        for(Iterator<String> i = key.iterator();i.hasNext();){
            name = i.next();
            if(friend_score.get(name) > 0) Recommend.add(name);
            if(Recommend.size() == 5) break;
        }
        return Recommend;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,ArrayList<String>> connect_friend = Find_Friend(friends);
        HashMap<String,Integer> friend_score = Score_Friend(user,connect_friend);
        friend_score = Score_Visit(friend_score,visitors);
        friend_score = Delete_Score(friend_score,connect_friend.get(user));

        List<String> answer = Recommend_Friend(friend_score);
        System.out.println(answer);
        return answer;
    }
}
