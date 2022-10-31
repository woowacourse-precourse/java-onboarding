package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> emailSet = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){ // 애초에 n^2 로직이 아니었는데?
            for(int j = i; j < forms.size(); j++){ // 다 보기는 해야함. 그래야 맞지.
                // 정렬을 하더라도, 애초에 맨 뒤 두개만 겹치면 상관이 없어진다. 애초에 그냥 이걸로 가는게 맞을지도
                if((i != j) && isSimilar(forms.get(i).get(1),forms.get(j).get(1))){
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }// 여기서 n^2/2 인데, 여기서 더 줄여보자.

        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }
    static boolean isSimilar(String A, String B){
        for(int i = 1; i < B.length(); i++){
            if(A.contains(B.substring(i-1,i+1))){
                return true;
            }
        }
        return false;
    }
}
