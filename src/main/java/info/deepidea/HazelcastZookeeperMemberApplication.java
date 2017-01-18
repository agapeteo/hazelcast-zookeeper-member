package info.deepidea;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Iterator;


@Data
@SpringBootApplication
@ConfigurationProperties
public class HazelcastZookeeperMemberApplication {

	@Value("${ZOOKEEPER_URL:localhost:2181}")
	private String zookeeperUrl;

	@Value("${ZOOKEEPER_PATH:/discovery/hazelcast}")
	private String zookeeperPath;

	@Value("${ZOOKEEPER_GROUP:defaultHazelcastGroup}")
	private String zookeeperGroup;


	public static void main(String[] args) {
		SpringApplication.run(HazelcastZookeeperMemberApplication.class, args);
	}

	@Bean
	public HazelcastInstance hazelcastInstance(){
		XmlConfigBuilder xmlClientConfigBuilder = new XmlConfigBuilder();

		Config config = xmlClientConfigBuilder.build();
		NetworkConfig networkConfig = config.getNetworkConfig();
		JoinConfig joinConfig = networkConfig.getJoin();
		DiscoveryConfig discoveryConfig = joinConfig.getDiscoveryConfig();
		Collection<DiscoveryStrategyConfig> discoveryStrategyConfigs = discoveryConfig.getDiscoveryStrategyConfigs();
		Iterator<DiscoveryStrategyConfig> iterator = discoveryStrategyConfigs.iterator();
		DiscoveryStrategyConfig strategyConfig = iterator.next();

		strategyConfig.addProperty("zookeeper_url", zookeeperUrl);
		strategyConfig.addProperty("zookeeper_path", zookeeperPath);
		strategyConfig.addProperty("group", zookeeperGroup);


		return Hazelcast.newHazelcastInstance(config);
	}

}
