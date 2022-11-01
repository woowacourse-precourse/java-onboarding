package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
1. 중복을 제거하는 기능
2. 친구의 친구를 찾는기능
3. 친구의 친구중 내친구를 제거하는기능
4. 나의 방문자를 확인하는기능
5. 나의 방문자중 친구를 제거하는 기능
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List <String> friendList = new ArrayList<>(myFriendsSearch(user,friends));
        List <String> friendCandidate= new ArrayList<>(friendOfFriend(friends,friendList));
        List <String> notFriendOfFriendCandidate = deleteMyAndFriend(friendCandidate,friendList,user);
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> myFriendsSearch(String user,List<List<String>> friends)
    {
        List<List<String>> copyFriends = new ArrayList<>();
        copyFriends.addAll(friends);
        List<String> myFriends = new ArrayList<>();
        for (int i=0;i<copyFriends.size();i++) {
            if(copyFriends.get(i).contains(user))
            {
                myFriends.addAll(copyFriends.get(i));
            }
        }

//        myFriends.addAll();
        myFriends=new ArrayList<>(myFriends.stream().distinct().collect(Collectors.toList()));

        myFriends.remove(user);
        return myFriends;
    }
    public static List<String> friendOfFriend(List<List<String>> friend,List<String> myFriend)
    {
        List<String> friendCandidate = new ArrayList<>();
        System.out.println("myfriend : "+myFriend);
        for(int j=0;j<myFriend.size();j++) {
            for (int i = 0; i < friend.size(); i++) {
                System.out.println(friend.get(i).contains(myFriend.get(j)));
                if (friend.get(i).contains(myFriend.get(j))) {
                    friendCandidate.addAll(friend.get(i));
                }
                System.out.println(friendCandidate);
            }
        }
        return friendCandidate;
    }
    public static List<String> deleteMyAndFriend(List<String> friendCandidate,List<String> myFriend,String user)
    {
        for(int i=0;i<friendCandidate.size();i++){
            friendCandidate.remove(user);
        }
        for(int i=0;i<friendCandidate.size();i++)
        {
            for(int j=0;j<myFriend.size();j++)
            {
                friendCandidate.remove(myFriend.get(j));
            }
        }
        return friendCandidate;
    }
}
