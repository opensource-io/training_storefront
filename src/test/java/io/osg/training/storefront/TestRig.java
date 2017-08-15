package io.osg.training.storefront;

import io.osg.training.storefront.model.entities.VendorEntity;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface TestRig {
    void initializeDbWithControlValues(DataSource dataSourceToInitialize, String tableToInsertTestValuesInto, List<String> columnsToInsertValuesInto, Map<Object, Object> vendorEntitiesToInsert);
}
