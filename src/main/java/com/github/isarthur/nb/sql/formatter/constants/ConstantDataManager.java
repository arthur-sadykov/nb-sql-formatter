/*
 * Copyright 2020 Arthur Sadykov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.isarthur.nb.sql.formatter.constants;

/**
 *
 * @author Arthur Sadykov
 */
public class ConstantDataManager {

    public static final String COUCHBASE_N1QL_DIALECT_ID = "n1ql";
    public static final String COUCHBASE_N1QL_DIALECT_NAME = "Couchbase N1QL";
    public static final String DIALECT = "dialect";
    public static final String DEFAULT_DIALECT = "Standard SQL";
    public static final int DEFAULT_INDENT = 2;
    public static final String IBM_DB2_DIALECT_ID = "db2";
    public static final String IBM_DB2_DIALECT_NAME = "IBM DB2";
    public static final String INDENT = "indent";
    public static final String ORACLE_PL_SQL_DIALECT_ID = "pl/sql";
    public static final String ORACLE_PL_SQL_DIALECT_NAME = "Oracle PL/SQL";
    public static final String SPACE = " ";
    public static final String STANDARD_SQL_DIALECT_ID = "sql";
    public static final String STANDARD_SQL_DIALECT_NAME = "Standard SQL";

    private ConstantDataManager() {
    }
}
