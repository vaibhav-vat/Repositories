package vat.springasyncannotation.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vat.springasyncannotation.service.CpuInfoService;
import vat.springasyncannotation.service.MemoryInfoService;


@RestController
public class Program 
{
	@Autowired
	private MemoryInfoService m;
	
	@Autowired
	private CpuInfoService c;
	
	@GetMapping("/1")
	private String getstatus() 
	{
		System.out.println("start");		 
		
		
		CompletableFuture < String > s1 = m.ingest();
		
		CompletableFuture < String > s2 = c.ingest();
		
		System.out.println(s2.toString());
		
		CompletableFuture.allOf(s1,s2).join();
		
		System.out.println(s1);
		
		System.out.println("end");
		return "hello";
	}
}
