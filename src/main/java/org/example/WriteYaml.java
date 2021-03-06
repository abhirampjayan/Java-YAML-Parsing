package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WriteYaml {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper ;

        mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<OrderLine> lines = new ArrayList<>();
        lines.add(new OrderLine("Copper Wire (200ft)", 1,new BigDecimal(50.67).setScale(2, RoundingMode.HALF_UP)));
        lines.add(new OrderLine("Washers (1/4\")", 24, new BigDecimal(.15).setScale(2, RoundingMode.HALF_UP)));
        Order order = new Order("B-9910", LocalDate.parse("2019-04-18", DateTimeFormatter.ISO_DATE),"Customer, Jane", lines);
        mapper.writeValue(new File("src/main/resources/orderOutput.yaml"), order);
    }
}
