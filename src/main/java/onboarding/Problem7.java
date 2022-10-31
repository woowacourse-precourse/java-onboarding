package onboarding;

import java.util.*;

class Pair implements Comparable<Pair> {
    public String name = "";
    public int cnt = 0;
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
        int idx = 0;
        for(int i = 0; i < friends.size(); i++){
            String first = friends.get(i).get(0);
            if(!m.containsKey(first)){
                m.put(first,idx);
                arr.add(first);
                idx++;
            }
            String second = friends.get(i).get(1);
            if(!m.containsKey(second)){
                m.put(second,idx);
                arr.add(second);
                idx++;
            }
        }//인덱스 만들어놓음
        for(int i = 0; i < visitors.size(); i++){
            if(!m.containsKey(visitors.get(i))){
                m.put(visitors.get(i),idx);
                arr.add(visitors.get(i));
                idx++;
            }
        }
        int[][] adj = new int[idx][idx];
        for(int i = 0; i < friends.size(); i++){
            int first = m.get(friends.get(i).get(0));
            int second = m.get(friends.get(i).get(1));
            //System.out.println(first+" "+second);
            adj[first][second] = 1;
            adj[second][first] = 1;
        }
        int useridx = m.get(user);
        Pair[] score = new Pair[idx];
        for(int i = 0; i < idx; i++){
            score[i] = new Pair();
        }
        /*for(int i = 0; i < idx; i++){
            for(int j = 0; j < idx; j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int curidx = 0; curidx < idx; curidx++){
            if(useridx == curidx) continue;
            int curscore = 0;
            for(int j = 0; j < idx; j++){
                if(adj[useridx][j] == 1 && adj[curidx][j] == 1) curscore += 10;
            }
            score[curidx].setCnt(curscore);
        }

        for(int i = 0; i < visitors.size(); i++){
            int curidx = m.get(visitors.get(i));
            score[curidx].setCnt(1);
        }
        for(int i = 0; i < idx; i++){
            score[i].setName(arr.get(i));
        }
        Arrays.sort(score);
/*        for(int i = 0; i < idx; i++)
            System.out.println(score[i].cnt + " " + score[i].name);*/
        for(int i = idx-1; i > -1; i--){
            if(score[i].cnt == 0) continue;
            if(answer.size() >= 5) break;
            if(adj[useridx][m.get(score[i].name)] == 1) continue;
            answer.add(score[i].name);
        }
        return answer;
    }
}
