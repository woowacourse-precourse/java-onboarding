package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteOverLap(cryptogram);
        return answer;
    }
    public static String deleteOverLap(String s){
        String ans ="";
        ans +=s.charAt(0);
        int ansLength =1;
        for(int i=1;i<s.length();i++){
            if(ans.charAt(ansLength-1) !=s.charAt(i)){
                ans +=s.charAt(i);
                ansLength++;
            }
            else{
                i =returnNextIndex(s,i);
                ans = ans.substring(0,ansLength-1);
                ansLength -= 1;
            }
        }
        return ans;
    }
    public static int returnNextIndex(String s,int startIndex){
        while(startIndex <s.length()-1){
            if(s.charAt(startIndex) == s.charAt(startIndex+1)){
                startIndex++;
            }
            else{
                break;
            }
        }
        return startIndex;
    }
}
