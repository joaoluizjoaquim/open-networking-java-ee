package org.gujavasc.opennetworking.test.event;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.messaging.jmq.io.Status;

public class EventIntegrationTest {

	@Test
	public void sample(){
		Response response = ClientBuilder.newClient().target("http://localhost:8080").request().get();
		Assert.assertEquals(Status.OK, response.getStatus());
	}
	
}
