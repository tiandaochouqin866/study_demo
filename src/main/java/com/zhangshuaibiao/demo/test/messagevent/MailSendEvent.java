package com.zhangshuaibiao.demo.test.messagevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author zhangsb29016
 * @create 2020/9/29 17:14
 * @desc
 */
public class MailSendEvent extends ApplicationContextEvent {
    /**
     * 发送目的地
     */
    private String to;

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     * @param to
     */
    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = this.to;
    }

    public String getTo() {
        return to;
    }
}
