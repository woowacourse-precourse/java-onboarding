package ExceptionValidation;

//- 입력이 1~10000 인지 판단
//- 아닐때는 0 반환

public class P3ExceptionValidation {

    public static boolean p3ExceptionValidation(int number){

        return inputBetween1and10000(number);
    }


    private static boolean inputBetween1and10000(int number) {
        if (number < 1 || number > 10000) {
            return false;
        }
        return true;
    }

}
