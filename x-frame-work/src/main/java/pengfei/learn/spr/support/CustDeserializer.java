package pengfei.learn.spr.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

import java.io.IOException;

public class CustDeserializer<T> extends JsonDeserializer<T> {
    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String text = p.getText();
        String name = p.getCurrentName();

        return null;
    }

    /**
     * Deserialization called when type being deserialized is defined to
     * contain additional type identifier, to allow for correctly
     * instantiating correct subtype. This can be due to annotation on
     * type (or its supertype), or due to global settings without
     * annotations.
     * <p>
     * Default implementation may work for some types, but ideally subclasses
     * should not rely on current default implementation.
     * Implementation is mostly provided to avoid compilation errors with older
     * code.
     *
     * @param p
     * @param ctxt
     * @param typeDeserializer Deserializer to use for handling type information
     */
    @Override
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return super.deserializeWithType(p, ctxt, typeDeserializer);
    }
}
