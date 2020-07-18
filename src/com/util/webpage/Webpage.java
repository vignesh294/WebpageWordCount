package com.util.webpage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Webpage {
    protected String url_string = null;
    protected String response = null;

    public Webpage() {}

    public Webpage(String url) {
        this.url_string = url;
    }

    public void loadPage() {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL(url_string);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                this.response += line;
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }

}
