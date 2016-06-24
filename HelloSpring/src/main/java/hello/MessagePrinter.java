package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	final private MessageService serv;
	
	@Autowired
	public MessagePrinter(MessageService serv){
		this.serv=serv;
	}

	public void printMessage() {
		// TODO Auto-generated method stub
		System.out.println(this.serv.getMessage());
	}

}
