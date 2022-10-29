package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer="";
        char convert_str[]=word.toCharArray();
        int dist=0;
        for(char c : convert_str){
            if(Character.isLowerCase(c)) {
                dist = 'z' - c;
                answer += (char)('a' + dist);
            }
            else if(Character.isUpperCase(c)) {
                dist = 'Z' - c;
                answer += (char)('A' + dist);
            }
            else
                answer += c;

        }




        return answer;
    }
}
