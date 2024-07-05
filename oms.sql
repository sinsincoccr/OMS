-- ȸ�� ���?

CREATE TABLE OMS_COMPANY_MEMBER (
    CPN_CD VARCHAR(30) PRIMARY KEY NOT NULL,
    CPN_BIZ_NO VARCHAR(20),
    CPN_ID VARCHAR(20),
    CPN_PW VARCHAR(20),
    CPN_NM VARCHAR(60),
    CEO_NM VARCHAR(40),
    CPN_ADDR VARCHAR(255),
    CPN_IMAGE_URL VARCHAR(200),
    CPN_DESC VARCHAR(200),
    OPN_DT VARCHAR(8),
    CPN_TEL VARCHAR(20),
    CPN_EMAIL VARCHAR(40),
    CPN_STATE VARCHAR(10),
    STATE_MDF_DATE DATE,
    REG_DATE DATE
);

select * from OMS_COMPANY_MEMBER;

INSERT INTO OMS_COMPANY_MEMBER (
    CPN_CD, CPN_BIZ_NO, CPN_ID, CPN_PW, CPN_NM, CEO_NM, CPN_ADDR, CPN_IMAGE_URL, CPN_DESC, OPN_DT, CPN_TEL, CPN_EMAIL, CPN_STATE, STATE_MDF_DATE, REG_DATE
) VALUES (
    'CPN002', '123-45-67899', '222', '222', 'Company B', 'CEO Name', '123 Main St, City', 'http://example.com/image.png', 'Description here', '20200101', '010-1234-5678', 'contact@company.com', 'Active', TO_DATE('2023-01-01', 'YYYY-MM-DD'), TO_DATE('2023-01-01', 'YYYY-MM-DD')
);

UPDATE OMS_COMPANY_MEMBER SET CPN_ID = '111' WHERE CPN_ID = 'Company A';

drop table OMS_COMPANY_MEMBER;

commit;


CREATE SEQUENCE cpn_cd_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;
    
    
    CREATE TABLE OMS_ITEM_CATEGORY (
    CTGR_CD VARCHAR(20) PRIMARY KEY,  
    CPN_NM VARCHAR(20),  
    SEQ INT,                          
    REG_USER_CD VARCHAR(20),          
    REG_DATE DATE,                    
    MDF_USER_CD VARCHAR(20),         
    MDF_DATE DATE                     
);

INSERT INTO OMS_ITEM_CATEGORY (CTGR_CD, CPN_NM, SEQ, REG_USER_CD, REG_DATE, MDF_USER_CD, MDF_DATE)
VALUES 
('CTGR002', 'Company B', 2, 'manager', TO_DATE('2023-01-02', 'YYYY-MM-DD'), 'manager', TO_DATE('2023-01-02', 'YYYY-MM-DD'));

commit;

drop table OMS_ITEM_CATEGORY;

select * from OMS_ITEM_CATEGORY;
commit;

CREATE TABLE OMS_ITEM_LIST (
    PRODUCT_CD VARCHAR(20) PRIMARY KEY NOT NULL,
    CTGR_CD VARCHAR(30),
    PRODUCT_NM VARCHAR(400),
    SEQ INT,
    NORMAL_AMOUNT INT,
    DISCOUNT_AMOUNT INT,
    RANKING INT,
    PRODUCT_STATE VARCHAR(10),
    PRODUCT_GUIDE VARCHAR(600),
    REG_USER_CD VARCHAR(20),
    REG_DATE DATE,
    MDF_USER_CD VARCHAR(20),
    MDF_DATE DATE

);

drop table OMS_ITEM_LIST;

INSERT INTO OMS_ITEM_LIST (
    CTGR_CD, PRODUCT_CD, PRODUCT_NM, SEQ, NORMAL_AMOUNT, DISCOUNT_AMOUNT, 
    RANKING, PRODUCT_STATE, PRODUCT_GUIDE, REG_USER_CD, REG_DATE, MDF_USER_CD, MDF_DATE
) VALUES (
    'CTGR001', 'P12345', 'Sample Product A', 1, 10000, 9000, 1, 'ACTIVE', 'This is a sample product.', 
    'admin', TO_DATE('2023-06-01', 'YYYY-MM-DD'), 'admin', TO_DATE('2023-06-01', 'YYYY-MM-DD')
);

INSERT INTO OMS_ITEM_LIST (
    CTGR_CD, PRODUCT_CD, PRODUCT_NM, SEQ, NORMAL_AMOUNT, DISCOUNT_AMOUNT, 
    RANKING, PRODUCT_STATE, PRODUCT_GUIDE, REG_USER_CD, REG_DATE, MDF_USER_CD, MDF_DATE
) VALUES (
    'CTGR002', 'P67890', 'Sample Product B', 2, 20000, 18000, 2, 'INACTIVE', 'This is another sample product.', 
    'user1', TO_DATE('2023-06-02', 'YYYY-MM-DD'), 'user1', TO_DATE('2023-06-02', 'YYYY-MM-DD')
);

commit;

select * from OMS_ITEM_LIST;
    
    
 