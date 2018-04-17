# springcloud-first
springcloud  springboot  eureka  rest+ribbon  feign

spring cloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。它运行环境简单，可以在开发人员的电脑上跑。


Eureka服务发现与注册中心：
    1.Eureka 是 Netflix 开发的服务发现框架，SpringCloud 将它集成在自己的子项目 spring-cloud-netflix 中，实现 SpringCloud 的服务发现功能。
为什么要使用 Eureka，因为在一个完整的系统架构中，任何单点的服务都不能保证不会中断，因此我们需要服务发现机制，在某个节点中断后，其它的节点能够继续提供服务，从而保证整个系统是高可用的。
    2.服务发现有两种模式：一种是客户端发现模式，一种是服务端发现模式。Erueka 采用的是客户端发现模式。
    3.Eureka Server 会提供服务注册服务，各个服务节点启动后，会在 Eureka Server 中进行注册，这样 Eureka Server 中就有了所有服务节点的信息，并且 Eureka 有监控页面，可以在页面中直观的看到所有注册的服务的情况。同时 Eureka 有心跳机制，当某个节点服务在规定时间内没有发送心跳信号时，Eureka 会从服务注册表中把这个服务节点移除。Eureka 还提供了客户端缓存的机制，即使所有的 Eureka Server 都挂掉，客户端仍可以利用缓存中的信息调用服务节点的服务。Eureka 一般配合 Ribbon 进行使用，Ribbon 提供了客户端负载均衡的功能，Ribbon 利用从 Eureka 中读取到的服务信息，在调用服务节点提供的服务时，会合理的进行负载。
        Eureka 通过心跳检测、健康检查、客户端缓存等机制，保证了系统具有高可用和灵活性。
    4.eureka 是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（因此可以在内存中完成），在默认情况下 erureka server 也是一个 eureka client。通过 eureka.client.register-with-eureka：false 和 eureka.client.fetch-registry：false 来表明自己是一个 eureka server

    
在服务架构中，业务都会被拆分成一个个独立的服务，服务与服务的通讯是基于 http restful 的。springcloud 有两种调用方式，一种是 ribbon+restTemplate，另一种是 feign
    1.ribbon 是一个负载均衡客户端，可以很好的控制 http 和 tcp 的一些行为。Feign 也用到 ribbon，当你使用 @ FeignClient，ribbon 自动被应用。

    2.Feign 是一个声明式的 web 服务客户端，它使得写 web 服务变得更简单。使用 Feign, 只需要创建一个接口并注解。它具有可插拔的注解特性，包括 Feign 注解和 JAX-RS 注解。Feign 同时支持可插拔的编码器和解码器。spring cloud 对 Spring mvc 添加了支持，同时在 spring web 中次用相同的 HttpMessageConverter。当我们使用 feign 的时候，spring cloud 整和了 Ribbon 和 eureka 去提供负载均衡。
    简而言之：
        feign 采用的是接口加注解
        feign 整合了 ribbon





_______________________________________Git使用遇到的问题_______________________________________
git合并分支或者push时，报错：“Please enter a commit message to explain why this merge is necessary,especi”的解决办法

问题：
1.我们在用git管理版本控制时，有时候会遇到git合并分支或者push时，会报错：
2.`Please enter a commit message to explain why this merge is necessary,
  especially if it merges an updated upstream into a topic branch。`
  
解决办法 ：
方法一： 
1、直接关闭当前窗口，再重新打开新的窗口； 
2、接着就可以继续操作；但个人觉得这个方法不是办法中的办法，迫不得已，太麻烦了。（个人不建议）

方法二： 
1、当出现上述情况，可按键盘左上角的“Ese”退出键； 
2、输入“：wq”，注意是英文输入状态下的冒号，然后按下“Enter”键即可。（个人觉得这个方法好， “ :wq”是啥意思呢？？？学Linux操作系统时的命令： 强制性写入文件并退出。）
