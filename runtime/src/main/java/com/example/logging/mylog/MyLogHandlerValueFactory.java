package com.example.logging.mylog;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class MyLogHandlerValueFactory {
	private static final Logger LOG = Logger.getLogger(MyLogHandlerValueFactory.class);

	public RuntimeValue<Optional<Handler>> create(MyLogConfig mylogConfig) {
		if (mylogConfig.handlerConfig.enable && mylogConfig.handlerConfig.handlerConfig.isPresent()) {
			return new RuntimeValue<>(Optional.of(createHandler(mylogConfig.handlerConfig.handlerConfig.get())));
		}
		return new RuntimeValue<>(Optional.empty());
	}

	public RuntimeValue<Map<String, Handler>> createNamedHandlers(MyLogConfig mylogConfig) {
		return new RuntimeValue<>(mylogConfig.handlerConfigMap.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> createHandler(entry.getValue()))));
	}

	private Handler createHandler(HandlerConfig handlerConfig) {
		MyLogHandler handler = new MyLogHandler();
		handler.setLevel(handlerConfig.level);
		handler.setFilename(handlerConfig.filename);
		handler.setPort(handlerConfig.port);
		handler.setStandalone(handlerConfig.standalone);
		handler.setLocalDir(handlerConfig.localDir);
		handler.setFormatter(new SimpleFormatter());

		return handler;
	}
}
