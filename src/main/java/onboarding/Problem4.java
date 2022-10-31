package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	StringBuilder sb = new StringBuilder();

        int upper_case = 'A' + 'Z';
        int lower_case = 'a' + 'z';
        for(var e: word.toCharArray())
        {
            if(e >= 'a' && e <= 'z') { sb.append((char)(lower_case - e )); continue; }
            if(e >= 'A' && e <= 'Z') { sb.append((char)(upper_case - e )); continue; }
            sb.append(e);
        }

        return sb.toString();
    }
}
