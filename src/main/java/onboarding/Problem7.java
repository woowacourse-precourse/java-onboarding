package onboarding;

import java.util.*;

public class Problem7 {
    private class Pair<L, R>{
        L left;
        R right;
        private Pair(L left, R right){
            this.left = left;
            this.right = right;
        }
    }

    private Hashtable<String, List<String>> friendsGraph;
    private Hashtable<String, Integer> score;

    public Problem7(){
        friendsGraph = new Hashtable<String, List<String>>();
        score = new Hashtable<String, Integer>();
    }

    private void addNewKey(String name){
        friendsGraph.put(name, new ArrayList<String>());
        score.put(name, 0);
    }
    private void initFrendsGraph(List<List<String>> friends){
        for(int i = 0; i < friends.size(); ++i){
            String f1 = friends.get(i).get(0);
            String f2 = friends.get(i).get(1);
            if(!friendsGraph.containsKey(f1)){
                addNewKey(f1);
            }
            if(!friendsGraph.containsKey(f2)){
                addNewKey(f2);
            }
            friendsGraph.get(f1).add(f2);
            friendsGraph.get(f2).add(f1);
        }
    }
    private List<String> findUserFF(List<String> userF){
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < userF.size(); ++i){
            ret.addAll(friendsGraph.get(userF.get(i)));
        }
        return ret;
    }
    private void scoring10(String user){
        List<String> userF = friendsGraph.get(user);
        if(userF == null){
            return;
        }
        List<String> userFF = findUserFF(userF);
        for(int i = 0; i < userFF.size(); ++i){
            score.replace(userFF.get(i), score.get(userFF.get(i)) + 10);
        }
    }
    private void scoring1(List<String> visitors){
        for(int i = 0; i < visitors.size(); ++i){
            if(!score.containsKey(visitors.get(i))){
                addNewKey(visitors.get(i));
            }
            score.replace(visitors.get(i), score.get(visitors.get(i)) + 1);
        }
    }
    private List<Pair<Integer,String>> getSortedScore(){
        List<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String >>();
        for(Map.Entry<String,Integer> e : score.entrySet()){
            ret.add(new Pair<>(e.getValue(), e.getKey()));
        }
        /* 추천 점수가 같은 경우는 이름순으로 정렬한다. */
        Collections.sort(ret, new Comparator<Pair<Integer, String>>() {
            @Override
            public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
                return (o1.left != o2.left ? o2.left - o1.left : o1.right.compareTo(o2.right));
            }
        });
        return ret;
    }
    private List<String> findTop5ScoreUser(String user){
        List<String> ret = new ArrayList<String>();
        List<Pair<Integer,String>> sortedScoreList = getSortedScore();
        List<String> userF = friendsGraph.get(user);
        for(int i = 0, cur = 0; i < sortedScoreList.size() && cur < 4; ++i){
            if(sortedScoreList.get(i).left == 0){
                continue;
            }
            String name = sortedScoreList.get(i).right;
            /* user이거나, 이미 user와 친구인 경우는 배제해야한다. */
            if(userF != null && (userF.contains(name) || name.equals(user))){
                continue;
            }
            ret.add(name);
        }
        return ret;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Problem7 p7 = new Problem7();

        p7.initFrendsGraph(friends);
        p7.scoring10(user);
        p7.scoring1(visitors);

        answer = p7.findTop5ScoreUser(user);

        return answer;
    }
}
