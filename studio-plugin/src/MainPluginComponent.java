import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * Created by cuo050 on 7/6/17.
 */
public class MainPluginComponent {


    public class Derp extends AnAction {

        public Derp() {
            super("Main Component", "You're too slow!", IconLoader.getIcon("sonic.png"));
        }

        @Override
        public void actionPerformed(AnActionEvent anActionEvent) {
            Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
            //String txt = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
            final Icon sonicIcon = IconLoader.getIcon("sonic.png");
            Messages.showMessageDialog(project, "You're too slow!", "Gotta go Fast!", Messages.getWarningIcon());
        }
    }

    public class FindProviderAction extends BaseJavaLocalInspectionTool {


    }
}
