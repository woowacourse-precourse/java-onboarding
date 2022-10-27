package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i=0;i<forms.size()-1;i++){
            for (int j=i+1; j<forms.size();j++) {
                String iName = forms.get(i).get(1);
                String jName = forms.get(j).get(1);
                String iMail = forms.get(i).get(0);
                String jMail = forms.get(j).get(0);
                if (isConfused(iName, jName)) {
                    answer.addAll(List.of(iMail, jMail));
                }
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        for(String mail : answer){
            hashSet.add(mail);
        }
        answer = new ArrayList<>(hashSet);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
    static boolean isConfused(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        ArrayList<String> nGramA = new ArrayList<>();
        ArrayList<String> nGramB = new ArrayList<>();
        for (int i=0;i<lenA-1;i++) {
            nGramA.add(A.substring(i,i+2));
        }
        for (int i=0;i<lenB-1;i++) {
            nGramB.add(B.substring(i,i+2));
        }
        for (int i=0;i<nGramA.size();i++) {
            if (nGramB.contains(nGramA.get(i))) {
                return true;
            }
        }
        return false;
    }
}
