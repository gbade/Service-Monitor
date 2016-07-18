
package com.paycom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.paycom package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloResponse_QNAME = new QName("http://paycom.com/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://paycom.com/", "hello");
    private final static QName _GenerateXML_QNAME = new QName("http://paycom.com/", "GenerateXML");
    private final static QName _GenerateXMLResponse_QNAME = new QName("http://paycom.com/", "GenerateXMLResponse");
    private final static QName _Parser_QNAME = new QName("http://paycom.com/", "Parser");
    private final static QName _ParserResponse_QNAME = new QName("http://paycom.com/", "ParserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.paycom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link GenerateXMLResponse }
     * 
     */
    public GenerateXMLResponse createGenerateXMLResponse() {
        return new GenerateXMLResponse();
    }

    /**
     * Create an instance of {@link GenerateXML }
     * 
     */
    public GenerateXML createGenerateXML() {
        return new GenerateXML();
    }

    /**
     * Create an instance of {@link Parser }
     * 
     */
    public Parser createParser() {
        return new Parser();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link ParserResponse }
     * 
     */
    public ParserResponse createParserResponse() {
        return new ParserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "GenerateXML")
    public JAXBElement<GenerateXML> createGenerateXML(GenerateXML value) {
        return new JAXBElement<GenerateXML>(_GenerateXML_QNAME, GenerateXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "GenerateXMLResponse")
    public JAXBElement<GenerateXMLResponse> createGenerateXMLResponse(GenerateXMLResponse value) {
        return new JAXBElement<GenerateXMLResponse>(_GenerateXMLResponse_QNAME, GenerateXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Parser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "Parser")
    public JAXBElement<Parser> createParser(Parser value) {
        return new JAXBElement<Parser>(_Parser_QNAME, Parser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paycom.com/", name = "ParserResponse")
    public JAXBElement<ParserResponse> createParserResponse(ParserResponse value) {
        return new JAXBElement<ParserResponse>(_ParserResponse_QNAME, ParserResponse.class, null, value);
    }

}
