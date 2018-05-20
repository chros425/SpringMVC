# SpringMVC
## SpringMVC框架
- SpringMVC是Spring的一个模块，提供web层解决方案(基于mvc设计架构)

![](./_image/2018-05-20-18-17-14.jpg)
### MVC在B/S系统的应用
- MVC是一个设计模式，在B/S系统的应用

![](./_image/2018-05-20-18-19-00.jpg)
### SpringMVC的框架

![](./_image/2018-05-20-18-20-00.jpg)
1. 用户发起request请求，请求至DispatcherServlet前端控制器
2. DispatcherServlet前端控制器请求HandlerMapping处理器映射器查找Handler
    - DispatcherServlet:前端控制器，相当于中央调度器，各个组件都和前端控制器进行交互，降低了各个组件之间的耦合度
3. HandlerMapping处理器映射器，根据url及一些配置规则(xml配置、注解配置)查找Handler，将Handler返回给DispatcherServlet前端控制器
4. DispatcherServlet前端控制器调用适配器执行Handler，有了适配器，通过适配器去扩展对不同Handler执行方式(比如原始servlet开发，注解开发)
5. 适配器执行Handler
    - Handler是后端控制器
6. Handler执行完成返回ModelAndView
    - ModelAndView:SpringMVC的一个对象，对model和view进行封装
7. 适配器将ModelAndView返回给DispatcherServlet
8. DispatcherServlet调用视图解析器进行视图解析，解析后生成view，视图解析器根据逻辑视图名解析出真正的视图。
    - View:SpringMVC视图封装对象，提供了很多view，jsp、freemarker、pdf
9. ViewResolver视图解析器给前端控制器返回view
10. DispatcherServlet调用view的渲染视图的方法，将模型数据填充到request域。
11. DispatcherServlet向用户响应结果(jsp页面、json数据)

- DispatcherServlet:前端控制器，由SpringMVC提供
- HandlerMapping:处理器映射器，由SpringMVC提供
- HandlerAdapter:处理器适配器，由SpringMVC提供
- **Handler:处理器，需要程序员编写**
- ViewResolver:视图解析器，由SpringMVC提供
- **View:真正视图页面需要由程序员编写**
## 入门程序
### 需求
- 实现商品列表查询
### 需要的jar包
