package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> name = new HashMap<>();
        int[] score_num = new int[10001];
        int cnt=0; // 사람 수
        for(int i=0; i<friends.size(); i++){
            String f1 = friends.get(i).get(0); String f2 = friends.get(i).get(1);
            // 쭉 돌면서 없으면 map에 정보추가 있으면 넘어가기
            if(name.get(f1)==null){
                name.put(f1, cnt);
                cnt++;
            }
            if(name.get(f2)==null){
                name.put(f2, cnt);
                cnt++;
            }
        }
        // 방문자 정보
        for(int i=0; i<visitors.size(); i++){
            String f1 = visitors.get(i);
            if(name.get(f1)==null){
                name.put(f1, cnt);
                cnt++;
            }
        }


        Iterator<String> iter = name.keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            int value = name.get(key);
        }

        // 친구 네트워크 인접리스트
        ArrayList<ArrayList<Integer>> network = new ArrayList<>();
        ArrayList<Integer>[] adjlist = new ArrayList[cnt];
        for(int i=0; i<adjlist.length; i++) {
            adjlist[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<friends.size(); i++){
            String f1 = friends.get(i).get(0); String f2 = friends.get(i).get(1);
            // 사람에 해당하는 번호찾기
            int fnum1 = name.get(f1); int fnum2 = name.get(f2);
            adjlist[fnum1].add(fnum2);
            adjlist[fnum2].add(fnum1);
        }

        // 기준
        int person = name.get(user);

        for(int i=0; i<adjlist[person].size(); i++){
            //
            int fri = adjlist[person].get(i);
            score_num[fri]=-9999; // 이미 친구인 경우
            for(int j=0; j<adjlist[fri].size(); j++){
                int frifri = adjlist[fri].get(j);
                if(frifri==person){
                    continue;
                } // 자기자신일 경우 continue

                if(score_num[frifri]>0) continue;
                else if(score_num[frifri]==0){
                    score_num[frifri]=10;
                }
            }
        }

        // visitors check
        for(int i=0; i<visitors.size(); i++){
            int f_idx = name.get(visitors.get(i));
            score_num[f_idx]++;
        }

        // ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            String nick ="";
            if(score_num[i]>0){
                for(String key : name.keySet()){
                    if(name.get(key).equals(i)){
                        nick = key;
                        break;
                    }
                }
                // String who = nick;
                answer.add(nick);

            }
        }

        return answer;
    }
}
