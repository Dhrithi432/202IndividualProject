package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Date;


public class XMLFileParser implements FileParser {
    private NodeList records;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    Document outputDoc;
    public XMLFileParser() throws ParserConfigurationException {
        records = new NodeList() {
            @Override
            public Node item(int index) {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }
        };

        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
    }

    @Override
    public void fetchRecords(String inputFilename){
        try {
            File file = new File(inputFilename);

            // TO handle & operators
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb =  new StringBuffer();
            String line = null;
            while((line = br.readLine())!= null)
            {
                if(line.indexOf("&") != -1)
                {
                    line = line.replaceAll("&","");
                }
                String newline = System.getProperty("line.separator");
                sb.append(line).append(newline);
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(inputFilename));
            bw.write(sb.toString());
            bw.close();

            //Fetch the records
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            records = doc.getElementsByTagName("CARD");
        }catch(SAXParseException sax){
            System.out.println("Error with & or any special character:"+sax);

        }catch(Exception e){
            System.out.println("Error while fetching records");
        }
    }

    @Override
    public void processRecords(String outputFilename){
        try {
            RecordsIterator iterator = new RecordsIteratorImpl(records);
            outputDoc = dBuilder.newDocument();

            Element root = outputDoc.createElement("CARDS");
            outputDoc.appendChild(root);

            Element element;
            String card_number = "";
            String output = "";
            String card_type = "Invalid";
            String error_message = "None";
            Date expiry_date;
            while (!iterator.isDone()) {
                element = (Element) iterator.currentNode();

                try {
                    card_number = element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                }catch(Exception e){
                    card_number="null";
                }
                // Implementing Factory Method Pattern to get the Card Factory object
                CardFactory cardFactory = new CardFactoryImpl();

                // Using the factory object to create the appropriate Object of Subclass of Card
                Card card = cardFactory.createCard(card_number);

                //Finally validate the card and return the card_type
                if(card==null){
                    card_type = "INVALID";
                    if(card_number.equals("")){
                        card_type = "Invalid: empty/null card number";
                    }
                    try {
                        long number = Double.valueOf(card_number).longValue();
                        String value = Long.toString(number);
                        if(value.length() >19) {
                            card_type = "Invalid: more than 19 digits";
                        }
                    }catch (Exception e) {
                        card_type = "Invalid: non numeric characters";
                    }
//                    error_message = "InvalidCardNumber";
//                    card_type = "INVALID: Card not according to format";
                }else{
                    output = card.validateCardType(card_number);
                    if (output.equals("Invalid")) {
                        error_message = "InvalidCardNumber";
                    }
                    card_type=output;
                }

                Element row = outputDoc.createElement("CARD");
                root.appendChild(row);

                Element cardNumber = outputDoc.createElement("CARD_NUMBER");
                cardNumber.appendChild(outputDoc.createTextNode(card_number));
                row.appendChild(cardNumber);

                Element cardType = outputDoc.createElement("CARD_TYPE");
                cardType.appendChild(outputDoc.createTextNode(card_type));
                row.appendChild(cardType);

//                Element error = outputDoc.createElement("ERROR");
//                error.appendChild(outputDoc.createTextNode(error_message));
//                row.appendChild(error);

                iterator.next();
            }

            this.writeFile(outputFilename);
        }catch(Exception e){
            System.out.println("Error while processing records:"+e);

        }
    }

    @Override
    public void writeFile(String outputFilename) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        outputDoc.setXmlStandalone(true);
        DOMSource domSource = new DOMSource(outputDoc);
        StreamResult streamResult = new StreamResult(new File(outputFilename));

        transformer.transform(domSource, streamResult);
    }
}
