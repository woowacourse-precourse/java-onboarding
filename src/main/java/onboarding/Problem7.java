package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriend = new ArrayList<>();
        List<List<String>> theirFriend = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        List<Integer> listScore = new ArrayList<>();

        int idx;
        int temp;

        // Who is my friend?
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                myFriend.add(friends.get(i).get(1));
                listName.add(friends.get(i).get(1));
                listScore.add(0);
            }
            else if(friends.get(i).get(1).equals(user)){
                myFriend.add(friends.get(i).get(0));
                listName.add(friends.get(i).get(0));
                listScore.add(0);
            }
            else{
                theirFriend.add(friends.get(i));
            }
        }

        // if my friend's friend, add score
        for(int i=0; i<theirFriend.size(); i++){
            for(int j=0; j<myFriend.size(); j++){
                if(theirFriend.get(i).get(0).equals(myFriend.get(j))){
                    if(listName.contains(theirFriend.get(i).get(1))){
                        idx=listName.indexOf(theirFriend.get(i).get(1));
                        temp=listScore.get(i)+10;
                        listScore.set(idx,temp);
                    }
                    else{
                        listName.add(theirFriend.get(i).get(1));
                        listScore.add(10);
                    }
                }
            }
        }

        return listName;
    }
}
