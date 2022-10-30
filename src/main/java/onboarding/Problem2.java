package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true){
            boolean Flag=false;
            String pre_str="";
            if(cryptogram.length()>=1){
                pre_str=cryptogram.substring(0,1);
            }

            for(int i=1;i<cryptogram.length();++i){
                if(pre_str.equals(cryptogram.substring(i,i+1))){

                    Flag=true;
                    break;
                }else{
                    pre_str=cryptogram.substring(i,i+1);
                }

            }
            if(Flag==false){

                break;
            }
            String tmp="";
            int idx=0;
            boolean conseq=false;
            int N=cryptogram.length();
            cryptogram+="E";
            while(idx<N){

                if(cryptogram.substring(idx,idx+1).equals(cryptogram.substring(idx+1,idx+2))){
                    ++idx;
                    conseq=true;
                }else{
                    if(conseq==true){
                        conseq=false;
                        ++idx;
                    }else{
                        tmp+=cryptogram.substring(idx,idx+1);
                        ++idx;
                    }

                }
            }
            cryptogram=tmp;

        }
        answer=cryptogram;
        return answer;
    }
//     public static void main(String[] args){
//        System.out.println(solution("zyelleyz"));
//     }
}
