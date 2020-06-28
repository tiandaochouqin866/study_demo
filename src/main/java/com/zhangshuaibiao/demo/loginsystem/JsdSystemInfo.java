package com.zhangshuaibiao.demo.loginsystem;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;


/**
 * @author wangwj13231@hundsun.com<br>
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/4/26 10:47
 * @description
 */
public interface JsdSystemInfo extends Library {


    JsdSystemInfo INSTANCE = (JsdSystemInfo)
            Native.loadLibrary(GetDllNameUtil.getDllNameJsd() ,
                    JsdSystemInfo.class);


    int KingStar_GetSystemInfo(byte[] str, IntByReference nLen);


}
