package com.example.logging.mylog;

import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class GeneralHandler {

	/**
	 * Determine whether the general handler is used or not
	 */
	@ConfigItem(defaultValue = "false")
	boolean enable;

	/**
	 * The unnamed handler's config
	 */
	@ConfigItem(name = ConfigItem.PARENT)
	Optional<HandlerConfig> handlerConfig;

	@Override
	public String toString() {
		return "GeneralHandler{" +
				"enable=" + enable +
				", handlerConfig=" + handlerConfig +
				'}';
	}
}
