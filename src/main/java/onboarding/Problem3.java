package onboarding;

public class Problem3 {
    public static int solution(int number) {

        Calculator<Integer, Integer> calculator =
                new ThreeSixNineCalculator();
        calculator.setVariable(number);

        return calculator.calculation();
    }

    public enum ThreeSixNine{
        THREE('3'), SIX('6'), NINE('9');

        private char number;

        ThreeSixNine(char number){
            this.number = number;
        }

        public char getNumber() {
            return number;
        }
    }

    public static class ThreeSixNineCalculator implements Calculator<Integer, Integer>{
        int number;

        @Override
        public void setVariable(Integer number) {
            this.number = number;
        }

        @Override
        public Integer calculation(){
            int result = 0;
            for(int i=1; i<number+1; i++){
                result += countTsn(i);
            }
            return result;
        }

        public int countTsn(int num){
            int cnt = 0;
            char[] numChar = String.valueOf(num).toCharArray();
            for(ThreeSixNine tsn : ThreeSixNine.values()){
                cnt += isContain(numChar, tsn);
            }
            return cnt;
        }

        public int isContain(char[] num, ThreeSixNine tsn){
            int cnt = 0;
            for(int i=0; i<num.length; i++){
                if(num[i] == tsn.getNumber()) cnt++;
            }
            return cnt;
        }
    }
}
