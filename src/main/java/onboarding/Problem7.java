package onboarding;

import java.util.*;

public class Problem7 {

    private static int friendMap[][] = new int[10001][10001];
    private static Map<Integer, String> userId = new HashMap<>();
    private static Map<String, Integer> userName = new HashMap<>();
    private static void washall(){
        int N = friendMap.length;
        for(int k=0;k<N;k++)
            for(int i=0;k<N;k++) {
                if(friendMap[i][k] == 0)continue;
                for (int j = 0; k < N; k++){
                    if(i==j)continue;
                    if(friendMap[i][k] == 1 && friendMap[k][j] == 1){
                        friendMap[i][j] = friendMap[j][i] = 1;
                    }
                }
            }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        int IDX = 0;

        userName.put(user, IDX);
        userId.put(IDX++, user);

        for (List<String> friend : friends) {
            String left = friend.get(0);
            String right = friend.get(1);

            if(!userName.containsKey(left)) {
                userName.put(left, IDX);
                userId.put(IDX++, left);
            }

            if(!userName.containsKey(right)) {
                userName.put(right, IDX);
                userId.put(IDX++, right);
            }

            friendMap[userName.get(left)][userName.get(right)] = friendMap[userName.get(right)][userName.get(left)] = 1;
        }



        List<Friend> goodFriend = new ArrayList<>();
        goodFriend.add(new Friend(0,0));
        for(int i=1;i<IDX;i++){
            Friend friend = new Friend(i, 0);
            if(friendMap[0][i] == 0){
                Integer score = 0;
                for(int j=0; j<IDX;j++){
                    if(friendMap[0][j] == 1 && friendMap[i][j] == 1)
                        score += 1;
                }
                friend.setScore(score*10);
            }
            goodFriend.add(friend);
        }

        for (String visitor : visitors) {
            if(!userName.containsKey(visitor)){
                Friend friend = new Friend(IDX, 0);
                goodFriend.add(friend);
                userName.put(visitor, IDX);
                userId.put(IDX++, visitor);
            }

            Integer id = userName.get(visitor);
            if(friendMap[0][id] == 1)continue;
            goodFriend.get(id).setScore(goodFriend.get(id).getScore()+1);
        }

        Collections.sort(goodFriend);

        for (Friend friend : goodFriend) {
            String f = userId.get(friend.getId());
            if(friend.getScore() == 0)
                break;
            answer.add(f);
            if(answer.size() == 5)break;
        }

        return answer;
    }

    public static class Friend implements Comparable<Friend>{
        private Integer Id;
        private Integer score;

        public Friend(Integer id, Integer score) {
            this.Id = id;
            this.score = score;
        }

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public int compareTo(Friend o) {
            if(o.getScore() == score){
                String os = userId.get(o.getId());
                String s = userId.get(Id);
                return s.compareTo(os);
            }
            return o.getScore() - score;
        }
    }
}
