package com.nmvk.scrumster.mock;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

/**
 * Mock data used for mocking.
 * @author raghav
 */
public class MockData {

    /**
     * Mock issue JSON.
     */
    static String issues[] = new String[2];

    /**
     * Mock calendar data.
     */
    static String calendar[] = new String[2];

    static {
        try {
            issues[0] = new JSONObject().append("key", 1)
                    .append("Summary", "Database migration")
                    .append("Status", "In-Progress").toString();
            issues[1] =  new JSONObject().append("key", 2)
                    .append("Summary", "Database Design")
                    .append("Status", "Done").toString();
        } catch (JSONException je) {
            // This should not be thrown
        }
    }


}
