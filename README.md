
# 实现
## 配置中心
- [x] Config-Server
- [x] Config-Client
- [x] Config-Client/refresh
- [x] Config-Server/bus/refresh

## 服务治理
- [x] Eureka
- [x] Feign
- [x] Ribbon
- [x] Hystrix
- [x] Hystrix.Turbine
- [] Zuul
- [] 


## 分页式链路监控
- [] Sleuth
- [] Zipkin
- [] 

## 消息组件
- [] Bus

## 安全控制
- [] Security

## 补充
- [] Cluster
- [] Data.Flow
- [] CLI
- [] Task



# IP分配

|   模块   |                服务                |   IP 段   |
|----------|------------------------------------|-----------|
| 配置中心 |                                    |           |
|          | Config-Server                      | 10086     |
| 服务治理 |                                    |           |
|          | Eureka                             | 10000     |
| 业务模块 |                                    |           |
|          | Portal                             | 8100/8199 |
|          | Sns                                | 8200/8299 |
|          | Other                              | 8300/8499 |
|          | &nbsp; &nbsp; &nbsp; &nbsp;Hystrix | 8301      |
| 消息组件 |                                    |           |
|          | Zoopkeeper                         | 7100      |
|          | Kafka                              | 7101      |
|          | MQ.active                          | 7201      |
|          | MQ.Rabbit                          | 7202      |