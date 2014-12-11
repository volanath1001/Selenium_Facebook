package core;

import java.util.Map;

import org.jdom2.Element;

public interface IDataContainer {


    Element geteDataContainer();

    void seteDataContainer(Element eDataContainer);

    String getField(String fieldName);

    IDataContainer getDataContainer(String containerName);

    Map<String, String> get();




}
