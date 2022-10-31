package onboarding;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if(!err_check(user, friends, visitors)) return answer;
        HashSet<String> friend = new HashSet<>();
        friend = find_friends(user, friends);
        Map<String, Integer> point = get_point(user, friend, friends, visitors);
        answer = sorting(point);
        return answer;
    }

    private static boolean err_check(String user, List<List<String>> friends, List<String> visitors){
        //1 <= user length <= 30
        if(user.length() < 1 || user.length() > 30) return false;
        //visitors is a list which length more than 1 and not more than 10000
        else if(visitors.size() < 0 || visitors.size() > 10000) return false;
        else{
            //friends is a list which length more than 1 and not more than 10000
            if(friends.size() < 1 || friends.size() > 10000) return false;
            else{
                for(List<String> i:friends){
                    //friends' each element is 2 length list
                    if(i.size() != 2) return false;
                    int a = i.get(0).length();
                    int b = i.get(1).length();
                    //ID's length constraint
                    if(a < 1 || a > 30 || b < 1 || b > 30) return false;
                    //if consists of only lowercase alphabet
                    for(int j = 0; j < a; j++){
                        char ch = i.get(0).charAt(j);
                        if(!(ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                            return false;
                    }
                    for(int j = 0; j < b; j++){
                        char ch = i.get(1).charAt(j);
                        if(!(ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private static List<String> sorting(Map<String, Integer> point){
        List<String> ans = new ArrayList<>();
        List<Map.Entry<String, Integer>> sort_point = new ArrayList<>(point.entrySet());
        sort_point.sort(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if(o1.getValue() > o2.getValue())
                    return -1;
                else if(o1.getValue() < o2.getValue())
                    return 1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i = 0; i < sort_point.size(); i++) {
            if (i > 4) break;
            ans.add(sort_point.get(i).getKey());
        }
        return ans;
    }

    private static HashSet<String> find_friends(String user, List<List<String>> friends){
        HashSet<String> friend = new HashSet<>();
        //to find user's friend list
        for(List<String> i:friends){
            String fr1 = i.get(0);
            String fr2 = i.get(1);
            if(fr1.equals(user))
                friend.add(fr2);
            else if(fr2.equals(user))
                friend.add(fr1);
        }
        return friend;
    }
    private static Map<String, Integer> get_point(String user, HashSet<String> friend, List<List<String>> friends, List<String> visitors){
        Map<String, Integer> point = new HashMap<>();
        //add know_each_friends
        for(List<String> i:friends){
            String fr1 = i.get(0);
            String fr2 = i.get(1);
            //fr1 and fr2 should not be user
            if(fr1.equals(user) || fr2.equals(user)) continue;
            //if both of them are friends, continue
            else if(friend.contains(fr1) && friend.contains(fr2)) continue;
            //get points * 10 (if first time, get + 10 points)
            if(friend.contains(fr1)){
                if(point.containsKey((fr2)))
                    point.put(fr2, point.get(fr2) + 10);
                else
                    point.put(fr2, 10);
            }
            else if(friend.contains(fr2)){
                if(point.containsKey((fr1)))
                    point.put(fr1, point.get(fr1) + 10);
                else
                    point.put(fr1, 10);
            }
        }
        //add visiting points
        for(String i:visitors){
            if(!friend.contains(i)){
                if(point.containsKey(i))
                    point.put(i, point.get(i) + 1);
                else
                    point.put(i, 1);    
            }
        }
        return point;
    }
}