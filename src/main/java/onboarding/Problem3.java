package onboarding;
public class Problem3 {
    public static int solution(int number) {
        int clap=0;
        for(int i=1;i<=number;i++){
            String str=i+"";
            for(int j=str.length()-1;j>=0;j--){
                if(str.charAt(j)=='3'||str.charAt(j)=='6'||str.charAt(j)=='9'){
                    clap++;
                }
            }
        }
        System.out.println(clap);
        return clap;
    }
}
