package org.gujavasc.opennetworking.event;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.gujavasc.opennetworking.utils.LinkBuilder;

@Provider
@Produces(value = MediaType.APPLICATION_JSON)
public class EventDetailResource implements MessageBodyWriter<Event> {
	@Context
	private UriInfo uriInfo;

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	@Override
	@Deprecated
	public long getSize(Event t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(Event t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		JsonGenerator gen = Json.createGenerator(entityStream);
		gen.writeStartObject()
			.write("id", t.getId())
			.write("name", t.getName())
			.write("totalParticipants",t.getTotalParticipants())
		.writeEnd();
		gen.flush();
	}
}