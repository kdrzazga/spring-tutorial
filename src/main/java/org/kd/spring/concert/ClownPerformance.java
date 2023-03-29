package org.kd.spring.concert;

public class ClownPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("HA! HA! (executing Performance.perform()");
    }
}
