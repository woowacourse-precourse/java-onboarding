## 슈도 코드

```
problem2(cryptogram){
    deleteIndexList = []
    answer = cryptogram        
    do{
        bool valid[] = new bool[cryptogram.size()]
        for(int i in cryptogram.size()){
            valid[i] = true;
        }
        for(int i in list){
            valid[i] = false;
        }
        save = answer;
        answer = "";
        for(int i in save.size()){
            if(valid[i]){
                answer += save[i];
            }
        }
    }while(deleteIndexList = getDeleteIndexList(answer) not empty);
    
    return answer;
}
```

## 기능 요구 사항
- 삭제할 문자열의 인덱스 리스트를 반환하는 int[] getDeleteIndexList(string) 함수

TODO
- 