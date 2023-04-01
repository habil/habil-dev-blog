package dev.habil.transcoder.service;


import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoder;
import com.amazonaws.services.elastictranscoder.model.CreateJobOutput;
import com.amazonaws.services.elastictranscoder.model.CreateJobRequest;
import com.amazonaws.services.elastictranscoder.model.CreateJobResult;
import com.amazonaws.services.elastictranscoder.model.JobInput;
import dev.habil.transcoder.model.S3Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoTranscoderService {

    private final AmazonElasticTranscoder transcoder;

    public String start(S3Event request) {
        CreateJobResult result = new CreateJobResult();
        try {
            var key = request.getRecords().get(0).getS3().getObject().getKey();
            result = transcoder.createJob(getCreateJobRequest(key));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result.toString();
    }


    private CreateJobRequest getCreateJobRequest(String key) {
        var fileName = key.split("/")[1];
        CreateJobRequest job = new CreateJobRequest();
        job.setPipelineId("PIPELINE-ID");
        job.setOutputKeyPrefix("S3-OUTPUT-FOLDER");
        //input
        JobInput input = new JobInput();
        input.setKey(key);
        input.setFrameRate("auto");
        input.setResolution("auto");
        input.setAspectRatio("auto");
        input.setInterlaced("auto");
        input.setContainer("auto");
        job.setInput(input);

        //outputs
        CreateJobOutput output = new CreateJobOutput();
        output.setPresetId("PRESET-ID");
        output.setKey(fileName);

        job.setOutput(output);
        return job;
    }
}
