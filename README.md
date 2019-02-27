# redis_cluster
读写分离

https://www.cnblogs.com/chen1-kerr/p/7069735.html

https://www.cnblogs.com/jerrylz/p/5650213.html

https://my.oschina.net/u/2600078/blog/1923696

1.注释掉 bind      2. protected-mode no

关闭防火墙

启动集群的时候 ./redis-trib.rb create --replicas 1 10.31.8.220:7000 10.31.8.220:7001 10.31.8.220:7002 10.31.8.220:7003 10.31.8.220:7004 10.31.8.220:7005
需要用ip启动 用127.0.0.1 会到致程序访问的时候 ，集群返回ip是都是127.0.0.1，访问找不到服务
