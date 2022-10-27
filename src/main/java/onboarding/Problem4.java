package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char chr = word.charAt(i);

            if(chr >= 'a' && chr <= 'z')
                stringBuilder.append(reverseSmall(chr));
            else if(chr >= 'A' && chr <= 'Z')
                stringBuilder.append(reverseBig(chr));
            else
                stringBuilder.append(chr);
        }
        answer = stringBuilder.toString();

        return answer;
    }

    public static char reverseBig(char chr){
        int offset = 'Z' - chr;

        return (char)('A'+offset);
    }

    public static  char reverseSmall(char chr){
        int offset = 'z' - chr;

        return (char)('a'+offset);
    }


}
