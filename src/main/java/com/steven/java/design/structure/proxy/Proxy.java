package com.steven.java.design.structure.proxy;

/**
 * @author Guo shijie
 * @Description
 * @Package com.steven.java.design.structure.proxy
 * @date 16/9/18 上午10:49
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }

}
