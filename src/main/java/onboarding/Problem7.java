package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    // func : save people from user, friends, visitors and return it
    private static List<String> getNameList(String user, List<List<String>> friends, List<String> visitors){
       List<String> nameList = new ArrayList<>();

       // user input
        nameList.add(user);
       // friends input
        for (int i=0;i<friends.size();i++){
            for (int j=0;j<2;j++){
                String name = friends.get(i).get(j);
                // the name is not in nameList, add it
                if (!(nameList.contains(name)))
                    nameList.add(name);
            }
        }
        for (int i=0;i<visitors.size();i++){
            String name = visitors.get(i);
            if (!(nameList.contains(name)))
                nameList.add(name);
        }
        return nameList;
    }
    // func : calculate score by visit, return scoreboard
    private static List<Integer> visitScore(List<String> nameList, List<String> visitors, List<Integer> scoreboard){

        // plus visit score
        for (int i=0;i<visitors.size();i++){
            int idx = nameList.indexOf(visitors.get(i));
            scoreboard.set(idx, scoreboard.get(idx) + 1);
        }
        return scoreboard;
    }
    // func : get friends table, order : nameList
    private static List<List<Integer>> getFriendTable(List<String> nameList, List<List<String>> friends){

        List<List<Integer>> userFriend = new ArrayList<>();

        // check nameList and find one by one
        for (int i=0;i<nameList.size();i++){
            String checkName = nameList.get(i);
            List<Integer> tmpScore = new ArrayList<>();
            List<Integer> idxList = new ArrayList<>();
            // check checkName's friends and restore friends nameList index in idxList
            for (int j=0; j<friends.size();j++) {
                if (friends.get(j).contains(checkName)) {
                    if (friends.get(j).indexOf(checkName) == 0){
                        idxList.add(nameList.indexOf(friends.get(j).get(1)));
                    }
                    else{
                        idxList.add(nameList.indexOf(friends.get(j).get(0)));
                    }
                }
            }
            // make up tmpScore
            for (int k=0;k<nameList.size();k++){
                if (idxList.contains(k)){
                    tmpScore.add(1);
                }
                else
                    tmpScore.add(0);
            }
            userFriend.add(tmpScore);
        }

        return userFriend;
    }
    // func : calculate score by checking friendship
    private static List<Integer> getFriendScore(List<String> nameList, List<List<String>> friends, List<Integer> scoreboard){

        // check friend table
        List<List<Integer>> friendTable = getFriendTable(nameList, friends);
        List<Integer> userFriendIdx = new ArrayList<>();

        // calculate friend score
        // if he is user's friend, store index
        for(int i=0;i<friendTable.get(0).size();i++){
            if (friendTable.get(0).get(i) == 1){
                userFriendIdx.add(i);
            }
        }

        // check user's friends ^ 2 and score up
        for (int i=0;i<userFriendIdx.size();i++){
            for (int j=0;j<friendTable.get(userFriendIdx.get(i)).size();j++){
                if (friendTable.get(userFriendIdx.get(i)).get(j) == 1)
                    scoreboard.set(j, scoreboard.get(j) + 10);
            }
        }
        // initialize myself
        scoreboard.set(0,0);
        return scoreboard;
    }
    // func : calculate score and return 5 recommends
    private static List<String> getRecommend(String user, List<List<String>> friends, List<String> visitors){
        List<String> recommend = new ArrayList<>();
        List<String> nameList = getNameList(user, friends, visitors);
        List<Integer> scoreboard = new ArrayList<>();
        List<List<Integer>> friendTable = getFriendTable(nameList, friends);
        for (int i=0;i<nameList.size();i++)
            scoreboard.add(0);
        // calculate visiting score
        visitScore(nameList,visitors,scoreboard);

        // calculate friend score
        getFriendScore(nameList,friends,scoreboard);

        int flag = 0;
        int prevMax = 0;
        while (flag < 5){
            int max = 0;
            for (int j=0;j<scoreboard.size();j++){
                if (max < scoreboard.get(j))
                    max = scoreboard.get(j);
            }
            // there's no recommend
            if (max == 0)
                break;
            else{
                int maxIdx = scoreboard.indexOf(max);
                // if not already friend
                if (friendTable.get(0).get(maxIdx) != 1){
                    recommend.add(nameList.get(maxIdx));
                    if (prevMax == max)
                        Collections.sort(recommend);
                    flag += 1;
                    prevMax += max;
                }
                scoreboard.set(maxIdx,0);
            }
        }

        return recommend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getRecommend(user,friends,visitors);
        return answer;
    }
}
