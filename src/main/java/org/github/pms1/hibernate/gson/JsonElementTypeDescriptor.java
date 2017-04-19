package org.github.pms1.hibernate.gson;

import static org.github.pms1.hibernate.gson.GsonUtil.gson;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;

import com.google.gson.JsonElement;

public class JsonElementTypeDescriptor
		extends AbstractTypeDescriptor<JsonElement> /* implements DynamicParameterizedType */ {

	// @Override
	// public void setParameterValues(Properties parameters) {
	// }

	public JsonElementTypeDescriptor() {
		super(JsonElement.class, new MutableMutabilityPlan<JsonElement>() {
			@Override
			protected JsonElement deepCopyNotNull(JsonElement value) {
				return gson.fromJson(GsonUtil.gson.toJson(value), JsonElement.class);
			}
		});
	}

	@Override
	public boolean areEqual(JsonElement one, JsonElement another) {
		if (one == another) {
			return true;
		}
		if (one == null || another == null) {
			return false;
		}
		return one.equals(another);
	}

	@Override
	public String toString(JsonElement value) {
		if (value == null)
			return null;
		else
			return value.toString();
	}

	@Override
	public JsonElement fromString(String string) {
		return gson.fromJson(string, JsonElement.class);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <X> X unwrap(JsonElement value, Class<X> type, WrapperOptions options) {
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
	public <X> JsonElement wrap(X value, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		return fromString(value.toString());
	}

}