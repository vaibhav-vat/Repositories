package vat.springasyncannotation.async_config;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class MyAsyncConfiguration
{
    
    /** The Constant ASYNCH_THREAD. */
    private static final String ASYNCH_THREAD = "AsynchThread-";

	/**
	 * Async executor.
	 *
	 * @return the executor
	 */
	@Bean(name = "myAsyncExecutor")
    public Executor asyncExecutor() 
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix(ASYNCH_THREAD);
        executor.initialize();
        return executor;
    }
}