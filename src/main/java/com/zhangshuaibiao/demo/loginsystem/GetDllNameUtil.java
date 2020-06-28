package com.zhangshuaibiao.demo.loginsystem;

import com.sun.jna.Platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangwj13231@hundsun.com<br>
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/4/26 10:50
 * @description
 */
public class GetDllNameUtil {
    protected static final Logger logger = LoggerFactory.getLogger(GetDllNameUtil.class);

    public static String getDllNameHsFutu() {
        String str = "";
        if (Platform.isWindows()) {
            if (Platform.is64Bit()) {
                str = "penetrateSupervise/hsDll/win64/lib/HsFutuSystemInfo";	// HsFutuSystemInfo.dll
            } else {
                str = "penetrateSupervise/hsDll/win32/lib/HsFutuSystemInfo";	// HsFutuSystemInfo.dll
            }

        } else if (Platform.isLinux()) {
            if (Platform.is64Bit()) {
                str = "penetrateSupervise/hsDll/linux.x64/lib/libHsFutuSystemInfo.so";	// libHsFutuSystemInfo.so
            } else {
                str = "penetrateSupervise/hsDll/linux.i386/lib/libHsFutuSystemInfo.so";	// libHsFutuSystemInfo.so
            }
        }

        logger.debug("加载动态库=" + str);
        return str;
    }


    public static String getDllNameJsd() {
        String str = "";
        if (Platform.isWindows()) {
            if (Platform.is64Bit()) {
                str = "penetrateSupervise/jsdDll/win64/KCC_API";
            } else {
                str = "penetrateSupervise/jsdDll/win32/KCC_API";
            }

        } else if (Platform.isLinux()) {
            if (Platform.is64Bit()) {
                str = "penetrateSupervise/jsdDll/linux64/libkcc.so";
            } else {
                str = "penetrateSupervise/jsdDll/linux32/libkcc.so";
            }
        }

        logger.debug("加载动态库=" + str);
        return str;
    }
    
    public static String getDllNameCTP() {
        String str = "";
        if (Platform.isWindows()) {
//            if (Platform.is64Bit()) {
//                str = "penetrateSupervise/jsdDll/win64/KCC_API";
//            } else {
//                str = "penetrateSupervise/jsdDll/win32/KCC_API";
//            }
        	logger.error("un support windows");
        } else if (Platform.isLinux()) {
            if (Platform.is64Bit()) {
                str = "penetrateSupervise/ctpDll/linux64/LinuxDataCollect.so";
            } else {
//                str = "penetrateSupervise/jsdDll/linux32/libkcc.so";
            	logger.error("un support linux 32 bit");
            }
        }

        logger.debug("加载动态库=" + str);
        return str;
    }

}
