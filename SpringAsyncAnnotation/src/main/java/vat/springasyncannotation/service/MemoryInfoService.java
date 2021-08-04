package vat.springasyncannotation.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MemoryInfoService
{
	@Async("myAsyncExecutor")
	public CompletableFuture<String> getUnits()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Memory: "+i);
			try 
			{
				Thread.sleep(1000);
				if(i==5)
				{
					return CompletableFuture.completedFuture("Memory with 5");
				}
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		return CompletableFuture.completedFuture("Memory not defined");		
	}

}