/*******************************************************************************
 * Copyright (c) 2016 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.vpe.bot.test;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.reddeer.common.platform.RunningPlatform;
import org.eclipse.reddeer.common.wait.TimePeriod;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.common.wait.WaitWhile;
import org.eclipse.reddeer.workbench.core.condition.JobIsRunning;
import org.eclipse.reddeer.eclipse.jst.servlet.ui.project.facet.WebProjectFirstPage;
import org.eclipse.reddeer.eclipse.jst.servlet.ui.project.facet.WebProjectWizard;
import org.eclipse.reddeer.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.reddeer.eclipse.ui.views.log.LogMessage;
import org.eclipse.reddeer.eclipse.ui.views.log.LogView;
import org.eclipse.reddeer.eclipse.wst.html.ui.wizard.NewHTMLFileWizardPage;
import org.eclipse.reddeer.eclipse.wst.html.ui.wizard.NewHTMLTemplatesWizardPage;
import org.eclipse.reddeer.eclipse.wst.html.ui.wizard.NewHTMLWizard;
import org.eclipse.reddeer.requirements.cleanworkspace.CleanWorkspaceRequirement.CleanWorkspace;
import org.eclipse.reddeer.workbench.impl.editor.TextEditor;

@CleanWorkspace
public class VPETestBase {
	
	protected static String PROJECT_NAME = "WebProject";
	
	public static void createWebProject() {
		WebProjectWizard ww = new WebProjectWizard();
		ww.open();
		WebProjectFirstPage fp  = new WebProjectFirstPage(ww);
		fp.setProjectName(PROJECT_NAME);
		ww.finish();
		new WaitUntil(new JobIsRunning(),TimePeriod.DEFAULT, false);
		new WaitWhile(new JobIsRunning(),TimePeriod.LONG);
	}
	
	public void checkNoErrors(){
		LogView lw = new LogView();
		lw.open();
		List<LogMessage> lms = lw.getErrorMessages();
		if(lms.size() == 1){
			assertTrue(lms.get(0).getMessage().contains("No log entry found within maximum log size")); //this is ok
		} else {
			assertTrue(lw.getErrorMessages().isEmpty());
		}
	}
	
	public static String createHTMLPageWithJS(){
		String pageName = createHTMLPage(null);
		addJQueryToPage(pageName);
		return pageName;
	}
	
	public static String createHTMLPage(String template){
		ProjectExplorer pe = new ProjectExplorer();
		pe.open();
		pe.selectProjects(PROJECT_NAME);
		NewHTMLWizard nw = new NewHTMLWizard();
		nw.open();
		NewHTMLFileWizardPage fp = new NewHTMLFileWizardPage(nw);
		String pageName = fp.getFileName();
		nw.next();
		if(template != null){
			NewHTMLTemplatesWizardPage tp = new NewHTMLTemplatesWizardPage(nw);
			tp.setTemplate(template);
		}
		nw.finish();
		return pageName;
	}
	
	private static void addJQueryToPage(String pageName){
		TextEditor te = new TextEditor(pageName);
		
		te.insertText(3, 0, "<script src=\"http://code.jquery.com/jquery-1.11.2.min.js\"></script>");
		
		te.save();
	}
	
	public static boolean isLinux(){
		return RunningPlatform.isLinux();
	}
	
	public static boolean isOSX(){
		return RunningPlatform.isOSX();
	}
	
	public static boolean isGTK2(){
		String isGTK3 = System.getProperty("SWT_GTK3");
		Boolean isLinux = RunningPlatform.isLinux();
		
		return isLinux && "0".equals(isGTK3);
	}

}
