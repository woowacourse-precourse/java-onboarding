package onboarding;

public class Problem2 {
    // 문자열에서 인접한 중복 문자를 제거하는 함수
    public static String removeDuplicates(String s)
    {
        // 기본 케이스
        char[] chars = s.toCharArray();
        if (chars.length==0 || (chars.length==2 && chars[0]==chars[1])){
            return "";
        }
        int i, k = 0;

        for (i=1; i<chars.length; i++)
        {
            if (chars[i-1]!=chars[i]){
                chars[k++]=chars[i-1];
            }
            else {
                while (i<chars.length && chars[i-1]==chars[i]){
                    i++;
                }
            }
        }
        if (i<=chars.length) {chars[k++] = chars[i-1];};
        String new_s = new String(chars).substring(0, k);
        if (k!=chars.length){
            return removeDuplicates(new_s);
        }
        System.out.println(new_s);
        return new_s;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer=removeDuplicates(cryptogram);
        return answer;
    }
}