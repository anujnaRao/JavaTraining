package com.epsilon.training.annotations.processes;

import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.annotations.JsonSerializable;
import com.epsilon.training.annotations.XmlProperty;
import com.epsilon.training.annotations.XmlSerializable;
import com.epsilon.training.exception.NotXmlSerializableException;

public class XmlSerialize {
	
	public void xSerialize(Writer writer, Object obj) {
		String xml = this.xSerialize(obj);
		try(PrintWriter out = new PrintWriter(writer);){
			out.print(xml);
		}
	}
	
	public String xSerialize(Object ob) {

		if(ob == null) {
			throw new NotXmlSerializableException("Cannot Serialize object");
		}

		Class<?> cls = ob.getClass();

		if(!cls.isAnnotationPresent(XmlSerializable.class)) {
			throw new NotXmlSerializableException("The class " + cls.getName() + "doeas not have @JsonSerializer");
		}
		
		List<String> kvList = new ArrayList<>();
		
		for(Field f: cls.getDeclaredFields()) {
			if(f.isAnnotationPresent(XmlProperty.class)) {
				try {
					String label = f.getName();
		
					XmlProperty ann =  f.getAnnotation(XmlProperty.class);
					if(ann != null) {
						label = ann.label();
						if(label == null || label.trim().equals("")) {
							label = f.getName();
						}
					}
					f.setAccessible(true);
					Class<?> cl = f.get(ob).getClass();
					if(cl.isAnnotationPresent(XmlSerializable.class)) {
						XmlSerialize xs = new XmlSerialize();
						
						String xml = xs.xSerialize(f.get(ob));
						kvList.add("<" + label + ">" + xml + "</" + label + ">");
					}
					//System.out.println(f.getName() + " --> " + f.get(ob));
					String kv =  String.format("<%s> %s </%s>"  , label, f.get(ob), label);
					kvList.add(kv);
				} catch (Exception e) {
					System.out.println("Error for field " + f.getName() + " - " + e.getMessage());
				} 
			}
			
		}
		
		StringBuffer sb = new StringBuffer(1000);
		for(int i = 0; i < kvList.size(); i++ ) {
			sb.append(kvList.get(i));
		}
	
		return sb.toString();
	}

}
