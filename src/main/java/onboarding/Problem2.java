package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int top=-1;
        char[] arr=new char[1000];
        arr[0]=cryptogram.charAt(0);
        top++;
        for(int i=1;i<cryptogram.length();i++) {
            char a = cryptogram.charAt(i);
            if(arr[top]==a){
                top--;
            }else{
                arr[++top]=a;
            }
        }
        for(int i=0;i<=top;i++){
            answer+=arr[i];
        }
        return answer;
    }
}
