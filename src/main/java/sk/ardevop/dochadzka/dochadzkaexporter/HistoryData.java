package sk.ardevop.dochadzka.dochadzkaexporter;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class HistoryData {

  @JsonAlias("favicon_url")
  private String faviconUrl;
  @JsonAlias("page_transition")
  private String pageTransition;
  private String title;
  private String url;
  @JsonAlias("client_id")
  private String clientId;
  @JsonAlias("time_usec")
  private long timeUsec;
}
