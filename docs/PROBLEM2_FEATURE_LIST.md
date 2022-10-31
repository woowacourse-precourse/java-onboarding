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
- ~~삭제할 문자열의 인덱스 셋을 반환하는 int[] getDeleteIndexSet(string) 함수~~

TODO
- ~~슈도코드에 맞춰 로직 작성~~
- ~~테스트 성공 확인~~
- ~~리팩터링~~