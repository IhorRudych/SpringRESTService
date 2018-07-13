package hello;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Beutiful City") String name) {
        String[] strings2 = {"Rome", "Paris", "London", "Kyiv", "Madrid", "Berlin", "Helsinki", "Oslo", "Amsterdam", "Athens", "Kopenhagen", "Prague", "Warsaw", "Budapest", "World"};
		
        Random r = new Random();
        int Low = 0;
        int High = 15;
        int r2 = r.nextInt(High-Low) + Low;
		
        return new Greeting(counter.incrementAndGet(),
          String.format(template, strings2[r2])); 
        
    }
}
