package org.jboss.tools.portlet.ui.bot.task.wizard.web.jboss;

import org.jboss.reddeer.jface.wizard.WizardPage;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.text.LabeledText;

/**
 * Wizard Page for New JavaPortlet Wizard
 * 
 * @author psuchy
 * 
 */
public class NewJavaPortletWizardPage extends WizardPage {

	public NewJavaPortletWizardPage() {
		super();
	}

	public void setClassName(String name) {
		new LabeledText("Class name:").setText(name);
	}

	public void setPackage(String packageName) {
		new LabeledText("Java package:").setText(packageName);
	}

	public void setProject(String projectName) {
		new LabeledCombo("Project:").setSelection(projectName);
	}

}