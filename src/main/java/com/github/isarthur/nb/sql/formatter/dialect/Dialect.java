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
package com.github.isarthur.nb.sql.formatter.dialect;

import com.github.isarthur.nb.sql.formatter.constants.ConstantDataManager;

/**
 *
 * @author Arthur Sadykov
 */
public abstract class Dialect {
    
    public static Dialect get(String name) {
        switch (name) {
            case ConstantDataManager.STANDARD_SQL_DIALECT_NAME: {
                return new StandardSQLDialect();
            }
            case ConstantDataManager.COUCHBASE_N1QL_DIALECT_NAME: {
                return new CouchbaseN1QLlDialect();
            }
            case ConstantDataManager.IBM_DB2_DIALECT_NAME: {
                return new IBMDB2Dialect();
            }
            case ConstantDataManager.ORACLE_PL_SQL_DIALECT_NAME: {
                return new OraclePLSQLDialect();
            }
            default: {
                throw new IllegalArgumentException("Dialect.get: unsupported dialect.");
            }
        }
    }
    
    public abstract String getId();
    
    public abstract String getName();
    
    @Override
    public String toString() {
        return getName();
    }
    
}
