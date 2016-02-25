/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package XML;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import livre.Livre;

/**
 * This class parses XML feeds from stackoverflow.com.
 * Given an InputStream representation of a feed, it returns a List of entries,
 * where each list element represents a single entry (post) in the XML feed.
 */
public class XMLParser {
    private static final String ns = null;

    // We don't use namespaces

    public Livre parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        }finally {
            in.close();
        }
    }

    private Livre readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        Livre livre=new Livre();
        parser.require(XmlPullParser.START_TAG, ns, "get-pat-loan");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the loan tag
            if (name.equals("loan")) {
                livre =readloan(parser, livre);
            } else {
                skip(parser);
            }
        }
        return livre;
    }

    private Livre readloan(XmlPullParser parser,Livre livre) throws IOException, XmlPullParserException {

        parser.require(XmlPullParser.START_TAG, ns, "loan");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("z36")) {
            livre =readz36(parser, livre);
            }
            else if (name.equals("z13")) {
                livre =readz13(parser,livre);
            }
            else {
                skip(parser);
            }
        }

        return livre;
    }

    private Livre readz13(XmlPullParser parser, Livre livre) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "z13");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the z13 tag
            if (name.equals("z13-author")) {
                livre.setAuteur(readz13autor(parser));
                parser.nextTag();
            }
            else if (name.equals("z13-title")) {
                livre.setNom(readz13title(parser));
                parser.nextTag();
            }
            else if (name.equals("z13-imprint")) {
                livre.setDate_parution(readz13paru(parser));
                parser.nextTag();
            }else {
                skip(parser);
            }
        }
        return livre;
    }

    private String readz13autor(XmlPullParser parser) throws IOException, XmlPullParserException {
        String autor ="";
        if(parser.next()==XmlPullParser.TEXT){
            autor=parser.getText();
        }
        return  autor;
    }
    private String readz13title(XmlPullParser parser) throws IOException, XmlPullParserException {
        String title ="";
        if(parser.next()==XmlPullParser.TEXT){
            title=parser.getText();
        }
        return  title;
    }
    private String readz13paru(XmlPullParser parser) throws IOException, XmlPullParserException {
        String paru ="";
        if(parser.next()==XmlPullParser.TEXT){
            paru=parser.getText();
         }
        return  paru;
    }


    private Livre readz36(XmlPullParser parser,Livre livre) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "z36");
        int i =2;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the z36 tag
            if (name.equals("z36-id")) {
                livre.setNumero_etu(readz36id(parser));
                parser.nextTag();
            }
            else if (name.equals("z36-due-date")) {
                livre.setDate_retour(readz36dateretour(parser));
                parser.nextTag();
            } else {
                skip(parser);
            }
        }

        return livre;
    }

    private String readz36dateretour(XmlPullParser parser) throws IOException, XmlPullParserException {
        String dateretour ="";
        if(parser.next()==XmlPullParser.TEXT){
            dateretour=parser.getText();
        }
        return  dateretour;
    }

    private String readz36id(XmlPullParser parser) throws IOException, XmlPullParserException {
        String id ="";
        if(parser.next()==XmlPullParser.TEXT){
            id=parser.getText();
        }
        return  id;
    }
    // Skips tags the parser isn't interested in. Uses depth to handle nested tags. i.e.,
    // if the next tag after a START_TAG isn't a matching END_TAG, it keeps going until it
    // finds the matching END_TAG (as indicated by the value of "depth" being 0).
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
            case XmlPullParser.END_TAG:
                    depth--;
                    break;
            case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
