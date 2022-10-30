package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
//1.form를 만드는 메서드
//2.forms의 밸류를 받아서 두글자씩 나누고 통과되면 배열에 추가하는 메서드
//3.나눈 두글자를 forms 밸류에 넣으면서 있는지 확인하는 메서드
//4.통과시키고 키 값을 set에 넣고 남은 리스트 출력하는 메서드
}
/*
닉네임이 "제이워니"일 경우 "제이엠"과 두글자가 겹쳐서 삭제하면 "워니"를 못찾음
삭제 안하면 효율이 매우 떨어짐
두글자만 같아도 중복이니까 두글자씩
문자열에서 두글자를 얻어서 그 두글자를 배열에 저장
이후에 배열에 두글자가 있으면 통과 (dp)
*/
