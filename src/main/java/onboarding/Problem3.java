package onboarding;

public class Problem3 {
    public char[] intToCharArray(int n){
        String str = Integer.toString(n);
        int len = str.length();
        char[] arr = new char[len];
        for(int i=0;i<len;i++) arr[i] = str.charAt(i);
        return arr;
    }
    public static int solution(int number) {
        Problem3 p = new Problem3();
        int answer = 0;

        for(int i=1;i<=number;i++){
            char[] arr= p.intToCharArray(i);
            for(char c:arr){
                if(c=='3' || c=='6' || c=='9') answer++;
            }
        }
        return answer;
    }
}
