package example;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;

/**
 * Created by cuo050 on 7/11/17.
 */
public class EditorIllustration extends AnAction {

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        //Get required data keys
        final Project project = e.getData(CommonDataKeys.PROJECT);
        final Editor editor = e.getData(CommonDataKeys.EDITOR);

        final Document document = editor.getDocument();
        final SelectionModel selectionModel = editor.getSelectionModel();
        final int start = selectionModel.getSelectionStart();
        final int end = selectionModel.getSelectionEnd();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                document.replaceString(start, end, "Replacement");
            }
        };

        WriteCommandAction.runWriteCommandAction(project, runnable);
        selectionModel.removeSelection();
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

    }

}
