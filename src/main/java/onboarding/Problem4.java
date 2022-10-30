package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    private static String lowerCasesTable = "abcdefghijklnmopqrstuvwxyz";
    private static String upperCasesTable = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
    public static String solution(String word) {
        String answer = "";
        answer=substitution(word).stream().map(String::valueOf).collect(Collectors.joining());
        return answer;
    }

    public static List<Character> substitution(String word){
        List<Character> answer = new ArrayList<>();
        for(char c : word.toCharArray()) {
            answer.add(mixer(c,Character.isUpperCase(c)));
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
            substitutionChar= lowerCasesTable.charAt(index);
        }
        return substitutionChar;
    }
}
