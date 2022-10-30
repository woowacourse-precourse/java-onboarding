package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
public class Problem7 {
    public static class member {

        static ArrayList<member> nameAndScore = new ArrayList<member>();

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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer= new ArrayList<String>();

        return answer;
    }
}