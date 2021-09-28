package com.qa.util;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;

interface MyInterface {
    void getApiResponse(final String response, File file) throws IOException, JSONException;
}
