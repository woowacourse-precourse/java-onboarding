package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> notfriends = new ArrayList<>();
        List<String> yesfriends = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(1) == user) {
                yesfriends.add(friends.get(i).get(0));
            }
            else {
                notfriends.add(friends.get(i).get(0));
            }
        }
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(1) != user)
                notfriends.add(friends.get(i).get(1));
        }
        for(int i = 0; i < visitors.size(); i++) {
            if(!notfriends.contains(visitors.get(i)) && !yesfriends.contains(visitors.get(i)))
                notfriends.add(visitors.get(i));
        }
        List<String> f  = yesfriends.stream().distinct().collect(Collectors.toList());
        List<String> nf = notfriends.stream().distinct().collect(Collectors.toList());
        f.remove(user);
        nf.remove(user);

        for(int i = 0; i < f.size(); i++) {
            nf.remove(f.get(i));
        }

        int[] score = new int[nf.size()];
        for(int i = 0; i < nf.size(); i++) {
            String p = nf.get(i);
            for(int j = 0; j < friends.size(); j++) {
                if(p.equals(friends.get(j).get(0)) || p.equals(friends.get(j).get(1))){
                    for(int k = 0; k < f.size(); k++) {
                        if(friends.get(j).get(0).equals(f.get(i)) ||friends.get(j).get(1).equals(f.get(i)) )
                            score[i] += 10;
                    }
                }
            }
        }

        for(int i = 0; i < f.size(); i++) {
            nf.remove(f.get(i));
        }

        for(int i = 0; i < visitors.size(); i++) {
            if(nf.indexOf(visitors.get(i)) >= 0)
                score[nf.indexOf(visitors.get(i))]++;
        }

        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score.length - 1; j++) {
                if(score[j] < score[j + 1]) {
                    int tmp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = tmp;
                    Collections.swap(nf, i, j);
                }
                else if(score[j] == score[j+1]) {
                    if(nf.get(j).compareTo(nf.get(j+1)) < 0) {
                    }
                    else if(nf.get(j).compareTo(nf.get(j+1)) > 0) {
                        Collections.swap(nf, j, j+1);
                    }
                }
            }
        }

        return nf;
    }
}
