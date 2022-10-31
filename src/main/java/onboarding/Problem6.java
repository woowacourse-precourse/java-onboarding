package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> nickName = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            nickName.add(forms.get(i).get(1));
        }

        List<Integer>dupIndexList = findDuplicateIndex(nickName);

        for(int i=0;i<dupIndexList.size();i++){
            answer.add(forms.get(dupIndexList.get(i)).get(0));
        }
        Collections.sort(answer);

        return answer;
    }

    private static List<Integer> findDuplicateIndex(List<String> nickName) {
        List<Integer> dupList = new ArrayList<>();

        for (int i = 0; i < nickName.size() - 1; i++) {
            if (dupList.contains(i)|| nickName.get(i).length()==1) continue;
            for (int j = i + 1; j < nickName.size(); j++) {
                if(nickName.get(j).length()==1) continue;
                if (nickName.get(i).length() == 2) {
                    if (nickName.get(j).contains(nickName.get(i))) {
                        if(!dupList.contains(i))
                            dupList.add(i);
                        if(!dupList.contains(j))
                            dupList.add(j);
                    }
                } else {
                    for (int k = 0; k < nickName.get(i).length() - 1; k++) {
                        String idx = nickName.get(i).substring(k, k + 2);
                        if (nickName.get(j).contains(idx)) {
                            if(!dupList.contains(i))
                                dupList.add(i);
                            if(!dupList.contains(j))
                                dupList.add(j);
                        }
                    }
                }
            }
        }
        return dupList;
    }
}