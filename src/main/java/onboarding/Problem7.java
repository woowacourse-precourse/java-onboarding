package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> friend_list = new ArrayList<>();
    static List<String> Near_friend = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        int[]count = new int[2*friends.size()];

        for (List<String> friend : friends) {
            Check_user(friend.get(0), friend.get(1), user);//사용자와 같은 친구인 아이디를 분류
        }

        for (List<String> friend : friends) {
            for (int j = 0; j < friend_list.size(); j++) {
                count[j] += Check_friend(friend.get(0), friend.get(1), friend_list.get(j), user);
                //사용자와 친구 아이디 중 친구은 사람을 분류
            }

        }
        add_visitors(visitors);
        count_visitors(visitors,count);
        String[] arry= Near_friend.toArray(new String[0]);
        sort(arry,count);
        answer = Arrays.asList(arry);

        return answer;
    }
    public static int Check_friend(String friend_one, String friend_two, String user, String one_user) //사용자와 친구 아이디 중 친구은 사람을 분류
    {
        int count =0;
        if(user == friend_one && one_user!=friend_two)
        {
            count +=add_list(friend_two,10);
        }
        else if (user == friend_two && one_user!=friend_one)
        {
            count += add_list(friend_one,10);
        }
        return count;
    }
    public static int add_list(String friend,int num)//이 사람이 리스트에 존재하면 num 만큼 점수를 올린다.
    {
        int count=0;
        if(!Near_friend.contains(friend))
        {
            Near_friend.add(friend);
        }
        count+= num;

        return  count;
    }
    public static void Check_user(String friend_one, String friend_two,String user)//사용자와 같은 친구인 아이디를 분류
    {
        if(Objects.equals(user, friend_one))
        {
            friend_list.add(friend_two);

        } else if (Objects.equals(user, friend_two))
        {
            friend_list.add(friend_one);
        }

    }
    public static void count_visitors(List<String> visitors,int[] count)//방문자들의 점수를 합산한다.
    {
        for(int i=0; i<Near_friend.size();i++)
        {
            for(String vistor:visitors)
            {
                if(vistor ==Near_friend.get(i))
                    count[i]++;
            }
        }
    }

    public static void add_visitors(List<String> visitors)//방문자들을 점수 리스트에 추가한다.
    {
        for(String visitor:visitors)
            if(!Near_friend.contains(visitor)&&!friend_list.contains(visitor))
                Near_friend.add(visitor);
    }
    public static void sort(String[] list, int[] score)
    {
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i; j < list.length; j++) {
                if (score[j] > score[min]) {
                    int temp = score[j];
                    score[j] = score[min];
                    score[min] = temp;

                    String temp2 = list[j];
                    list[j] = list[min];
                    list[min] = temp2;
                }
            }
        }

    }
}
