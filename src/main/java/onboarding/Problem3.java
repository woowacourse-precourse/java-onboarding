package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int clap = 0;

        validateCase(number);

        for(int i=1 ; i <= number ; i++){
            String stringNumber = Integer.valueOf(i).toString();
            System.out.println(stringNumber);
            if( stringNumber.contains("3") || stringNumber.contains("6") || stringNumber.contains("9") ){
                String[] splits = stringNumber.split("");

                for( String split : splits ){
                    System.out.println("split : " + split);
                    if( split.equals("3") || split.equals("6") || split.equals("9") ){
                        clap++;
                    }
                    System.out.println(" : " + clap);
                }
            }
        }
        return clap;
    }

    public static void validateCase(int number){
        if(number < 1 || number > 10000) throw new RuntimeException("숫자의 범위가 적합하지 않습니다.");
    }
}
