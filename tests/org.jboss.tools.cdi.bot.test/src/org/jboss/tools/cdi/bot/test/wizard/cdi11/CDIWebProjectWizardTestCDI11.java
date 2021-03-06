package org.jboss.tools.cdi.bot.test.wizard.cdi11;

import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerReqType;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.reddeer.eclipse.ui.perspectives.JavaEEPerspective;
import org.jboss.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.jboss.reddeer.requirements.server.ServerReqState;
import org.jboss.tools.cdi.bot.test.wizard.template.CDIWebProjectWizardTemplate;

@OpenPerspective(JavaEEPerspective.class)
@JBossServer(state=ServerReqState.PRESENT, type=ServerReqType.WILDFLY10x, cleanup=false)
public class CDIWebProjectWizardTestCDI11 extends CDIWebProjectWizardTemplate{
	
	public CDIWebProjectWizardTestCDI11(){
		CDIVersion = "1.2";
	}
	
	

}
