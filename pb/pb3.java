import java.util.Scanner;
public class pb3 {
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 10000사이의 정수를 입력하세요.");
		String num = sc.next();
		int length = num.length();// 길이
		int temp = 0;
		int answer=0;
		int number = Integer.parseInt(num);// 입력변수 int형변환
		int numberCount= Integer.parseInt(num);
		for (int i=number;i>0;i--)
        {   numberCount=numberCount-1;
            while (length > 0) 
            {//length가 마이너스가 되면 그만함
                if (length == 1) 
                {
                    temp = number % 10;
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer=answer+1;
                    }
                    length--;
                    
                    
                } 
                else 
                {
                    temp = (int) (number / (Math.pow(10, length-1)));
                    
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer=answer+1;
                    }
                    number = (int) (number - (temp * (Math.pow(10, length-1))));
                
                    length--;

                    
                }
            }
            number=numberCount;           
            num=Integer.toString(number);           
            length=num.length();
            answer=answer;
            //System.out.println(answer);
            // System.out.println(number);
        
            // System.out.println(numberCount);
        
        }
        
        System.out.println(answer);
            

		}
		
		
		
	}


