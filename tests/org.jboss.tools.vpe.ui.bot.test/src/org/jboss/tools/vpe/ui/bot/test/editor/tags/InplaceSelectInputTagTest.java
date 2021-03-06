/*******************************************************************************
 * Copyright (c) 2007-2016 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.vpe.ui.bot.test.editor.tags;

import org.jboss.reddeer.common.wait.AbstractWait;
import org.jboss.reddeer.common.wait.TimePeriod;

/**
 * Tests Rich Faces InplaceSelectInput Tag behavior
 * 
 * @author vlado pakan
 *
 */
public class InplaceSelectInputTagTest extends AbstractTagTest {
	private static final String defaultLabel = "DefaultLabel";
	private static final String option1 = "Option 1";
	private static final String option2 = "Option 2";

	@Override
	protected void initTestPage() {
		initTestPage(TestPageType.JSP,
				"<%@ taglib uri=\"http://java.sun.com/jsf/html\" prefix=\"h\" %>\n"
						+ "<%@ taglib uri=\"http://java.sun.com/jsf/core\" prefix=\"f\" %>\n"
						+ "<%@ taglib uri=\"http://richfaces.org/rich\" prefix=\"rich\" %>\n" + "<html>\n"
						+ "  <head>\n" + "  </head>\n" + "  <body>\n" + "    <f:view>\n"
						+ "      <rich:inplaceSelect value=\"0\" defaultLabel=\"" + defaultLabel + "\">\n"
						+ "        <f:selectItem itemValue=\"0\" itemLabel=\"" + option1 + "\" />\n"
						+ "        <f:selectItem itemValue=\"1\" itemLabel=\"" + option2 + "\" />\n"
						+ "      </rich:inplaceSelect>\n" + "    </f:view>\n" + "  </body>\n" + "</html>");
	}

	@Override
	protected void verifyTag() {
		assertVisualEditorContains(getVisualEditor(), "SPAN", new String[] { "vpe-user-toggle-id", "title", "class" },
				new String[] { "false", "rich:inplaceSelect value: 0 defaultLabel: " + defaultLabel,
						"rich-inplace-select rich-inplace-select-view" },
				getTestPageFileName());
		assertVisualEditorContainsNodeWithValue(getVisualEditor(), defaultLabel, getTestPageFileName());
		// check tag selection
		getVisualEditor().selectDomNode(getVisualEditor().getDomNodeByTagName("SPAN", 2), 0);
		AbstractWait.sleep(TimePeriod.getCustom(3));
		String selectedText = getSourceEditor().getSelectedText();
		final String hasToStartWith = "<rich:inplaceSelect value=\"0\" defaultLabel=\"" + defaultLabel + "\">";
		assertTrue("Selected text in Source Pane has to start with '" + hasToStartWith + "'" + "\nbut it is '"
				+ selectedText + "'", selectedText.trim().startsWith(hasToStartWith));
		final String hasEndWith = "</rich:inplaceSelect>";
		assertTrue("Selected text in Source Pane has to end with '" + hasEndWith + "'" + "\nbut it is '" + selectedText
				+ "'", selectedText.trim().endsWith(hasEndWith));
		// Click on tag and check correct tag displaying
		getVisualEditor().mouseClickOnNode(getVisualEditor().getDomNodeByTagName("SPAN", 2));
		AbstractWait.sleep(TimePeriod.getCustom(3));
		assertVisualEditorContains(getVisualEditor(), "SPAN", new String[] { "vpe-user-toggle-id", "class" },
				new String[] { "true", "rich-inplace-select rich-inplace-select-edit" }, getTestPageFileName());
		assertVisualEditorContainsNodeWithValue(getVisualEditor(), option1, getTestPageFileName());
		assertVisualEditorContainsNodeWithValue(getVisualEditor(), option2, getTestPageFileName());
		assertVisualEditorNotContainNodeWithValue(getVisualEditor(), defaultLabel, getTestPageFileName());
		selectedText = getSourceEditor().getSelectedText();
		// check tag selection
		assertTrue("Selected text in Source Pane has to start with '" + hasToStartWith + "'" + "\nbut it is '"
				+ selectedText + "'", selectedText.trim().startsWith(hasToStartWith));
		assertTrue("Selected text in Source Pane has to end with '" + hasEndWith + "'" + "\nbut it is '" + selectedText
				+ "'", selectedText.trim().endsWith(hasEndWith));
	}

}
