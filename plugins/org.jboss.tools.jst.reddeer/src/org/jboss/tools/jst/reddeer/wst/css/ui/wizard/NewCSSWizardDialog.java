package org.jboss.tools.jst.reddeer.wst.css.ui.wizard;

import org.jboss.reddeer.eclipse.topmenu.NewMenuWizard;

/**
 * Wizard dialog for creating a CSS File.
 * @author vpakan
 */
public class NewCSSWizardDialog extends NewMenuWizard {
	/**
	 * Constructs the wizard with Web > HTML File.
	 */
	public NewCSSWizardDialog() {
		super("New CSS File", "Web", "CSS File");
	}
	
}