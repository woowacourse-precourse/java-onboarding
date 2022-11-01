package onboarding;

import javax.xml.namespace.QName;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = makeFriendList(user, friends);
        ArrayList<SuggestFriend> suggestFriends = findFriendOfFriend(user,friends,userFriends);
        checkVisitor(suggestFriends, userFriends, visitors);
        return answer;
    }
    public static List<String> makeFriendList(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for (List<String> item : friends){
            if(item.get(0).equals(user)){
                userFriends.add(item.get(1));
            }
            else if(item.get(1).equals(user)){
                userFriends.add(item.get(0));
            }
        }
        return userFriends;
    }
    public static ArrayList<SuggestFriend> findFriendOfFriend(String user, List<List<String>> friends, List<String> userFriends){
        ArrayList<SuggestFriend> suggestFriends = new ArrayList<>();
        for(List<String> item : friends){
            if(userFriends.contains(item.get(0))){
                if(!item.get(1).equals(user)){
                    if(!findRedundancy(suggestFriends, item.get(1))){
                       suggestFriends.add(new SuggestFriend(item.get(1),5));
                    }
                }
            }
            else if(userFriends.contains(item.get(1))){
                if(!item.get(0).equals(user)){
                    if(!findRedundancy(suggestFriends, item.get(0))){
                        suggestFriends.add(new SuggestFriend(item.get(0),5));
                    }
                }
            }
        }
        return suggestFriends;
    }
    public static boolean findRedundancy(ArrayList<SuggestFriend> suggestFriends, String name){
        for(SuggestFriend item : suggestFriends){
            if(item.name.equals(name))
                return true;
        }
        return false;
    }
    public static void checkVisitor(ArrayList<SuggestFriend> suggestFriends, List<String> userFriends, List<String> visitors){
        for(String item : visitors){
            if(!findAndAddScore(suggestFriends,item)){
                if(!userFriends.contains(item)){
                    suggestFriends.add(new SuggestFriend(item,1));
                }
            }
        }
    }
    public static boolean findAndAddScore(ArrayList<SuggestFriend> suggestFriends, String name){
        for(SuggestFriend item : suggestFriends){
            if(item.name.equals(name)) {
                item.score+=1;
                return true;
            }
        }
        return false;
    }

}

class SuggestFriend{
    String name;
    int score;

    SuggestFriend(String name, int score){
        this.name = name;
        this.score = score;
    }
}