//Spring Framework
//Core support for dependency injection, transaction management, web applications, 
//data access, messaging, testing and more.

//The example above shows the basic concept of dependency injection, 
//the MessagePrinter is decoupled from the MessageService implementation, 
//with Spring Framework wiring everything together.

//Once you've set up your build with the spring-context dependency, 
//you'll be able to do the following:
package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
	@Bean
	MessageService mockMessageService(){
		return new MessageService(){
			public String getMessage()
			{
				return "Hello Spring";
			}
		};
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer=context.getBean(MessagePrinter.class);
		printer.printMessage();

	}

}
