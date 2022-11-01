package onboarding;

import java.lang.reflect.Array;
import java.util.*;

class InitFriendInformation{
    Map<String, ArrayList<String>> conn = new HashMap<String, ArrayList<String>>();
    public void addConnect(List<List<String>> friends, ArrayList<String> arrayList, int index, int who){
        arrayList.add(friends.get(index).get(who));
        conn.put(friends.get(index).get((who+1)%2), arrayList);
    }

    public void replaceConnect(List<List<String>> friends, ArrayList<String> getList, int index, int who){
        getList.add(friends.get(index).get(who));
        conn.replace(friends.get(index).get((who+1)%2), getList);
    }

    public Map<String, ArrayList<String>> connectFriend(String user, List<List<String>> friends, List<String> visitors){
        for(int i=0;i<friends.size();i++){
            if(!conn.containsKey(friends.get(i).get(0))){
                ArrayList<String> arrayList = new ArrayList<>();
                addConnect(friends, arrayList, i, 1);
            } else{
                ArrayList<String> getList = conn.get(friends.get(i).get(0));
                replaceConnect(friends, getList, i, 1);
            }

            if(!conn.containsKey(friends.get(i).get(1))){
                ArrayList<String> arrayList = new ArrayList<>();
                addConnect(friends, arrayList, i, 0);
            } else{
                ArrayList<String> getList = conn.get(friends.get(i).get(1));
                replaceConnect(friends, getList, i, 0);
            }
        }

        return conn;
    }
}

class ScoreBoard{
    HashMap<String, Integer> score = new HashMap<>();
    Set<String> visited = new HashSet<>();

    private void addScoreVisitors(List<String> visitors) {
        for(int i = 0; i< visitors.size(); i++){
            if(!score.containsKey(visitors.get(i))){
                score.put(visitors.get(i), 1);
            } else{
                score.put(visitors.get(i), (int)score.get(visitors.get(i)) + 1);
            }
        }
    }

    public void dfs(String user, Map<String, ArrayList<String>> conn, String cur){
        visited.add(cur);
        if(!conn.get(cur).contains(user)) {
            return;
        }

        for(int i=0;i<conn.get(cur).size();i++){
            if(!visited.contains(conn.get(cur).get(i))){
                if(!score.containsKey(conn.get(cur).get(i))){
                    score.put(conn.get(cur).get(i), 10);
                } else{
                    score.put(conn.get(cur).get(i), score.get(conn.get(cur).get(i)) + 10);
                }

                dfs(user, conn, conn.get(cur).get(i));
            }
        }
    }

    public List<String> resultBestScore(String user, Map<String, ArrayList<String>> conn, List<String> visitors){
        addScoreVisitors(visitors);

        visited.add(user);
        for(int i=0;i<conn.get(user).size();i++){
            if(!visited.contains(conn.get(user).get(i))){
                dfs(user, conn, conn.get(user).get(i));
            }
        }

        return scoreConversionSortedList(user, conn);
    }

    private List<String> scoreConversionSortedList(String user, Map<String, ArrayList<String>> conn) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(score.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        List<String> answer = new ArrayList<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() == 0) break;
            if(!conn.get(user).contains(entry.getKey())) answer.add(entry.getKey());
            if(answer.size() == 5) break;
        }
        return answer;
    }
}

public class Problem7 {
    private final static InitFriendInformation initFriendInformation = new InitFriendInformation();
    private final static ScoreBoard scoreBoard = new ScoreBoard();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> connectFriend = initFriendInformation.connectFriend(user, friends, visitors);
        return scoreBoard.resultBestScore(user, connectFriend, visitors);
    }
}
