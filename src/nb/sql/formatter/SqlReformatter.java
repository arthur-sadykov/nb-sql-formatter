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
package nb.sql.formatter;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import javax.swing.text.BadLocationException;
import nb.sql.formatter.settings.Settings;
import nb.sql.formatter.ui.DocumentHandler;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

/**
 *
 *
 * @author Arthur Sadykov
 */
public class SqlReformatter implements ReformatTask {

    private final Context context;

    private SqlReformatter(Context context) {
        this.context = context;
    }

    @Override
    public void reformat() throws BadLocationException {
        String sql = DocumentHandler.getContent(context.document());
        DocumentHandler.clear(context.document());
        DocumentHandler.insert(context.document(), formatSqlCode(sql));
    }

    private String formatSqlCode(String sql) {
        return SqlFormatter.of(Settings.getSelectedDialectId()).format(sql, Settings.getIndentString());
    }

    @Override
    public ExtraLock reformatLock() {
        return null;
    }

    @MimeRegistration(mimeType = "text/x-sql", service = ReformatTask.Factory.class)
    public static class FactoryImpl implements ReformatTask.Factory {

        @Override
        public ReformatTask createTask(Context context) {
            return new SqlReformatter(context);
        }
    }
}
