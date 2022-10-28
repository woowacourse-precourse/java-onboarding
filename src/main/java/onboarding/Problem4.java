package onboarding;

public class Problem4 {
    /*
     * 기능 정리
     * 1. 대문자,소문자를 나눠 문자매핑 시키기 (array의 0~25 index 번호를 각 알파벳을 의미하는 수로 사용하고,각 index 안에는 해당 매핑시킬 알파벳 아스키 코드값 할당)
     * 2. 매핑 배열을 가지고 문자열 변환하기
     * */



    public static String solution(String word) { // 문자열인데 이름을 word로 해놓은 이유
        setLetterCaseMappingTable();
        String answer = getChangedString(word);
        return answer;
    }
}
