package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = new ArrayList<>();
        List<List<String>> theirFriends = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();

        int idx;
        int temp;

        // Who is my friend?
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                myFriends.add(friends.get(i).get(1));
                names.add(friends.get(i).get(1));
                scores.add(0);
            }
            else if(friends.get(i).get(1).equals(user)){
                myFriends.add(friends.get(i).get(0));
                names.add(friends.get(i).get(0));
                scores.add(0);
            }
            else{
                theirFriends.add(friends.get(i));
            }
        }

        // if my friend's friend, add score
        for(int i=0; i<theirFriends.size()-1; i++){
            for(int j=0; j<myFriends.size(); j++){
                if(theirFriends.get(i).get(0).equals(myFriends.get(j))){
                    if(names.contains(theirFriends.get(i).get(1))){
                        idx=names.indexOf(theirFriends.get(i).get(1));
                        temp=scores.get(i)+10;
                        scores.set(idx,temp);
                    }
                    else{
                        names.add(theirFriends.get(i).get(1));
                        scores.add(10);
                    }
                }
                else if(theirFriends.get(i).get(1).equals(myFriends.get(j))){
                    if(names.contains(theirFriends.get(i).get(0))){
                        idx=names.indexOf(theirFriends.get(i).get(0));
                        temp=scores.get(i)+10;
                        scores.set(idx,temp);
                    }
                    else{
                        names.add(theirFriends.get(i).get(0));
                        scores.add(10);
                    }
                }
            }
        }

        // add visitors, add score
        for (int i = 0; i < visitors.size(); i++) {
            if(names.contains(visitors.get(i))){
                idx=names.indexOf(visitors.get(i));
                temp=scores.get(idx)+3;
                scores.set(idx,temp);
            }
            else{
                names.add(visitors.get(i));
                scores.add(3);
            }
        }

        // remove my friend in listName
        for (int j = 0; j < myFriends.size(); j++) {
            if(names.contains(myFriends.get(j))){
                idx=names.indexOf(myFriends.get(j));
                names.remove(idx);
                scores.remove(idx);
            }
        }

        // sort order
        String change;
        for (int i = 0; i < scores.size()-1; i++) {
            for (int j = i+1; j < scores.size(); j++) {
                if(scores.get(i)<scores.get(j)){
                    temp=scores.get(i);
                    scores.set(i,scores.get(j));
                    scores.set(j,temp);
                    change=names.get(i);
                    names.set(i,names.get(j));
                    names.set(j,change);
                }
                if(scores.get(i).equals(scores.get(j)) && names.get(i).compareTo(names.get(j))>0){
                    change=names.get(i);
                    names.set(i,names.get(j));
                    names.set(j,change);
                }
            }
        }

        return names;
    }
}