package com.TestWeb.util;

public class DTOutil {
	
	public static boolean checkNull(Object...obj) {
		for(int i = 0 ; i < obj.length; i++) {
			if(obj[i] == null) {
				return false;
			}
		}
		return true;
	}
}
