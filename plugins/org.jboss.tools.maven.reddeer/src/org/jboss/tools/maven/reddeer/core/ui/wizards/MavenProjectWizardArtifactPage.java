package org.jboss.tools.maven.reddeer.core.ui.wizards;

import org.jboss.reddeer.jface.wizard.WizardPage;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.group.DefaultGroup;

public class MavenProjectWizardArtifactPage extends WizardPage{
	
	/**
	 * Set project group id
	 * @param groupId
	 */
	public void setGroupId(String groupId){
		new LabeledCombo(new DefaultGroup("Artifact"),"Group Id:").setText(groupId);
	}

	/**
	 * Set project artifact id
	 * @param artifactId
	 */
	public void setArtifactId(String artifactId){
		new LabeledCombo(new DefaultGroup("Artifact"),"Artifact Id:").setText(artifactId);
	}
	
	/**
	 * Set project version
	 * @param version
	 */
	public void setVersion(String version){
		new LabeledCombo(new DefaultGroup("Artifact"),"Version:").setText(version);
	}
	
	/**
	 * Get project group id
	 * @return project group id
	 */
	public String getGroupId(){
		return new LabeledCombo(new DefaultGroup("Artifact"),"Group Id:").getText();
	}
	
	/**
	 * Get project artifact id
	 * @return project artifact id
	 */
	public String getArtifactId(){
		return new LabeledCombo(new DefaultGroup("Artifact"),"Artifact Id:").getText();
	}
	
	/**
	 * Get project version
	 * @return project version
	 */
	public String getVersion(){
		return new LabeledCombo(new DefaultGroup("Artifact"),"Version:").getText();
	}
	
	public void setPackaging(String packaging){
		new LabeledCombo(new DefaultGroup("Artifact"),"Packaging:").setText(packaging);
	}

}
