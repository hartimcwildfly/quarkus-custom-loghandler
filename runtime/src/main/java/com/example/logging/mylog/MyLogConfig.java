package com.example.logging.mylog;

import java.util.Map;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

/**
 * Configuration for MyLog logging.
 */
@ConfigRoot(phase = ConfigPhase.RUN_TIME, name = "log")
public class MyLogConfig {

	/**
	 * The unnamed handler
	 */
	@ConfigItem(name = "mylog")
	public GeneralHandler handlerConfig;

	/**
	 * The named handlers
	 */
	@ConfigItem(name = "handler.mylog")
	public Map<String, HandlerConfig> handlerConfigMap;

	@Override
	public String toString() {
		return "MyLogConfig{" +
				"handlerConfig=" + handlerConfig +
				", handlerConfigMap=" + handlerConfigMap +
				'}';
	}
}
