package onboarding;

import java.util.*;


class Friends implements Comparable<Friends> {
    public Friends(String n) {
        name=n;
    }

    String name = "";
    HashSet<String> friendList = new HashSet<>();
    int visitCount = 0;
    int recommendPoint = 0;

    public String getName() {
        return name;
    }

    public void inputFriend(String st) {
        friendList.add(st);
    }

    public void visitPlus() {
        visitCount++;
    }

    public HashSet<String> getFriendList()
    {
        return friendList;
    }
    public void solveRecommendPoint(String user, HashSet<String> userFriendList){
        boolean isUserFriend = false;
        for(String st:friendList)
        {
            if(st.equals(user))
                isUserFriend=true;
        }
        for(String myFriend : friendList)
        {
            for(String userFriend:userFriendList)
            {
                if(myFriend.equals(userFriend))
                    recommendPoint+=10;
            }
        }
        recommendPoint+=visitCount;
        if(isUserFriend)
        {
            recommendPoint=0;
        }
    }
    public int getRecommendPoint()
    {
        return recommendPoint;
    }
    @Override
    public int compareTo(Friends o) {
        if(this.recommendPoint>o.recommendPoint)
            return -1;
        return 1;
    }
}
public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        ArrayList<Friends> allList = new ArrayList<>();

        //1
        allList.add(new Friends(user));
        for(List<String> ls:friends)
        {
            boolean exist1 = false;
            boolean exist2 = false;
            for(Friends f:allList)
            {
                if(f.getName().equals(ls.get(0)))
                {
                    f.inputFriend(ls.get(1));
                    exist1 = true;
                }
                if(f.getName().equals(ls.get(1))) {
                    f.inputFriend(ls.get(0));
                    exist2 = true;
                }
            }
            if(!exist1)
            {
                Friends newFriend1 = new Friends(ls.get(0));
                newFriend1.inputFriend(ls.get(1));
                allList.add(newFriend1);
            }
            if(!exist2)
            {
                Friends newFriend2 = new Friends(ls.get(1));
                newFriend2.inputFriend(ls.get(0));
                allList.add(newFriend2);
            }
        }

        //2
        for(String st:visitors)
        {
            boolean exist3 = false;
            for(Friends f:allList) {
                if(f.getName().equals(st))
                {
                    exist3=true;
                    f.visitPlus();
                }
            }
            if(!exist3)
            {
                Friends newFriend3 = new Friends(st);
                newFriend3.visitPlus();
                allList.add(newFriend3);
            }
        }

        //3
        Friends master=null;
        for(Friends f:allList)
        {
            if(f.getName().equals(user))
            {
                master = f;
                break;
            }
        }
        for(Friends f:allList)
        {
            f.solveRecommendPoint(user,master.getFriendList());
        }
        ArrayList<Friends> maybeAnswer = new ArrayList<>(allList);
        maybeAnswer.remove(master);
        Collections.sort(maybeAnswer);
        int countRecommend=0;
        for(Friends f:maybeAnswer)
        {
            if(f.getRecommendPoint()>0&&countRecommend<5)
            {
                answer.add(f.getName());
            }
            countRecommend++;
        }
        return answer;
    }

}