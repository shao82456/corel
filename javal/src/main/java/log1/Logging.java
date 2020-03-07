package log1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Logging {
    Logger log = LoggerFactory.getLogger(Logging.class);
}