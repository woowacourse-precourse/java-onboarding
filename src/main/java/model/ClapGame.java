package model;

public class ClapGame {
    // 초기 설정 숫자
    private final int settingNum;
    // 박수 횟수
    private int clapNumber;

    public ClapGame(int number){
        this.settingNum = number;
        this.clapNumber = 0;
    }

    // 369게임 시작
    public void start(){
        for (int i = 1; i <= this.settingNum; i++){
            decomposed(i);
        }
    }

    // 숫자를 각자리수로 분해하는 매소드
    void decomposed(int decomposedNum){
        while (decomposedNum > 0) {
            clap(decomposedNum % 10);
            decomposedNum /= 10;
        }
    }

    // 369 유무 확인후 박수 횟수 증가
    void clap(int eachDigit){
        if(eachDigit == 3 || eachDigit == 6 || eachDigit == 9)
            this.clapNumber++;
    }

    public int getClapNumber(){
        return this.clapNumber;
    }
}
