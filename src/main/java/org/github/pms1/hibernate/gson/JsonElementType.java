package org.github.pms1.hibernate.gson;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;

import com.google.gson.JsonElement;

public class JsonElementType extends AbstractSingleColumnStandardBasicType<JsonElement>
/* implements DynamicParameterizedType */ {

	public JsonElementType() {
		super(GsonBinarySqlTypeDescriptor2.INSTANCE, new JsonElementTypeDescriptor());
	}

	public String getName() {
		return JsonElement.class.getName();
	}

	// @Override
	// public void setParameterValues(Properties parameters) {
	// // ((JsonElementTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	// }

}