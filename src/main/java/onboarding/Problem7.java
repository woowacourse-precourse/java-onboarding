package onboarding;

import java.util.Collections;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userfriend =new ArrayList<>();
        List<String> friends2 = new ArrayList<>();
        //user친구리스트
        for(int i=0;i<friends.size();i++) {
            if(friends.get(i).contains(user)) {
                for(int j=0;j<2;j++) {
                    if(friends.get(i).get(j)!=user) {
                        userfriend.add(friends.get(i).get(j));
                    }
                }
            }
        }
        //user친구아닌사람리스트
        for(int i=0;i<friends.size();i++) {
            for(int j=0;j<2;j++) {
                if(friends.get(i).get(j)!=user) {
                    friends2.add(friends.get(i).get(j));
                }
            }
        }
        for(int i=0;i<visitors.size();i++) {
            friends2.add(visitors.get(i));
        }
        Set<String> set = new HashSet<String>(friends2);
        List<String> nofriend =new ArrayList<String>(set);
        for(int i=0;i<userfriend.size();i++) {
            nofriend.remove(userfriend.get(i));
        }
        //user함께아는 친구
        int[] score= new int[nofriend.size()];
        for(int i=1;i<score.length;i++) {
            score[i]=0;
        }
        for(int i=0;i<friends.size();i++) {
            for(int j=0;j<nofriend.size();j++) {
                if(friends.get(i).contains(nofriend.get(j))) {
                    for(int k=0;k<userfriend.size();k++) {
                        if(friends.get(i).contains(nofriend.get(j)) && friends.get(i).contains(userfriend.get(k))) {
                            score[j]+=10;
                        }
                    }
                }
            }
        }
        //방문횟수
        for(int i=0;i<visitors.size();i++) {
            for(int j=0;j<nofriend.size();j++) {
                if(visitors.get(i)==nofriend.get(j)) {
                    score[j]+=1;
                }
            }
        }
        Map<String, Integer> scoremap = new HashMap<>();
        //글자오름차순으로정렬1
        for(int i=0;i<score.length;i++) {
            scoremap.put(nofriend.get(i),score[i]);
        }
        List<String> keySet = new ArrayList<>(scoremap.keySet());

        Collections.sort(keySet);

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scoremap.get(o2).compareTo(scoremap.get(o1));
            }
        });
        return keySet;
    }
}
