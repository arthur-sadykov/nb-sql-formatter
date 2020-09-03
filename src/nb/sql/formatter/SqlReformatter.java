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
import java.util.prefs.Preferences;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import nb.sql.formatter.constants.ConstantDataManager;
import nb.sql.formatter.dialect.Dialect;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;
import org.openide.util.NbPreferences;

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
        String sql = getSqlCode();
        clearDocument();
        insertFormattedSqlCodeInDocument(formatSqlCode(sql));
    }

    private String getSqlCode() throws BadLocationException {
        Document doc = context.document();
        return doc.getText(0, doc.getLength());
    }

    private void clearDocument() throws BadLocationException {
        context.document().remove(0, context.document().getLength());
    }

    private void insertFormattedSqlCodeInDocument(String sql) throws BadLocationException {
        context.document().insertString(0, sql, null);
    }

    private String formatSqlCode(String sql) {
        return SqlFormatter.of(getSelectedDialectId()).format(sql, getIndentString());
    }

    private String getSelectedDialectId() {
        Preferences prefs = NbPreferences.forModule(SqlFormatter.class);
        String dialectName = prefs.get(ConstantDataManager.DIALECT, ConstantDataManager.DEFAULT_DIALECT);
        return Dialect.getId(dialectName);
    }

    private String getIndentString() {
        int indent = getSelectedIndent();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(ConstantDataManager.SPACE);
        }
        return sb.toString();
    }

    private int getSelectedIndent() {
        Preferences prefs = NbPreferences.forModule(SqlFormatter.class);
        return prefs.getInt(ConstantDataManager.INDENT, ConstantDataManager.DEFAULT_INDENT);
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
