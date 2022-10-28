package onboarding;

import org.mockito.stubbing.Stubber;

import java.util.*;

public class Problem7 {
    static class Info {
        int score; String id;
        public Info(int score, String id) {
            this.score = score;
            this.id = id;
        }
    }

    static class sortInfo implements Comparator<Info> {
        public int compare(Info a, Info b) {
            if(a.score == b.score) return (a.id).compareTo(b.id);
            else return b.score - a.score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        int unused = 0;
        Hashtable<Integer, String> noToId = new Hashtable<>();
        Hashtable<String, Integer> idToNo = new Hashtable<>();

        List<List<Integer>> frRel = new ArrayList<>();

        boolean inht;
        int no0, no1;
        for(List<String> fr : friends) {
            for(int i = 0; i < 2; i++) {
                inht = idToNo.containsKey(fr.get(i));
                if(!inht) {
                    noToId.put(unused, fr.get(i));
                    idToNo.put(fr.get(i), unused++);
                    frRel.add(new ArrayList<>());
                }
            }
            no0 = idToNo.get(fr.get(0));
            no1 = idToNo.get(fr.get(1));
            (frRel.get(no0)).add(no1);
            (frRel.get(no1)).add(no0);
        }
        int MX = unused + visitors.size();
        boolean userfr[] = new boolean[MX];
        int score[] = new int[MX];

        for(int i = 0; i < MX; i++) {
            userfr[i] = false;
            score[i] = 0;
        }

        int userNo = idToNo.get(user);
        for(int uf : frRel.get(userNo)) userfr[uf] = true;

        for(String vis : visitors) {
            inht = idToNo.containsKey(vis);
            if(!inht) {
                noToId.put(unused, vis);
                idToNo.put(vis, unused++);
            }
            no0 = idToNo.get(vis);
            score[no0]++;
        }
        for(int i = 0; i < frRel.size(); i++) {
            if(i == userNo) continue;
            for(int no : frRel.get(i))
                if(userfr[no]) score[i] += 10;
        }
        ArrayList<Info> recList = new ArrayList<Info>();
        for(int i = 0; i < MX; i++)
            if(score[i] != 0 && !userfr[i] && (i != userNo))
                recList.add(new Info(score[i], noToId.get(i)));

        Collections.sort(recList, new sortInfo());

        int lim = Math.min(5, recList.size());
        for(int i = 0; i < lim; i++)
            answer.add(recList.get(i).id);
        return answer;
    }
}