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

/**
 *
 * @author Arthur Sadykov
 */
public enum Dialect {
    SQL("Standard SQL"),
    N1QL("Couchbase N1QL"),
    DB2("IBM DB2"),
    PL_SQL("Oracle PL/SQL");
    private final String name;

    private Dialect(String name) {
        this.name = name;
    }

    public static String getId(String name) {
        switch (name) {
            case "Standard SQL": {
                return "sql";
            }
            case "Couchbase N1QL": {
                return "n1ql";
            }
            case "IBM DB2": {
                return "db2";
            }
            case "Oracle PL/SQL": {
                return "pl/sql";
            }
            default: {
                throw new IllegalArgumentException("Dialect.getId: invalid dialect name.");
            }
        }
    }

    public static Dialect get(String name) {
        switch (name) {
            case "Standard SQL": {
                return SQL;
            }
            case "Couchbase N1QL": {
                return N1QL;
            }
            case "IBM DB2": {
                return DB2;
            }
            case "Oracle PL/SQL": {
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
