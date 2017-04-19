package org.github.pms1.hibernate.gson;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;

import com.google.gson.JsonObject;

public class JsonObjectType extends AbstractSingleColumnStandardBasicType<JsonObject>
/* implements DynamicParameterizedType */ {

	public JsonObjectType() {
		super(GsonBinarySqlTypeDescriptor.INSTANCE, new JsonObjectTypeDescriptor());
	}

	public String getName() {
		return JsonObject.class.getName();
	}

	// @Override
	// public void setParameterValues(Properties parameters) {
	// // ((JsonObjectTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
	// }

}