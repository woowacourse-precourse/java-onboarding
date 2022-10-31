package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //각자 친구관계 맵
        //점수 맵
        //친구인 사람들의 친구들 점수 + 10
        //방문한 사람들 점수 + 1
        List<String> answer = Collections.emptyList();

        HashMap<String,List<String>> friends_map = new HashMap<String,List<String>>();

        friends_map = make_frends(friends);
        answer = make_answer(user, friends_map, visitors);

        return answer;
    }

    public static HashMap<String,List<String>> make_frends(List<List<String>> friends){
        HashMap<String,List<String>> friends_map = new HashMap<String,List<String>>();

        for(int i =0;i<friends.size();i++)
        {
            if(2 < friends.get(i).size()) //2보다 크면 잘못된 값
                break;
                
            String another_friend = friends.get(i).get(1);
            String main_friend = friends.get(i).get(0);
            add_friend_not_in_map(friends_map, another_friend, main_friend);    
            
            check_add_friend_in_map(friends_map, another_friend, main_friend);
        }
        return friends_map;
    }

    private static void add_friend_not_in_map(HashMap<String, List<String>> friends_map, String another_friend,
            String main_friend) {
        if(!check_friend_in_map(friends_map, main_friend))
        {
            addFriend(friends_map, another_friend, main_friend);
        }
        if(!check_friend_in_map(friends_map, another_friend))
        {
            addFriend(friends_map, main_friend, another_friend);
        }
    }
    
    private static void check_add_friend_in_map(HashMap<String, List<String>> friends_map, String another_friend, String main_friend) {
        if(check_friend_in_map(friends_map, main_friend))
        {
            add_friend_to_map(friends_map, another_friend, main_friend);
        }
        if(check_friend_in_map(friends_map, another_friend))
        {
            add_friend_to_map(friends_map, main_friend, another_friend);
        }
    }

    private static void add_friend_to_map(HashMap<String, List<String>> friends_map, String another_friend, String main_friend) {
        if(!friends_map.get(main_friend).contains(another_friend))
            friends_map.get(main_friend).add(another_friend);
    }
    
    private static boolean check_friend_in_map(HashMap<String, List<String>> friends_map, String friend) {
        return friends_map.get(friend) != null ? true : false;
    }
    
    private static void addFriend(HashMap<String, List<String>> friends_map, String tobeAddedfriend, String main_friend) {
        List<String> templist = new ArrayList<>();
        templist.add(tobeAddedfriend);
        friends_map.put(main_friend, templist);
    }

    public static List<String> make_answer(String user, HashMap<String,List<String>> friends_map, List<String> visitors){
        HashMap<String,Integer> scores = new HashMap<String,Integer>();
        List<String> userfriends = new ArrayList<String>();

        userfriends = friends_map.get(user);
        for(int i = 0;i<userfriends.size();i++)
        {
            if(userfriends.get(i) != null)
                scorefriends(scores, friends_map, userfriends.get(i));
        }

        for(int i = 0; i<visitors.size(); i++)
        {
            if(scores.get(visitors.get(i)) == null)
            {
                scores.put(visitors.get(i), 1);
            }
            else
            {
                scores.put(visitors.get(i), scores.get(visitors.get(i)) + 1);
            }
        }

        return sortedlist(userfriends, scores, user);

    }

    public static HashMap<String,Integer> scorefriends(HashMap<String,Integer> scores, HashMap<String,List<String>> friends_map, String freind) {
        List<String> friends_fr = new ArrayList<String>();

        if(friends_map.get(freind) == null)
            return scores;

        
        friends_fr = friends_map.get(freind);
        for(int i =0; i < friends_fr.size();i++)
        {
            if(scores.get(friends_fr.get(i)) == null)
            {
                scores.put(friends_fr.get(i), 10);
            }
            else
            {
                scores.put(friends_fr.get(i), scores.get(friends_fr.get(i)) + 10);
            }
        }
        return scores;
    }

    public static List<String> sortedlist(List<String> userfriends, HashMap<String,Integer> scores, String user) {

        List<String> topscores = new ArrayList<String>();
        List<String> sortkeys = new ArrayList<>(scores.keySet());
        sortkeys.sort(String.CASE_INSENSITIVE_ORDER); //알파벳순 정렬
        sortkeys.sort((o1, o2) -> scores.get(o2).compareTo(scores.get(o1)));

        for(int i = 0; i<sortkeys.size();i++)
        {
            if(topscores.size() >= 5)
                break;
            if(!userfriends.contains(sortkeys.get(i)) && sortkeys.get(i) != user)
            {
                topscores.add(sortkeys.get(i));
            }
        }
        return topscores;
    }

}
