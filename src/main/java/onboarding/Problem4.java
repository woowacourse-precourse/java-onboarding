package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<word.length(); i++){ // 문자 하나씩 도는 for문
            char chr = word.charAt(i);

            // 스스로하는 피드백 : 중괄호 없애지 말기
            if(Character.isLowerCase(chr))  // 소문자일 경우
                stringBuilder.append(reverseSmall(chr));
            else if(Character.isUpperCase(chr)) // 대문자일 경우
                stringBuilder.append(reverseBig(chr));
            else                                // 그 외
                stringBuilder.append(chr);
        }
        answer = stringBuilder.toString();

        return answer;
    }

    public static char reverseBig(char chr){
        int offset = 'Z' - chr; // Z와의 offset 값을 구해서 A에다가 더해줌

        return (char)('A'+offset);
    }

    public static  char reverseSmall(char chr){
        int offset = 'z' - chr;

        return (char)('a'+offset);
    }


}
