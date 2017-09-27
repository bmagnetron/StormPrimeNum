package com.storm.url.stream.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.*;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import com.storm.util.LoadTableDetails;
import com.storm.util.StaticLoadTableDetails;

public class SpringUrlSpout extends BaseRichSpout {

	private SpoutOutputCollector collector;
	private String url;
	private Values values;
	private String spoutName;
	//private LoadTableDetails lt;
	private StaticLoadTableDetails lt;

	@Override
	public void nextTuple() {

		
	/*	System.out.println("Url got: " + url);
		System.out.println("spoutNamepassed"+spoutName);*/
	//	values = (Values) Util.intializeBean(url);
	//	if (values == null) {
			/*
			 * values= (Values) Util .initializeContext("values");
			 */
		/*	System.out.println("Values is null");
			System.out.println("spoutNamepassed"+spoutName);*/
		//	url = lt.getMapping(spoutName);
			values = (Values) Util.intializeBean(url);
	//	}
		// System.out.println(spoutName);
		collector.emit(values);
		// collector.emit(new Values(new String(url)));

	}

	public Values getValues() {
		return values;
	}

	public void setValues(Values values) {
		this.values = values;
	}

	public SpoutOutputCollector getCollector() {
		return collector;
	}

	public void setCollector(SpoutOutputCollector collector) {
		this.collector = collector;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector outputcollector) {
	/*	System.out.println("Spring Spout Open ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Set<String> ComponentIds = context.getComponentIds();
		List<String> list = new ArrayList<String>(ComponentIds);
		String[] spoutNameArr = list.get(1).split("_");
		spoutName = spoutNameArr[0] + "_" + spoutNameArr[1];
		System.out.println(spoutName);*/
		Set<String> ComponentIds = context.getComponentIds();
		System.out.println("Spout open ++++++++++++++++++++++++++++++++"+ComponentIds.toString());
		System.out.println(context.getComponentId(context.getThisTaskId()));
		System.out.println(context.getThisTaskId());
		url = StaticLoadTableDetails.getMapping(context.getComponentId(context.getThisTaskId()));
	//	url = lt.getMapping(spoutName);
		this.collector = outputcollector;

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("url"));

	}

	public String getSpoutName() {
		return spoutName;
	}

	public void setSpoutName(String spoutName) {
		this.spoutName = spoutName;
	}

	public StaticLoadTableDetails getLt() {
		return lt;
	}

	public void setLt(StaticLoadTableDetails lt) {
		this.lt = lt;
	}

	/*public LoadTableDetails getLt() {
		return lt;
	}

	public void setLt(LoadTableDetails lt) {
		this.lt = lt;
	}*/
	
	

}
