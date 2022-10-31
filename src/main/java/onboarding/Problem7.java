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
        for(int i=0; i<theirFriend.size()-1; i++){
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
                else if(theirFriend.get(i).get(1).equals(myFriend.get(j))){
                    if(listName.contains(theirFriend.get(i).get(0))){
                        idx=listName.indexOf(theirFriend.get(i).get(0));
                        temp=listScore.get(i)+10;
                        listScore.set(idx,temp);
                    }
                    else{
                        listName.add(theirFriend.get(i).get(0));
                        listScore.add(10);
                    }
                }
            }
        }

        // add visitors, add score
        for (int i = 0; i < visitors.size(); i++) {
            if(listName.contains(visitors.get(i))){
                idx=listName.indexOf(visitors.get(i));
                temp=listScore.get(idx)+3;
                listScore.set(idx,temp);
            }
            else{
                listName.add(visitors.get(i));
                listScore.add(3);
            }
        }

        // remove my friend in listName
        for (int j = 0; j < myFriend.size(); j++) {
            if(listName.contains(myFriend.get(j))){
                idx=listName.indexOf(myFriend.get(j));
                listName.remove(idx);
                listScore.remove(idx);
            }
        }

        // sort order
        String change;
        for (int i = 0; i < listScore.size()-1; i++) {
            for (int j = i+1; j < listScore.size(); j++) {
                if(listScore.get(i)<listScore.get(j)){
                    temp=listScore.get(i);
                    listScore.set(i,listScore.get(j));
                    listScore.set(j,temp);
                    change=listName.get(i);
                    listName.set(i,listName.get(j));
                    listName.set(j,change);
                }
                if(listScore.get(i).equals(listScore.get(j)) && listName.get(i).compareTo(listName.get(j))>0){
                    change=listName.get(i);
                    listName.set(i,listName.get(j));
                    listName.set(j,change);
                }
            }
        }

        return listName;
    }
}
//test
