package application;

import com.FinalProject.NewTransactionEvent;
import com.custom.aop.Async;
import com.custom.aop.EventListener;
import com.custom.aop.EventService;

@EventService
public class PublishEventService {

	@Async
	@EventListener
	public void receiveMessage(NewTransactionEvent event) {
		System.out.println("Receive Transaction event: " + event.getTransaction().getName());
	}
}
