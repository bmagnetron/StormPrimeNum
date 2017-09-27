package com.storm.url.stream.spring;

public interface ISpoutBoltBuilder {

	public void buildTopology(String spoutName, String boltName);
	public void submitTopology();
//	public <String>List Topology

}
