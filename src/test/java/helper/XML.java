package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import util.Widgets;
import core.Constant;
import core.IDataContainer;
import core.TextBox;

public class XML {
	
	public static String testId = Constant.TCID;
	public static String dataContainerName = null;
	static SAXBuilder builder = null;
	static String path = null;
	
	public static void setXmlDataFile(String path) {
		XML.path = path;
	}
	
	public static Map<String, String> getData(){
		
		Map<String, String> map = new HashMap<String, String>();
		
		builder = new SAXBuilder();
		
		Document document = null;
		try {
			document = builder.build(new File(System.getProperty("user.dir")+"/src/test/resources/"+path));
		} catch (JDOMException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		List<Element> e = document.getRootElement().getChildren();
		
		
		for(Element ee: e){
			String n = ee.getAttributeValue("name");
			String id = ee.getAttributeValue("id");
			System.out.println("Data Container Name >"+n+"   Data Container Id >"+id);
			
			if(testId.equals(id) && dataContainerName.equals(n)){
				List<Element> e2 = ee.getChildren();
				
				for(Element ee2: e2){
					System.out.println("	"+ee2.getAttributeValue("name")+"	=	"+ee2.getAttributeValue("value"));
					map.put(ee2.getAttributeValue("name"), ee2.getAttributeValue("value"));
				}
			}
		}
		
		return map;
	}
	public static void write(){
		
	}
	
	public static void autoPopulate(String container,Object SO){

		dataContainerName = container;
		
        
			
			Map<String , String> data = getData();
			
			Class<?> screenObject = SO.getClass();
			
		
	        if (screenObject.getAnnotation(Widgets.class) != null) {
	            Class<?>[] ScreenObjectInners = screenObject.getDeclaredClasses();
	            for (Class<?> ScreenObjectInner : ScreenObjectInners) {
	                if (ScreenObjectInner.getAnnotation(Widgets.class) != null) {
	                    for (Map.Entry<String, String> entry : data
	                            .entrySet()) {
	                        String s1 = entry.getKey();
	                        String s2 = entry.getValue();
	                        System.out.println(s1);
	                        System.out.println(s2);
	                        TextBox t = null;
							try {
								t = (TextBox) ScreenObjectInner
								        .getDeclaredField(s1).get(null);
							} catch (IllegalArgumentException
									| IllegalAccessException
									| NoSuchFieldException | SecurityException e) {
								e.printStackTrace();
							}
	                        t.populate(s2);
	                    }
	                }
	            }

	        }
	     
	}

}
