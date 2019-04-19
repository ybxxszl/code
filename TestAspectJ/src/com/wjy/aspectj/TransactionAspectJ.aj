package com.wjy.aspectj;

public aspect TransactionAspectJ {

    void around():call(void Hello.sayHello()){
        System.out.println("事务开始...");
        proceed();
        System.out.println("事务结束...");
    }

}
