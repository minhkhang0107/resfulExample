package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class EmployUtil {
    String value;
    public EmployUtil(String value){
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
//
//
    public static EmployUtil of (BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return new EmployUtil(sb.toString());
    }

}
