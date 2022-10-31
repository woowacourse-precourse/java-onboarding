package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char chr = word.charAt(i);

            if(Character.isLowerCase(chr))
                stringBuilder.append(reverseSmall(chr));
            else if(Character.isUpperCase(chr))
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
