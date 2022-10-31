package onboarding.problem2;

public class CryptogramGenerator {
    private Cryptogram cryptogram;

    public CryptogramGenerator(String input){
        this.cryptogram = new Cryptogram(input);
    }
    //1. 생성자, 문자열 받고 Cryptogram 인스턴스 생성


    //2. 크립토그램 변환함수, Cryptogram의 중복 제거 반복호출 후 반환

    public String generate(){
        while(cryptogram.removeDuplicated());
        return cryptogram.getCryptogram();
    }
}
