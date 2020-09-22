package com.zhangshuaibiao.demo.test.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author zhangsb29016
 * @create 2020/9/22 13:58
 * @desc
 */
public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        //1.下面两句装载配置文件并启动容器
        Resource res = new ClassPathResource("/resources/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);

        //2 向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //3 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        //4 第一次从容器中获取car,将出发容器实例化该Bean,这将引发Bean生命周期方法的调用
        Car car1 = (Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("red");
        //5 第二次从容器中获取car,直接从缓存池中获取
        Car car2 = (Car)bf.getBean("car");
        //6 查看car1和car2是否指向同一个引用
        System.out.println("car1==car2"+(car1 == car2));
        //7 关闭容器
        ((XmlBeanFactory)bf).destroySingletons();

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
