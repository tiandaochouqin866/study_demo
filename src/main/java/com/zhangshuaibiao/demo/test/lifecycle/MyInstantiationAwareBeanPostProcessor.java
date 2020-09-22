package com.zhangshuaibiao.demo.test.lifecycle;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author zhangsb29016
 * @create 2020/9/21 19:37
 * @desc MyInstantiationAwareBeanPostProcessor通过扩展InstantiationAwareBeanPostProcessor适配器
 * InstantiationAwareBeanPostProcessAdapter提供实现
 *
 * 在此类中，我们通过过滤条件仅对car Bean进行处理，而对其他的Bean一概视不可见
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /**
     * 1 接口方法，在实例Bean前进行调用
     *
     * @param beanClass
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) {
        //1-1 仅对容器中Car-Bean进行处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    /**
     * 2 接口方法：在实例化Bean后调用
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        //2-1 仅对容器中car Bean进行处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcess.postProcessAfterInstantiation");
        }
        return true;
    }

    /**
     * 3 接口方法：在设置某个属性时调用
     *
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
                                                    Object bean, String beanName) {
        //3-1 仅对容器中的car Bean进行处理，还可以通过pds入参进行过滤
        //仅对car的某个特定属性时进行处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcesssor.postProcessPropertyValues");

        }
        return pvs;
    }

}
