package com.example.cryptocurrenciestask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FileWriterServiceImplTest {
    @InjectMocks
    private FileWriterServiceImpl fileWriterService;

    @Mock
    private ReportGeneratorService reportGeneratorService;

    @Test
    public void write_toFile_Ok() {
        Mockito.when(reportGeneratorService.generateReport()).thenReturn("test_report");
        fileWriterService.writeToCsv();
        List<String> actual = read();
        Assertions.assertEquals(actual.get(0), "test_report");
    }

    private List<String> read() {
        try {
           return Files.readAllLines(Path.of("result.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
