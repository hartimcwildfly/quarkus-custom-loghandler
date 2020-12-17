package com.example.logging.mylog.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.LogHandlerBuildItem;
import io.quarkus.deployment.builditem.NamedLogHandlersBuildItem;
import com.example.logging.mylog.MyLogConfig;
import com.example.logging.mylog.MyLogHandlerValueFactory;

class MyLogProcessor {

	private static final String FEATURE = "mylog";

	@BuildStep
	FeatureBuildItem feature() {
		return new FeatureBuildItem(FEATURE);
	}

	@BuildStep
	@Record(ExecutionTime.RUNTIME_INIT)
	LogHandlerBuildItem addRLogHandler(final MyLogConfig mylogConfig,
			MyLogHandlerValueFactory mylogHandlerValueFactory) {
		return new LogHandlerBuildItem(mylogHandlerValueFactory.create(mylogConfig));
	}

	@BuildStep
	@Record(ExecutionTime.RUNTIME_INIT)
	NamedLogHandlersBuildItem addRLogHandlers(final MyLogConfig mylogConfig,
			MyLogHandlerValueFactory mylogHandlerValueFactory) {
		return new NamedLogHandlersBuildItem(mylogHandlerValueFactory.createNamedHandlers(mylogConfig));
	}
}
