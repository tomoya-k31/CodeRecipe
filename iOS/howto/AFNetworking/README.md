## Build Configurationに「Beta」を追加

Podfileに以下を追加して、`$ pod install`
```
xcodeproj "AFNetworking.xcodeproj", {'Beta' => :debug}
```


Project -> [info]/Configuration -> [+]
* select [ Duplicate "Debug" configuraion ] -> rename [ Beta ]

Project -> [Build Setting]/Apple LLVM 5.1 - Preprocessing -> Add [ BETA=1 ]to Beta

```
#ifdef BETA
    // BETA
#endif


#if defined(DEBUG) || defined(BETA)
	// DEBUG or BETA
#else
	// RELEASE
#endif


#if defined(DEBUG)
	// DEBUG
#elif defined(BETA)
	// BETA
#else
	// RELEASE
#endif
```