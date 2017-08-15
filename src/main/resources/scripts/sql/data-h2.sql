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
  ,SKU_DESCRIPTION
) VALUES
  (1, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Open Source Group'), 'OSG-001-001', '1 Unit of OSG Training.', 'A single unit of OSG training to be redeemed to attend a class.')
  ,(2, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Red Hat'), 'RHT001', '1 Unit of Red Hat Training.', 'A single unit of Red Hat training to be redeemed to attend a class.')
  ,(3, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-001-001', '1 Unit of Pivotal Training.', 'A single unit of Pivotal training to be redeemed to attend a class.')
  ,(4, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Cloudbees'), 'CLB-001-001', '1 Unit of Cloudbees Training.', 'A single unit of Cloudbees training to be redeemed to attend a class.')
  ,(5, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Open Source Group'), 'OSG-001-002', '2 Units of OSG Training.', 'Two units of OSG training to be redeemed to attend a class.')
  ,(6, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Red Hat'), 'RHT002', '2 Units of Red Hat Training.', 'Two units of Red Hat training to be redeemed to attend a class.')
  ,(7, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-001-002', '2 Units of Pivotal Training.', 'Two units of Pivotal training to be redeemed to attend a class.')
  ,(8, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Cloudbees'), 'CLB-001-002', '2 Units of Cloudbees Training.', 'Two units of Cloudbees training to be redeemed to attend a class.')
;

