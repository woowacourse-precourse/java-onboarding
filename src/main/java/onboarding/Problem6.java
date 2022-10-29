package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean compareString(String s1, String s2) {
        char[] c1Arr = s1.toCharArray();
        char[] c2Arr = s2.toCharArray();

        for(int c1=0; c1<c1Arr.length-1; c1++){
            StringBuilder c1Double = new StringBuilder();
            c1Double.append(c1Arr[c1]).append(c1Arr[c1+1]);

            for(int c2=0; c2<c2Arr.length-1; c2++) {
                String c1Str = c1Double.toString();
                String c2Str = String.valueOf(c2Arr[c2]) + c1Arr[c2 + 1];
                if(c1Str.equals(c2Str)){
                    return true;
                }
            }
        }
        return  false;
    }
}
