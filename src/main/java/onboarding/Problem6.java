package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = divideTwo(forms);
        return answer;
    }

    //1.forms의 밸류를 받아서 두글자씩 나누고 통과시키는 메서드
    public static List<String> divideTwo(List<List<String>> forms) {
        List<String> pass = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();

//        for (List<String> form : forms) {
        for(int i =0;i <forms.size();i++){
            String[] nickname = forms.get(i).get(1).split("");
            for (int j = 0; j < nickname.length - 1; j++) {
                String twoWord = nickname[j] + nickname[j + 1];
                if (!(pass.contains(twoWord))) { /*이미 비교한 두글자는 방문하지 않도록*/
//                    2.나눈 글자를 form 밸류에 넣으면서 확인하는 메서드
//                    for (List<String> formCheck : forms) {
                    for (int k=i+1;k<forms.size();k++){
                        if (forms.get(k).get(1).contains(twoWord)) {
//                          set에 넣어서 중복점검 안하도록
                            resultSet.add(forms.get(k).get(0));
                            resultSet.add(forms.get(i).get(0));
                        }
                    }
                    pass.add(twoWord);
                }
            }
        }
        List<String> result = new ArrayList<>(resultSet); /*set을 list로 다시 변환*/
        Collections.sort(result);
        System.out.println(result);
        return result;
    }
//3.통과시키고 키 값을 set에 넣고 남은 리스트 출력하는 메서드

}
/*
닉네임이 "제이워니"일 경우 "제이엠"과 두글자가 겹쳐서 삭제하면 "워니"를 못찾음
삭제 안하면 효율이 매우 떨어짐
두글자만 같아도 중복이니까 두글자씩
문자열에서 두글자를 얻어서 그 두글자를 배열에 저장
이후에 배열에 두글자가 있으면 통과 (dp)
*/
