package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //get friends list
        List<user_recommended_friend> user_recommended_friend_list = new ArrayList<>();
        List<String> temp_friend_list = new ArrayList<>();
        for(int i = 0; i < friends.size(); i ++)
        {
            temp_friend_list.add(friends.get(i).get(0));
            temp_friend_list.add(friends.get(i).get(1));
        }
        for(int i = 0; i < visitors.size(); i ++)
        {
            temp_friend_list.add(visitors.get(i));
        }
        Set<String> set = new HashSet<>(temp_friend_list);
        List<String> friend_list = new ArrayList<>(set);

        //set friends relation
        for(int i = 0; i < friend_list.size(); i ++)
        {
            if(check_relation(friend_list.get(i), friends, user) == -2)
            {
                user_recommended_friend friend = new user_recommended_friend(friend_list.get(i), -2);
                user_recommended_friend_list.add(friend);
            }
            if(check_relation(friend_list.get(i), friends, user) == -1)
            {
                user_recommended_friend friend = new user_recommended_friend(friend_list.get(i), -1);
                user_recommended_friend_list.add(friend);
            }
            if(check_relation(friend_list.get(i), friends, user) == 0)
            {
                user_recommended_friend friend = new user_recommended_friend(friend_list.get(i), 0);
                user_recommended_friend_list.add(friend);
            }
        }
        //set score by relation
        for(int i = 0; i < friends.size(); i ++)
        {
            if(is_friend(friends.get(i).get(0), user_recommended_friend_list) && is_friend_friend(friends.get(i).get(1), user_recommended_friend_list))
            {
                for(int j = 0; j < user_recommended_friend_list.size(); j ++)
                {
                    if(user_recommended_friend_list.get(j).name.equals(friends.get(i).get(1)))
                    {
                        user_recommended_friend_list.get(j).score += 10;
                    }
                }
            }
            else if(is_friend(friends.get(i).get(1), user_recommended_friend_list) && is_friend_friend(friends.get(i).get(0), user_recommended_friend_list))
            {
                for(int j = 0; j < user_recommended_friend_list.size(); j ++)
                {
                    if(user_recommended_friend_list.get(j).name.equals(friends.get(i).get(0)))
                    {
                        user_recommended_friend_list.get(j).score += 10;
                    }
                }
            }
        }
        //set score by visit
        for(int i = 0; i < visitors.size(); i ++)
        {
            if(is_friend_friend(visitors.get(i), user_recommended_friend_list))
            {
                for(int j = 0; j < user_recommended_friend_list.size(); j ++)
                {
                    if(user_recommended_friend_list.get(j).name.equals(visitors.get(i)))
                    {
                        user_recommended_friend_list.get(j).score += 1;
                    }
                }
            }
        }
        //sort array
        MyComperator cmp = new MyComperator();
        Collections.sort(user_recommended_friend_list, cmp);

        //make answer
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < user_recommended_friend_list.size(); i ++)
        {
            if(user_recommended_friend_list.get(i).score > 0)
                answer.add(user_recommended_friend_list.get(i).name);
        }
        return answer;
    }
    static class MyComperator implements Comparator<user_recommended_friend> {
        @Override
        public int compare(user_recommended_friend o1, user_recommended_friend o2) {
            if(o1.score > o2.score)
                return -1;
            else if(o1.score < o2.score)
                return 1;
            for(int i = 0; i < o1.name.length(); i ++)
            {
                if(o2.name.length() < i)
                    return 1;
                if(o1.name.charAt(i) > o2.name.charAt(i))
                    return 1;
                if(o1.name.charAt(i) < o2.name.charAt(i))
                    return -1;
            }
            return -1;
        }
    }
    static boolean is_friend(String name, List<user_recommended_friend> user_recommended_friend_list)
    {
        for(int i = 0; i < user_recommended_friend_list.size(); i ++)
        {
            if(user_recommended_friend_list.get(i).name.equals(name))
            {
                if(user_recommended_friend_list.get(i).score == -1)
                    return true;
                else return false;
            }
        }
        return false;
    }
    static boolean is_friend_friend(String name, List<user_recommended_friend> user_recommended_friend_list)
    {
        for(int i = 0; i < user_recommended_friend_list.size(); i ++)
        {
            if(user_recommended_friend_list.get(i).name.equals(name))
            {
                if(user_recommended_friend_list.get(i).score >= 0)
                    return true;
                else return false;
            }
        }
        return false;
    }
    static int check_relation(String name, List<List<String>> friends, String user)
    {
        //relation : user
        if(name.equals(user))
            return -2;
        //relation : friends;
        for(int i = 0; i < friends.size(); i ++)
        {
            if(friends.get(i).get(0).equals(name) || friends.get(i).get(1).equals(name))
            {
                if(friends.get(i).get(0).equals(user) || friends.get(i).get(1).equals(user))
                {
                    return -1;
                }
            }
        }
        //relation : (maybe)recommended friends;
        return 0;
    }
    static class user_recommended_friend
    {
        String name;
        int score;
        user_recommended_friend(String name, int score)
        {
            this.name = name;
            this.score = score;
        }
    }
}
