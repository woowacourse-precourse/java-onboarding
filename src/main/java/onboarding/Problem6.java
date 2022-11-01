package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> tempAnswer = new HashSet<String>();
        List<List<Integer>> pairs =createComparisonPair(forms);

        for (int i=0; i<pairs.size();i++){
            List<Integer> pair = pairs.get(i);
            List<String> crew0 = forms.get(pair.get(0));
            List<String> crew1 = forms.get(pair.get(1));

            if (isContainSameStr(crew0.get(1), crew1.get(1))){
                tempAnswer.add(crew0.get(0));
                tempAnswer.add(crew1.get(0));
            }
        }
        answer = new ArrayList<>(tempAnswer);
        Collections.sort(answer);
        return answer;
    }
    private static List<List<Integer>> createComparisonPair(List<List<String>> forms){
        int size = forms.size();
        List<List<Integer>> temp =new ArrayList<>();
        for (int i=0; i<size;i++){
            for (int j=i+1;j<size;j++){
                temp.add(List.of(i, j));
            }
        }
        return temp;
    }
    private static boolean isContainSameStr(String a, String b){
        boolean result = false;
        HashSet<String> aMap = new HashSet<String>();

        for (int i=0; i<a.length()-1;i++){
            String temp = a.substring(i, i+2);
            aMap.add(temp);
        }
        for (int i=0;i<b.length()-1;i++){
            String temp = b.substring(i, i+2);
            if (aMap.contains(temp)){
                return true;
            }
        }
        return result;
    }
}
