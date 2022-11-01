package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> userfriends= findUserFreinds(user,friends);
        List<String> friendsofuserfriend = findFriendsOfUserFriends(user, userfriends, friends);

        Map<String,Integer> nameandscore = new HashMap<>();
        nameandscore = countScoreByFriendsOfUserFriends(nameandscore,friendsofuserfriend);
        nameandscore = countScoreByNumberOfVisitors(nameandscore, visitors, userfriends);

        answer = recommendFriend(nameandscore);

        return answer;
    }

    public static String findMyFriend( String myname, List<String> friends){
        String myfriend = "";

        if(friends.contains(myname)){
            if(friends.get(0).equals(myname)) {
                myfriend= friends.get(1);
            }
            else if(friends.get(1).equals(myname)){
                myfriend = friends.get(0);
            }
        }
        return myfriend;
    }

    public static List<String> findUserFreinds(String user, List<List<String>> friends){
        List<String> userfriends= new ArrayList<>();
        for (int i=0; i< friends.size(); i++) {
            String uesrfriend = findMyFriend(user, friends.get(i));
            if (!uesrfriend.isEmpty()) {
                userfriends.add(findMyFriend(user, friends.get(i)));
            }
        }
        return userfriends;
    }

    public static List<String> findFriendsOfUserFriends(String user, List<String> userfriends, List<List<String>> friends){
        List<String> freindoffriend = new ArrayList<>();
        for (int i = 0; i < userfriends.size(); i++) {
            for(int j=0; j<friends.size(); j++) {
                if(!friends.get(j).contains(user)) {
                    String myfreind = findMyFriend(userfriends.get(i), friends.get(j));
                    if (!myfreind.isEmpty()) {
                        freindoffriend.add(myfreind);
                    }
                }
            }
        }
        return freindoffriend;
    }

    public static Map<String,Integer> countScoreByFriendsOfUserFriends(Map<String,Integer> nameandscore, List<String>freindsofuserfriend){
        Map<String,Integer> result = nameandscore;
        for(int i=0; i<freindsofuserfriend.size(); i++){
            if(!nameandscore.containsKey(freindsofuserfriend.get(i))){
                nameandscore.put(freindsofuserfriend.get(i), 10);
            }
            else if(nameandscore.containsKey(freindsofuserfriend.get(i))){
                int score = nameandscore.get(freindsofuserfriend.get(i));
                nameandscore.put(freindsofuserfriend.get(i), score +10);
            }
        }
        return result;
    }

    public static Map<String, Integer> countScoreByNumberOfVisitors(Map<String,Integer> nameandscore,List<String> visitors, List<String> userfriends){
        Map<String,Integer> result = nameandscore;

        for(int i=0; i<visitors.size(); i++){
            String visitorname = visitors.get(i);
            if(!userfriends.contains(visitorname)) {
                if (!result.containsKey(visitorname)) {
                    result.put(visitorname, 1);
                }
                else if (result.containsKey(visitorname)) {
                    int score = result.get(visitorname);
                    result.put(visitorname, score+1 );
                }
            }
        }
        return result;
    }

    public static List<String> recommendFriend(Map<String, Integer> nameandscore ){
        List<Map.Entry<String,Integer>> sortedbyscore = nameandscore.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        System.out.println("sortedbyscore = " + sortedbyscore);
        List<String> result = new ArrayList<>();
        List<String> tmp;
        for (int i=0; i<sortedbyscore.size()-1; i++) {
            int j=1;
            if(!result.contains(sortedbyscore.get(i).getKey())) {
                tmp = new ArrayList<>();
                tmp.add(sortedbyscore.get(i).getKey());
                if(sortedbyscore.get(i).getValue() == sortedbyscore.get(i+j).getValue() ) {
                    while (sortedbyscore.get(i).getValue() == sortedbyscore.get(i + j).getValue()) {
                        tmp.add(sortedbyscore.get(i + j).getKey());
                        j++;
                        if( i+j == sortedbyscore.size()){
                            break;
                        }
                        System.out.println("tmp = " + tmp);
                    }
                    tmp.sort(Comparator.naturalOrder());
                }
                else if(sortedbyscore.get(i).getValue() != sortedbyscore.get(i+j).getValue()){
                    tmp.add(sortedbyscore.get(i + j).getKey());
                }
                if(i+j == sortedbyscore.size()-1){
                    tmp.add(sortedbyscore.get(i + j).getKey());
                }
                for (String name : tmp) {
                    if(result.size()<5) {
                        result.add(name);
                    }
                }
            }
        }
        return  result;
    }


}

