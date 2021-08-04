package vat.springasyncannotation.controller;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vat.springasyncannotation.service.CpuInfoService;
import vat.springasyncannotation.service.MemoryInfoService;

//Simple Controller
@RestController
public class Program 
{
	
	@Autowired
	private MemoryInfoService memoryInfoService;
	
	@Autowired
	private CpuInfoService cpuInfoService;
	
	@GetMapping("/startFunctionsParallely")
	private String startFunctionsParallely() 
	{
		System.out.println("start");		 
			
		//As getUnits have already implemented @Async they will run parallely
		CompletableFuture < String > s1 = memoryInfoService.getUnits();		
		CompletableFuture < String > s2 = cpuInfoService.getUnits();

		//Get the status of s1 and s2
		System.out.println("memoryInfoService status: "+s1.toString());
		System.out.println("cpuInfoService status: "+s2.toString());
		
		//wait until s1 and s2 finished
		CompletableFuture.allOf(s1,s2).join();
		
		//Get the status of s1 and s2
		System.out.println("memoryInfoService status: "+s1.toString());
		System.out.println("cpuInfoService status: "+s2.toString());
		
		System.out.println("end");
		
		return "Started Functions Parallely";
	}
}
