/*
1. 친구 목록 만들기
2. 현재 친구가 아니면서 친구 2명의 친구는 점수 + 10
3. 현재 친구가 아닌 visitor 점수 + 1
4. 최대 5명 리턴
 */

package onboarding;

import java.util.*;


public class Problem7 {
    private static int _first_user = 0;
    private static int _second_user = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> usersPoint = new HashMap<String, Integer>();
        List<String> answer = new ArrayList<>();

        List<String> myFriends = getMyFriends(user, friends);
        usersPoint = calcFriendPoint(user, myFriends, friends, usersPoint);
        usersPoint = calcVisitorPoint(user, myFriends, visitors, usersPoint);

        System.out.print(usersPoint);

        return answer;
    }

    private static List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<String>();
        for (int i = 0; i < friends.size(); ++i)
        {
            List<String> friend = friends.get(i);
            if (isMyFriend(user, friend))
            {
                myFriends.add(getMyFriend(user, friend));
            }
        }
        return myFriends;
    }

    private static boolean isMyFriend(String user, List<String> friend)
    {
        if (friend.get(_first_user) == user || friend.get(_second_user) == user) {
            return true;
        }
        return false;
    }

    private static String getMyFriend(String user, List<String> friend)
    {
        if (friend.get(_first_user) == user)
        {
            return friend.get(_second_user);
        }
        return friend.get(_first_user);
    }

    private static HashMap<String, Integer> calcFriendPoint(String user, List<String> myFriends
            , List<List<String>> friends, HashMap<String, Integer> usersPoint)
    {
        for (int i = 0; i < myFriends.size(); ++i)
        {
            String myFriend = myFriends.get(i);
            List<String> friendFriends = getMyFriends(myFriend, friends);
            for (int j = 0; j < friendFriends.size(); ++j)
            {
                String ff = friendFriends.get(j);
                if (user != ff)
                {
                    if (!isFriend(ff, myFriends))
                    {
                        if (usersPoint.get(ff) != null)
                        {
                            int point = usersPoint.get(ff);
                            usersPoint.put(ff, point + 10);
                        }
                        else
                        {
                            usersPoint.put(ff, 10);
                        }
                    }
                }
            }
        }
        return usersPoint;
    }

    private static HashMap<String, Integer> calcVisitorPoint(String user, List<String> myFriends
            , List<String> visitors, HashMap<String, Integer> usersPoint)
    {
        for (int i = 0; i < visitors.size(); ++i)
        {
            String visitor = visitors.get(i);
            if (!(user == visitor) && !isFriend(visitor, myFriends))
            {
                if (usersPoint.get(visitor) != null)
                {
                    int point = usersPoint.get(visitor);
                    usersPoint.put(visitor, point + 1);
                }
                else
                {
                    usersPoint.put(visitor, 1);
                }
            }
        }
        return usersPoint;
    }

    private static boolean isFriend(String user, List<String> friends)
    {
        for (int i = 0; i < friends.size(); ++i)
        {
            if (friends.get(i) == user)
            {
                return true;
            }
        }
        return false;
    }
}

