package onboarding;

import org.mockito.internal.stubbing.answers.CallsRealMethods;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendsOfUser = findFriendsOfUser(user, friends);
        List<String> commonFriends = findCommonFriends(friends, friendsOfUser, user);
        visitors = changVisitors(visitors, friendsOfUser);
        System.out.println(visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriendsOfUser(String user, List<List<String>> friends){

        List<String> friendsOfUser = new ArrayList<>();

        for(int i=0; i < friends.size() ; i++){
            if(friends.get(i).contains(user)){
                int userIndex = friends.get(i).indexOf(user);
                friendsOfUser.add(friends.get(i).get(1-userIndex));
            }
        }
        return friendsOfUser;
    }

    public static List<String> findCommonFriends(List<List<String>> friends, List<String> friendsOfUser, String user){
        ArrayList<String> commonFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            if(friendsOfUser.contains(friends.get(i).get(0))) commonFriends.add(friends.get(i).get(1));
            if(friendsOfUser.contains(friends.get(i).get(1))) commonFriends.add(friends.get(i).get(0));
        }

        while(commonFriends.contains(user)){
            commonFriends.remove(user);
        }

        while(commonFriends.contains(friendsOfUser)){
            commonFriends.removeAll(friendsOfUser);
        }

        return commonFriends;
    }

    public static List<String> changVisitors(List<String> visitors,List<String> friendsOfUser){


        System.out.println("1");
//        for(int i=0; i<friendsOfUser.size(); i++){
//            String oldFriend = friendsOfUser.get(i);
//
//        }

//        Iterator iter = visitors.iterator();
//        while(iter.hasNext()){
//            if("donut".equals(iter.next())){
//                iter.remove();
//            }
//        }
//        visitors.remove(visitors.indexOf("donut"));
//        visitors.remove(visitors.indexOf("shakevan"));
//        visitors.remove(2);
//        visitors.remove(3);
        System.out.println("2");
        ArrayList<String> visitors2 = new ArrayList<>();
        System.out.println("3");
        visitors2.add("bedi");
        visitors2.add("bedi");
        visitors2.add("bedi");
        System.out.println("4");
        return visitors2;
    }


}
