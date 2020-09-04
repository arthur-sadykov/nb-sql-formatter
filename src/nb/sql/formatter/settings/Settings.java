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
package nb.sql.formatter.settings;

import java.util.prefs.Preferences;
import nb.sql.formatter.constants.ConstantDataManager;
import nb.sql.formatter.dialect.Dialect;
import org.openide.util.NbPreferences;

/**
 *
 * @author Arthur Sadykov
 */
public class Settings {

    private Settings() {
    }

    public static String getSelectedDialectId() {
        Preferences prefs = NbPreferences.forModule(Settings.class);
        String dialectName = prefs.get(ConstantDataManager.DIALECT, ConstantDataManager.DEFAULT_DIALECT);
        return Dialect.get(dialectName).getId();
    }

    public static String getIndentString() {
        int indent = getSelectedIndent();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(ConstantDataManager.SPACE);
        }
        return sb.toString();
    }

    private static int getSelectedIndent() {
        Preferences prefs = NbPreferences.forModule(Settings.class);
        return prefs.getInt(ConstantDataManager.INDENT, ConstantDataManager.DEFAULT_INDENT);
    }
}
