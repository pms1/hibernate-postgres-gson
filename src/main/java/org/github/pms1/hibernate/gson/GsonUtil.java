package org.github.pms1.hibernate.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class GsonUtil {
	private GsonUtil() {

	}

	static Gson gson = new GsonBuilder().serializeNulls().create();

}
