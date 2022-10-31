## 슈도 코드

```
problem7(string user, list<list<string>> friends, list<string> visitors){
    ans = [];
    allUserSet = getAllUserSet();
    friendGraph = makeFriendGraph();
    myFriendList = graph[user];
    scoreMap = getScoreMap();
    scoreInfos = getScoreInfos();
    // sort by nickname alphabetic
    sort(scoreInfos);
    int count = 0;
    for(scoreInfo in scoreInfos){
        if(scoreInfo.name in myFriends){
            continue;
        }
        if(count < 5){
            answer.add(scoreInfo.name);
            count++;
        }
        else break;
    }
    return ans;
}
```

## 기능 요구 사항

- ~~모든 유저 이름을 반환하는 Set<String> getAllUserSet() 함수~~
- ~~해당 유저의 친구 정보를 리스트로 갖고 있는 Map<String, List<String>> makeFriendGraph() 함수~~
- ~~각 user에 대한 점수를 갖고 있는 Map<String, Integer> getScoreMap() 함수~~
- ~~모든 ScoreInfo를 가져오는 List<ScoreInfo> getScoreInfo() 함수~~
- ~~scoreInfos 정렬 후 최대 5개의 유저 이름을 가져오는 로직~~

## TODO

- ~~score, name을 갖고 있는 내부 클래스 ScoreInfo 개발~~
- ~~ScoreInfo 사용자 정의 정렬 구현~~
- ~~로직 완성 & 테스트~~