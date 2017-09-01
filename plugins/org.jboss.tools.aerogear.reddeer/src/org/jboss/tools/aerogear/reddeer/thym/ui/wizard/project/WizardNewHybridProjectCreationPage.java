/******************************************************************************* 
 * Copyright (c) 2017 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.aerogear.reddeer.thym.ui.wizard.project;

import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.jface.wizard.WizardPage;
import org.eclipse.reddeer.swt.impl.group.DefaultGroup;
import org.eclipse.reddeer.swt.impl.text.LabeledText;

public class WizardNewHybridProjectCreationPage extends WizardPage{
	
	
	public WizardNewHybridProjectCreationPage(ReferencedComposite referencedComposite) {
		super(referencedComposite);
		// TODO Auto-generated constructor stub
	}

	public void setProjectName(String projectName){
		new LabeledText(referencedComposite, "Project name:").setText(projectName);
	}
	
	public String getProjectName(){
		return new LabeledText(referencedComposite, "Project name:").getText();
	}
	
	public void setAppName(String appName){
		new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "Name:").setText(appName);
	}
	
	public String getAppName(){
		return new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "Name:").getText();
	}
	
	public void setAppID(String appId){
		new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "ID:").setText(appId);
	}
	
	public String getAppID(){
		return new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "ID:").getText();
	}
	
	public String getAppNameMessage(){
		return new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "Name:").getMessage();
	}
	
	public String getAppIDMessage(){
		return new LabeledText(new DefaultGroup(referencedComposite, "Mobile Application"), "ID:").getMessage();
	}
	
	

}
