## 灰度组件

组件使用者要设置一个key值，唯一标识要灰度的功能，根据自己业务的特点，选择一个灰度对象（如用户ID），
在配置文件或配置中心，配置这个key对应的灰度规则和功能开关。
```
features:
- key: call_newapi_getUserById
  enabled: true //enabled为true时，rule生效
  rule: {893,342,1020-1120,%30} //按照用户ID做灰度
- key: call_newapi_registerUser
  enabled: true
  rule: {1391198723, %10} //按照手机号来做灰度
- key: newalgo_loan
  enabled: true
  rule: {0-1000} //按照贷款的金额做灰度
```