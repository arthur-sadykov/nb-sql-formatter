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
public class IBMDB2Dialect extends Dialect {

    @Override
    public String getId() {
        return ConstantDataManager.IBM_DB2_DIALECT_ID;
    }

    @Override
    public String getName() {
        return ConstantDataManager.IBM_DB2_DIALECT_NAME;
    }
}
