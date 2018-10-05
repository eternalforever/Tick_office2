package com.dld.utils;
import com.dld.vo.JsonBean;;
public class JsonUtils {
	public static JsonBean writeJsonUtils(int code,Object msg) {
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setMsg(msg);
		return bean;
		
	}

}
