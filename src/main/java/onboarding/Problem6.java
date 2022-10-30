package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getEmail(forms);
        return answer;
    }


    //중복된 닉네임을 가진 이메일 가져오는 기능
    public static List<String> getEmail(List<List<String>> forms){

        Set<Integer> dupNum = scanDup(forms);

        List<String> sol = new ArrayList<>();
        for (Integer integer : dupNum) {
            sol.add(forms.get(integer).get(0));
        }
        Collections.sort(sol);
        return sol;
    }

    // 중복 검사 기능
    private static Set<Integer> scanDup(List<List<String>> forms) {
        HashMap<String, List<Integer>> dupString = new HashMap<>();
        Set<Integer> dupNum = new HashSet<>();

        for(int i = 0; i< forms.size(); i++){
            String s = forms.get(i).get(1);
            if(s.length()<2){
                continue;
            }else{
                for(int j =0; j<s.length()-1; j++){
                    String substring = s.substring(j, j + 2);
                    List<Integer> integers = dupString.get(substring);
                    if(integers==null){
                        dupString.put(substring, new ArrayList<>(List.of(i)));
                    }else{
                        integers.add(i);
                        if(integers.size()>1){
                            dupNum.addAll(new HashSet<>(integers));
                        }
                    }
                }
            }
        }
        return dupNum;
    }
}
