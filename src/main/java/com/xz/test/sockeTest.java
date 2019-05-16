package com.xz.test;



import java.net.ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class sockeTest {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress() + "~~" + address.getHostName());
        byte[] bytes = address.getAddress();
        System.out.println(Arrays.toString(bytes));
        System.out.println(address);

        URL imoocUrl = new URL("http://www.imooc.com");
        URL url = new URL(imoocUrl, "/index.html?user=tom");
        System.out.println(url.getHost());
        System.out.println(url.getFile());

        URL bdUrl = new URL("http://www.baidu.com");
        try {
            InputStream is = bdUrl.openStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
