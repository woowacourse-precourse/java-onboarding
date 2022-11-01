package onboarding;

import java.util.*;

public class Problem7 {
    private static final int USER_NUM=100;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if(input_exception(user,friends,visitors)) return Collections.emptyList();
        List<String> answer = getRanking(user,friends,visitors);
        return answer;
    }

    private static List<String> getRanking(String user, List<List<String>> friends, List<String> visitors){
        List<String> result= new ArrayList<>();
        List<String> userList = getUser(friends,visitors);
        ArrayList<String>[] freindList=new ArrayList[USER_NUM];
        ArrayList<Integer> userScore;

        for(int i=0;i<freindList.length;i++){
            freindList[i]=getFriendList(userList.get(i),friends);
        }
        userScore=getScore(user,userList,freindList,visitors);


        Collections.sort(result);
        return result;
    }

    private static ArrayList<Integer> getScore(String user,List<String> userList,ArrayList<String>[] freindList,List<String> visitors){
        ArrayList result= new ArrayList<>();
        for(int i=0;i<userList.size();i++){
            boolean check=false;
            int score=0;
            if(user.equals(userList.get(i))) {
                result.add(0);
                continue;
            }
            for(int j=0;j<freindList[i].size();j++){
                if(freindList.equals(user)){
                    result.add(0);
                    check=true;
                    break;
                }
            }
            if (check) continue;

        }
        return result;
    }

    private static List<String> getUser(List<List<String>> friends,List<String> visitors){
        List<String> result=new ArrayList<>();
        HashSet<String> userList=new HashSet<>();
        for(int i=0;i<friends.size();i++){
            userList.add(friends.get(i).get(0));
            userList.add(friends.get(i).get(1));
        }
        for(int i=0;i<visitors.size();i++){
            userList.add(visitors.get(i));
        }
        Iterator<String> iter=userList.iterator();
        while(iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }

    private static ArrayList<String> getFriendList(String user, List<List<String>> friends) {
        ArrayList result=new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            if(user==friends.get(i).get(0)) result.add(friends.get(i).get(1));
            else if(user==friends.get(i).get(1)) result.add(friends.get(i).get(0));
        }
        return result;
    }

    private static boolean input_exception(String user, List<List<String>> friends, List<String> visitors){
        //true is 'exception excution'
        return false;
    }
}
