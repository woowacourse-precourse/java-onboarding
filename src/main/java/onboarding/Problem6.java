package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<ArrayList<String>> word = new ArrayList<>();

        for (List<String> form : forms) {          //2차원 리스트생성
            ArrayList<String> word2 = new ArrayList<>();
            String nickname = form.get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                word2.add(nickname.substring(j, j + 2));
            }
            word.add(word2);
        }

        for(int i=0; i<word.size(); i++){
            for(int j=0; j<word.size(); j++){
                for (String s : word.get(j)){
                    if (word.get(i).contains(s) && i!=j){
                        answer.add(forms.get(i).get(0));
                    }
                }
            }
        }
        return result(answer);
    }
    static List<String> result(List<String> answer){    //answer 중복제거하고 정렬하기
        ArrayList<String> answer2 = new ArrayList<>();

        for(String ans : answer){   //중복제거
            if(!answer2.contains(ans))
                answer2.add(ans);
        }
        answer2.sort(Comparator.naturalOrder());
        return answer2;
    }
}
