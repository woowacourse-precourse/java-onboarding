package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1. 중복을 제거하는 기능
2. 친구의 친구를 찾는기능
3. 친구의 친구중 내친구를 제거하는기능
4. 나의 방문자를 확인하는기능
5. 나의 방문자중 친구를 제거하는 기능
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List <String> friendCandidate= new ArrayList<>();
        List <String> friendList = new ArrayList<>();
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> myFriendsSearch(String user,List<List<String>> friends)
    {
        List<List<String>> copyFriends = new ArrayList<>();
        copyFriends.addAll(friends);
        List<String> myFriends = new ArrayList<>();
        System.out.println();
        for (int i=0;i<copyFriends.size();i++) {
            if(copyFriends.get(i).contains(user))
            {
                myFriends.addAll(copyFriends.get(i));
            }
            System.out.println(myFriends);
        }

        System.out.println(myFriends);
//        myFriends.addAll();
        myFriends=new ArrayList<>(myFriends.stream().distinct().collect(Collectors.toList()));
        System.out.println(myFriends);

        myFriends.remove(user);
        return myFriends;
    }
}
