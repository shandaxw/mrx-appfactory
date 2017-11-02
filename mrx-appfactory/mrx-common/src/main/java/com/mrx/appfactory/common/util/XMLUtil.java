package com.mrx.appfactory.common.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author xuwen
 *
 */
public class XMLUtil {

    /**
     * Bean 2 XML.
     *
     * @param obj the obj
     * @return the string
     * @throws JAXBException the JAXB exception
     * @throws Exception the exception
     */
    public static String bean2XML(Object obj) throws JAXBException, Exception {
        String result = null;
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return result;
    }

    /**
     * XML 2 bean.
     *
     * @param c the c
     * @param xmlString the xml string
     * @return the object
     * @throws JAXBException the JAXB exception
     */
    public static Object xML2Bean(java.lang.Class<?> c, String xmlString) throws JAXBException {
        StringReader reader = new StringReader(xmlString);
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller marshaller = context.createUnmarshaller();
            return marshaller.unmarshal(reader);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
