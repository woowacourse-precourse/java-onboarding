package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int a = Integer.valueOf('a');
        int z = Integer.valueOf('z');
        int sum = a+z;

        String answer = "";

        for (int i=0; i<word.length(); i++){
            if (word.valueOf(word.charAt(i)).isBlank()){
                answer+=" ";
            }else{
                char character = word.charAt(i);
                if (Character.isUpperCase(character)) {
                    int chartonum = (int)Character.toLowerCase(character);
                    char c = (char) (sum-chartonum);
                    answer+=Character.toUpperCase(c);
                } else {
                    int chartonum = (int) character;
                    char c = (char) (sum-chartonum);
                    answer+=c;
                }
            }
        }
        return answer;
    }
}
