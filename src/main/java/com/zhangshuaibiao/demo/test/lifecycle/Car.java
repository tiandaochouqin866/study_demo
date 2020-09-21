package com.zhangshuaibiao.demo.test.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author zhangsb29016
 * @create 2020/9/21 19:04
 * @desc 1.管理Bean生命周期的接口
 *      Car类在2-5处实现了BeanFactoryAware、BeanNameAware、InitializingBean、DisposableBean这些Bean
 *      级的生命周期控制接口。在6和7处定义了myInit()和myDestroy()方法，以便在配置文件中通过init-method
 *      和destroy-method属性定义初始化和销毁方法
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;

    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;

    private String beanName;

    public Car() {
        System.out.println("调用Car()构造函数。");
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSPeed:" + maxSpeed);
    }


    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     * <p>
     * desc:2.BeanFactoryAware接口方法
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用beanFactoryAware.setBeanFactory()。");
        this.beanFactory = beanFactory;
    }

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * <p>Invoked after population of normal bean properties but before an
     * init callback such as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method.
     *
     * @param name the name of the bean in the factory.
     *             Note that this name is the actual bean name used in the factory, which may
     *             differ from the originally specified name: in particular for inner bean
     *             names, the actual bean name might have been made unique through appending
     *             "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     *             method to extract the original bean name (without suffix), if desired.
     * @desc:2 BeanNameAware方法
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("调用beanNameAware.setBeanName()方法");
        this.beanName = beanName;

    }


    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     * @desc:4 InitializingBean接口方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用initializingBean.afterPropertiesSet()。");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     * @desc :5  DisposableBean接口方法
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()");
    }

    /**
     * 6 通过<bean>的init-method属性指定的初始化方法
     */
    public void myInit() {
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240。");
    }

    /**
     * 7 通过<bean>的destroy-method属性执行的销毁方法
     */
    public void myDestroy() {
    System.out.println("调用destroy-method所指定的myDestroy()。");
    }
}
