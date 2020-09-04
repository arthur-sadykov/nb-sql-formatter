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
package nb.sql.formatter.typinghooks;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.github.vertical_blank.sqlformatter.core.DialectConfig;
import com.github.vertical_blank.sqlformatter.core.FormatConfig;
import com.github.vertical_blank.sqlformatter.core.Formatter;
import com.github.vertical_blank.sqlformatter.core.Tokenizer;
import com.github.vertical_blank.sqlformatter.languages.AbstractFormatter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import nb.sql.formatter.settings.Settings;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.typinghooks.TypedBreakInterceptor;

/**
 *
 * @author Arthur Sadykov
 */
public class SqlTypedBreakInterceptor implements TypedBreakInterceptor {

    private int indent;

    @Override
    public boolean beforeInsert(Context context) throws BadLocationException {
        AbstractFormatter af = SqlFormatter.of(Settings.getSelectedDialectId());
        DialectConfig dialectConfig = af.dialectConfig();
        Formatter formatter = new Formatter(
                FormatConfig.builder().indent(Settings.getIndentString()).build(),
                new Tokenizer(dialectConfig));
        formatter.setBreakOffset(context.getBreakInsertOffset());
        Document doc = context.getDocument();
        indent = formatter.getIndentForBreakInsert(doc.getText(0, doc.getLength()));
        return false;
    }

    @Override
    public void insert(MutableContext context) throws BadLocationException {
        indent(context);
    }

    private void indent(MutableContext context) {
        if (indent > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < indent; i++) {
                sb.append(" ");
            }
            context.setText("\n" + sb.toString(), 0, indent + 1);
        }
    }

    @Override
    public void afterInsert(Context context) throws BadLocationException {
    }

    @Override
    public void cancelled(Context context) {
    }

    @MimeRegistration(mimeType = "text/x-sql", service = TypedBreakInterceptor.Factory.class)
    public static class FactoryImpl implements TypedBreakInterceptor.Factory {

        @Override
        public TypedBreakInterceptor createTypedBreakInterceptor(MimePath mimePath) {
            return new SqlTypedBreakInterceptor();
        }
    }
}
