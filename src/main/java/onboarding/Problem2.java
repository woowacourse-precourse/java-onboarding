package onboarding;

public class Problem2 {
    /*
    기능 목록
     1. 암호를 해석할 때, 문자열이 비어있는지 확인한다
     2. 암호를 해석할 때, 문자열에 중복 문자가 없는지 확인한다.
     3. 만약 비어있지 않고, 문자열에 중복이 없다면 중복 문자를 제거한다.
     4. 스택을 이용해 한 글자씩 입력시킨다.
     5. 만약 입력시키려는 문자와 스택에 마지막으로 들어온 문자가 같다면 같은 두 글자를 제거 한다.
     6. 결과(중복이 지워진 문자열)를 스택에서 문자열로 반환한다.
    */


    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean isEmpty(String cryptogram){
        if(cryptogram.length() == 0) return true;
        return false;
    }
}
