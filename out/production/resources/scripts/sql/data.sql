INSERT INTO TRAINING_STOREFRONT.VENDORS (
  VENDOR_KEY,
  VENDOR_NAME
) VALUES
  (1, 'Open Source Group'),
  (2, 'Red Hat'),
  (3, 'Pivotal'),
  (4, 'Cloudbees')
;

INSERT INTO TRAINING_STOREFRONT.SKUS (
  SKU_KEY
  ,VENDOR_KEY
  ,VENDOR_SKU_CODE
  ,SKU_NAME
  ,SKU_DECRIPTION
) VALUES
  (1, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Open Source Group'), 'OSG-001-001', 'OSG Test class', 'A class to test storefront functionality.')
  ,(2, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Red Hat'), 'OSG-001-001', 'OSG Test class', 'A class to test storefront functionality.')
;

