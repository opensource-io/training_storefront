INSERT INTO TRAINING_STOREFRONT.VENDORS (
  VENDOR_KEY,
  VENDOR_NAME
) VALUES
  (1, 'Open Source Group'),
  (2, 'Red Hat'),
  (3, 'Pivotal'),
  (4, 'CloudBees')
;

INSERT INTO TRAINING_STOREFRONT.SKUS (
  SKU_KEY
  ,VENDOR_KEY
  ,VENDOR_SKU_CODE
  ,SKU_NAME
  ,SKU_DESCRIPTION
  ,CLASS_LENGTH
) VALUES
  (1,  (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'CloudBees'), 'CB-JADM', 'Continuous Delivery with the CloudBees Jenkins Platform, Admin Training', '', '1')
  ,(2, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'CloudBees'), 'CB-JUSR', 'Continuous Delivery with the CloudBees Jenkins Platform, User Training', '', '2')
  ,(3, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'CloudBees'), 'CB-JCRT', 'Continuous Delivery with the CloudBees Jenkins Platform, Certification Training', '', '2')

  ,(4, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-GFD', 'GemFire Developer Training', '', '4')
  ,(5, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-GFA', 'GemFire Administration Training', '', '3')

  ,(6, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-CFA', 'Pivotal Cloud Foundry Administrator Training', '', '3')
  ,(7, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-CFD', 'Pivotal Cloud Foundry Developer Training', '', '4')

  ,(8, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-RMQ', 'RabbitMQ Training', '', '3')

  ,(9, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-SPW', 'Spring Web Training', '', '4')
  ,(10, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-ESP', 'Enterprise Spring Training', '', '4')
  ,(11, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-SBD', 'Spring Boot Developer Training', '', '2')
  ,(12, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Pivotal'), 'PIV-CSP', 'Core Spring Training', '', '4')

  ,(13, (SELECT VENDOR_KEY FROM TRAINING_STOREFRONT.VENDORS AS V WHERE V.VENDOR_NAME = 'Red Hat'), 'RH124', 'Red Hat System Administrator I', '', '5')
;

INSERT INTO TRAINING_STOREFRONT.ADDRESSES (
  ADDRESS_KEY
  ,ADDRESS_LINE_1
  ,CITY
  ,COUNTRY_SUBDIVISION
) VALUES
  (1, '', 'Live', 'Online')
  ,(2, '', 'Dallas', 'TX')
  ,(3, '', 'Minneapolis', 'MN')
  ,(4, '', 'Boston', 'MA')
  ,(5, '', 'Chicago', 'IL')
  ,(6, '', 'Columbus', 'OH')
  ,(7, '', 'Denver', 'CO')
  ,(8, '', 'Detroit', 'MI')
  ,(9, '', 'Hartford', 'CT')
  ,(10, '', 'Los Angeles', 'CA')
  ,(11, '', 'Miami', 'FL')
  ,(12, '', 'Orlando', 'FL')
  ,(13, '', 'Portland', 'OR')
  ,(14, '', 'Raleigh', 'NC')
  ,(15, '', 'Redwood City', 'CA')
  ,(16, '', 'Sacramento', 'CA')
  ,(17, '', 'San Diego', 'CA')
  ,(18, '', 'San Francisco', 'CA')
  ,(19, '', 'Seattle', 'WA')
  ,(20, '', 'St Louis', 'MO')
  ,(21, '', 'Tampa', 'FL')
  ,(22, '', 'Washington', 'DC')
  ,(23, '', 'Austin', 'TX')
  ,(24, '', 'Columbia', 'MD')
;

INSERT INTO TRAINING_STOREFRONT.INSTRUCTORS (
  INSTRUCTOR_KEY
  ,INSTRUCTOR_NAME
  ,INSTRUCTOR_EMAIL
) VALUES
  (1, '', '')
;

  -- (1, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-ESP'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-10-23 09:00:00-12', '2017-10-23 17:00:00-12', 'CST')
  -- ,(2, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-ESP'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-10-23 09:00:00-12', '2017-10-26 17:00:00-12', 'CST')
  -- ,(3, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-10-23 09:00:00-12', '2017-10-24 17:00:00-12', 'CST')
  -- ,(8, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-11-13 09:00:00-12', '2017-11-14 17:00:00-12', 'CST')
  -- ,(9, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-11-13 09:00:00-12', '2017-11-14 17:00:00-12', 'PST')
  -- ,(11, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JADM'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-11-15 09:00:00-12', '2017-11-15 17:00:00-12', 'CST')
  -- ,(12, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JADM'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-11-15 09:00:00-12', '2017-11-15 17:00:00-12', 'PST')
  -- ,(14, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JCRT'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-11-16 09:00:00-12', '2017-11-17 17:00:00-12', 'CST')
  -- ,(15, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JCRT'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-11-16 09:00:00-12', '2017-11-17 17:00:00-12', 'PST')

  -- ,(16, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-GFA'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-11-13 09:00:00-12', '2017-11-15 17:00:00-12', 'PST')
  -- ,(17, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-GFA'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Seattle'), '2017-11-13 09:00:00-12', '2017-11-15 17:00:00-12', 'PST')
  -- ,(18, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-GFA'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-11-13 09:00:00-12', '2017-11-15 17:00:00-12', 'PST')
  -- ,(26, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SBD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Seattle'), '2017-12-04 09:00:00-12', '2017-12-05 17:00:00-12', 'PST')
  -- ,(27, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SBD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Dallas'), '2017-12-04 09:00:00-12', '2017-12-05 17:00:00-12', 'CST')
  -- ,(28, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SPW'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-06 09:00:00-12', '2017-12-08 17:00:00-12', 'PST')
  -- ,(29, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SPW'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Seattle'), '2017-12-06 09:00:00-12', '2017-12-08 17:00:00-12', 'PST')
  -- ,(30, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SPW'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Dallas'), '2017-12-06 09:00:00-12', '2017-12-08 17:00:00-12', 'CDT')




INSERT INTO TRAINING_STOREFRONT.CLASS_SESSIONS (
  CLASS_SESSION_KEY
  ,SKU_KEY
  ,ADDRESS_KEY
  ,CLASS_SESSION_STARTDATE
  ,CLASS_SESSION_STARTTIME
  ,CLASS_SESSION_ENDTIME
  ,CLASS_SESSION_TIMEZONE
) VALUES
  (7, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-11-13', '09:00:00', '17:00:00', 'CST')
  ,(22, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-CFD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-04', '09:00:00', '17:00:00', 'PST')
  ,(23, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-CFD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-12-04', '09:00:00', '17:00:00', 'CST')
  ,(24, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-CFD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-12-04', '09:00:00', '17:00:00', 'PST')
  ,(25, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-SBD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-18', '09:00:00', '17:00:00', 'PST')
  ,(31, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'PIV-GFD'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-11', '09:00:00', '17:00:00', 'PST')
  ,(34, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-11', '09:00:00', '17:00:00', 'PST')
  ,(35, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-12-11', '09:00:00', '17:00:00', 'CST')
  ,(36, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JUSR'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-12-11', '09:00:00', '17:00:00', 'PST')
  ,(37, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JADM'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-13', '09:00:00', '17:00:00', 'PST')
  ,(38, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JADM'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-12-13', '09:00:00', '17:00:00', 'CST')
  ,(39, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JADM'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-12-13', '09:00:00', '17:00:00', 'PST')
  ,(40, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JCRT'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-12-14', '09:00:00', '17:00:00', 'PST')
  ,(41, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JCRT'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Minneapolis'), '2017-12-14', '09:00:00', '17:00:00', 'CST')
  ,(42, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'CB-JCRT'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Redwood City'), '2017-12-14', '09:00:00', '17:00:00', 'PST')
  ,(43, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'RH124'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Columbia'), '2017-11-13', '09:00:00', '17:00:00', 'EST')
  ,(44, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'RH124'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-11-13', '09:00:00', '17:00:00', 'EST')

  ,(45, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'RH124'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'San Diego'), '2017-11-27', '07:00:00', '15:00:00', 'PST')
  ,(46, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'RH124'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Denver'), '2017-11-27', '10:30:00', '17:00:00', 'MST')
  ,(47, (SELECT SKU_KEY FROM TRAINING_STOREFRONT.SKUS AS S WHERE S.VENDOR_SKU_CODE = 'RH124'), (SELECT ADDRESS_KEY FROM TRAINING_STOREFRONT.ADDRESSES AS A WHERE A.CITY = 'Live'), '2017-11-27', '10:30:00', '18:30:00', 'EST')

;