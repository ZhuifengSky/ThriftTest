package com.micmiu.thrift.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;


public class HelloServerThreadDemo {
	public static final int SERVER_PORT = 8090;

	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");

			TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(
					new HelloWorldServiceImpl());

			// �򵥵ĵ��̷߳���ģ�ͣ�һ�����ڲ���
			TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			TThreadPoolServer.Args tArgs= new TThreadPoolServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// tArgs.protocolFactory(new TCompactProtocol.Factory());
			// tArgs.protocolFactory(new TJSONProtocol.Factory());
			TServer server = new TSimpleServer(tArgs);
			server.serve();

		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloServerThreadDemo server = new HelloServerThreadDemo();
		server.startServer();
	}

}
