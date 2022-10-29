package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = find369Count(number);
        return answer;
    }

    // 숫자를 메모리를 사용해야 하는지
    // 아니면 계산으로 해야하는지

    //계산으로 했을 시
    //갯수를 세는 변수 하나 있고
    //숫자를 받으면 그 숫자에 3,6,9를 세는 기능

    public static int find369Count(int number){
        int sol=0;
        int[] list = new int[10001];
        for(int i=1; i<number+1; i++){
            if(i<10){
                if(i==3 || i==6 || i==9){
                    list[i]=1;
                }
            }else{
                String string = Integer.toString(i);
                char c =  string.charAt(0);
                int i1 = list[Integer.valueOf(string.substring(1))];
                if(c=='3' || c=='6' || c=='9'){
                    list[i]=i1+1;
                }else{
                    list[i]=i1;
                }
            }
            sol+=list[i];
        }
        return sol;
    }
}
