## 슈도 코드

```
problem3(int number){
    clap = 0;
    for(int i=1;i<=number;i++){
        clap += getClapsByNumber(i);
    }
    return clap;
}
```

## 기능 요구 사항
- ~~규칙에 따라 해당 숫자에서 박수치는 횟수를 구해주는 int getClapsByNumber(int) 함수~~

TODO
- ~~슈도코드에 맞게 로직 구현~~
- ~~테스트 확인하기~~
- 리팩터링
1. ~~박수쳐야 하는 함수인지를 판단하는 로직 bool isClapNumber(char) 함수화~~
2. ~~상수 static final 화~~
3. ~~리네임~~