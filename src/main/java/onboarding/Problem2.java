package onboarding;

/**
 * - 큰 틀의 기능 구현
 * 1. 문자열 비교 : 같은 문자 일 경우 해당 문자 출력 함수
 * 2. 해당 문자 문자열에서 삭제 함수
 * 3. 결과값 출력 함수 -> while문을 통해 위의 두 함수 반복해 마지막 결과값만 return
 * **/

/**
 * 1. 문자열 비교 함수
 * - 문자열 비교 후 같으면 true 값으로 반환 , 아닐시 false 로 번환
 * - 문자열 비교 하기 위한 탐색 함수 같은 문자 발견시 그 해당 char 값 반환, 아닐시 null값 반환
 *  **/

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
//    public static void main(String[] args){
//        char test1 = 'a';
//        char test2 = 'b';
//        String test3 = "zyelleyz";
//        char test4 =searchAt(test3);
//        System.out.println(test4);
//    }

    private static boolean compareChar(char current, char next)
    {
        if(current == next)
            return true;
        return false;
    }

    private static char searchAt(String inputStr){
        char ret ='\u0000';
        for (int i = 0; i < inputStr.length(); i++)
        {
            if(compareChar(ret,inputStr.charAt(i))){
                return ret;
            }
            ret = inputStr.charAt(i);
        }
        ret = '\u0000';
        return ret;
    }
}
