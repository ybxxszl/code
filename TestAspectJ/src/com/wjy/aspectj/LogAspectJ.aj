package com.wjy.aspectj;

public aspect LogAspectJ {

    pointcut logPointcut() 
    :execution(void Hello.sayHello());

    after():logPointcut() {
        System.out.println("日志记录...");
    }

}
