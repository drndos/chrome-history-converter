package sk.ardevop.dochadzka.dochadzkaexporter;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Data;

@Data
public class BrowserHistory {

  @JsonAlias("Browser History")
  private List<HistoryData> browserHistory;
}
