package org.github.pms1.hibernate.gson;

import static org.github.pms1.hibernate.gson.GsonUtil.gson;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;

import com.google.gson.JsonObject;

public class JsonObjectTypeDescriptor
		extends AbstractTypeDescriptor<JsonObject> /* implements DynamicParameterizedType */ {

	// @Override
	// public void setParameterValues(Properties parameters) {
	// }

	public JsonObjectTypeDescriptor() {
		super(JsonObject.class, new MutableMutabilityPlan<JsonObject>() {
			@Override
			protected JsonObject deepCopyNotNull(JsonObject value) {
				return gson.fromJson(GsonUtil.gson.toJson(value), JsonObject.class);
			}
		});
	}

	@Override
	public boolean areEqual(JsonObject one, JsonObject another) {
		if (one == another) {
			return true;
		}
		if (one == null || another == null) {
			return false;
		}
		return one.equals(another);
	}

	@Override
	public String toString(JsonObject value) {
		if (value == null)
			return null;
		else
			return value.toString();
	}

	@Override
	public JsonObject fromString(String string) {
		return gson.fromJson(string, JsonObject.class);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <X> X unwrap(JsonObject value, Class<X> type, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		if (String.class.isAssignableFrom(type)) {
			return (X) toString(value);
		}
		if (Object.class.isAssignableFrom(type)) {
			return (X) fromString(toString(value));
		}
		throw unknownUnwrap(type);
	}

	@Override
	public <X> JsonObject wrap(X value, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		return fromString(value.toString());
	}

}