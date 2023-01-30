package es.nhs.alquilerhardware.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 13/12/2022
 */
@Service
public class JsonUtils
{

    /* Attribute - Logger */
    private final Logger LOGGER = LogManager.getLogger();

    /**
     * Parse an object to JSON in Pretty format
     *
     * @param objectToJson object to be parsed
     * @return String with JSON in Pretty format
     * @throws ReservaException
     */
    public String writeObjectToJsonAsStringPretty(Object objectToJson) throws ReservaException
    {
        String resultJsonAsString = "";
        try
        {
            // Write Result Pretty Format
            resultJsonAsString = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectToJson);
        }
        catch (JsonProcessingException jsonProcessingException)
        {
            throw new ReservaException("Error a la Hora de transformar el objeto a Json" , "",jsonProcessingException);
        }

        return resultJsonAsString;
    }

}
