package com.ckj.projects;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * created by ChenKaiJu on 2018/8/28  22:06
 */
public class Utils {

    public static JSONArray getCenterList(HttpServlet servlet){
        String path=servlet.getServletContext().getRealPath("/");
        path=path+"centerList.txt";
        System.out.println("loading config from "+path+".........");
        JSONArray array=new JSONArray();
        BufferedReader reader=null;
        File file=new File(path);
        try {
            reader=new BufferedReader(new FileReader(file));
            String line=null;
            while ((line=reader.readLine())!=null){
                try{
                    line=line.trim();
                    if(!line.equals("")&&!line.startsWith("#")){
                        System.out.println(line);
                        String[] address=line.split(":");
                        JSONObject addr=new JSONObject();
                        addr.put("ipAddress",address[0]);
                        addr.put("serverPort",address[1]);
                        array.put(addr);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return array;
    }
}
