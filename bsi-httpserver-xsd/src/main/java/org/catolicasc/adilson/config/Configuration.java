package org.catolicasc.adilson.config;

import lombok.val;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

	static final String CONF_REFERENCE = "config/reference";

	public static Config loadConfiguration() {
		val defaultConfiguration = ConfigFactory.load( "config/application" );
		return defaultConfiguration.withFallback( ConfigFactory.load( CONF_REFERENCE ) );
	}

	public static Config loadConfiguration( String rootName ) {
		val defaultConfiguration = loadConfiguration();
		return loadConfiguration( rootName, defaultConfiguration );
	}

	public static Config loadConfiguration( String rootName, Config defaultConfiguration ) {
		val config = defaultConfiguration.getConfig( rootName );
		return config.withFallback( defaultConfiguration );
	}
}