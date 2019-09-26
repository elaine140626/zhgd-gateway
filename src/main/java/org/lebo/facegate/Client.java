package org.lebo.facegate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.lebo.facegate.FaceGateApi.LogonAcceptCallback;
import org.lebo.facegate.FaceGateApi.RecvMessageCallback;
import org.lebo.facegate.FaceGateApi.SearchCallback;

import org.lebo.facegate.callback.FaceGateCallback;

import com.sun.jna.platform.win32.WinNT.HANDLE;
import org.lebo.facegate.structure.XRECORD_ITEM_S;
import org.lebo.facegate.structure.XTIME_S;



public class Client extends Thread{
	public static Map<String,HANDLE> handleMap=new HashMap<String,HANDLE>();
	private int    PORT = 8085;
	private byte[] ADDR = "47.106.71.3".getBytes();//与中心连接中设置的端口地址保持一致
	private LogonAcceptCallback lononAcceptCbk   = new FaceGateCallback.LogonAcceptCallbackImpl();
	private RecvMessageCallback recvmessageCbk   = new FaceGateCallback.RecvMessageCallbackImpl();
	private SearchCallback  searchCallback = new FaceGateCallback.SearchCallbackImpl();
	public static FaceGateApi instance = null;
	HANDLE ghandle = null;
	@Override
	public void start() {
		//保存人脸图片的路径 具体文件名为 customId + "_" + System.currentTimeMillis() + ".png"

		try {
			System.out.println("wo yao kai shi lian she bei le ====================");

			instance = FaceGateApi.instance;
			System.out.println(instance);
			//初始化函数
			System.out.println("port:"+PORT);
			System.out.println("lononAcceptCbk"+lononAcceptCbk);
			System.out.println("recvmessageCbk"+recvmessageCbk);
			System.out.println("ADDR"+ADDR);
			instance.FACE_GATE_Init(PORT, lononAcceptCbk, recvmessageCbk, ADDR);

			Thread.sleep(3000);
			//设置搜索回调函数

			instance.FACE_GATE_SetSearchCallbak(searchCallback);

			int errorsNum = 0;
			Scanner scanner = null;
			while(true) {
				if (ghandle == null) {
					//因为这里是模拟客户端连接必须等待回调接口返回
					ghandle = lononAcceptCbk.getHandle();
					System.out.println(ghandle);
					errorsNum ++;
					if(errorsNum == 100) break;
					System.out.println("wait LogonAcceptCallback ....... ");
				}
				Thread.sleep(1000);}
//			lononAcceptCbk.getHandle();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}




