package TO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonSerializer implements Serializer<Person> {

	@Override
	public byte[] serialize(String topic, Person data) {
		if (data == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
	    try {
	      return mapper.writeValueAsBytes(data);
	    } catch (JsonProcessingException e) {
	      throw new RuntimeException("Error serializing Person object", e);
	    }
	}
	
}
