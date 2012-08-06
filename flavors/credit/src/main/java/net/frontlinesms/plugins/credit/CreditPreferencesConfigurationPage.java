package net.frontlinesms.plugins.credit;

import org.creditsms.plugins.paymentview.PaymentViewPluginController;

import net.frontlinesms.firstrun.ui.FirstTimeWizard;
import net.frontlinesms.firstrun.ui.FirstTimeWizardPage;
import net.frontlinesms.plugins.PluginProperties;
import net.frontlinesms.ui.UiProperties;

public class CreditPreferencesConfigurationPage extends FirstTimeWizardPage {
	private static final String PLUGIN_NAME = PaymentViewPluginController.class.getName();
	private static final String HOME_TAB_LOGO_PATH = "classpath:/icons/credit-hometablogo.png";

	public CreditPreferencesConfigurationPage(FirstTimeWizard ui) {
		super(ui);
	}

	@Override
	public void initContent() {}

	@Override
	public String getLayoutFile() {
		return "/ui/plugins/credit/firsttime/configure.xml";
	}
	
//> UI EVENT METHODS
	public void next() {
		PluginProperties pluginProperties = PluginProperties.getInstance();
		pluginProperties.setPluginEnabled(PLUGIN_NAME, true);
		pluginProperties.saveToDisk();
		
		UiProperties uiProperties = UiProperties.getInstance();
		uiProperties.setHometabCustomLogo(true);
		uiProperties.setHometabLogoPath(HOME_TAB_LOGO_PATH);
		uiProperties.saveToDisk();
		
		ui.gotoNextPage();
	}
}
