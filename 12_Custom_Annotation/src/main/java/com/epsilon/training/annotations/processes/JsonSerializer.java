package com.epsilon.training.annotations.processes;

import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.annotations.JsonIgnored;
import com.epsilon.training.annotations.JsonProperty;
import com.epsilon.training.annotations.JsonSerializable;
import com.epsilon.training.exception.NotJsonSerializableException;

public class JsonSerializer {

	public void serializer(Writer writer, Object obj) {
		String json = this.serializer(obj);
		try(PrintWriter out = new PrintWriter(writer);){
			out.print(json);
		}
	}
	
	public String serializer(Object ob) {

		if(ob == null) {
			throw new NotJsonSerializableException("Cannot Serialize object");
		}

		Class<?> cls = ob.getClass();

		if(!cls.isAnnotationPresent(JsonSerializable.class)) {
			throw new NotJsonSerializableException("The class " + cls.getName() + "doeas not have @JsonSerializer");
		}
		
		List<String> kvList = new ArrayList<>();
		
		for(Field f: cls.getDeclaredFields()) {
			if(!f.isAnnotationPresent(JsonIgnored.class)) {
				try {
					String label = f.getName();
		
					JsonProperty ann =  f.getAnnotation(JsonProperty.class);
					if(ann != null) {
						label = ann.label();
						if(label == null || label.trim().equals("")) {
							label = f.getName();
						}
					}
					f.setAccessible(true);
					Class<?> cl = f.get(ob).getClass();
					if(cl.isAnnotationPresent(JsonSerializable.class)) {
						JsonSerializer js = new JsonSerializer();
						
						String json = js.serializer(f.get(ob));
						kvList.add(label + ":" + json);
					}
					//System.out.println(f.getName() + " --> " + f.get(ob));
					String kv =  String.format("\"%s\": \"%s\""  , label, f.get(ob));
					kvList.add(kv);
				} catch (Exception e) {
					System.out.println("Error for field " + f.getName() + " - " + e.getMessage());
				} 
			}
			
		}
		
		StringBuffer sb = new StringBuffer(1000);
		sb.append("{");
		for(int i = 0, j = kvList.size() - 1; i < j; i++ ) {
			sb.append(kvList.get(i));
			sb.append(",");
		}
		sb.append(kvList.get(kvList.size() -1));
		sb.append("}");

		return sb.toString();
	}
}

// This is for Person Serializer

//List<String> kvList = new ArrayList<>();
//for(Field f: cls.getDeclaredFields()) {
//	if(f.isAnnotationPresent(JsonIgnored.class)) {
//		try {
//			String label = f.getName();
//
//			JsonProperty ann =  f.getAnnotation(JsonProperty.class);
//			if(ann != null) {
//				label = ann.label();
//				if(label == null || label.trim().equals("")) {
//					label = f.getName();
//				}
//			}
//			f.setAccessible(true);
//			//					System.out.println(f.getName() + " --> " + f.get(ob));
//			String kv =  String.format("\"%s\": \"%s\""  , label, f.get(ob));
//			kvList.add(kv);
//		} catch (Exception e) {
//			System.out.println("Error for field " + f.getName() + " - " + e.getMessage());
//		} 
//	}
//}
