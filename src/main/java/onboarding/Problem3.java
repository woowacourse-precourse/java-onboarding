package onboarding;

public class Problem3 {
    public static int countThree(String str){
        int l=str.length();
        int count=0;
        for(int i=0; i<l; i++){
            if(str.charAt(i)=='3'){
                count++;
            }
            if(str.charAt(i)=='6'){
                count++;
            }
            if(str.charAt(i)=='9'){
                count++;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            answer+=countThree(new Integer(i).toString());
        }

        return answer;
    }
}
