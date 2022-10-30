package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // create a set to get all users in friends and visitors
        HashSet<String> usernameSet = new HashSet<>();

        // add users from friends
        for(List<String> friendList: friends){ // ["donut", "andole"]
            for(String name: friendList){ // "donut"
                usernameSet.add(name);
            }
        }
        //add users from visitors
        for(String visitor: visitors){
            usernameSet.add(visitor);
        }

        // initialize all users' score to zero
        List<HashMap<String, Integer>> usernameAndScoreList = new ArrayList<>();
        for (String username: usernameSet){
            HashMap<String, Integer> usernameAndScore = new HashMap<>();
            usernameAndScore.put(username, 0);
            usernameAndScoreList.add(usernameAndScore);
        }


        // find user's direct friend
        HashSet<String> directFriends = new HashSet<String>();
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                for(String friendName: friendList){
                    if(friendName != user){
                        directFriends.add(friendName);
                    }
                }
            }
        }

        // find user's mutual friend (direct friends' friends)
        HashSet<String> mutualFriends = new HashSet<>();
        for(String directFriend: directFriends){
            for(List<String> friendList: friends){
                for(String friendName: friendList){
                    if(friendName != directFriend && friendName != user){
                        mutualFriends.add(friendName);
                    }
                }
            }
        }
        mutualFriends.removeAll(directFriends);


        // add score to mutual friends
        for(String mutualFriend: mutualFriends){ // andole
                for(List<String> friendList: friends){ // ["donut", "andole"]
                    if(friendList.contains(mutualFriend)){ // true
                        // find in scoreList and add score
                        for(HashMap<String, Integer> usernameAndScore: usernameAndScoreList){
                            for(String key: usernameAndScore.keySet()){ //
                                if(key==mutualFriend){
                                    usernameAndScore.put(key, usernameAndScore.get(key)+10);
                                }
                            }
                        }
                    }
                }
            }

        // add score to visitors
        for(String visitor: visitors){
            for(HashMap<String, Integer> usernameAndScore: usernameAndScoreList){
                for(String key: usernameAndScore.keySet()){ //
                    if(key==visitor){
                        usernameAndScore.put(key, usernameAndScore.get(key)+1);
                    }
                }
            }
        }


        System.out.println(usernameAndScoreList);




        List<String> answer =   new ArrayList<>();

       /* // user의 direct friend 구하기
        HashSet<String> directFriends = new HashSet<String>();
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                for(String friendName: friendList){
                    if(friendName != user){
                        directFriends.add(friendName);
                    }
                }
            }
        }

        // user의 mutual friend 구하기
        HashSet<String> mutualFriends = new HashSet<>();
        for(String directFriend: directFriends){
            for(List<String> friendList: friends){
                for(String friendName: friendList){
                    if(friendName != directFriend && friendName != user){
                        mutualFriends.add(friendName);
                    }
                }
            }
        }
        mutualFriends.removeAll(directFriends);

        // 추천인 리스트 만들기
        HashSet<String> suggestedAccounts = new HashSet<>();
        suggestedAccounts.addAll(mutualFriends);
        suggestedAccounts.addAll(visitors);
        suggestedAccounts.removeAll(directFriends);

        System.out.println("suggested: "+suggestedAccounts);
        System.out.println("mutual: "+mutualFriends);
        System.out.println("visited: "+visitors);



        // mutual friend => + 10점
        for(String mutualFriend: mutualFriends){
            if(suggestedAccounts.contains(mutualFriend)){
                for(List<String> friendList: friends){
                    if(friendList.contains(mutualFriend)){
                        score.put(mutualFriend, score.get(mutualFriend)+10);
                    }
                }
            }
        }

        // visitor => + 1 점
        for(String visitor: visitors){
            if(suggestedAccounts.contains(visitor)){
                score.put(visitor, score.get(visitor)+1);
            }
        }

        System.out.println(score);

        HashMap<String, Integer> sortedScore = new HashMap<>();
        score.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedScore.put(x.getKey(), x.getValue()));

        System.out.println(sortedScore);

        for(Map.Entry<String,Integer> entry: score.entrySet()){
            answer.add(entry.getKey());
            if(answer.size()>=5){
                break;
            }
        }*/

        return answer;
    }

}
