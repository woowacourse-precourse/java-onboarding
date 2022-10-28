package onboarding;

/**
 * - 큰 틀의 기능 구현
 * 1. 문자열 비교 : 같은 문자 일 경우 해당 문자 출력 함수
 * 2. 해당 문자 문자열에서 삭제 함수
 * 3. 결과값 출력 함수 -> while문을 통해 위의 두 함수 반복해 마지막 결과값만 return
 * **/

/**
 * 1. 문자열 비교 함수
 * - 문자열 비교 후 같으면 해당 문자 반환 아닐 시 char의 null 값 return
 *  **/

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
//    public static void main(String[] args){
//        char test1 = 'a';
//        char test2 = 'b';
//        if(compareChar(test1,test2) == '\u0000')
//            System.out.println("null");
//        else
//            System.out.println(compareChar(test1,test2));
//    }

    private static char compareChar(char prev, char current)
    {
        char ret = '\u0000';
        if(prev == current)
            return prev;
        return ret;
    }
}
