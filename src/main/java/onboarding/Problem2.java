package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        StringBuilder answer=new StringBuilder(cryptogram);

        while(true){ //step 0~?
            int start=0;
            int current=0;
            StringBuilder stepAnswer = new StringBuilder();
            while(true){ //step i
                if(current>=answer.length()-1){
                    break;
                }
                if(answer.charAt(current)==answer.charAt(current+1)){
                    stepAnswer.append(answer.substring(start,current));
                    while(true){
                        if(current<answer.length()-1&&answer.charAt(current)==answer.charAt(current+1)){
                            current+=1;
                        }else{
                            break;
                        }
                    }
                    start=current+1;
                }
                current+=1;
            }
            if(start!=answer.length()){
                stepAnswer.append(answer.substring(start,answer.length()));
            }
            if(answer.toString().equals(stepAnswer.toString())){ // 업데이트가 없다
                break;
            }
            answer=stepAnswer;
        }

        return String.valueOf(answer);
    }
}
