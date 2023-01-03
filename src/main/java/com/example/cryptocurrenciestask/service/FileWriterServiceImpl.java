package com.example.cryptocurrenciestask.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileWriterServiceImpl implements FileWriterService {
    private static final String RESULT_FILE = "result.csv";
    private final ReportGeneratorService reportGeneratorService;

    public FileWriterServiceImpl(ReportGeneratorService reportGeneratorService) {
        this.reportGeneratorService = reportGeneratorService;
    }

    @Override
    public String writeToCsv() {
        try {
            File file = new File(RESULT_FILE);
            String report = reportGeneratorService.generateReport();
            Files.write(file.toPath(), report.getBytes());
            return "Report is generated in: " + file.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to csv", e);
        }
    }
}
