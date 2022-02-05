## security的验证步骤
1. 请求获取token 
```shell
http://localhost:8080/oauth/authorize?client_id=client&response_type=code&redirect_url=http://www.baidu.com
```
2. 通过上面获取的token 去置换 access_teken , **curl**命令如下
```shell
curl --location --request POST 'http://localhost:8080/oauth/token' \
--header 'Authorization: Basic Y2xpZW50OjEyMzQ1Ng==' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=C64E9C09226C624483AFAC4329ED3B6C' \
--data-urlencode 'grant_type=authorization_code' \
--data-urlencode 'client_id=client' \
--data-urlencode 'code=9E0g3e' \
--data-urlencode 'redirect_uri=http://www.baidu.com' \
--data-urlencode 'scope=all'
```
3. 通过accesstoken去获取用户进本信息
```shell
curl --location --request POST 'localhost:8080/user/getCurrentUser' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDQwNzg1MDQsInVzZXJfbmFtZSI6ImFkbWluIiwianRpIjoiY2U3YjViZTktZmY3OS00YThiLTgyNDAtMDU3NzQzN2QyMTYxIiwiY2xpZW50X2lkIjoiY2xpZW50Iiwic2NvcGUiOlsiYWxsIl19.kJtSXwu1qZ0a6FerZ8T_AqDnyfeHbygeXGTtquhagGw' \
--header 'Cookie: JSESSIONID=C64E9C09226C624483AFAC4329ED3B6C'
```

## sso 登录配置如下
```shell
http://localhost:8081/user/getCurrentUser
```
跳转至oauth的服务器进行授权认证
> 认证服务器需要配置自动认证授权否则，会通过中间页面进行授权的步骤

> 认证服务器需要配置 sso的自动认证，否则无法sso的登录
```shell 
AuthorizationServerConfig中需要配置
com.laosan.config.AuthorizationServerConfig.configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer)
//获取秘钥必须要身份认证,单点登录必须要配置的配置项
        security.tokenKeyAccess("isAuthenticated()");
```
