import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class pb1 
{
    public static void main(String[] args)throws IOException 
    {
        Random random = new Random();
        ArrayList phobi = new ArrayList();
        int a=random.nextInt(400); //포비 임의페이지 번호        
        if(a%2==0)
        {
            
            int b=a-1;//포비 왼쪽페이지 번호
            phobi.add(0, b);
            phobi.add(1, a);
        }
        else{
            int b=a+1;//포비 오른쪽페이지 번호
            phobi.add(0, a);
            phobi.add(1, b);
        }
        int phobiNum;
        int e=(int)phobi.get(0);
        int f=(int)phobi.get(1);
        int plusPe=(e/100)+(e%100)/10+(e%10);
        int plusPf=(f/100)+(f%100)/10+(f%10);        
        int multiPe=(e/100)*((e%100)/10)*(e%10);
        int multiPf=(f/100)*((f%100)/10)*(f%10);
        ArrayList maxPhobi = new ArrayList();
        maxPhobi.add(plusPe);
        maxPhobi.add(plusPf);
        maxPhobi.add(multiPe);
        maxPhobi.add(multiPe);
        phobiNum=(int)Collections.max(maxPhobi);
    
      

        int c=random.nextInt(400); //크롱  임의페이지 번호
        ArrayList crong = new ArrayList();
        if(c%2==0)
        {
            
            int d=c-1;//크롱 왼쪽페이지 번호
            crong.add(0, d);
            crong.add(1, c);
        }
        else{
            int d=c+1;//포비 오른쪽페이지 번호
            crong.add(0, c);
            crong.add(1, d);
        }
        int crongNum;
        int h=(int)crong.get(0);
        int i=(int)crong.get(1);
        int plusPh=(h/100)+(h%100)/10+(h%10);
        int plusPi=(i/100)+(i%100)/10+(i%10);        
        int multiPh=(h/100)*((h%100)/10)*(h%10);
        int multiPi=(i/100)*((i%100)/10)*(i%10);
        ArrayList maxCrong = new ArrayList();
        maxCrong.add(plusPh);
        maxCrong.add(plusPi);
        maxCrong.add(multiPh);
        maxCrong.add(multiPi);
        crongNum=(int)Collections.max(maxCrong);
        

        if(crongNum<phobiNum)
        {
            int result=1;
            System.out.printf("result "+result+"\n");
            System.out.printf("crong "+crong+"\n");
            System.out.printf("phobi "+phobi+"\n");
        }
        else if(crongNum>phobiNum)
        {
            int result=2;
            System.out.printf("result "+result+"\n");
            System.out.printf("crong "+crong+"\n");
            System.out.printf("phobi "+phobi+"\n");
        }
        else
        {
            int result=-1;
            System.out.printf("result "+result+"\n");
            System.out.printf("crong "+crong+"\n");
            System.out.printf("phobi "+phobi+"\n");
        }
        
    }
}

