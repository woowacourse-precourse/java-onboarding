package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //알파벳을 거꾸로 하기 위해서 미리 a 배열을 선언함
        //A가 들어오면 a[A-'A'] + 'A'
        //즉, a[0] + 'A' = 25 + 'A' = 90 = 'Z'
        //하나 더 예로 들면 a[Z-'A'] + 'A'
        //a[25] + 'A' = 0 + 'A' = 65 = 'A'
        int[] a = {
                25, 24, 23, 22 ,21,
                20, 19, 18, 17, 16,
                15, 14, 13, 12, 11,
                10, 9, 8, 7, 6,
                5, 4, 3, 2, 1, 0
        };
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == ' '){
                answer += ' ';
            } else if(word.charAt(i) >= 'a' && 'z' >= word.charAt(i)){
                answer += (char)(a[word.charAt(i) - 'a'] + 'a');
            }else if(word.charAt(i) >= 'A' && 'Z' >= word.charAt(i)){
                answer += (char)(a[word.charAt(i) - 'A'] + 'A');
            }
        }
        return answer;
    }
}
