package sk.ardevop.dochadzka.dochadzkaexporter;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HistoryDataCsv {

  private final String faviconUrl;
  private final String pageTransition;
  private final String title;
  private final String url;
  private final String clientId;
  private final Date date;
}
