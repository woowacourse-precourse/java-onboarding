package onboarding;

import java.util.*;

class Pair implements Comparable<Pair> {
    public String name;
    public int cnt;
    public Pair(){
        name = "";
        cnt = 0;
    }
    public void setCnt(int n){
        cnt += n;
    }
    public void setName(String _name){
        name = _name;
    }
    @Override
    public int compareTo(Pair o) {
        if(cnt - o.cnt != 0) return cnt - o.cnt;
        return o.name.compareTo(name);
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        int index = 0;
        for (List<String> friend : friends) {
            String first = friend.get(0);
            if (!m.containsKey(first)) {
                m.put(first, index);
                arr.add(first);
                index++;
            }
            String second = friend.get(1);
            if (!m.containsKey(second)) {
                m.put(second, index);
                arr.add(second);
                index++;
            }
        }//인덱스 만들어놓음
        for (String visitor : visitors) {
            if (!m.containsKey(visitor)) {
                m.put(visitor, index);
                arr.add(visitor);
                index++;
            }
        }
        int[][] adj = new int[index][index];
        for (List<String> friend : friends) {
            int first = m.get(friend.get(0));
            int second = m.get(friend.get(1));
            //System.out.println(first+" "+second);
            adj[first][second] = 1;
            adj[second][first] = 1;
        }
        int userIndex = m.get(user);
        Pair[] score = new Pair[index];
        for(int i = 0; i < index; i++){
            score[i] = new Pair();
        }

        for(int curIndex = 0; curIndex < index; curIndex++){
            if(userIndex == curIndex) continue;
            int curScore = 0;
            for(int j = 0; j < index; j++){
                if(adj[userIndex][j] == 1 && adj[curIndex][j] == 1) curScore += 10;
            }
            score[curIndex].setCnt(curScore);
        }

        for (String visitor : visitors) {
            int curIndex = m.get(visitor);
            score[curIndex].setCnt(1);
        }
        for(int i = 0; i < index; i++){
            score[i].setName(arr.get(i));
        }
        Arrays.sort(score);

        for(int i = index-1; i > -1; i--){
            if(score[i].cnt == 0) continue;
            if(answer.size() >= 5) break;
            if(adj[userIndex][m.get(score[i].name)] == 1) continue;
            answer.add(score[i].name);
        }
        return answer;
    }
}