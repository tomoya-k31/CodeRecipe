## Build Configurationに「Beta」を追加

Podfileに以下を追加して、`$ pod install`
```
xcodeproj "AFNetworking.xcodeproj", {'Beta' => :debug}
```


Project -> [info]/Configuration -> [+]
* select [ Duplicate "Debug" configuraion ] -> rename [ Beta ]

Project -> [Build Setting]/Apple LLVM 5.1 - Preprocessing -> Add [ BETA=1 ]to Beta