package com.example.logging.mylog;

import java.util.logging.Level;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class HandlerConfig {

	/**
	 * The handler's log level
	 */
	@ConfigItem(defaultValue = "DEBUG")
	public Level level;

	/**
	 * The filename
	 */
	@ConfigItem
	public String filename;

	/**
	 * The dir for local logs
	 */
	@ConfigItem
	public String localDir;

	/**
	 * The remote port
	 */
	@ConfigItem
	public Integer port;

	/**
	 * standalone
	 */
	@ConfigItem
	public Boolean standalone;

	@Override
	public String toString() {
		return "HandlerConfig{" +
				"level=" + level +
				", filename='" + filename + '\'' +
				", localDir='" + localDir + '\'' +
				", port=" + port +
				", standalone=" + standalone +
				'}';
	}
}
