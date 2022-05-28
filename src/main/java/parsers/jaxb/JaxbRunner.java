package parsers.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parsers.models.ServiceStation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbRunner {
    private static final Logger LOGGER = LogManager.getLogger(JaxbRunner.class);

    public static void marshal(ServiceStation serviceStation) {
        try {
            JAXBContext context = JAXBContext.newInstance(ServiceStation.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(serviceStation, new File(System.getProperty("user.dir") + "/src/main/resources/testJaxb.xml"));
        } catch (JAXBException e){
            LOGGER.info(e);
        }
    }
    public static ServiceStation unmarhall() throws FileNotFoundException, JAXBException {
            JAXBContext context = JAXBContext.newInstance(ServiceStation.class);
            return (ServiceStation) context.createUnmarshaller()
                    .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/testJaxb.xml"));
    }
}
