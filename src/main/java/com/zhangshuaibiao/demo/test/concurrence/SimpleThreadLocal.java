package com.zhangshuaibiao.demo.test.concurrence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsb29016
 * @create 2020/11/30 19:35
 * @desc
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialVaule();
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialVaule(){
        return null;
    }


}
