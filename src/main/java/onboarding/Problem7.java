package onboarding;

import java.util.*;

public class Problem7 {

    public static Set<String> allUserSet;
    public static Map<String, List<String>> friendGraph;
    public static List<String> myFriends;
    public static Map<String, Integer> scoreMap;
    /**
     * @param user     : 주어진 사용자 이름 string
     * @param friends  : friends 관계가 나타내져 있는 String[][]
     * @param visitors : 방문자 String
     * @return Set<String> : 모든 유저 이름을 담은 Set
     */
    public static Set<String> getAllUserSet(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUser = new HashSet<>();
        allUser.add(user);
        for (String visitor : visitors) {
            allUser.add(visitor);
        }
        for (int i = 0; i < friends.size(); i++) {
            allUser.add(friends.get(i).get(0));
            allUser.add(friends.get(i).get(1));
        }
        return allUser;
    }

    /**
     * @param friends : friends 관계가 나타내져 있는 String[][]
     * @return Map<String, List < String>> : 해당하는 유저의 이름 -> 친구 리스트를 반환해주는 Map
     */
    public static Map<String, List<String>> makeFriendGraph(List<List<String>> friends) {
        Map<String, List<String>> friendGraph = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String from = friends.get(i).get(0);
            String to = friends.get(i).get(1);
            if (friendGraph.get(from) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(to);
                friendGraph.put(from, temp);
            } else {
                friendGraph.get(from).add(to);
            }
            if (friendGraph.get(to) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(from);
                friendGraph.put(to, temp);
            } else {
                friendGraph.get(to).add(from);
            }
        }
        return friendGraph;
    }

    /**
     * @param user     : 유저 이름 String
     * @param visitors : 방문자 목록 String
     * @return Map<String, Integer> : 해당하는 유저 String에 대한 user의 점수
     */
    public static Map<String, Integer> getScoreMap(String user, List<String> visitors) {
        Map<String, Integer> scoreMap = new TreeMap<>();
        // 모든 유저의 친구관계를 살펴본다
        for (String userName : allUserSet) {
            // 자기 자신에 대한 점수는 구하지 하지 않음
            if (userName.equals(user)) {
                continue;
            }
            // 해당 유저의 친구들을 살펴보는데
            List<String> userFriends = friendGraph.get(userName);
            for (String myFriend : myFriends) {
                // user의 친구들과 겹치는 것이 있고, 해당하는 유저 점수가 아직 0점일 때
                if (userFriends != null && userFriends.contains(myFriend)) {
                    if (scoreMap.get(userName) == null) {
                        scoreMap.put(userName, 10);
                    } else { // 이미 점수가 존재할 때
                        int prevScore = scoreMap.get(userName);
                        scoreMap.put(userName, prevScore + 10);
                    }
                }
            }
        }
        // 방문자들에 대한 연산
        for (String visitName : visitors) {
            if (scoreMap.get(visitName) == null) {
                scoreMap.put(visitName, 1);
            } else {
                int prevScore = scoreMap.get(visitName);
                scoreMap.put(visitName, prevScore + 1);
            }
        }
        return scoreMap;
    }

    /**
     *  각 유저에 대한 점수 정보를 나타내는 ScoreInfo class
     */
    public static class ScoreInfo {
        private String name;
        private Integer score;

        public ScoreInfo(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public Integer getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    /**
     *  ScoreInfo를 점수내림차순 -> 이름오름차순으로 정렬하기 위한 Comparator
     */
    public static Comparator<ScoreInfo> comparator = new Comparator<ScoreInfo>() {
        @Override
        public int compare(ScoreInfo o1, ScoreInfo o2) {
            if (o1.getScore() == o2.getScore()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o2.getScore() - o1.getScore();
        }
    };

    /**
     *
     * @param user : 유저 String
     * @return List<ScoreInfo> : 해당 유저를 제외한 모두의 ScoreInfo
     */
    public static List<ScoreInfo> getScoreInfos(String user){
        List<ScoreInfo> scoreInfos = new ArrayList<>();
        for (String userName : allUserSet) {
            // 본인은 계산하지 않는다
            if (userName.equals(user)) {
                continue;
            }
            scoreInfos.add(new ScoreInfo(userName, scoreMap.get(userName)));
        }
        return scoreInfos;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        allUserSet = getAllUserSet(user, friends, visitors);
        friendGraph = makeFriendGraph(friends);
        myFriends = friendGraph.get(user);
        scoreMap = getScoreMap(user, visitors);
        List<ScoreInfo> scoreInfos = getScoreInfos(user);
        Collections.sort(scoreInfos, comparator);
        int count = 0;
        for (ScoreInfo scoreInfo : scoreInfos) {
            if (myFriends.contains(scoreInfo.getName()))
                continue;
            if (count < 5) {
                answer.add(scoreInfo.getName());
                count++;
            } else
                break;
        }
        return answer;
    }
}
