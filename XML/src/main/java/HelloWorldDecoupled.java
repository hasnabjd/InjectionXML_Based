import Factories.MessageSupportFactory;
import Providers.MessageProvider;
import Renderers.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class HelloWorldDecoupled {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageRenderer mr = context.getBean("messageRenderer", MessageRenderer.class);
        MessageProvider mp = context.getBean("messageProvider", MessageProvider.class);

        mr.setMessageProvider(mp);
        mr.render();
    }
}
