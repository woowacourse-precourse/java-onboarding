package onboarding;

public class Problem3 {
    // 1. number -> String으로 변경후 3,6,9가 있으면 count로 세기
    public static int solution(int number) {
        String num = "";
        if(constraints(number)) return -1; // 제한사항에 걸렸을경우 -1로 리턴
        int result =0;
        for(int i = 1; i<number+1; i++) {num +=i+"";}//1234567891011121314
            for(int j =0; j<num.length();j++){
                if(num.charAt(j) == '3') result++;
                if(num.charAt(j) == '6') result++;
                if(num.charAt(j) == '9') result++;
            }
       // print(number,result);


        return result;

    }
//    public static  void print(int number, int result) {
//        System.out.println("| number | result |");
//        System.out.println("| --- | --- |");
//        System.out.println("| "+number+" | "+result+" | ");
//
//
//    }
    public static boolean constraints(int number){ // 제한사항
        if(number<1|| number>1000){System.out.println("number가 1미만 혹은 1000초과 입니다."); return false;}
        return true;
    }


}
