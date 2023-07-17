package com.example.BlogMode.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface ExcelService {
    public ByteArrayInputStream getActualData() throws IOException;
}
