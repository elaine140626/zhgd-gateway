package org.lebo.facegate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(FaceGateApi.class.getResource("").getPath().replaceFirst("/","").replaceAll("%20"," ")+"FaceGateApi.dll");
        Client client = new Client();
        client.start();
    }
}


