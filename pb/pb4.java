import javax.lang.model.util.ElementScanner14;
import java.util.Scanner;

public class pb4 {
    public static void main(String[] args){
    pb4 ra=new pb4();
    Scanner sc = new Scanner(System.in);
	System.out.println("문자열을 입력하시오");
	String scWord = sc.nextLine();
    System.out.println(ra.solution(scWord));

    
    
    
    }

    public String solution(String word)
    {
        String result="";
        char[] wordtemp=word.toCharArray();
        int reverse,abstemp,ascii=0;
        for (int i=0;i<wordtemp.length;i++)
        {
            if (Character.isUpperCase(wordtemp[i]))
            {
                ascii=65;
            }
            else if(Character.isLowerCase(wordtemp[i]))
            {
                ascii=97;
            }
            else{
                result=result + ' ';
                continue;

            }
            abstemp = Math.abs(ascii - wordtemp[i]);
            reverse = (ascii +25 ) -abstemp;
            result = result +String.valueOf((char)reverse);
        }
        return result;
    }
    
}
