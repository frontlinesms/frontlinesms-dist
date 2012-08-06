/**
 * 
 */
package net.frontlinesms;

import org.springframework.context.ApplicationContext;


import net.frontlinesms.events.EventBus;
import net.frontlinesms.junit.BaseTestCase;
import net.frontlinesms.plugins.PluginController;
import net.frontlinesms.plugins.PluginInitialisationException;
import net.frontlinesms.plugins.forms.FormsPluginController;
import net.frontlinesms.plugins.httptrigger.HttpTriggerPluginController;
import net.frontlinesms.plugins.reminders.RemindersPluginController;
import net.frontlinesms.plugins.reminders.data.repository.ReminderDao;
import net.frontlinesms.plugins.translation.TranslationPluginController;

import static org.mockito.Mockito.*;


/**
 * @author Alex Anderson <alex@frontlinesms.com>
 */
public class PluginLoadingTest extends BaseTestCase {
	/** Test loading of all the plugins 
	 * @throws PluginInitialisationException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException */
	public void testPluginLoading() throws PluginInitialisationException, InstantiationException, IllegalAccessException {
		FrontlineSMS frontlineController = getMockFrontlineController();
		ApplicationContext applicationContext = getMockApplicationContext();

		Class<?>[] controllerClasses = new Class<?>[] {
			TranslationPluginController.class,
			FormsPluginController.class,
			RemindersPluginController.class,
			HttpTriggerPluginController.class,
		};
		
		for(Class<?> c : controllerClasses) {
			PluginController p = (PluginController) c.newInstance();
			p.init(frontlineController, applicationContext);
		}
	}

	private ApplicationContext getMockApplicationContext() {
		ApplicationContext c = mock(ApplicationContext.class);
		
		EventBus eventBus = mock(EventBus.class);
		when(c.getBean("eventBus")).thenReturn(eventBus);
		
		doRemindersSetup(c);
		return c;
	}

	private void doRemindersSetup(ApplicationContext c) {
		ReminderDao dao = mock(ReminderDao.class);
		when(c.getBean("reminderDao")).thenReturn(dao);
	}

	private FrontlineSMS getMockFrontlineController() {
		FrontlineSMS f = mock(FrontlineSMS.class);
		
		return f;
	}
}
