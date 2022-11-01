package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Exception.RangeException;

public class Problem4 {
    private static String lowerCasesTable = "abcdefghijklnmopqrstuvwxyz";
    private static String upperCasesTable = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
    public static String solution(String word) {
        String answer = "";
        try{
            exception(word);
            answer=substitution(word).stream().map(String::valueOf).collect(Collectors.joining());
        }catch (RangeException e)
        {
            //문제에 예외를 어떻게 처리하라는 말이 없음
            //log.error OR log.warn
            //System.out.println(e.toString());
        }
        return answer;
    }

    /**
     * 치환해주는 메소드
     *
     * @param word 문장
     * @return 치환된 문장
     */
    public static List<Character> substitution(String word){
        List<Character> answer = new ArrayList<>();
        for(char c : word.toCharArray()) {
                answer.add(mixer(c, Character.isUpperCase(c)));
        }
        return answer;
    }

    /**
     * 테이블을 이용하여 본격적으로 섞어주는 메소드
     *
     * @param alphabet 알파벳 한글자
     * @param isUpper 대문자 구분
     * @return 치환된 알파벳
     */
    public static char mixer(char alphabet,boolean isUpper)
    {
        int index;
        char substitutionChar;
        if(alphabet==' ') return ' ';
        if(isUpper)
        {   index = upperCasesTable.length()-upperCasesTable.lastIndexOf(alphabet) - 1;
            substitutionChar= upperCasesTable.charAt(index);
        }else{
            index = lowerCasesTable.length()-lowerCasesTable.lastIndexOf(alphabet) - 1 ;
            try{
                substitutionChar= lowerCasesTable.charAt(index);
            }catch (StringIndexOutOfBoundsException e)
            {
                substitutionChar = alphabet;
            }
        }
        return substitutionChar;
    }

    /**
     * 1~1000범위에 일치하지 않는 입력값 예외처리
     * 
     * @param word 문장
     * @throws RangeException 범위Exception
     */
    public static void exception(String word) throws RangeException
    {
        if(word.length()<0||word.length()>1000){
            new RangeException("1~1000의 범위와 일치하지 않습니다");
        }
    }
}
