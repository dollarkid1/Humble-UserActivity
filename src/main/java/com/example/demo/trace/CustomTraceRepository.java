package com.example.demo.trace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {
    @Autowired
    private ApplicationTraceRepo traceRepo;

    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

    @Override
    public List<HttpTrace> findAll() {

        List<ApplicationTrace> applicationTraces = traceRepo.findAll();
        List<HttpTrace> traces = new ArrayList<>();
        applicationTraces.forEach(tx ->
                traces.add(tx.getTrace())
        );
        return traces;
    }

    @Override
    public void add(HttpTrace trace) {
        ApplicationTrace appTrace = new ApplicationTrace();
        appTrace.setTrace(trace);
        traceRepo.save(appTrace);

    }
}

