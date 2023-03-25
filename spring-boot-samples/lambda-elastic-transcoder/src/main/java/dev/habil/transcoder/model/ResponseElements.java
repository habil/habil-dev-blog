package dev.habil.transcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseElements {
    @JsonProperty("x-amz-request-id")
    String xAmzRequestId;
    @JsonProperty("x-amz-id-2")
    String xAmzId2;
}
