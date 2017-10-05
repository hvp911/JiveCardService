package net.rest.exception;

import com.google.inject.AbstractModule;
import net.rest.exception.ApiExceptionMapper;

/**
 * ErrorHandlingModule to handle customized exception responses.
 */
public class ErrorHandling extends AbstractModule {
	@Override
	protected void configure() {
		bind(ApiExceptionMapper.class).toInstance(new ApiExceptionMapper());
		bind(ThrowableExceptionMapper.class).toInstance(new ThrowableExceptionMapper());
	}
}
