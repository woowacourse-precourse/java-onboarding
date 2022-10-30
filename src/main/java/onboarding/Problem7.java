package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Problem7 {

    static ArrayList<member> nameAndScore = new ArrayList<member>();

    public static class member {

        String name;
        int score;

        public member(String user, int score) {
            this.name=user;
            this.score=score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }

    static Comparator<member> comparator = new Comparator<member>() {

        public int compare(member o1, member o2) {

            int score1 = o1.getScore();
            int score2 = o2.getScore();
            if (score1 > score2) {
                return -1;
            } else if (score1 < score2) {
                return 1;
            } else {
                return (o1.getName().compareTo(o2.getName()));
            }
        }
    };

    public static String nextUser (List<String> connectionList,String user) {
        if (connectionList.get(0)==user) {
            return connectionList.get(1);
        } else {
            return connectionList.get(0);
        }
    }
    public static int containsName(String user) {
        for (int i=0; i<nameAndScore.size(); i++) {
            if (nameAndScore.get(i).name==user) {
                return i;
            }
        }
        return -1;
    }
    public static void plusScore(String user, int num, ArrayList<member> nameAndScore) {
        int userIdx = containsName(user);
        if (userIdx!=-1) {
            int updatedScore= (int) nameAndScore.get(userIdx).score+num;
            nameAndScore.remove(userIdx);
            nameAndScore.add(new member(user,updatedScore));
        } else {
            nameAndScore.add(new member(user,num));
        }
    }

    public static void duplicateFriendsCount(String user, int depth, int[] visited, List<List<String>> friends, List<String> alreadyFriends) {
        if (depth==1) {
            for (int i=0; i<friends.size(); i++) {
                if (friends.get(i).contains(user)) {
                    if (visited[i]==0) {
                        visited[i]=1;
                        String next=nextUser(friends.get(i),user);
                        if (alreadyFriends.contains(next)) {
                            continue;
                        }
                        plusScore(next,10,nameAndScore);
                    }
                }
            }
        } else {
            for (int i=0; i<friends.size(); i++) {
                if (friends.get(i).contains(user)) {
                    if (visited[i]==0) {
                        visited[i]=1;
                        String next=nextUser(friends.get(i),user);
                        duplicateFriendsCount(next,1,visited,friends,alreadyFriends);
                    }
                }
            }
        }
    }

    public static void visitorsCount(List<String> alreadyFriends, List<String> visitors) {
        for (int i=0; i<visitors.size(); i++) {
            System.out.println(visitors.get(i));
            if (!alreadyFriends.contains(visitors.get(i))) {
                plusScore(visitors.get(i),1,nameAndScore);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer= new ArrayList<String>();
        int[] visited = new int[friends.size()];
        List<String> alreadyFriends = new ArrayList<>(friends.size());

        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                alreadyFriends.add(nextUser(friends.get(i),user));
            }
        }

        duplicateFriendsCount(user,0,visited,friends,alreadyFriends);

        visitorsCount(alreadyFriends,visitors);

        Collections.sort(nameAndScore, comparator);

        for (int i=0; i<Math.min(5,nameAndScore.size()); i++) {
            answer.add(nameAndScore.get(i).name);
        }

        return answer;
    }
}