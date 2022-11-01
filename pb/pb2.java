import java.util.*;

public class pb2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("암호를 입력하시오");
        String code=sc.next();
        int size=code.length();
        String[] arr = code.split("");
        ArrayList newArr = new ArrayList();
        System.out.println(Arrays.toString(arr));
        System.out.println(size);
        for(int i=1;i<size;i++)
        {
            if(i>=2)
            {
                if(arr[i-2]==arr[i-1])
                {
                    continue;  
                }
                else {
                    if(arr[i]!=arr[i-1])
                    {   
                        
                        
                        if(i==size-1)
                        {
                            newArr.add(arr[i]);
                        }
                        else
                        {
                            newArr.add(arr[i-1]);
                        } 
                    }    
                    
                    else
                    {
                        continue;
                    }
                }   
            }
            else
            {
                if(arr[i]!=arr[i-1])
                    {   
                           newArr.add(arr[i-1]);
                         
                    }    
                    
                else
                {
                    *continue;
                }
            }
        
        }
    
        System.out.println(newArr);
    }
}