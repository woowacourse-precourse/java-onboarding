package onboarding;

/**
 * - 큰 틀의 기능 구현
 * 1. 문자열 비교 : 문자열 내 문자와 다음 문자가 같은지 체크 하는 함수
 * 2. 해당 인덱스 출력 함수 : 문자가 언제까지 같은지 출력하는 함수 - > 두 함수가 필요 시작점 출력 함수 끝점 출력함수
 * 2. 문자열에서 시작점과 끝점을 통한 삭제 함수
 * 3. 결과값 출력 함수 -> while문을 통해 위의 과정 반복 후 결과값 출력
 * **/

/**
 *  * 1. 문자열 비교 : 문자열 내 문자와 다음 문자가 같은지 체크 하는 함수
 *  - boolean 함수를 이용한다
 * **/

/**
 * 2. 해당 인덱스 출력 함수
 * - 문자열 비교 후 같으면 true 값으로 반환 , 아닐시 false 로 번환
 * - 문자열 비교 하기 위한 탐색 함수 같은 문자 발견시 그 해당 char 값 반환, 아닐시 null값 반환
 * ~ 수정 : 시작 문자 위치 출력 함수 -> 증복 되는 부분 시작점 출력 함수
 * ~ 추가 : 끝 문자 위치 출력 함수 -> 중복이 끝나는 부분 위치 출력 함수
 *  **/

/**
 * 3. 문자열에서 중복되는 부분 시작점과 끝점을 통한 삭제 함수
 * - 시작점 부터 끝점을 문자열에서 제거한다.
 * - 시작점과 끝점의 문자열을 substring인 형태로 만든다
 * - 해당 substr을 replace 함수로 제거한다.
 * **/

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
//    public static void main(String[] args){
//        char test1 = 'a';
//        char test2 = 'b';
//        String test3 = "zyelleyz";
//        int i = searchStart(test3);
//        int j = searchEnd(test3, i);
//        System.out.println(deleteChar(test3, i,j));
//    }

    private static boolean compareChar(char current, char next)
    {
        if(current == next)
            return true;
        return false;
    }

    private static int searchStart(String inputStr){
        char ret = '\u0000';
        for (int i = 0; i < inputStr.length(); i++)
        {
            if(compareChar(ret,inputStr.charAt(i))){
                return i - 1;
            }
            ret = inputStr.charAt(i);
        }
        return -1;
    }
    private static int searchEnd(String inputStr,int start){
        char ret = inputStr.charAt(start);
        System.out.println(start);
        for (int i = start; i< inputStr.length(); i++)
        {
            if(compareChar(ret,inputStr.charAt(i))==false){
                return i;
            }
            ret = inputStr.charAt(i);
        }
        return -1;
    }
    private static String deleteChar(String inputstr, int start, int end){
        String subStr ="";
        String ret = inputstr;
        subStr = inputstr.substring(start,end);
        ret = ret.replace(subStr,"");
        return ret;
    }
}
