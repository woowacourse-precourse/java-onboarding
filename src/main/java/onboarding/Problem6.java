package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
//        System.out.println(forms.get(1).get(1));
        List<List<String>> nicknames = new ArrayList<>();
        for (int i=0;i<forms.size();i++){
            nicknames.add(Arrays.asList(forms.get(i).get(1).split("")));
        }
        System.out.println(nicknames);

        List<List<String>> splitnames = new ArrayList<>();
        for (int i=0;i<nicknames.size();i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < nicknames.get(i).size()-1; j++) {
                temp.add(nicknames.get(i).get(j) + nicknames.get(i).get(j+1));
            }
            splitnames.add(temp);
        }
        System.out.println(splitnames);

        HashSet<Integer> idx = new HashSet<>();
        for (int i=0;i<splitnames.size()-1;i++){
            for(int j = 0; j < splitnames.get(i).size(); j++){
                String target=splitnames.get(i).get(j);
                for(int k=i+1; k<splitnames.size();k++) {
                    for (int h = 0; h < splitnames.get(k).size(); h++) {
                        if(target.equals(splitnames.get(k).get(h))){
                            idx.add(i);
                            idx.add(k);
                        }
                    }

                }
            }
        }
        System.out.println(idx);

        List<Integer> resultIdx = new ArrayList<>();
        Iterator iter =idx.iterator();
        while(iter.hasNext()){
            resultIdx.add((Integer) iter.next());
        }
//        System.out.println(resultidx);

        for (int i=0;i<resultIdx.size();i++) {
            answer.add(forms.get(resultIdx.get(i)).get(0));
        }
        Collections.sort(answer);

        return answer;
    }
}
