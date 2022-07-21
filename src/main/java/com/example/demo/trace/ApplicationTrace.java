package com.example.demo.trace;

import lombok.Data;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "Application Trace")
public class ApplicationTrace {
    @Id
    private Long id;

    private HttpTrace trace;
}

