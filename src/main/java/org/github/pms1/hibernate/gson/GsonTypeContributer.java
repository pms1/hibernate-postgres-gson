package org.github.pms1.hibernate.gson;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.boot.model.TypeContributor;
import org.hibernate.service.ServiceRegistry;

public class GsonTypeContributer implements TypeContributor {

	@Override
	public void contribute(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
		// JavaTypeDescriptorRegistry.INSTANCE.addDescriptor(JsonObjectTypeDescriptor.INSTANCE);

		typeContributions.contributeType(new JsonObjectType());
		typeContributions.contributeType(new JsonElementType());
	}
}
