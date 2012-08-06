package net.frontlinesms.plugins.credit;

import java.util.Arrays;
import java.util.List;

import net.frontlinesms.firstrun.ui.FirstTimeWizard;
import net.frontlinesms.firstrun.ui.FirstTimeWizardPage;
import net.frontlinesms.firstrun.ui.FirstTimeWizardPageProvider;

public class CreditFirstTimeWizardPageProvider implements FirstTimeWizardPageProvider {
	private FirstTimeWizard ui;
	
	public void setOwner(FirstTimeWizard firstTimeWizard) {
		this.ui = firstTimeWizard;
	}
	
	public List<FirstTimeWizardPage> getPages() {
		return Arrays.asList(new FirstTimeWizardPage[] {
			new CreditPreferencesConfigurationPage(ui),
		});
	}
}
