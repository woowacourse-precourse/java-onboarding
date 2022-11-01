package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    static void expand(String newname, List<String> name, List<Integer> score, List<List<Integer>> graph){
        name.add(newname);
        score.add(0);

        int gsize = graph.size();
        List<Integer> L = new ArrayList<Integer>(Collections.nCopies(gsize,0));
        graph.add(L);
        for(int i=0;i<gsize+1;i++){
            graph.get(i).add(0);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<Integer> score = new ArrayList<Integer>();
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        expand(user,name,score,graph);
        //graph만들기
        for(int i=0;i<friends.size();i++){
            String name0 = friends.get(i).get(0);
            if(!name.contains(name0)) expand(name0,name,score,graph);

            String name1 = friends.get(i).get(1);
            if(!name.contains(name1)) expand(name1,name,score,graph);

            int p = name.indexOf(name0);
            int q = name.indexOf(name1);
            graph.get(p).set(q,1);
            graph.get(q).set(p,1);
        }

        int gsize = graph.size();
        for(int i=1;i<gsize;i++){
            if(graph.get(0).get(i)==0){
                for(int j=1;j<gsize;j++){
                    int wasscore = score.get(j);
                    score.set(j,wasscore+10);
                }
            }
        }
        //방문점수
        for(int i=0;i<visitors.size();i++){
            String visitor = visitors.get(i);
            //다른 친구들과 아무관계 없는 사람에 대해서는 name, score에만 추가해주면 됨
            if(!name.contains(visitor)){
                name.add(visitor);
                score.add(0);
            }
            int index = name.indexOf(visitor);
            int wasscore = score.get(index);
            score.set(index,wasscore+1);
        }

        //친구 0으로 초기화
        for(int i=0;i<gsize;i++){
            if(graph.get(0).get(i)==1){
                score.set(i,0);
            }
        }
        int count = 0;
        int maxscore = Collections.max(score);
        do{
            List<String> beforesort = new ArrayList<String>();
            for(int a=0;a<score.size();a++){
                if(maxscore==score.get(a)){
                    beforesort.add(name.get(a));
                    count += 1;
                }
            }
            Collections.sort(beforesort);
            int canputin = Math.min(5-result.size(),beforesort.size());
            for(int a=0;a<canputin;a++){
                result.add(beforesort.get(a));
            }

            int themax = 0;
            for(int a=0;a<score.size();a++){
                int nowscore = score.get(a);
                if(maxscore>nowscore){
                    if(themax<nowscore) themax = nowscore;
                }
            }
            if(themax==0) break;
            else maxscore = themax;
        }while(count<5);
        return result;
    }
}
