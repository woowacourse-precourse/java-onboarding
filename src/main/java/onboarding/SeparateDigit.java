package onboarding;

import java.util.List;

public class SeparateDigit {
    int[] separatedNumber;
    int size;

    static final int MAXPAGE = 400;
    static final int MINPAGE = 1;
    public SeparateDigit(List<Integer> bookPage){
        digitSeparating(bookPage);
    }
    public void digitSeparating(List<Integer> bookPage) {
        String stringNumber = bookPage.toString().replaceAll("[^0-9]","");
        size=stringNumber.length();
        separatedNumber = new int[size];
        for(int i=0; i<size; i++){
            separatedNumber[i] = (int)stringNumber.charAt(i) - '0';
        }
    }
    public static boolean isWrongPage(List<Integer> bookPage) {
        int firstPage = bookPage.get(0);
        if(firstPage<MINPAGE||firstPage>MAXPAGE
        || firstPage%2 == 0
        || firstPage - bookPage.get(1) != -1){
            return true;
        }
        return false;
    }
    public int score(){
        int sum = sumSeparatedNumber();
        int mul = multiplySeparatedNumber();
        return biggerInt(sum, mul);
    }
    public int sumSeparatedNumber(){
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += separatedNumber[i];
        }
        return sum;
    }
    public int multiplySeparatedNumber(){
        int mul=1;
        for(int i=0; i<size; i++){
            mul *= separatedNumber[i];
        }
        return mul;
    }
    public int biggerInt(int number1, int number2){
        if(number1>number2){
            return number1;
        }
        return number2;
    }
}
