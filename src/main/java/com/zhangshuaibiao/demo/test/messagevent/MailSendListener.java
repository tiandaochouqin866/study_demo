package com.zhangshuaibiao.demo.test.messagevent;

import org.springframework.context.ApplicationListener;

/**
 * @author zhangsb29016
 * @create 2020/9/29 18:18
 * @desc MailSenderListner直接实现ApplicationListener接口，在接口方法中通过
 * instanceof操作符判断事件的类型，仅对MailSendEvent类型的时间进行处理
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     *              desc:对MailSendEvent事件进行处理
     */
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = (MailSendEvent) event;
        System.out.println("MailSendListener:向"+mse.getTo()+"发送完一封邮件");
    }
}
