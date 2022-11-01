package onboarding.problem3;

public class Controller {

    // 규칙 기능 : 입력 받은 수가 지정된 규칙에 적합한 수 반환
    public static int getCount(int i){
        int count = 0;

        int digitOne = i % 10;
        int digitTen = i / 10;

//        if (i==33 || i==66 || i==99) { count += 2; break;} break 빨간줄
        if(digitOne == 3 || digitOne == 6 || digitOne == 9){    count += 1;    } // 1의 자리 3,6,9 규칙
        if(digitTen == 3 || digitTen == 6 || digitTen == 9) {   count += 1;    } // 10의 자리 규칙

        return count;
    }
}
