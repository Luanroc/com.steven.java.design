#Java的23种设计模式
- **IDE:** IntelliJ IDEA 15.0.1
- **Server:** Apache Tomcat 9.0.0.1M1
- **DATABASE:** Mysql 5.6.7
- **Author:** Steven Guo

## 一、设计模式的分类

####总体来说设计模式分为三大类：

- 创建型模式(5种)：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

- 结构型模式(7种)：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

- 行为型模式(11种)：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

####其实还有两类：并发型模式和线程池模式。用一个图片来整体描述一下：
![](http://dl.iteye.com/upload/attachment/0083/1179/57a92d42-4d84-3aa9-a8b9-63a0b02c2c36.jpg)

## 二、设计模式的六大原则
+ 1、开闭原则（Open Close Principle）

> 开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。

+ 2、里氏代换原则（Liskov Substitution Principle）

> 里氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。 LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。—— From Baidu 百科

+ 3、依赖倒转原则（Dependence Inversion Principle）

> 这个是开闭原则的基础，具体内容：真对接口编程，依赖于抽象而不依赖于具体。

+ 4、接口隔离原则（Interface Segregation Principle）

> 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。

+ 5、迪米特法则（最少知道原则）（Demeter Principle）

> 为什么叫最少知道原则，就是说：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。

+ 6、合成复用原则（Composite Reuse Principle）

> 原则是尽量使用合成/聚合的方式，而不是使用继承。

## 三、Java的23中设计模式
####从这一块开始，我们详细介绍Java中23种设计模式的概念，应用场景等情况，并结合他们的特点及设计模式的原则进行分析。

### 1、工厂方法模式（Factory Method）
>**工厂方法模式分为三种:**

#### 1.1、普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。首先看下关系图：
![](http://dl.iteye.com/upload/attachment/0083/1180/421a1a3f-6777-3bca-85d7-00fc60c1ae8b.png)

#### 1.2、多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。关系图：
![](http://dl.iteye.com/upload/attachment/0083/1181/84673ccf-ef89-3774-b5cf-6d2523cd03e5.jpg)

#### 1.3、静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。

> 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。

### 2、抽象工厂模式（Abstract Factory）
> 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。因为抽象工厂不太好理解，我们先看看图，然后就和代码，就比较容易理解。

![](http://dl.iteye.com/upload/attachment/0083/1185/34a0f8de-16e0-3cd5-9f69-257fcb2be742.jpg)

### 3、单例模式（Singleton）
单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：

+ 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。

+ 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。

+ 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。

### 4、建造者模式（Builder）
工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的。

### 5、原型模式（Prototype)
原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。本小结会通过对象的复制，进行讲解。在Java中，复制对象是通过clone()实现的

##7种结构型模式 
> 这章开始，我将讲下7种结构型模式：适配器模式、装饰模式、代理模式、外观模式、桥接模式、组合模式、享元模式。其中对象的适配器模式是各种模式的起源，我们看下面的图：

![](http://dl.iteye.com/upload/attachment/0083/1187/e28698b9-994e-3fa8-8810-16f30e7cf3e3.jpg)

### 6、适配器模式（Adapter）
> 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。首先，我们来看看

> 类的适配器模式，先看类图：

![](http://dl.iteye.com/upload/attachment/0083/1189/6b2d13aa-7cc7-3e98-9764-bdcb2c64f795.jpg)

> 对象的适配器模式，看图：

![](http://dl.iteye.com/upload/attachment/0083/1191/0aabe35b-5b79-3ead-838f-9d4b6fbd774d.jpg)

> 接口的适配器模式

![](http://dl.iteye.com/upload/attachment/0083/1193/a604fca8-e0c6-3e4e-b00a-49da21595b4e.jpg)

### 7、装饰模式（Decorator）
> 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例，关系图如下：

![](http://dl.iteye.com/upload/attachment/0083/1195/e1b8b6a3-0150-31ae-8f77-7c3d888b6f80.jpg)

### 8、代理模式（Proxy）
> 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候回去找中介，为什么呢？因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法。先来看看关系图：

![](http://dl.iteye.com/upload/attachment/0083/1197/ea094ad9-efc5-337d-a8e8-ce9223511144.jpg?_=1303842105)



##Git开发规范
+ branch 分支规范：
> master ：主分支，线上部署代码
> 
> test   : 进入测试代码，只有开发完成了才允许合并到此分支
> 
> dev    : 开发分支，处于开发阶段分支
> 
> XXXXXX : 正处于开发的分支，此分支不需提交git
  
+ Tags 标签规范
> 不允许提交本地标签
> 
> 线上版本标签 格式 vN.n.n.yyyyMMddHHmm 例如：v1.0.0.201601201501

+ 代码编写提交规范
> 更新所有分支
> 
> 从dev 分支创建一个新的开发分支
> 
> 在新的分支进行开发，开发完成，更新dev分支，合并当前分支到dev分支，测试无误项目组长将dev合并到test
> 
> 测试拉取test进行测试