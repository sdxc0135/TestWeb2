package com.TestWeb.util;

public class MakeParameter {
	static public String get(String ...str) {
		String result = "?"+str[0] + "=" + str[1];
		
		if(str.length%2 == 0) {
			for(int i = 2 ; i < str.length ; i+=2) {
				if(str[i+1] != "" && str[i+1] != null) {
					result += "&" + str[i] + "=" + str[i+1] ;
				}
			}
		}
		return result;
	}
}
