package dev.habil.transcoder.model;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Record {
    String eventVersion;
    String eventSource;
    String awsRegion;
    Date eventTime;
    String eventName;
    UserIdentity userIdentity;
    RequestParameters requestParameters;
    ResponseElements responseElements;
    S3 s3;
}
