package ExceptionValidation;

//- 입력이 1~1000000 인지 판단
//- 위의 범위가 아닐때는 [0,0,0,0,0,0,0,0,0] 을 반환

public class P5ExceptionValidation {

    public static boolean p5ExceptionValidation(int money){

        return inputBetween1and1000000(money);
    }


    private static boolean inputBetween1and1000000(int money) {
        if (money < 1 || money > 1000000) {
            return false;
        }
        return true;
    }

}
