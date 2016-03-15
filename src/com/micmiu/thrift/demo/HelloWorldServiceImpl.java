package com.micmiu.thrift.demo;

import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface{

	@Override
	public String sayHello(String username) throws TException {
		return "Hello,"+username+"! I'm  Thrift Test Demo.";
	}

}
