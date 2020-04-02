CREATE TABLE tbl_pais (
    cmp_codpais  VARCHAR2(3 CHAR) NOT NULL,
    cmp_nompais  VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE tbl_pais ADD CONSTRAINT tbl_pais_pk PRIMARY KEY ( cmp_codpais );

CREATE TABLE tbl_poblacion (
    cmp_id                INTEGER NOT NULL,
    tbl_pais_cmp_codpais  VARCHAR2(3 CHAR) NOT NULL,
    cmp_ano               INTEGER NOT NULL,
    poblacion             INTEGER NOT NULL
);

ALTER TABLE tbl_poblacion ADD CONSTRAINT tbl_poblacion_pk PRIMARY KEY ( cmp_id );

ALTER TABLE tbl_poblacion
    ADD CONSTRAINT tbl_poblacion_tbl_pais_fk FOREIGN KEY ( tbl_pais_cmp_codpais )
        REFERENCES tbl_pais ( cmp_codpais );