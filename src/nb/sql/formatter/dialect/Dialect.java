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
package nb.sql.formatter.dialect;

import nb.sql.formatter.constants.ConstantDataManager;

/**
 *
 * @author Arthur Sadykov
 */
public enum Dialect {
    SQL(ConstantDataManager.STANDARD_SQL_DIALECT_NAME),
    N1QL(ConstantDataManager.COUCHBASE_N1QL_DIALECT_NAME),
    DB2(ConstantDataManager.IBM_DB2_DIALECT_NAME),
    PL_SQL(ConstantDataManager.ORACLE_PL_SQL_DIALECT_NAME);
    private final String name;

    private Dialect(String name) {
        this.name = name;
    }

    public static String getId(String name) {
        switch (name) {
            case ConstantDataManager.STANDARD_SQL_DIALECT_NAME: {
                return ConstantDataManager.STANDARD_SQL_DIALECT_ID;
            }
            case ConstantDataManager.COUCHBASE_N1QL_DIALECT_NAME: {
                return ConstantDataManager.COUCHBASE_N1QL_DIALECT_ID;
            }
            case ConstantDataManager.IBM_DB2_DIALECT_NAME: {
                return ConstantDataManager.IBM_DB2_DIALECT_ID;
            }
            case ConstantDataManager.ORACLE_PL_SQL_DIALECT_NAME: {
                return ConstantDataManager.ORACLE_PL_SQL_DIALECT_ID;
            }
            default: {
                throw new IllegalArgumentException("Dialect.getId: invalid dialect name.");
            }
        }
    }

    public static Dialect get(String name) {
        switch (name) {
            case ConstantDataManager.STANDARD_SQL_DIALECT_NAME: {
                return SQL;
            }
            case ConstantDataManager.COUCHBASE_N1QL_DIALECT_NAME: {
                return N1QL;
            }
            case ConstantDataManager.IBM_DB2_DIALECT_NAME: {
                return DB2;
            }
            case ConstantDataManager.ORACLE_PL_SQL_DIALECT_NAME: {
                return PL_SQL;
            }
            default: {
                throw new IllegalArgumentException("Dialect.get: invalid dialect name.");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
