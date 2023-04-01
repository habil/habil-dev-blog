package dev.habil.transcoder.function;


import dev.habil.transcoder.model.S3Event;
import dev.habil.transcoder.service.VideoTranscoderService;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VideoTranscoderFunction implements Function<S3Event, String> {

    private final VideoTranscoderService service;

    @Override
    public String apply(S3Event s3Event) {
        return service.start(s3Event);
    }
}
