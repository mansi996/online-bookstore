
//REST - 

package com.example.RestExample.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	//GET
	//URL --> /hello-world
	//method --> "Hello-World"
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world") 
	//either this or next line
	
	@GetMapping(path="/hello-world")
	public String HelloWorld()
	{
		return "Hello- World";
	}
	
	//now I create a simple hello world which is using the bean -it will return the 
	//result in JSON format.
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World bean");
	}
	
	//now we are making the use of the path variabe i.e if I write my url path as 
	// path= /hello-world-variable/nameOfVariable(mansi) then what will happen is 
	//I would be returned with 
	//JSON result saying {message: hello-world,variableName(mansi)}
	
	//Important to note - I'm making use of HelloWorldBean class to return the message 
	@GetMapping(path="/hello-world/{name}")
	public HelloWorldBean helloWorldVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("HelloWorld, %s",name));
	}
	
	
}
