package com.storm.kafka;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.StringScheme;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
import java.util.Properties;

import org.apache.storm.spout.SchemeAsMultiScheme;

import backtype.storm.spout.RawScheme;




public class SpoutBuilder {
	
	public Properties configs = null;
	
	public SpoutBuilder(Properties configs) {
		this.configs = configs;
	}

public KafkaSpout buildKafkaSpout() {
	Properties configs;
	BrokerHosts hosts = new ZkHosts(configs.getProperty(Keys.KAFKA_ZOOKEEPER));
	String topic = configs.getProperty(Keys.KAFKA_TOPIC);
	String zkRoot = configs.getProperty(Keys.KAFKA_ZKROOT);
	String groupId = configs.getProperty(Keys.KAFKA_CONSUMERGROUP);
	SpoutConfig spoutConfig = new SpoutConfig(hosts, topic, zkRoot, groupId);
	spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
	KafkaSpout kafkaSpout = new KafkaSpout(spoutConfig);
	return kafkaSpout;
}
}