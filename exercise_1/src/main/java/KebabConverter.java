import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KebabConverter {

    private static Logger logger = LoggerFactory.getLogger("kebab");

    /**
     * Converts a text into kebab case.
     * Example: "Kebab Case" into "kebab-case".
     *
     * @param value
     * @return converted string
     */
    public String convertToKebabCase(String value) {
        logger.info("calling convert to kebab with {}", value);
        String throwAwayChars = "()[]{}=?!.:,-_+\\\"#~/";
        value = value.replaceAll("[" + Pattern.quote(throwAwayChars) + "]", " ");
        value = value.toLowerCase();
        return value.trim().replaceAll("\\s+", "-");
    }
}