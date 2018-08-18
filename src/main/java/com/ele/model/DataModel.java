package com.ele.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.immutables.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@SuppressWarnings("javadoc")
@EleImmutable
public interface DataModel {
    ObjectMapper OM = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .registerModule(new Jdk8Module());
    Logger LOG = LoggerFactory.getLogger(DataModel.class);

    @JsonIgnore
    @Value.Lazy
    default String toJSON() {
        return toJSON("");
    }

    @JsonIgnore
    @Value.Lazy
    default String toJSON(String defaultString) {
        try {
            return OM.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.error("Parsing JSON failed", e);
            return defaultString;
        }
    }

    @JsonIgnore
    static <T extends DataModel> T fromJSON(String json, Class<T> type) throws IOException {
        return OM.readValue(json, type);
    }

    @JsonIgnore
    static <T extends DataModel> T fromJSON(String json, Class<T> type, T defaultValue) {
        try {
            return OM.readValue(json, type);
        } catch (IOException e) {
            LOG.error("Unable to parse json string for " + type.getName(), e);
            return defaultValue;
        }
    }

}
