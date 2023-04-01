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
public class S3 {
    String s3SchemaVersion;
    String configurationId;
    Bucket bucket;
    @JsonProperty("object")
    S3Object object;
}
