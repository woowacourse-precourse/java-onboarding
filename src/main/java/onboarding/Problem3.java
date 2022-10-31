package onboarding;
class NumberString{
    private StringBuilder stringBuilder;
    private String numString;
    private int count;
    private int number;
    NumberString(int number){
        this.number = number;
        this.count = 0;
    }
    public void setNumString(){
        this.stringBuilder = new StringBuilder();
        for(int i=1;i<=this.number;i++){
            this.stringBuilder.append(Integer.toString(i));
        }
        this.numString = this.stringBuilder.toString();
    }
    public int getCount(){
        for(int i=0;i<this.numString.length();i++){
            if(numString.charAt(i)=='3'||
                    numString.charAt(i)=='6'||
                    numString.charAt(i)=='9')
                this.count++;
        }
        return this.count;
    }
}
public class Problem3 {
    public static int solution(int number) {
        NumberString numberString = new NumberString(number);
        numberString.setNumString();
        return numberString.getCount();
    }

}
