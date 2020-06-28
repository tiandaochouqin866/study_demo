package com.zhangshuaibiao.demo.loginsystem;

import java.util.Base64;
import com.sun.jna.ptr.IntByReference;

/**
 * @author wangwj13231@hundsun.com<br>
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/4/26 10:51
 * @description  穿透式监管,取dll获取新增的字段值,测试类
 *
 * 注意new IntByReference()引用,int的话还是0
 */
public class SysInfoTest {

    public static void main(String[] args) {
//        String version = HsFutuSystemInfo.INSTANCE.hundsun_getversion();
//        System.out.println(version);

        System.out.println("\nHS");
        byte[] pszSysInfo = new byte[1024];
        byte[] pszSysInfoIntegrity = new byte[1024];
        IntByReference iSysInfoLen = new IntByReference(0);
        IntByReference iSysInfoIntegrityLen = new IntByReference(0);
        // 执行后:返回pszSysInfo信息, iSysInfoLen是该信息的有效长度
        int hsRetCode = HsFutuSystemInfo.INSTANCE.hundsun_getsysteminfo(pszSysInfo, iSysInfoLen, pszSysInfoIntegrity, iSysInfoIntegrityLen);
        System.out.println(hsRetCode);

        byte[] sysInfo = new byte[iSysInfoLen.getValue()];
        //System.arraycopy(pszSysInfo, 0, sysInfo, 0, sysInfo.length);
//		System.out.println(Hex.encodeHexString(sysInfo));
        System.out.println("hs_sysInfo="+new String(sysInfo));

        byte[] sysInfoIntegrity = new byte[iSysInfoIntegrityLen.getValue()];
        System.arraycopy(pszSysInfoIntegrity, 0, sysInfoIntegrity, 0, sysInfoIntegrity.length);
//		System.out.println(Hex.encodeHexString(sysInfoIntegrity));
        System.out.println(new String(sysInfoIntegrity));



        System.out.println("\nJSD");
        byte[] str = new byte[1024];
        IntByReference nlen = new IntByReference(0);
        int jsdRetCode = JsdSystemInfo.INSTANCE.KingStar_GetSystemInfo(str, nlen);
        System.out.println(jsdRetCode);

        byte[] retInfo = new byte[nlen.getValue()];
        System.arraycopy(str, 0, retInfo, 0, retInfo.length);
        System.out.println(new String(retInfo));

     /*   System.out.println("\nCTP");
        byte[] pSystemInfo = new byte[270];
        IntByReference nLen = new IntByReference(0);
        int retCode = CTPSystemInfo.INSTANCE._Z17CTP_GetSystemInfoPcRi(pSystemInfo, nLen);
        byte[] ctpSysInfo = new byte[nLen.getValue()];
        System.arraycopy(pSystemInfo, 0, ctpSysInfo, 0, ctpSysInfo.length);
        System.out.println(new String(Base64.getEncoder().encode(ctpSysInfo)));*/
    }


}
