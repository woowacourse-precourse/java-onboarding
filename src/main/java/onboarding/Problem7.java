package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = recommendSystem(user, friends, visitors);
        return answer;
    }

    static class FriendInfo {
        private String name;
        private int score;

        public FriendInfo(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void friendWith() {
            score += 10;
        }

        public void visited() {
            score += 1;
        }

        public boolean comparePerson(String name)
        {
            if(this.name.equals(name))
                return true; //중복되면 TRUE 반환
            return false;
        }

    }

    public static List<String> recommendSystem(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> result = Collections.emptyList();
        ArrayList<String> friendList = findUserFriend(user, friends);
        ArrayList<FriendInfo> PersonInfo = findPersonKnowWith(user,friends, friendList);
        PersonInfo = findVisitor(PersonInfo, visitors, friendList);
        result = findTop5(PersonInfo);
        return result;
        /*for (int i = 0; i < friends.size(); i++) {
            ArrayList<String> relationShip = (ArrayList<String>)friends.get(i);
            addPersonList(PersonInfo,relationShip,user);
        }
        addPersonList(PersonInfo,(ArrayList<String>)visitors,user);*/
    }

    public static ArrayList<String> findUserFriend(String user, List<List<String>> friends)
    { //user의 친구를 찾아주는 함수
        ArrayList<String> friendsList = new ArrayList<>();
        for(List<String> relationship : friends)
        {
            if(relationship.get(0).equals(user))
            {
                friendsList.add(relationship.get(1));
            }
            if (relationship.get(1).equals(user))
            {
                friendsList.add(relationship.get(0));
            }
        }
        return friendsList;
    }

    public static ArrayList<FriendInfo> findPersonKnowWith(String user, List<List<String>> friends,
        ArrayList<String> userFriend) {
        ArrayList<FriendInfo> PersonInfo = new ArrayList<>();
        for(List<String> relationship : friends)
        {
            if(userFriend.contains(relationship.get(0)) && !userFriend.contains(relationship.get(1))&&!relationship.get(1).equals(user))
            {
                int idx =overlapCheck(PersonInfo, relationship.get(1));
                if(idx ==-1)
                {
                    FriendInfo friend =new FriendInfo(relationship.get(1));
                    PersonInfo.add(friend);
                    friend.friendWith();
                }
                else{
                    PersonInfo.get(idx).friendWith();
                }
            }
            else if(!userFriend.contains(relationship.get(0)) && userFriend.contains(relationship.get(1)))
            {
                int idx =overlapCheck(PersonInfo, relationship.get(0));
                if(idx ==-1)
                {
                    FriendInfo friend =new FriendInfo(relationship.get(0));
                    PersonInfo.add(friend);
                    friend.friendWith();
                }
                else{
                    PersonInfo.get(idx).friendWith();
                }
            }
        }
        return PersonInfo;
    }

    public static ArrayList<FriendInfo> findVisitor(ArrayList<FriendInfo> PersonInfo, List<String> visitors, ArrayList<String> userFriend)
    {
        ArrayList<FriendInfo> temp = PersonInfo;
        for(int i=0; i< visitors.size(); i++)
        {
            for(int j=0; j<temp.size(); j++)
            {
                int idx = overlapCheck(temp, visitors.get(i));
                if(idx==-1 && !userFriend.contains(visitors.get(i)))
                {
                    FriendInfo friend =new FriendInfo(visitors.get(i));
                    temp.add(friend);
                    friend.visited();
                }
                else if (idx!=-1 && !userFriend.contains(visitors.get(i))){
                    temp.get(idx).visited();
                }
            }
        }
        return temp;
    }

    public static List<String> findTop5(ArrayList<FriendInfo> PersonInfo)
    {
        List<String> top5 = Collections.emptyList();
        for(int i=0; i< PersonInfo.size(); i++)
        {
            for(int j=i; j< PersonInfo.size(); j++)
            {
                FriendInfo temp = PersonInfo.get(i);
                if(PersonInfo.get(i).getScore()<PersonInfo.get(j).getScore()){
                    PersonInfo.set(i,PersonInfo.get(j));
                    PersonInfo.set(j,temp);
                } else if (PersonInfo.get(i).getScore()==PersonInfo.get(j).getScore()) {
                    if(PersonInfo.get(i).getName().compareTo(PersonInfo.get(j).getName()) < 0)//문자열 비교
                    {
                        PersonInfo.set(i,PersonInfo.get(j));
                        PersonInfo.set(j,temp);
                    }
                }

            }
        }
        for(int i=0; i<5; i++)
        {
            top5.add(PersonInfo.get(i).getName());
        }
        return top5;
    }








    /*
    public static void addPersonList(ArrayList<FriendInfo> friendList, ArrayList<String> addList, String user)
    { //friendList 안에 addList 사람이 있는지 확인
        for(int i=0; i< addList.size(); i++)
        {
            if(!overlapCheck(friendList, addList.get(i)) && !addList.get(i).equals(user))
            {
                friendList.add(new FriendInfo(addList.get(i)));
            }
        }
    }
 */
    public static int overlapCheck(ArrayList<FriendInfo> PersonInfos, String name) //성능 문제 생각 //오버랩 되면 true 반환
    {
        for(int i=0; i< PersonInfos.size(); i++)
        {
            if(PersonInfos.get(i).comparePerson(name))
                return i;
        }
        return -1;
    }

}
