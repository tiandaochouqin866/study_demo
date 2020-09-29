package com.zhangshuaibiao.demo.test.messagevent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhangsb29016
 * @create 2020/9/29 18:23
 * @desc MailSender要拥有发布事件的能力，必须实现ApplicationContextAware接口
 */
public class MailSender implements ApplicationContextAware {
    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */

    private ApplicationContext ac;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

           this.ac = ac;
    }

    public void sendMail(String to){
        System.out.println("MailSender:模拟发送邮件");
        MailSendEvent mse= new MailSendEvent(this.ac,to);
        //向容器中的所有事件监听器发送事件
        ac.publishEvent(mse);
    }
}
