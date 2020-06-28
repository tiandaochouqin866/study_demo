package com.zhangshuaibiao.demo.loginsystem;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/**
 * @author sunff
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/11/26 10:50
 * @description 直接调用ctp提供的so,替换CTPDataCollect.jav
 * 关于so的调用，GET_SystemInfo会报找不到导致函数。解决办法：调用_Z17CTP_GetSystemInfoPcRi
 * nm LinuxDataCollect.so |grep SystemInfo
 * 0000000000085230 T _Z17CTP_GetSystemInfoPcRi
 * 0000000000084c40 T _Z21CTP_GetRealSystemInfoPcRi
 * 00000000000850e0 T _Z28CTP_GetSystemInfoUnAesEncodePcRi
 */
public interface CTPSystemInfo  extends Library {
	CTPSystemInfo INSTANCE = (CTPSystemInfo)
            Native.loadLibrary(GetDllNameUtil.getDllNameCTP() ,
            		CTPSystemInfo.class);
    
    
  ///获取AES加密和RSA加密的终端信息 
  ///@pSystemInfo 出参 空间需要调用者自己分配 至少270个字节
  ///@nLen 出参 获取到的采集信息的长度
  ///采集信息内可能含有‘\0’ 建议调用者使用内存复制
  int _Z17CTP_GetSystemInfoPcRi(byte[] pSystemInfo, IntByReference nLen);
  

}
