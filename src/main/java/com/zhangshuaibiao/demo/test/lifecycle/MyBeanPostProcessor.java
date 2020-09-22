package com.zhangshuaibiao.demo.test.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zhangsb29016
 * @create 2020/9/22 13:13
 * @desc BeanPostProcessor实现类，在该类中，我们只对
 * car Bean进行处理，对配置文件所提供的属性设置值进行判断，
 * 并执行相应的“补缺补漏”的操作：
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("调用BeanPostProcessor.postProcessorBeforeInitialization()," +
                        "color为空，设置为默认黑色");
                car.setColor("black");
            }

        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor.postProcessorAfterInitialization");
                car.setMaxSpeed(200);
            }

        }
        return bean;
    }

}
