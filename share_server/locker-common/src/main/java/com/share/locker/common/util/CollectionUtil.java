package com.share.locker.common.util;

import java.util.List;

public class CollectionUtil {
	public static boolean isEmptyArray(List list){
		return list == null || list.size() == 0;
	}
}
