package com.muse.graphqldemo.config.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Base configuration for mongodb
 */
@EnableMongoRepositories(basePackages = "com.muse.graphqldemo.domain.repositories")
public abstract class BaseMongoConfiguration extends AbstractMongoClientConfiguration {
	
	/**
	 * Mongodb database name
	 */
	@Value("${mongodb.database}")
	private String mongoDatabase;

	/**
	 * add for enable index
	 */
	@Autowired
	public void mongoMappingContextFactory(MongoMappingContext mongoMappingContext) {
		mongoMappingContext.setAutoIndexCreation(true);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDatabase;
	}
	
	/**
	 * Creates a {@link MongoTransactionManager} bean.
	 *
	 * @param dbFactory
	 *        the {@link MongoDatabaseFactory } to use for the
	 *        {@code MongoTransactionManager} creation.
	 * @return the created {@code MongoTransactionManager}.
	 */
	@Bean
	public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}
}
