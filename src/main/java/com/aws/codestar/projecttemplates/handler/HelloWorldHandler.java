package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.aws.codestar.benchmarks.BenchMark;
import com.aws.codestar.projecttemplates.GatewayResponse;
import org.json.JSONObject;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.RunnerException;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        BenchMark bm = new BenchMark();
        try {
            bm.main();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new GatewayResponse(new JSONObject().put("Output", "Hello World!").toString(), headers, 200);
    }
}
