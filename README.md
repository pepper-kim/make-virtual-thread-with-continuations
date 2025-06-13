## make-virtual-thread-with-continuations
Continuation을 이용해서 직접 Virtual thread를 만들어보세요. empty-version을 이용해서 complete-version을 만들 수 있습니다. Cursor와 함께라면 어렵지 않습니다.

## Prerequisites
- JDK 24 혹은 그 이상의 버전
- 아래 VM 옵션과 함께 컴파일 및 실행을 해야 함. `--enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED`


## Cursor 설정
### .vscode/launch.json 설정
```
{
  "version": "0.2.0",
  "defaults": {
    "java": {
      "vmArgs": "--enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED",
      "console": "integratedTerminal",
      "projectName": "Continuations"
    }
  }
}
```

### .vscode/setting.json 설정
```
{
  "java.configuration.updateBuildConfiguration": "interactive",
  "java.debug.settings.vmArgs": "--enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED"
}
```

## 참고 자료
- https://guruma.github.io/posts/2018-11-18-Continuation-Concept/
- https://techblog.lycorp.co.jp/ko/about-java-virtual-thread-2
- [채널 발표 자료](https://www.notion.so/channelio/20f74b55ec7c8010b333ed54ee055ad3?source=copy_link)
- https://www.youtube.com/watch?v=pwLtYvRK334&t=2994s