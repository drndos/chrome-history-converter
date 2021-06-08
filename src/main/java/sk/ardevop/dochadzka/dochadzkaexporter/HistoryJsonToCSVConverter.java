package sk.ardevop.dochadzka.dochadzkaexporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

public class HistoryJsonToCSVConverter {

  public static void main(String[] args)
      throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
    ObjectMapper objectMapper = new ObjectMapper();
    BrowserHistory browserHistory = objectMapper.readValue(new File("BrowserHistory-ardevop.json"), BrowserHistory.class);

    Path exportPath = Paths.get("history-ardevop.csv");
    Writer writer = new FileWriter(exportPath.toString());

    StatefulBeanToCsv<HistoryDataCsv> sbc = new StatefulBeanToCsvBuilder<HistoryDataCsv>(writer)
        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
        .build();
    sbc.write(browserHistory.getBrowserHistory().stream()
        .map(bh -> HistoryDataCsv.builder()
            .clientId(bh.getClientId())
            .date(Date.from(Instant.ofEpochMilli(bh.getTimeUsec()/1000)))
            .faviconUrl(bh.getFaviconUrl())
            .title(bh.getTitle())
            .pageTransition(bh.getPageTransition())
            .url(bh.getUrl())
            .build()
        ).collect(Collectors.toList()));
    writer.close();
  }

}
