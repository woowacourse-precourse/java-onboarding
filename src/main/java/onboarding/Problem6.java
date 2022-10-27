package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
