package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = NickCheck(forms);
        return answer;
    }
    public static List<String> NickCheck(List<List<String>> crew){
        List<String> repet = new ArrayList<>();

        for(int i = 0; i < crew.size(); i++){

            int nick_len = crew.get(i).get(1).length();
            int cnt = 0;
            //j를 이용하여 i번째 닉네임의 시작부터 2글자씩 k번째 닉네임과 비교
            for(int j = 0 ; j < nick_len-1; j++){
                // k는 i+1 번째 부터 비교한다. 그리고 i와 k가 같을 때는 비교하지 않는다.
                for(int k = i+1 ; k < crew.size() ; k++){
                    if((i!=k)&&crew.get(k).get(1).contains(crew.get(i).get(1).substring(j, j+2))){
                        cnt++;
                        repet.add(crew.get(k).get(0));
                    }
                }
            }
            if(cnt != 0){
                repet.add(crew.get(i).get(0));
            }
        }
        Set<String> delete = new HashSet<>(repet);
        repet = new ArrayList<>(delete);

        Collections.sort(repet);
        return repet;
    }
}
