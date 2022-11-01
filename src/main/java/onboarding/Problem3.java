package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer ;
        int count=0;
        for(int i=1;i<number+1;i++){
            String numstr = Integer.toString(i);
            for(int j=0; j<numstr.length(); j++) {
                int temp_num=Integer.parseInt(numstr.substring(j, j + 1));
                if(temp_num==3||temp_num==6||temp_num==9){
                    count++;
                }
            }
        }

       answer=count;
        return answer;
    }
}
