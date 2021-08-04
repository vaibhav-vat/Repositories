package vat.springasyncannotation.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CpuInfoService 
{
	@Async("myAsyncExecutor")
	public CompletableFuture<String> ingest()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("CpuInfo: "+i);
			try 
			{
				Thread.sleep(1000);
				if(i==5)
				{
					return CompletableFuture.completedFuture("CpuInfo with 5");
				}
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		return CompletableFuture.completedFuture("CpuInfo not defined");	
	}

}